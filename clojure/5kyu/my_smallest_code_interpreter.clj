;https://www.codewars.com/kata/526156943dfe7ce06200063e
(println "My smallest code interpreter (aka Brainf**k)")

(defn increment [v]
  (let [new-v (inc (int v))]
    (if (> new-v 255)
      0      
      new-v)))

(defn decrement [v]
  (let [new-v (dec (int v))]
    (if (< new-v 0)
      255
      new-v)))

(defn find-matching-close [source pos]
  (loop [level 0 current-pos (inc pos)]
    (cond
      (and (= (nth source current-pos) \]) (= level 0)) current-pos
      (= (nth source current-pos) \[) (recur (inc level) (inc current-pos))
      (= (nth source current-pos) \]) (recur (dec level) (inc current-pos))
      :else (recur level (inc current-pos)))))

(defn find-matching-open [source pos]
  (loop [level 0 current-pos (dec pos)]
    (cond
      (and (= (nth source current-pos) \[) (= level 0)) current-pos
      (= (nth source current-pos) \]) (recur (inc level) (dec current-pos))
      (= (nth source current-pos) \[) (recur (dec level) (dec current-pos))
      :else (recur level (dec current-pos)))))

(comment
  (find-matching-close "[a[[]]]" 0)
  (find-matching-open "[[]]" 2)
  (find-matching-close "+[+,]" 1)
  (find-matching-open "+[+,]" 4))

(defn update-state [{:keys [source input output memory ip dp] :as state}]
  (case (nth source ip)
    \> (merge state {:dp (inc dp)
                     :ip (inc ip)})
    \< (merge state {:dp (dec dp)
                     :ip (inc ip)})
    \+ (merge state {:memory (assoc memory dp (increment (or (memory dp) 0)))
                     :ip (inc ip)})
    \- (merge state {:memory (assoc memory dp (decrement (or (memory dp) 0)))
                     :ip (inc ip)})
    \. (merge state {:output (conj output (or (memory dp) 0))
                     :ip (inc ip)})
    \, (if (empty? input)
         (assoc state :error "insufficient input")
         (merge state {:memory (assoc memory dp (int (first input)))
                       :input (rest input)
                       :ip (inc ip)})) 
    \[ (if (zero? (or (memory dp) 0))
         (assoc state :ip (+ 1 (find-matching-close source ip)))
         (assoc state :ip (inc ip)))
    \] (if (not (zero? (or (memory dp) 0)))
         (assoc state :ip (+ 1 (find-matching-open source ip)))
         (assoc state :ip (inc ip)))))

(defn new-state [source input] 
  {:source source
   :input input
   :output []
   :memory {}
   :ip 0
   :dp 0})

(defn interpret [state]
  (if (or (= (state :ip) (count (state :source)))
          (not (nil? (state :error))))
    [state]
    (lazy-seq (cons state (interpret (update-state state))))))

(defn execute-string [source input]
  (let [result (->> (new-state source input)
                    (interpret)
                    last)]
    (if (nil? (result :error))
      (->> result
           :output
           (map char)
           vec
           (apply str))
      nil)))

(comment
  (def program (interpret (new-state "+[+,]" [255])))
  (nth program 0)
  (nth program 1)
  (nth program 2)
  (take 3 program)
  (nth program 3)
  (nth program 4)
  (nth program 5)
  (nth program 6)
  (nth program 7)
  (nth program 8)

  (last program)
  (count program)
  (take 6 program)
  (last (take 1001 program)))
  
(comment
  (execute-string ">>" [])
  (execute-string ">>+" [])
  (execute-string ">>>---<,." [10])
  (execute-string "-----" [])
  (clojure.string/index-of "+>[+++]" "[")
  (execute-string "+>[+++]" [10])
  (execute-string "+>+[+++,]" [\a \a \u00FF])
  (update-state {:source ","
                 :input [\a \a] 
                 :output [] 
                 :memory {} 
                 :ip 0 
                 :dp 0}))



(def test-program (interpret (new-state "+[,.]" (-> (range 1 256)
                                         vec
                                         (conj 0)
                                         (->> (map char)
                                              (apply str))))))
(map #(dissoc % :input) (take 300 test-program))
(count test-program)

(require '[clojure.test :refer [are]]
         '[clojure.string :as s])
(defn  ord->str  [n]  (str  (char n)))


(comment "output until inclusive 0"
 (let  [in  (-> (range 1 256)
                vec
                (conj 0)
                (->> (map char)
                     (apply str)))]
  (= in  (execute-string  "+[,.]" in)))        )

(comment "output n exclamation marks"
  (let [pluses (s/join (repeat (int \!) \+))
        src (str ">" pluses "<,[>.<-]")
        ! #(s/join (repeat % \!))]
    (are [n] (= (execute-string src (ord->str n))
                (! n))
         1 2 3 4 5 6 7 8 9 10)))

(comment "Memory 0 initialized"
  (= (execute-string  ".>."  "") "\0\0"))

(comment "Memory Operations"
  (= (execute-string  ".>.+.<."  "") "\0\0\1\0"))

(comment "input output"
  (are  [n]  (= (execute-string  ".,."  (ord->str n))
                (str  "\0"  (char n)))
       11 12 13 14 15 16 17 18 19 20))

(comment "Loops"
  (let  [z #(s/join  (repeat %  "\0"))]
    (are  [n]  (= (execute-string  "[>.<],[>.<-]"  (ord->str n))
                  (z n))
         21 22 23 24 25 26 27 28 29 30)))

(comment "insufficient input"
  (nil?  (execute-string  ","  "")))



(comment
  (execute-string "[+++]." [])
  (def program (interpret (new-state "[>.<],[>.<-]" [])))
  (type program)
  (first program)
  (nth program 1)
  (vec (take 5 program)))

(s/index-of "[][]" \])

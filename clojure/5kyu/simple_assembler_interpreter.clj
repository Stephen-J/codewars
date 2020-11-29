;https://www.codewars.com/kata/58e24788e24ddee28e000053
(println "Simple Assembler Interpreter")
(require '[clojure.string :as string])


(defn step [{:keys [instructions ip memory] :as state}]
  (let [statement (-> (nth instructions ip) (string/split #" "))]
    (case (first statement)
      "mov" (let [[_ register reg-or-const] statement
                  source (read-string reg-or-const)]
              (cond
                (symbol? source) (merge state {:memory (assoc memory (keyword register) (memory (keyword source)))
                                                  :ip (inc ip)})
                (int? source) (merge state {:memory (assoc memory (keyword register) source)
                                               :ip (inc ip)})))
      "inc" (let [[_ register] statement]
              (merge state {:memory (assoc memory (keyword register) (-> (memory (keyword register)) inc))
                            :ip (inc ip)}))
      "dec" (let [[_ register] statement]
              (merge state {:memory (assoc memory (keyword register) (-> (memory (keyword register)) dec))
                            :ip (inc ip)}))
      "jnz" (let [[_ reg-or-const steps] statement
                  condition (read-string reg-or-const)]
              (cond
                (int? condition) (if (not (zero? condition))
                                   (merge state {:ip (+ ip (Integer/parseInt steps))})
                                   (merge state {:ip (inc ip)}))
                (symbol? condition) (if (not (zero? (memory (keyword (name condition)))))
                                      (merge state {:ip (+ ip (Integer/parseInt steps))})
                                      (merge state {:ip (inc ip)}))))
      (merge state {:ip (inc ip)}))))

#_(defn interpret [state]
  (if (>= (state :ip) (count (state :instructions)))
    nil
    (lazy-seq (cons (step state) (interpret (step state))))))

(defn interpret [state]
    (lazy-seq (if (>= (state :ip) (count (state :instructions)))
                nil
                (cons (step state) (interpret (step state))))))

(defn new-state [instructions]
  {:instructions instructions
   :ip 0
   :memory {}})

#_(defn simple-assembler [assembly-code]
  (->> (interpret (new-state assembly-code))
       (last)
       (:memory)))

(defn simple-assembler [assembly-code]
  (loop [state (new-state assembly-code)]
    (if (>= (:ip state) (count (:instructions state)))
      state
      (recur (step state)))))



(def program (interpret (new-state ["mov a 5"  "inc a"  "dec a"  "dec a"  "jnz a -1"  "inc a"])))
(nth program 0)
(nth program 1)
(nth program 2)
(nth program 3)
(nth program 4)
(nth program 5)
(nth program 6)
(nth program 7)
(nth program 8)
(nth program 9)
(nth program 10)
(nth program 11)
(nth program 12)
(nth program 13)
#_(nth program 14)
(count program)
(last program)





#_(=  (simple-assembler  ["mov a 5"  "inc a"  "dec a"  "dec a"  "jnz a -1"  "inc a"]) {:a 1})

(let [x 1
      y (+ x 1)]
  y)



(comment (let  [code  ["mov c 12"
              "mov b 0"
              "mov a 200"
              "dec a"
              "inc b"
              "jnz a -2"
              "dec c"
              "mov a b"
              "jnz c -5"
              "jnz 0 1"
              "mov c a"]]
        (= (simple-assembler  (clojure.string/split-lines code))
                           {:a 409600 :b 409600 :c 409600})))
{:a 409600 :b 409600 :c 409600}
(def program2 (interpret (new-state ["mov c 12" "mov b 0" "mov a 200" "dec a" "inc b"
                          "jnz a -2" "dec c" "mov a b" "jnz c -5" "jnz 0 1" "mov c a"])))
(nth program2 0)
(nth program2 1)
(nth program2 2)
(nth program2 3)
(nth program2 4)
(nth program2 5)
(nth program2 6)
(nth program2 7)
(nth program2 8)
(nth program2 9)
(nth program2 10)
(nth program2 11)
(nth program2 12)
(nth program2 50)
(println "----")
#_(last (take 10 program2))
#_(last (take 100 program2))
#_(last (take 1000 program2))
#_(last (take 10000 program2))
#_(last (take 100000 program2))
#_(last (take 1000000 program2))
(comment  (last (take 1228842 (interpret (new-state ["mov c 12" "mov b 0" "mov a 200"
                                                     "dec a" "inc b" "jnz a -2" "dec c"
                                                     "mov a b" "jnz c -5" "jnz 0 1" "mov c a"])))))
(comment (last (interpret {:instructions ["mov c 12" "mov b 0" "mov a 200"
                               "dec a" "inc b" "jnz a -2" "dec c"
                               "mov a b" "jnz c -5" "jnz 0 1" "mov c a"]
                     :memory {:c 0 :b 409600 :a 409600}
                     :ip 10})))

(comment (simple-assembler ["mov c 12" "mov b 0" "mov a 200"
                            "dec a" "inc b" "jnz a -2" "dec c"
                            "mov a b" "jnz c -5" "jnz 0 1" "mov c a"]))


(def program3 (interpret (new-state ["jnz 0 1" "mov a 10"])))
(nth program3 0)
(nth program3 1)
#_(last program3)
#_(count program3)
#_(take 10 program3)
(doseq [s program3]
  (println s))

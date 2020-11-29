;https://www.codewars.com/kata/57814d79a56c88e3e0000786
(println "Simple Encryption 1 - Alternating Split")


(defn encrypt [st n]
  (if (<= n 0)
    st
    (recur (clojure.string/join
             (concat (->> st rest (take-nth 2))
                     (->> st (take-nth 2))))
           (dec n))))

(defn decrypt [st n]
  (if (<= n 0)
    st
    (if (even? (count st))
      (recur (clojure.string/join
               (let [f (drop  (/ (count st) 2)  st)
                     r (take  (/ (count st) 2)  st)]
                 (interleave f r)))
             (dec n))
      (recur (clojure.string/join
               (let [f (drop  (- (/ (count st) 2) 1)  st)
                     r (take  (- (/ (count st) 2) 1)  st)]
                 (conj (vec (interleave f r)) (last f))))
             (dec n)))))

(encrypt "This is a test!" 1)
(def a (drop (- (/ (count (encrypt "This is a test!" 1)) 2) 1) (encrypt "This is a test!" 1)))
(def b (take (- (/ (count (encrypt "This is a test!" 1)) 2) 1) (encrypt "This is a test!" 1)))
(last a)
(decrypt (encrypt "This is a test!!!" 3) 3)
(encrypt "This is a test!" 4)
(interleave "Ti sats!" "hsi  et")

(concat [1] [2])
(int (/ 15 2))
(interleave [1 1] [2 2])

(map #(do [%1 %2]) [1 nil] [2 2])
(-> []
    (conj 1))

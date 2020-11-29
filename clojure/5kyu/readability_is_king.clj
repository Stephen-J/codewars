;https://www.codewars.com/kata/52b2cf1386b31630870005d4
(println "Readability is king")
(require '[clojure.string :as s])
(import java.math.BigDecimal
        java.math.MathContext)

(defn flesch-kincaid [text]
  (let [data (->> (s/split text #"[.!?]")
                  (map #(filter (fn [w] (not= (count (s/trim w)) 0)) (s/split % #"\b"))))
        avg-words-per-sentence (/ (reduce #(+ %1 (count %2)) 0 data) (count data))
        avg-sylables-per-word (/ (reduce #(+ %1 (count (re-seq #"[aAeEiIoOuU]+" %2))) 0 (flatten data))
                                 (count (flatten data)))]
    (-> (BigDecimal. (- (+ (* 0.39 avg-words-per-sentence) (* 11.8 avg-sylables-per-word))
                        15.59))
        (.round (MathContext. 3))
        (.doubleValue))))


(def tests
  [["The turtle is leaving." 3.67]
   ["A good book is hard to find." -1.06]
   ["To be or not to be. That is the question." -0.66]
   ["Oh no! The lemming is falling." 1.31]
   ["Do not cut your fingers as your katana is getting sharper! Be gentle." 4.19]])


(map #(flesch-kincaid (nth % 0)) tests)

(re-seq #"[aAeEiIoOuU]+" "heello")

(flatten [["a" "a"] ["b" "b"]])

(let [avg-words-per-sentence 7
      avg-sylables-per-word (/ 7 7)]
  (- (+ (* 0.39 avg-words-per-sentence) (* 11.8 avg-sylables-per-word))
     15.59))

(MathContext. 2)

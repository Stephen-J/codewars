;https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1
(println "Counting Duplicates")

(require '[clojure.string :as str])


(defn duplicate-count [text]
  (->> (str/lower-case text)
       (reduce #(assoc %1 %2 (if-let [c (get %1 %2)]
                               (inc c)
                               1)) {})
       (reduce #(let [c (second %2)]
                  (if (> c 1)
                    (inc %1)
                    %1)) 0)))

(duplicate-count "abcde")
(duplicate-count "aabbcde")
(duplicate-count "AaBbcde")
(duplicate-count "Indivisibility")
(duplicate-count "Indivisibilities")

(+ nil 1)

(defn frequencies-duplicate-count [text]
  (->> (str/lower-case text)
       (frequencies)))
(frequencies-duplicate-count "abcde")
(frequencies-duplicate-count "aabbcde")
(frequencies-duplicate-count "AaBbcde")
(frequencies-duplicate-count "Indivisibility")
(frequencies-duplicate-count "Indivisibilities")

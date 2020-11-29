;https://www.codewars.com/kata/56c5847f27be2c3db20009c3
(println "Subtract the sum")


(defn get-number [n]
  (if (< n 100)
    n
    (recur (->> (str n)
                (map str)
                (map #(Integer/parseInt %))
                (reduce +)
                (- n)))))

(defn subtract-sum [n]
  (get-number n))


(str 12345)
(get-number 325)
(subtract-sum 100)
(subtract-sum 300)
(subtract-sum 39)
(subtract-sum 10000)

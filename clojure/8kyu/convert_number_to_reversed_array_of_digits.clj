;https://www.codewars.com/kata/5583090cbe83f4fd8c000051
(println "Convert Number To Reversed Array of Digits")

(defn digitize [n]
  (->> (str n)
       (reverse)
       (map #(- (int %) 48))))


(str 12345)

(digitize 12345)
(int \0)
(int \1)
(int \2)

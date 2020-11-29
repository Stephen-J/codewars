; https://www.codewars.com/kata/564057bc348c7200bd0000ff


(defn convert [n]
  (->> (str n)
       seq
       (map #(Integer/parseInt (str %)))))


(defn sum [n]
  (let [num-list (->> (str n)
                      seq
                      (map #(Integer/parseInt (str %))))] 
    (->> (cycle [1 10 9 12 3 4])
         (take (count num-list))
         (interleave (reverse num-list))
         (partition 2)
         (reduce #(+ %1 (* (first %2) (second %2))) 0))))


(defn thirt [n]
  (let [number (sum n)]
    (if (= number n)
      n
      (recur number))))

(thirt 1234567)
(thirt 8529)
(thirt 85299258)
(thirt 5634)
(thirt 1111111111)
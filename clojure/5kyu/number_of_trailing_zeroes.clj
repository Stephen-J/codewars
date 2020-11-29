;https://www.codewars.com/kata/52f787eb172a8b4ae1000a34
(println "Number of trailing zeroes of N!")



(defn zeroes [n]
  (if (= n 0)
    0
    (loop [accum 0 k (int (Math/floor (/ (Math/log10 n) (Math/log10 5))))]
      (if (= k 0)
        (int accum)
        (recur (+ accum (Math/floor (/ n (Math/pow 5 k)))) (dec k))))))

(int 1.0)
(zeroes 0)
(zeroes 6)
(zeroes 12)
(zeroes 16)
(factorial 16)
(zeroes 30)
(zeroes 1)
(zeroes 2)
(zeroes 3)
(zeroes 4)
(zeroes 5)


(defn factorial [n]
  (loop [accum 1 x n]
    (if (= x 0)
      accum
      (recur (* accum x) (dec x)))))

(factorial 1)
(factorial 2)
(factorial 3)
(factorial 4)
(factorial 5)
(factorial 10)
(factorial 11)
(factorial 12)
(factorial 13)
(factorial 14)
(factorial 15)
(factorial 16)
(factorial 17)
(factorial 18)
(factorial 19)
(factorial 20)
(factorial 100)
(map (fn [i] [i (factorial i)]) (range 1 21))

(int (/ 20 5))

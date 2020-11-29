;https://www.codewars.com/kata/55fd2d567d94ac3bc9000064
(comment (defn nth-odd [n]
  (- (* 2 (inc  n)) 1)))

(defn nth-odd [n]
  (-> (inc n)
      (* 2)
      (- 1)))

(defn nth-even [n]
  (* 2 n))

(comment  (defn num-numbers [row-index]
  (loop [accum 0 i row-index]
    (if (= i 0)
      accum
      (recur (+ accum i) (dec i))))))

(comment (defn num-numbers [row-index]
  (reduce + (range 1 (+ row-index 1)))))

(defn num-numbers [row-index]
  (/ (* row-index (+ row-index 1)) 2))

(defn sum-odd [n]
  (Math/pow n 2))

(sum-odd 3)

(defn summation [start num-terms difference]
  (* (/ num-terms 2) (+ (* 2 start) (* difference (- num-terms 1)))))
(+ 13 15 17 19)
(summation 13 4 2)

(defn starting-number [n]
  ())


(defn odd-numbers
  ([]
   (odd-numbers 1))
  ([n]
   (lazy-seq (cons n (odd-numbers (+ 2 n))))))


(comment  (defn row-sum-odd-numbers [row-num]
  (let [starting-number (nth-odd (num-numbers (- row-num 0)))]
    (reduce + (take row-num (odd-numbers starting-number))))))

(defn row-sum-odd-numbers [row-num]
  (summation (nth-odd (summation 0 row-num 1)) row-num 2))


(nth-odd 2)
(nth-even 2)
(take 10 (odd-numbers))
(num-numbers 3)
(nth-odd (num-numbers 3))
(starting-number 3)

(= 1 (row-sum-odd-numbers 1))
(= 125 (row-sum-odd-numbers 5))
(= 343 (row-sum-odd-numbers 7))

(- 343 125)
(- 125 1)
(sum-odd 2)
(sum-odd 5)
(-  (sum-odd 3) (sum-odd 2))

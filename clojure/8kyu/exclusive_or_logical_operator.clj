;https://www.codewars.com/kata/56fa3c5ce4d45d2a52001b3c
(println "Exclusive or logical operator")

(defn xor [a b]
  (cond
    (and a (not b)) true
    (and b (not a)) true
    :else false))

(xor false false)
(xor true false)
(xor false true)
(xor true true)

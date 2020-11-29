; https://www.codewars.com/kata/5545f109004975ea66000086
(println "Is n divisible by x and y")

(defn is-divisible [n x y]
  (and (= (rem n x) 0)
       (= (rem n y) 0)))


(is-divisible 3 1 3)
(is-divisible 12 2 6)
(is-divisible 100 5 3)
(is-divisible 12 7 5)

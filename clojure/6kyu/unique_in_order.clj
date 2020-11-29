;https://www.codewars.com/kata/54e6533c92449cc251001667

(defn unique-in-order [input]
  (dedupe input))

(unique-in-order [1 2 3])
(unique-in-order "ABC")
(unique-in-order '(1 2 3))
(unique-in-order [0 0 0 0 1 1 1 2 2 0 0 1 1 1])
(unique-in-order "AAAABBBCCDAABBB")
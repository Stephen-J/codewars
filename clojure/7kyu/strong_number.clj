;https://www.codewars.com/kata/5a4d303f880385399b000001
(println "Strong Number")

(defn factorial [n]
  (reduce * (range 1 (+ n 1))))
(range 5)
(factorial 1)

(defn strong [n]
  (if (= (->> (str n)
              (map #(factorial (Integer/parseInt (str %))))
              (reduce + )) n)
    "STRONG!!!!"
    "Not Strong !!"))

(strong 1)
(strong 2)
(strong 145)
(strong 40585)
(strong 7)
(strong 93)

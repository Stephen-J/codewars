;https://www.codewars.com/kata/5413759479ba273f8100003d
(println "esreveR")



(defn my-reverse [lst]
  (reduce #(cons %2 %1) [] lst))



(clojure.string/join (my-reverse "a b c d e f"))

; https://www.codewars.com/kata/55f9bca8ecaa9eac7100004a
(println "Beginner Series #2 Clock")


(defn past [h m s]
  (+ (* 1000 s)
     (* 60 m 1000)
     (* 60 60 h 1000)))

(past 0 1 1)

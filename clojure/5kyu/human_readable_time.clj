;https://www.codewars.com/kata/52685f7382004e774f0001f7
(println "Human Readable Time")

(defn human-readable [x]
  (let [hours (int (/ x 3600))
        minutes (int (/ (- x (* hours 3600)) 60)) 
        seconds (- x (* hours 3600) (* minutes 60))]
    (format "%02d:%02d:%02d" hours minutes seconds)))


(human-readable      0) ;"00:00:00")
(human-readable     59) ;"00:00:59")
(human-readable     60) ;"00:01:00")
(human-readable     90) ;"00:01:30")
(human-readable  86399) ;"23:59:59")
(human-readable 359999) ;"99:59:59")

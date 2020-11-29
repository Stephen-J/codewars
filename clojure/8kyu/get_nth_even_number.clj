;https://www.codewars.com/kata/5933a1f8552bc2750a0000ed
(println "Get Nth Even Number")

(defn nth-even [n]
  (-> (- n 1)
      (* 2)))

(nth-even 3)
(nth-even 1)
(nth-even 2)
(nth-even 4)
(nth-even 5)
(nth-even 6)
(nth-even 100)
(last (take 3 (take-nth 2 (range (Integer/MAX_VALUE)))))

; 1 0
; 2 2
; 3 4
; 4 6
; 5 8
; 6 10

(* (- 3 1) 2)

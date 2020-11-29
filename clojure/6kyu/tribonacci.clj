;https://www.codewars.com/kata/556deca17c58da83c00002db
(println "tribonacci")


(defn tribonacci 
  ([a b c]
   (lazy-seq (cons a (tribonacci b c (+ a b c)))))
  ([[a b c] n]
   (take n (tribonacci a b c))))

(tribonacci [300 200 100] 4)

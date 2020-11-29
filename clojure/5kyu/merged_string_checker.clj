;https://www.codewars.com/kata/54c9fcad28ec4c6e680011aa
(println "Merged String Checker")

(defn is-merge
  "Returns whether a string is a merge of two other strings"
  [s p1 p2]
  (cond
    (not= (first s) (first p1)) false
    (= (first s) (first p1)) true)) 



(is-merge "codewars" "code" "wars")
(is-merge "codewars" "cdw" "oears")
(not ( is-merge "codewars" "cod" "war"))

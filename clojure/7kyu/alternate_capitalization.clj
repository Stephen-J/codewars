; https://www.codewars.com/kata/59cfc000aeb2844d16000075
(println "Alternate Capitaliztion")



(defn solve [s]
 (reduce (fn [x i] (println i) ) [] (map (fn [i] [(Character/toUpperCase i) (Character/toLowerCase i)]) s)))

(solve "abcdef")
(partition 0 2 "12345")
(map (fn [i] [(Character/toUpperCase i) (Character/toLowerCase i)]) "abcdef")
(reduce str "aaa")
(def t (cycle [[0 1] [1 0]]))
(take 10 t)

(for [i [[\A \a] [\B \b]]
      x t]
  (println x))

(= (solve "abcdef") ["AbCdEf" "aBcDeF"])
(= (solve "codewars" ["CoDeWaRs" "cOdEwArS"]))

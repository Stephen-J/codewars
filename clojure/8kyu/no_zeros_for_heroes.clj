;https://www.codewars.com/kata/570a6a46455d08ff8d001002

(println "No Zeros for heros")


(defn no-boring-zeros [n]
  (if (= n 0)
    0
    (->> (Long/toString n)
         reverse
         (drop-while #(= % \0))
         reverse
         clojure.string/join
         Long/parseLong)))

(no-boring-zeros 1450)
(no-boring-zeros 960000)
(no-boring-zeros 1050)
(no-boring-zeros -1050)
(no-boring-zeros 0)

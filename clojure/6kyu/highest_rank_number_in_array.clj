;https://www.codewars.com/kata/5420fc9bb5b2c7fd57000004
(println "Highest Rank Number in an Array")

(comment (defn highest-rank [data]
  (->> (frequencies data)
       seq
       (sort #(let [o1 (second %1)
                    o2 (second %2)] 
                (cond
                  (< o1 o2) -1
                  (= o1 o2) 0
                  (> o1 o2) 1)))
       last
       first)))

(comment (defn highest-rank [data]
  (->> (frequencies data)
       seq
       (reduce #(if (> (second %2) (second %1))
                  %2
                  (if (and (= (second %2) (second %1))
                           (> (first %2) (first %1)))
                    %2
                    %1)))
       (first))))

(defn highest-rank [data]
  (->> (frequencies data)
       seq
       (reduce #(cond
                  (> (second %2) (second %1)) %2
                  (> (first %2) (first %1)) %2
                  :else %1))
       (first)))

(highest-rank [12,10,8,12,7,6,4,10,12])
(highest-rank [12 10 8 12 7 6 4 10 12 10])
(highest-rank [12 10 8 8 3 3 3 3 2 4 10 12 10])
(highest-rank [13 13 12 10 8 12 7 6 4 10 12 10])

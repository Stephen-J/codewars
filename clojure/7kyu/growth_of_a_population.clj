;https://www.codewars.com/kata/563b662a59afc2b5120000c6
(println "Growth of a population")



(defn population-growth
  ([p0 percent aug]
   (population-growth 1 p0 percent aug))
  ([year p0 percent aug]
   (let [new-pop (-> (* p0 (/ percent 100))
                     (+ p0 aug)
                     (int))]
     (lazy-seq (cons [year new-pop] (population-growth (inc year) new-pop percent aug))))))

(take 2 (population-growth 1 1000 2 50))
(= (int (/ 5707 5)) 1141)
(/ 10 2)

(defn nb-year [p0 percent aug p]
  (->> (population-growth p0 percent aug)
       (some #(and (>= (int (second %)) p) %))
       (first)))


(take 5 (population-growth 1000 2.0 50))
(nb-year 1000 2.0 50 1214)
(int 1214.228)
(nb-year 1500000 0.0 10000 2000000)

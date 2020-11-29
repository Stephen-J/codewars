;https://www.codewars.com/kata/550f22f4d758534c1100025a/clojure
(println "Directions Reduction")
(require '[clojure.string :as s])

(def north-south #{"NORTH" "SOUTH"})
(def east-west #{"EAST" "WEST"})

(defn update-state [state dir]
  (if (= (peek state) dir)
    (conj state dir)
    (let [dir-pair #{dir (peek state)}]
      (if (or (= dir-pair north-south) (= dir-pair east-west))
        (pop state)
        (conj state dir)))))

(defn dirReduc [arr]
  (let [directions (map s/upper-case arr)
        result (reduce update-state [] directions)]
    (if (empty? result)
      nil
      result)))


(def ur ["NORTH", "SouTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"])
(def vr ["WEST"])
(= (dirReduc ur) vr)

(dirReduc ["NORTH" "SOUTH" "EAST" "WEST"])
(dirReduc [])

(dirReduc ["EAST" "EAST" "WEST" "NORTH" "WEST" "EAST" "EAST" "SOUTH" "NORTH" "WEST"])
(partition 2 1 ur)
(nil? [])
(= #{1 2} #{2 1})
(reduce #(conj %1 %2) [] nil)
(rest [])
(first [])

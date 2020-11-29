;https://www.codewars.com/kata/5d50e3914861a500121e1958

(println "Alphabetical Addition")

(def base 96)
(defn add-letters [letters]
  (if (empty? letters)
    \z
    (->> (map #(- (int %) 97) letters) 
         (reduce +)
         (nth (cycle (range 1 27)))
         (+ 96)
         (char))))

(add-letters [\a \b \c])
(add-letters [\y \c \b])
(add-letters [\z])
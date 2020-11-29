;https://www.codewars.com/kata/5667e8f4e3f572a8f2000039
(println "Mumbling")

(require '[clojure.string :as str])

(defn accum [s]
  (->> (map-indexed #(-> (repeat (inc %1) %2)
                         str/join
                         str/capitalize) s)
       (str/join "-")))



(accum "abcd")
(accum "RqaEzty")
(accum "cwAt")

;https://www.codewars.com/kata/52742f58faf5485cae000b9a
#_(println "Human Readable Duration format")

(def sec [:seconds 1 "second" "seconds"])
(def minute [:minutes 60 "minute" "minutes"])
(def hour [:hours (* 60 60) "hour" "hours"])
(def day [:days (* 24 60 60) "day" "days"])
(def year [:years (* 365 24 60 60) "year" "years"])
(def unit-order [year day hour minute sec])


(defn extract-unit [{:keys [remaining] :as result} [unit v]]
  (merge result {unit (int (/ remaining v))
                 :remaining (mod remaining v)}))

(defn format-time-unit [result [unit _ single multiple]]
  (let [v (result unit)]
    (cond
      (= v 1) (str v " " single)
      (> v 1) (str v " " multiple)
      :else nil)))

(defn format-time-string [units]
  (case (count units)
    1 (first units)
    2 (str (first units) " and " (second units))
    (str (clojure.string/join ", " (butlast units)) " and " (last units))))

(defn formatDuration [secs]
  (if (= secs 0)
    "now"
    (as-> (reduce extract-unit {:remaining secs} unit-order) r
          (map #(format-time-unit r %) unit-order)
          (filter #(not (nil? %)) r)
          (format-time-string r))))

(formatDuration 0)
(formatDuration 1)
(formatDuration 62)
(formatDuration 120)
(formatDuration 3600)
(formatDuration 3662)

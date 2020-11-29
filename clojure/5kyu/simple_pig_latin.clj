;https://www.codewars.com/kata/520b9d2ad5c005041100000f

(println "Simple Pig Latin")
(require '[clojure.string :as s])

(defn pig-it [s]
    (s/join
      " "
      (map #(s/join (if (re-matches #"[!.?]" %)
                      %
                      (flatten [(rest %) (first %) [\a \y]]))) (s/split s #" "))))

(= (pig-it "Pig latin is cool") "igPay atinlay siay oolcay")

(= (pig-it "This is my string") "hisTay siay ymay tringsay")

(= (pig-it "Hello world !") "elloHay orldway !") 

;https://www.codewars.com/kata/545cedaa9943f7fe7b000048
;https://www.codewars.com/kata/search/my-languages?q=detect%20panagram&&beta=false

(println "Detect Panagram")



(def a (int \a))
(def z (int \z))

(defn pangram? [s]
  (->> (clojure.string/lower-case s)
       (frequencies)
       (keys)
       (map int)
       (filter #(and (>= % a) (<= % z)))
       (sort)
       (= (vec (range a (inc z))))))


(->> (clojure.string/lower-case "The")
     (frequencies)
     keys
     (map int)
     (= [116 104 101]))
(char 116)
(keys (frequencies "test"))
(pangram?  "The quick brown fox jumps over the lazy dog.")
(range (int  \a) (int  \z))

(= (pangram?  "The quick brown fox jumps over the lazy dog.") true)
(= (pangram?  "Pack my box with five dozen liquor jugs.") true)
(= (pangram?  "Not every sentence is a a pangram. An example") false)

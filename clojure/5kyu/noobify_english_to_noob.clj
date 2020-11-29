;https://www.codewars.com/kata/552ec968fcd1975e8100005a
(ns  english-to-n00b
  (:require [clojure.string :as str]))

(def replacers
  [[#"[Tt][oO][oO]" "2"]
   [#"[Tt][oO]" "2"]
   [#"[Ff][oO][rR][eE]" "4"]
   [#"[Ff][oO][rR]" "4"]
   [#"[oO][oO]" "00"]
   [#"[Bb][eE]" "b"]
   [#"[Aa][rR][eE]" "r"]
   [#"[Yy][oO][uU]" "u"]
   [#"[Pp][lL][eE][aA][sS][eE]" "plz"]
   [#"[Pp][eE][oO][pP][lL][eE]" "ppl"]
   [#"[Rr][eE][aA][lL][lL][yY]" "rly"]
   [#"[Hh][a][vV][eE]" "haz"]
   [#"[Kk][nN][oO][wW]" "no"]
   [#"[Ss]" "z"]])

(defn replace-word [word]
  (let [is-capital (> (byte \a) (byte (first word)))
        replaced (reduce #(str/replace  %1 (first %2) (second %2)) word replacers)]
    (if is-capital
      (apply str (flatten [(str/upper-case (first replaced)) (seq (rest replaced))]))
      replaced)))

(defn all-caps-if-h [text]
  (if (#{\h \H} (-> text first first))
    (map str/upper-case text)
    text))

(defn even-numbered-words-capitalized [text]
  (map-indexed #(if (= (mod (+ 1 %1) 2) 0)
                  (str/upper-case %2)
                  %2) text))

(defn remove-punctuation [text]
  (map #(str/replace % #"[.,']" "") text))

(defn question-mark [text]
  (map #(str/replace % "?" (apply str (char-array (count text) \?))) text))

(defn exclamation [text]
  (map #(str/replace % "!" (apply str (take (count text) (cycle ["!" "1"])))) text))

(defn add-lol [text]
  (if (#{\w \W} (-> text first first))
    (cons "LOL" text)
    text))

(defn add-omg [text]
  (if (>= (reduce #(+ %1 (count (str/replace %2 #"[!?]" ""))) 0 text) (- 32 (- (count text) 1)))
    (if (= (first text) "LOL")
      (concat [(first text)] ["OMG"] (rest text)) 
      (cons "OMG" text))
    text))

(defn n00bify [text]
  (->> (str/split text #" ")
       (map replace-word)
       remove-punctuation
       add-lol
       add-omg
       question-mark
       exclamation
       all-caps-if-h
       even-numbered-words-capitalized
       (str/join " ")))


(n00bify "The golfer said FORE!")

(=  (n00bify "Sometimes I use ? in the middle of a sentence; is that ok?!")
"OMG ZOMETIMEZ I UZE ?????????????? IN the MIDDLE of A zentence; IZ that OK??????????????!1!1!1!1!1!1!1")


(=  (n00bify "Well, 32 chars without OMG on!")
 "LOL OMG Well 32 charz WITHOUT OMG ON!1!1!1!1")


(=  (n00bify "After conversions, this should be!")
"After CONVERZIONZ thiz ZHOULD b!1!1!")


(=  (n00bify "Woot woot woot woot woot woot!")
"LOL OMG W00t W00T w00t W00T w00t W00T!1!1!1!1")

(=  (n00bify "Before you know it... wait, what does this have to do with UNO!?")
"OMG B4 u NO it WAIT what DOEZ thiz HAZ 2 DO with UNO!1!1!1!1!1!1!1??????????????")
(=  (n00bify "Sometimes I use ? in the middle of a sentence; is that ok?!")
"OMG ZOMETIMEZ I UZE ?????????????? IN the MIDDLE of A zentence; IZ that OK??????????????!1!1!1!1!1!1!1")

(=  (n00bify "Hi, how are you today?")  "HI HOW R U 2DAY?????")
(=  (n00bify "Hi, how are you today!")  "HI HOW R U 2DAY!1!1!")
(=  (n00bify "Cake is very delicious")  "Cake IZ very DELICIOUZ")
(=  (n00bify "I think it would be nice if we could all get along.")  "OMG I think IT would B nice IF we COULD all GET along")

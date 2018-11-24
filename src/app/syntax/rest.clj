(ns rest)

(defn auei
  [arg]
  (rest arg))

(def first_number (auei [1 2 3 4 5]))

(println first_number)
(println (auei first_number))
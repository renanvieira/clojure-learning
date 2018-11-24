(ns multi)

(defmulti get-data (fn [type val] type))


(defmethod get-data "integer" [type val]
  ;do something with val and return result
  (str (+ val 1) " " type)
  )

(defmethod get-data "smallint" [type val]
  ;do something with val and return result
  (str (- val 50) " " type)
  )


(defn -main
  "launch!"
  []
  (println (get-data "smallint" 50))
  (println (get-data "integer" 50)))


(-main)
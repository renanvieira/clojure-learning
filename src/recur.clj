(ns recur)
(defn func [x]
  (if (= x 1000000)
    x
    (recur (inc (+ x 1)))))



(func 5)

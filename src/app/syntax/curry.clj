(ns app.syntax.curry)

(defn messenger-builder [greetings]
  (fn [who] (println greetings who)))

(def hello-er (messenger-builder "Hello"))

(hello-er "World!")
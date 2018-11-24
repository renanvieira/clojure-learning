(ns app.core
  (:gen-class))

(require '[app.database :as db])

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn display-result [result]
  (doseq [res result]
    (println res)))

(defn -main []
  (let [db {:classname   "org.sqlite.JDBC"
            :subprotocol "sqlite"
            :subname     "db/db.sqlite3"}]
    (app.database/init-database db)
    (app.database/insert db :user {:name "Renan"})
    (app.database/insert db :user {:name "Mateus"})
    (display-result (app.database/query db "SELECT * FROM user"))))
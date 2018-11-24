(ns app.database
  (:require [clojure.java.jdbc :as jdbc]))

(declare drop-if-exists!)

(defn init-database
  [db]
  (try
    (drop-if-exists! db :user)
    (jdbc/db-do-commands db (jdbc/create-table-ddl :user
                                                   [[:id :integer :primary :key]
                                                    [:name "varchar(128)"]]))
    (catch Exception e
      (println e))))


(defn to_string
  "Convert symbol/keyword to string compatible with SQL"
  [str]
  (when str
    (-> ^String (if (or (symbol? str) (keyword? str))
                  (name str)
                  (str str))))
  )

(defn exists? [db table]
  (try
    (do
      (->> (format "SELECT 1 FROM %s" (to_string table))
           (vector)
           (jdbc/query db)))
    (catch Throwable e
      false)))

(defn drop! [db table]
  (->> (jdbc/drop-table-ddl (to_string table))
       (vector)
       (jdbc/execute! db)))

(defn drop-if-exists!
  "Drop table if it exists."
  [db-spec table-key]
  (when (exists? db-spec table-key)
    (println (format "Table %s exists...droping." (to_string table-key)))
    (drop! db-spec table-key))
  db-spec)

(defn insert [db table data]
  (jdbc/insert! db
                table
                data))


(defn query [db query]
  (jdbc/query db query))


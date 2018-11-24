(defproject app "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :main app.core
            :license {:name "Eclipse Public License"
                      :url  "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [org.clojure/java.jdbc "0.7.8"]
                           [org.xerial/sqlite-jdbc "3.23.1"]]
            :dev-dependencies [[org.clojure/java.jdbc "0.7.8"]
                               [org.xerial/sqlite-jdbc "3.23.1"]]
            :profiles {:uberjar {:aot :all}})
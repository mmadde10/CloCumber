(defproject clocumber "0.1.0-SNAPSHOT"
  :description "A Cucumber Testing Module Written in Clojure"
  :url "https://github.com/mmadde10/CloCumber"
  :license {:name "Eclipse Public License"
            :url "https://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.0.0"]]
  :profiles {:dev {:dependencies [[ring/ring-devel "1.4.0"]]}}
  :main clocumber.core
  :aot [clocumber.core])

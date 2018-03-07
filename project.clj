(defproject clocumber "0.1.0-SNAPSHOT"
  :description "A Cucumber Testing Module Written in Clojure"
  :url "https://github.com/mmadde10/CloCumber"
  :license {:name "Eclipse Public License"
            :url "https://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[com.siili/lein-cucumber "1.0.7"]]
  :cucumber-feature-paths ["test/features/"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "2.0.0"]
                 [etaoin "0.2.8-SNAPSHOT"]
                 [webica "3.0.0-beta2-clj0"]
                 [org.clojars.miau.biz/selenium-server-standalone "2.0a2"]
                 [environ "1.1.0"]]
  :profiles {:dev {:dependencies [[ring/ring-devel "1.4.0"]
  [com.siili/lein-cucumber "1.0.7"]]}}
  :main clocumber.core
  :aot [clocumber.core])

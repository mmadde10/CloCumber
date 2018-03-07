(require '[environ.core :refer [env]])
(import '[com.thoughtworks.selenium DefaultSelenium])
(require
  '[clojure.string :as string]
  '[webica.core :as w] ;; must always be first
  '[webica.by :as by]
  '[webica.web-driver :as driver]
  '[webica.firefox-driver :as firefox]
  '[webica.web-element :as element]
  '[webica.web-driver-wait :as wait]
  '[webica.remote-web-driver :as browser])


(defn- gen-agents
  [num-agents]
  (take num-agents (map agent (repeat nil)))) 

(def *default-options* {
  :port 4444 
  :host "localhost" 
  :command "*firefox" 
  :url "http://localhost/" 
  :num-agents 4 })

(def desired-cap
    {:name: {:env {:name}},
    :username {:env {:SAUCE-USER-NAME}},
    :sauce-access-key {:env {:SAUCE-ACCESS-KEY}},
    :os {:env {:os}},
    :browser {:env {:browser}},
    :browser-version {:env {:browser-version}}
    :platform {:env {:platform}},
    :browser-name {:env {:browser-name}},
    :tunnel-Id {:env {:tunnel-id}},
    :url {:env {:url}},
    :host "http://%s:%s@ondemand.saucelabs.com:80/wd/hub"})


(defn parse-options
  "Get options as hash map, provide defaults"
  [args]
  (let [options (apply hash-map args)] ; Convert [:port ####] to {:port ####}
    (merge *default-options* desired-cap)))


(defn make-browser [test-fn, opts]
  (let [client (new DefaultSelenium (:username desired-cap) (:sauce-access-key desired-cap) (:host desired-cap)  
     (:os desired-cap) (:browser desired-cap) (:browser-version desired-cap))]
    (.start client)))
(import '[com.thoughtworks.selenium DefaultSelenium])
(require '[environ.core :refer [env]])


(def sauce-username
  ({:env {:SAUCE-USER-NAME}}))

(def sauce-access-key
  ({:env {:SAUCE-ACCESS-KEY}}))





(defn- make-browser [test-fn, opts, username, access-key]

  (def desired-cap
    {:name: "name",
    :command "{
              \"username\" : \"SAUCE-USER-NAME\",
              \"access-key\" : \"SAUCE-ACCESS-KEY\",
              \"os\" : \"Windows 2003\",
              \"browser\" : \"firefox\",
              \"browser-version\" : \"\"}",
    :platform "platform",
    :browser-name "browsername",
    :tunnel-Id "version"
    :build build,
    :url url,
    :port 30000,
    :host "saucelabs.com"})

  (let [client (new DefaultSelenium (:host desired-cap) (:port desired-cap) (:command desired-cap) 
                    (:url desired-cap))]
    (.start client)
    (try
    ;;try to run tests here
      (test-fn client)
      (catch Exception e false)
      (finally
        (.stop client)))))
(import '[com.thoughtworks.selenium DefaultSelenium])
(require '[environ.core :refer [env]])



(defn- make-browser [test-fn, opts]

(def sauce-username
  ({:env {:SAUCE-USER-NAME}}))

(def sauce-access-key
  ({:env {:SAUCE-ACCESS-KEY}}))

  (def desired-cap
    {:name: "name",
    :username sauce-username,
    :sauce-access-key sauce-access-key,
    :os os,
    :browser browser,
    :browser-version version
    :command "{
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
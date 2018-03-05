(require 'selenium)

(def test-google
  {
   :name "google"
   :test (fn [client]
           (doto client
             (.open "http://www.google.com")
             (.type "q" "Sauce Labs")
             (.click "btnG")
             (.waitForPageToLoad "5000"))
           (.isTextPresent client "Selenium"))
   })

(def tests [test-google])

; Our fancy reporter :)
(defn reporter
  [results]
  (doseq [r results]
    (println r)))

(run-tests tests reporter
           :host "saucelabs.com"
           :command "{
              \"username\" : \"SAUCE-USER-NAME\",
              \"access-key\" : \"SAUCE-ACCESS-KEY\",
              \"os\" : \"Windows 2003\",
              \"browser\" : \"firefox\",
              \"browser-version\" : \"\"}"
           :url "http://saucelabs.com")
(use 'clojure-cukes.core)
(use 'clojure.test)
(ns browser (:require [src.clocumber.browser :as browser]))


(Given #"^I have a browser"
       (context (browser\make_browser))

(When #"I visit \"([^\"]*)\"" [website]
      (eat (repeat (read-string n) thing)))

(and #"I fill in \"([^\"]*)\" with \"([^\"]*)\"" [search text]
      (eat (repeat (read-string n) thing)))

(and #"I press \"([^\"]*)\"" [button]
      (eat (repeat (read-string n) thing)))

(Then #"^I should see \"([^\"]*)\"" [page-name]
      (assert (= (name (page)) page-name)))
(import '[com.thoughtworks.selenium DefaultSelenium])
(ns browser (:require [src.clocumber.browser :as browser]))


(defn- run-single-test
  "Run a single test, append test result to results"
  [test results opts]
  (let [test-fn (test :test)
        value (run-with-client test-fn opts)
        res {:test (test :name) :value value}]
    (dosync (alter results (fn [old] (conj old res))))))


(defn run-tests
  [tests reporter & args]
  (let [opts (browser/parse-options args)
        agents (browser/gen-agents (:num-agents opts))
        results (ref [])]
    (doseq [[test agent] (map vector tests (cycle agents))]
      (send agent (fn [_] (run-single-test test results opts))))
    (doseq [agent agents] (await agent)) ; Wait for tests to finish
    (shutdown-agents)
    (reporter @results)
    @results))

(defn tests-failed?
  "Check if all tests passed"
  [results]
  (not (empty? (filter false? (map :value results)))))
(ns nlpcore.protocols
  "NLP core protocols")


(defprotocol Module
  (get-id [this] "Get module id")
  (get-version [this] "Get nlpcore version")
  (set-logger! [this newlogger] "Set current logger")
  (get-logger [this] "Get current logger"))

(def default-module-impl {:get-id (fn [this] (:id this))
                          :get-version (fn [this] "1.1")
                          :set-logger! (fn [this newlogger] (reset! (:logger this) newlogger))
                          :get-logger (fn [this] @(:logger this))})


(defprotocol Corpus
  (build-corpus! [this] "Build and save corpus.")
  (get-corpus [this] "Get corpus"))

(defprotocol Model
  (load-model! [this] "Load the model")
  (train-model! [this] "Train the model")
  (save-model! [this] "Save the model")
  (get-model [this] "Get the model"))

(defprotocol Tool
  (build-tool! [this] "(Re)Build the tool")
  (get-tool-features [this] "Get tool features as a map")
  (apply-tool [this text opts] "Apply the tool to a text using opts map"))

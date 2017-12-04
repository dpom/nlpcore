(ns nlpcore.spec
  (:require
   [clojure.spec.alpha :as s]
   [duct.logger :refer [Logger]]
   [nlpcore.protocols :refer [Module Corpus Model Tool]]))

(defmacro known-keys
  [& {:keys [req req-un opt opt-un gen] :as args}]
  (letfn [(known-spec? [k] (boolean (s/get-spec k)))]
    (doseq [e (concat req req-un opt opt-un)]
      (when-not (known-spec? e)
        (throw (ex-info (str e " is not a currently registered spec.") args)))))
  `(s/keys ~@(interleave (keys args) (vals args))))



(s/def :nlpcore/id string?)
(s/def :nlpcore/logger #(satisfies? Logger %))
(s/def :nlpcore/language #(re-matches #"[a-z]{2}" %))
(s/def :nlpcore/model #(and (satisfies? Module %) (satisfies? Model %)))
(s/def :nlpcore/corpus #(and (satisfies? Module %) (satisfies? Corpus %)))
(s/def :nlpcore/tool #(and (satisfies? Module %) (satisfies? Tool %)))

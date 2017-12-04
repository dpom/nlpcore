(defproject dpom/nlpcore "1.0"
  :description "Natural Language Processing core protocols"
  :url "https://dpom.github.io/nlpcore/"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.9.0-RC2"]
                 [duct/logger "0.2.1"]]
  :pedantic? :warning
  :plugins [[lein-ancient "0.6.10" :exclusions [commons-logging org.clojure/clojure]]
            [jonase/eastwood "0.2.6-beta2"]
            [lein-kibit "0.1.6" :exclusions [org.clojure/clojure]]
            [lein-cljfmt "0.5.7" :exclusions [org.clojure/clojure org.clojure/clojure rewrite-clj]]
            [lein-codox "0.10.3" :exclusions [org.clojure/clojure]]]
  :repl-options {:init-ns user}
  :deploy-repositories [["clojars" {:creds :gpg}]]
  :profiles {:check {:global-vars {*warn-on-reflection* true}}} 
  :pom-addition [:developers [:developer
                              [:name "Dan Pomohaci"]
                              [:email "dan.pomohaci@gmail.com"]
                              [:timezone "+3"]]]
  :codox {:doc-files []
          :exclude-vars nil
          :project {:name "nlpcore"}
          :source-paths ["src"]
          :output-path "docs/api"}
)

(ns mallijib.spec
  (:require
   [malli.core :as m]
   [malli.util :as mu]))

(def registry;
  {:a [:map ;
       [:number [:or int? nil?]]]
   :b [:map {:closed true} ;
       [:number [:or int? nil?]]]
   :d (mu/closed-schema ;
       [:map [:number [:or 'int? 'nil?]]])
   :e (mu/closed-schema ;
       [:map [:number [:or int? nil?]]])})

(println registry)
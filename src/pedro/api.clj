(ns pedro.api

  (:require
   [compojure.core :refer [POST GET OPTIONS defroutes]]
   [compojure.route :as route]
   [ring.adapter.jetty :refer [run-jetty]]
   [ring.util.response :refer [response]]
   [cheshire.core :as json]
   [pedro.calculador-trastes :as calc]))

(defn json-response
  [dados]

  {:status 200

   :headers

   {"Content-Type" "application/json"

    "Access-Control-Allow-Origin" "*"

    "Access-Control-Allow-Headers"
    "Content-Type"

    "Access-Control-Allow-Methods"
    "GET,POST,OPTIONS"}

   :body

   (json/generate-string dados)})

(defn calcular-api
  [request]

  (try

    (let [dados

          (json/parse-string
           (slurp (:body request))
           true)

          escala
          (:escala dados)

          trastes
          (:trastes dados)]

      (json-response

       {:resultado

        (calc/calcular-json
         escala
         trastes)}))

    (catch Exception e

      (json-response

       {:erro

        (.getMessage e)}))))

(defroutes app

  (OPTIONS

    "/*"

    []

    (json-response {}))

  (GET

    "/"

    []

    (json-response

     {:status
      "API ONLINE"}))

  (POST

    "/calcular"

    request

    (calcular-api request))

  (route/not-found

   (json-response

    {:erro
     "Rota nao encontrada"})))

(defn -main
  []

  (println
   "Servidor iniciado localhost:3000")

  (run-jetty

   app

   {:port 3000

    :join? false}))
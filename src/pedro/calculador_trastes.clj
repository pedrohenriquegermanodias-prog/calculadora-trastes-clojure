(ns pedro.calculador-trastes)

(defn distancia-pestana
  [escala traste]
  (* escala
     (- 1
        (/ 1
           (Math/pow 2
                     (/ traste 12.0))))))

(defn distancia-ponte
  [escala pestana]
  (- escala pestana))

(defn converter-numero
  [texto]
  (try
    (Double/parseDouble texto)
    (catch Exception _
      nil)))

(defn ler-numero
  [mensagem]

  (print mensagem)
  (flush)

  (let [valor
        (converter-numero
         (read-line))]

    (if (and valor
             (> valor 0))

      valor

      (do
        (println)
        (println "ERRO: digite um número válido maior que zero.")
        (println)

        (ler-numero mensagem)))))

(defn escolher-trastes
  []

  (println)
  (println "Escolha o instrumento:")
  (println "1 - Violão (20 trastes)")
  (println "2 - Guitarra (22 trastes)")
  (println "3 - Guitarra moderna (24 trastes)")
  (println "4 - Personalizado")
  (println)

  (print "Opção: ")
  (flush)

  (let [opcao
        (read-line)]

    (case opcao

      "1" 20
      "2" 22
      "3" 24

      "4"
      (int
       (ler-numero
        "Digite a quantidade de trastes: "))

      (do
        (println)
        (println "ERRO: opção inválida.")
        (println)

        (escolher-trastes)))))

(defn calcular-trastes
  [escala quantidade]

  (println)
  (println "========== RESULTADO ==========")
  (println)

  (loop [traste 1
         anterior 0]

    (when (<= traste quantidade)

      (let [pestana
            (distancia-pestana
             escala
             traste)

            ponte
            (distancia-ponte
             escala
             pestana)

            espaco
            (if (= traste 1)
              pestana
              (- pestana anterior))]

        (println
         (format
          "Traste %-2d | Pestana: %7.2f mm | Ponte: %7.2f mm | Espaço: %6.2f mm"
          traste
          pestana
          ponte
          espaco))

        (recur
         (inc traste)
         pestana)))))

(defn arredondar
  [valor]

  (/ (Math/round
      (* valor 100.0))
     100.0))

(defn calcular-json
  [escala quantidade]

  (loop [traste 1
         anterior 0
         resultado []]

    (if (> traste quantidade)

      resultado

      (let [pestana
            (distancia-pestana
             escala
             traste)

            ponte
            (distancia-ponte
             escala
             pestana)

            espaco
            (if (= traste 1)

              pestana

              (- pestana anterior))

            linha

            {:traste traste

             :pestana
             (arredondar pestana)

             :ponte
             (arredondar ponte)

             :espaco
             (arredondar espaco)}]

        (recur

         (inc traste)

         pestana

         (conj
          resultado
          linha))))))

(defn -main
  [& args]

  (println)
  (println "===== CALCULADOR DE TRASTES =====")
  (println)

  (let [escala
        (ler-numero
         "Digite a escala do instrumento (mm): ")

        quantidade
        (escolher-trastes)]

    (calcular-trastes
     escala
     quantidade)

    (println)
    (println "Cálculo finalizado.")
    (println)))
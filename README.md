# Calculadora de Trastes – Projeto em Clojure

## Componentes do grupo

Pedro Henrique Germano Dias 24.00871-0
Enzo Mardegan Gallego 24.00087-6
Henrique Ferreira Festraits 24.00736-6

## Descrição geral do projeto

O objetivo deste projeto foi desenvolver uma aplicação capaz de calcular automaticamente a posição dos trastes de instrumentos de corda, como guitarra, violão e baixo.

O sistema recebe a escala do instrumento em milímetros e a quantidade de trastes desejada. A partir dessas informações, são realizados os cálculos matemáticos para determinar:

- Espaçamento entre os trastes
- Distância da pestana até cada traste
- Distância do traste até o rastilho

Além do cálculo em si, também foi desenvolvida uma interface web para facilitar a utilização do sistema, permitindo interação visual entre usuário e aplicação.

---

## Arquitetura do sistema

O projeto foi dividido em duas partes principais:

### Frontend

Responsável pela interface visual da aplicação.

Tecnologias utilizadas:

- HTML
- CSS
- JavaScript

Funções:

- Receber dados do usuário
- Enviar informações para API
- Exibir resultados na tela

### Backend

Desenvolvido em Clojure.

Responsável por:

- Receber requisições
- Validar dados
- Realizar cálculos matemáticos
- Retornar resultados em JSON

Fluxo geral:

```

Frontend → API REST → Cálculo → JSON → Frontend

```

---

## Fluxo operacional

1. Usuário informa a escala do instrumento
2. Usuário seleciona quantidade de trastes
3. Frontend envia os dados para API
4. API processa os cálculos
5. API retorna os resultados
6. Frontend exibe tabela com informações dos trastes

---

## Funcionalidades principais

- Cálculo automático dos trastes
- Distância até pestana
- Distância até rastilho
- Espaçamento entre trastes
- Interface visual interativa
- API REST
- Validação de entrada
- Escolha de instrumentos pré-configurados
- Quantidade personalizada de trastes

---

## Tecnologias utilizadas

Backend:

- Clojure
- Ring
- Compojure
- Cheshire
- Jetty

Frontend:

- HTML
- CSS
- JavaScript

Ferramentas:

- VS Code
- Git
- Live Server

---

## Infraestrutura de execução do projeto

Sistema operacional utilizado:

- Windows

Execução:

- Java (JVM)
- Clojure CLI
- Navegador Web

Comunicação:

- HTTP
- JSON

---

## Configuração do ambiente

### Instalar Java

Instalar JDK compatível.

### Instalar Clojure

Instalar Clojure CLI.

### Instalar Git

Necessário para dependências do projeto.

### Instalar bibliotecas

No terminal:

```bash
clj
```

### Executar backend

```bash
clj -M -m pedro.api
```

### Executar frontend

Abrir:

```

frontend/index.html

```

Utilizar Live Server do VS Code.

---

## Endpoints – API

### GET /

Verifica funcionamento da API.

Resposta:

```json
{
"status":"API ONLINE"
}
```

---

### POST /calcular

Entrada:

```json
{
"escala":650,
"trastes":22
}
```

Saída:

```json
{
"resultado":[
{
"traste":1,
"espaco":36.48,
"ponte":613.52,
"pestana":36.48
}
]
}
```

---

## Futuras melhorias

- Exportação PDF
- Exportação CSV
- Histórico de cálculos
- Gráficos de visualização
- Mais modelos de instrumentos
- Melhorias visuais na interface
- Possível versão mobile

---

## Referências

https://clojure.org/

https://ring-clojure.github.io/

https://github.com/weavejester/compojure

https://github.com/dakrone/cheshire

Material disponibilizado pela disciplina.

---

Projeto desenvolvido para fins acadêmicos.
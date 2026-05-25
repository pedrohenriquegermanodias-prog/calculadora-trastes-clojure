async function calcular() {

    try {

        const escala =
            Number(
                document
                .getElementById("escala")
                .value);

        let trastes =
            Number(
                document
                .getElementById("instrumento")
                .value);

        if (trastes === 0){

            trastes =
                Number(
                    document
                    .getElementById("custom")
                    .value);

        }

        if (!escala || escala <= 0){

            alert(
                "Digite uma escala válida.");

            return;

        }

        const resposta =
            await fetch(

                "http://localhost:3000/calcular",

                {

                    method:"POST",

                    headers:{

                        "Content-Type":
                        "application/json"

                    },

                    body:

                    JSON.stringify({

                        escala:escala,

                        trastes:trastes

                    })

                });

        const texto =
            await resposta.text();

        console.log(texto);

        const dados =
            JSON.parse(texto);

        if(dados.erro){

            alert(
                dados.erro);

            return;

        }

        mostrarResultado(
            dados.resultado);

    }

    catch(erro){

        console.error(
            erro);

        alert(
            "Erro ao conectar com API.");

    }

}

function mostrarResultado(
resultado){

    let html =

    `
    
<table>

    <tr>

    <th>Traste Nº</th>

    <th>Espaçamento do traste (mm)</th>

    <th>Distância ao rastilho (mm)</th>

    <th>Distância à pestana (mm)</th>

    </tr>
    `;

    resultado.forEach(

    linha=>{

        html +=

        `

        <tr>

        <td>${linha.traste}</td>

        <td>${linha.pestana} mm</td>

        <td>${linha.ponte} mm</td>

        <td>${linha.espaco} mm</td>

        </tr>

        `;

    });

    html +=

    "</table>";

    document
    .getElementById(
        "resultado")
    .innerHTML=

    html;

}

document
.getElementById(
"instrumento")

.addEventListener(

"change",

function(){

    document
    .getElementById(
    "custom")

    .style.display=

    this.value==="0"

    ?"block"

    :"none";

});
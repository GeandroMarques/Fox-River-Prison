document.getElementById("nomeSearch").addEventListener('keydown', function(event) {
   const error = document.getElementById("errorBox");
   const content = document.querySelectorAll(".content");
   if (error) error.remove();

   if (event.key === 'Enter') {
      if (content.length > 0){
         content.forEach(div=> {
            div.remove();
         })
      }
      enviar(this.value);
   }
});

function enviar(nomePrisioneiro){
   
   fetch("/get_preso", {
      method: "POST",
      headers: {
         "Content-Type": "application/json"
      },
      body: JSON.stringify({dado:nomePrisioneiro})
   })
   .then(response =>response.json())
   .then(data =>{
      if (Array.isArray(data) && data.length > 0){
         imprimirData(data);
      }
      else{
         errorMessage("Não há presos com esse nome");
      }
   })
   .catch(err =>{
      console.log(err);
      errorMessage("Ocorreu um erro. Tente novamente mais tarde")
   })
}

function imprimirData(data){
   const mainContent = document.getElementById("main-content");

   data.forEach(preso => {
      const content = document.createElement("content");
      content.className = "content";
      mainContent.appendChild(content);

      const nome = document.createElement("p");
      nome.id = "nome";
      nome.innerHTML = "Nome: " + preso.nome; 
      content.appendChild(nome);

      const data_nascimento = document.createElement("p");

      data_nascimento.id = "data-nascimento";
      data_nascimento.innerHTML = "Data de Nascimento: " + preso.data_nascimento; 
      content.appendChild(data_nascimento);

      const contentData = document.createElement("div");
      contentData.className = "content-data";
      content.appendChild(contentData);

      const pena = document.createElement("p");
      pena.id = "pena";
      pena.innerHTML = "Pena: " + preso.pena_meses; 
      contentData.appendChild(pena);
      const data_entrada = document.createElement("p");
      data_entrada.id = "data-entrada";
      data_entrada.innerHTML = "Data de entrada: " + preso.data_entrada; 
      contentData.appendChild(data_entrada);
   });
}

function errorMessage(msg){
   const content = document.getElementById("main-content");

   const erroDiv = document.createElement("div");
   erroDiv.className = "error";
   erroDiv.id = "errorBox";
   
   content.appendChild(erroDiv);

   const message = document.createElement("p");
   message.id = "error";
   message.innerHTML = msg;
   
   erroDiv.appendChild(message);
}
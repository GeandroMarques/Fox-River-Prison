window.onload = function() {
   enviar();
};



function enviar(){
   fetch("/get_lista_presos", {
      method: "POST",
      headers: {
         "Content-Type": "application/json"
      },
      body: JSON.stringify({})
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
      errorMessage("Ocorreu um erro. Tente novamente mais tarde")
   })
}

function imprimirData(data){
   const mainContent = document.getElementById("main-content");

   data.forEach(preso => {
         const content = document.createElement("div");
         content.className = "content";
         mainContent.appendChild(content);

         const id = document.createElement("input");
         id.id = "id";
         id.value = preso.id_pessoa;
         id.type = "text";
         id.hidden = true;
         content.appendChild(id);

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

         const cela = document.createElement('p');
         cela.id = "cela";
         cela.innerHTML = "Cela: " + preso.cela;
         contentData.appendChild(cela);

         const buttons = document.createElement("div");
         buttons.className = "buttons";
         content.appendChild(buttons);

         const but1 = document.createElement("button");
         but1.id="update";
         but1.onclick = () => Atualizar(preso.id_pessoa);
         but1.innerHTML = "Atualizar";
         buttons.appendChild(but1);

         const but2 = document.createElement("button");
         but2.id="delete";
         but2.onclick = () => deletar(preso.id_pessoa);
         but2.innerHTML = "Deletar";
         buttons.appendChild(but2);
   });
}

function deletar(id){
   fetch("/deletar_preso", {
      method: "POST",
      header: {
         "Content-Type": "application/json"
      },
      body: JSON.stringify({id:id})
   })
   .then(() =>{
      location.reload();
   })
   .catch(err =>{
      console.log(err);
   })
}

function Atualizar(id){
   window.location.href= `../../views/editarPreso.html?id=${id}`;
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
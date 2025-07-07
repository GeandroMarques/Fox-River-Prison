document.getElementById('formEditarPreso').addEventListener('submit', async function(event) {
    event.preventDefault();

    const params = new URLSearchParams(window.location.search);
    const id_pessoa = parseInt(params.get("id"));
    const nome = document.getElementById('nome').value;
    const data_nascimento = document.getElementById('data_nascimento').value;
    const pena_meses = parseInt(document.getElementById('pena_meses').value);
    const cela = parseInt(document.getElementById('cela').value);

    console.log(id_pessoa);

    try {
        const response = await fetch("/atualizar_preso", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({id:id_pessoa, nome:nome,data_nascimento:data_nascimento,pena_meses:pena_meses,cela:cela})
        });

        const result = await response.json();

        if (response.ok) {
            mostrarSucesso('Prisioneiro atualizado com sucesso!');
            limparFormulario();
        } else {
            mostrarErro(result.message || 'Erro ao atualizar prisioneiro');
        }

    } catch (error) {
        console.error('Erro:', error);
    }
});

// Funções auxiliares (reutilizáveis)
function mostrarSucesso(mensagem) {
    const divMensagem = document.getElementById('mensagem');
    divMensagem.innerHTML = `<div class="alert alert-success">${mensagem}</div>`;
    setTimeout(() => divMensagem.innerHTML = '', 3000);
}

function mostrarErro(mensagem) {
    const divMensagem = document.getElementById('mensagem');
    divMensagem.innerHTML = `<div class="alert alert-danger">${mensagem}</div>`;
}

function limparFormulario() {
    document.getElementById('formEditarPreso').reset();
}

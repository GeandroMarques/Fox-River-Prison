document.getElementById('formCadastroPreso').addEventListener('submit', async function(event) {
    event.preventDefault();
    
    // 1. Coletar dados do formulário
            nome = document.getElementById('nome').value;
            data_nascimento = document.getElementById('data_nascimento').value;
            pena_meses = parseInt(document.getElementById('pena_meses').value);
            cela = parseInt(document.getElementById('cela').value);

    // 3. Enviar para o backend
    try {
        const response = await fetch('/cadastrar_preso', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({nome:nome, data_nascimento:data_nascimento,pena_meses:pena_meses,cela:cela})
        });

        const result = await response.json();
        
        if (response.ok) {
            mostrarSucesso('Prisioneiro cadastrado com sucesso!');
            limparFormulario();
        } else {
            mostrarErro(result.message || 'Erro ao cadastrar prisioneiro');
        }
    } catch (error) {
        console.error('Erro:', error);
    }
});

// Funções auxiliares
function validarDados(data) {
    // Validações básicas - personalize conforme suas regras
    if (!data.pessoa.nome || data.pessoa.nome.length < 3) {
        mostrarErro('Nome inválido (mínimo 3 caracteres)');
        return false;
    }
    
    if (data.prisioneiro.pena_meses <= 0) {
        mostrarErro('Pena deve ser maior que 0 meses');
        return false;
    }
    
    if (data.prisioneiro.cela <= 0) {
        mostrarErro('Cela inválida');
        return false;
    }
    
    return true;
}

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
    document.getElementById('formCadastroPreso').reset();
}
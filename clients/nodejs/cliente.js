
const axios = require('axios');

const BASE_URL = "http://localhost:8080/api";

async function runClient() {
  try {
    console.log("--- Cliente Node.js Conectado à API ---");

    // --- TESTE 1: Adicionar Livro ---
    const novoLivro = { isbn: "978-04", titulo: "Clean Code", autor: "Uncle Bob" };
    const resAdd = await axios.post(`${BASE_URL}/livros`, novoLivro);
    console.log(`\n[RESULTADO 1] Adicionar Livro: ${resAdd.data}`);

    // --- TESTE 2: Registrar Usuário ---
    const membroLocal = { id: 0, nome: "Bob Junior", matricula: "JS999" };
    const resUser = await axios.post(`${BASE_URL}/usuarios`, membroLocal);
    const membroRegistrado = resUser.data;
    console.log(`\n[RESULTADO 2] Usuário Registrado com ID: ${membroRegistrado.id}`);

    // --- TESTE 3: Buscar e Emprestar ---
    const resBusca = await axios.get(`${BASE_URL}/livros/busca`, { params: { titulo: "Distributed Systems" } });
    const livroBuscado = resBusca.data;

    if (livroBuscado) {
      console.log(`\n[BUSCA] Livro encontrado: ${livroBuscado.titulo}`);
     
      const emprestimoPayload = {
        livro: livroBuscado,
        membro: membroRegistrado,
        dataEmprestimo: "2023-10-01",
        dataPrevistaDevolucao: "2023-10-08"
      };

      const resEmp = await axios.post(`${BASE_URL}/emprestimos`, emprestimoPayload);
      console.log(`[RESULTADO 3] Empréstimo: ${resEmp.data}`);
    }

  } catch (error) {
    console.error("Erro na comunicação:", error.message);
  }
}

runClient();

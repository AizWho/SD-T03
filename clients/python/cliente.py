import requests
import json

BASE_URL = "http://localhost:8080/api"

def main():
    print("--- Cliente Python Conectado à API ---")

    # --- TESTE 1: Adicionar Livro ---
    novo_livro = {"isbn": "978-03", "titulo": "Microservices", "autor": "Newman"}
    resp = requests.post(f"{BASE_URL}/livros", json=novo_livro)
    print(f"\n[RESULTADO 1] Adicionar Livro: {resp.text}")

    # --- TESTE 2: Listar Acervo ---
    resp = requests.get(f"{BASE_URL}/livros")
    livros = resp.json()
    print("\n[RESULTADO 2] Listar Acervo:")
    for l in livros:
        status = "Disponível" if l['disponivel'] else "Indisponível"
        print(f"- {l['titulo']} ({status})")

    # --- TESTE 3: Registrar Usuário ---
    membro_local = {"id": 0, "nome": "Alice Silva", "matricula": "MAT123"}
    print(f"\n[TESTE 3] ID Local antes: {membro_local['id']}")
    
    resp = requests.post(f"{BASE_URL}/usuarios", json=membro_local)
    membro_registrado = resp.json()
    print(f"[RESULTADO 3] Membro retornado pelo servidor com ID: {membro_registrado['id']}")

    # --- TESTE 4: Empréstimo ---
    # Primeiro busca o livro
    resp = requests.get(f"{BASE_URL}/livros/busca", params={"titulo": "Design Patterns"})
    livro_buscado = resp.json()

    if livro_buscado:
        emprestimo_payload = {
            "livro": livro_buscado,
            "membro": membro_registrado,
            "dataEmprestimo": "2023-10-01",
            "dataPrevistaDevolucao": "2023-10-08"
        }
        resp = requests.post(f"{BASE_URL}/emprestimos", json=emprestimo_payload)
        print(f"\n[RESULTADO 4] Empréstimo: {resp.text}")
    
    # --- TESTE 5: Verificar Status ---
    resp = requests.get(f"{BASE_URL}/livros/busca", params={"titulo": "Design Patterns"})
    livro_apos = resp.json()
    print(f"\n[RESULTADO 5] Status Final do Livro '{livro_apos['titulo']}': Disponível? {livro_apos['disponivel']}")

if __name__ == "__main__":
    main()
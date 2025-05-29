
# Sistema de Gerenciamento de Consultório Médico 🏥

Este é um sistema simples de gerenciamento de consultório médico desenvolvido em Java. O projeto permite realizar operações de cadastro, atualização, exclusão e listagem de **pacientes**, **médicos** e **consultas**.

O sistema roda via terminal (linha de comando) e tem como objetivo treinar conceitos fundamentais de **Programação Orientada a Objetos (POO)**, como:  
- Encapsulamento  
- Classes e Objetos  
- Relacionamentos entre objetos  
- Tratamento de exceções  
- CRUD básico em memória (sem banco de dados)  

---

## 🚀 Funcionalidades

- ✅ Cadastrar, listar, atualizar e deletar pacientes  
- ✅ Cadastrar, listar, atualizar e deletar médicos  
- ✅ Agendar consultas entre pacientes e médicos  
- ✅ Atualizar o status das consultas (Agendada, Realizada ou Cancelada)  
- ✅ Listar todas as consultas marcadas  
- ✅ Validação de dados e tratamento de erros como ID não encontrado  

---

## 🛠️ Tecnologias Utilizadas

- Java (versão 17 ou superior recomendada)  
- JDK instalado e configurado  
- IDE de sua preferência (IntelliJ, Eclipse, VS Code ou outro)  

---

## 📦 Como executar

1. Clone este repositório:  
```bash
git clone https://github.com/Jooivys/Consultorio_Medico.git
```

2. Navegue até a pasta do projeto e abra na sua IDE.  

3. Compile e execute a classe `Main.java`.  

4. Utilize o menu interativo no terminal para navegar pelas funcionalidades.  

---

## 📁 Estrutura do Projeto

```
src/
├── entidade/         # Classes de domínio: Paciente, Medico, Consulta
├── repositorio/      # Classes responsáveis por armazenar os dados em memória
├── servico/          # Regras de negócio
├── erro/             # Tratamento de exceções
├── template/         # Menu e interface com o usuário
└── Main.java         # Classe principal (ponto de entrada do programa)
```

---

## 👨‍💻 Autor

Desenvolvido por: 
**[@Jooivys](https://github.com/Jooivys)**  
**[@ianbrunini](https://github.com/ianbrunini)**
**[@Gustavobr8001](https://github.com/Gustavobr8001)**
**[@arthurcopaoli](https://github.com/arthurcopaoli)**
**[@gustavoramalho1](https://github.com/gustavoramalho1)**
---

## 📝 Observações

Este projeto não utiliza banco de dados, os dados são armazenados em memória enquanto o programa está em execução. Ao finalizar o programa, todos os dados são apagados.  

---

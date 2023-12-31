# DesafioDigiboard
O desafio propõe o desenvolvimento de uma aplicação web com as seguintes características: 
 - [X] 1.Crie uma aplicação web utilizando Java 8 + JSF e banco de dados PostgreSQL. 
 - [X] 2.Crie uma página com um formulário para adicionar novos usuários ao banco de dados, incluindo campos para nome, endereço e data de nascimento. 
 - [X] 3.Utilize o componente "dataTable" para exibir todos os usuários cadastrados no banco de dados. 
 - [X] 4.Adicione uma funcionalidade de edição e exclusão de usuários. 
 - [ ] 5.Implemente validações nos campos do formulário, garantindo que todos os campos obrigatórios são preenchidos e que a data de nascimento é válida. 
 - [ ] 6.Permita que uma foto do perfil seja carregada. 
 - [X] 7.Implemente uma função de busca para localizar usuários por nome ou parte do nome.
 - [ ]  8.Adicione autenticação e autorização à aplicação, garantindo que somente usuários autenticados possam acessar as funcionalidades de adição, edição e exclusão de usuários. 
 - [X] 9.Teste a aplicação e garanta que todas as funcionalidades estão funcionando corretamente e sem erros. 
 - [X] 10.Faça comentários no código.

## Tecnologias utilizadas
- Java
- JSF (Java Server Faces)
- Primes Faces 5.1 (Framework)
- PostgreSQL (Banco de Dados)
- Netbeans 8.02 (IDE)

## Como o projeto funciona?
O programa irá abrir com a tela **Listar Usuários**:

![Tela inicial](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaInicial.png)

Você poder adicionar, editar e excluir usuários do programa, quantas vezes quiser.

### Tela Novo Cadastro
Ao apertar no botão **Novo Cadastro**, o programa esconderá a `dataTable` e irá evidenciar a Tela Novo Cadastro. 

![Tela Novo Cadastro](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaNovoCadastro.png)

Após inserir as informações do novo usuário, e clicar em **Salvar**, o programa irá salvar os dados no Banco de Dados e voltará para a tela **Listar Usuários** com uma mensagem de sucesso ou erro e com os dados atualizados.

![Tela Salvo](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaSalvo.png)

### Tela Edição
Ao apertar no botão **Editar**, em algum dos dados salvos, o programa esconderá a `dataTable` e irá evidenciar a **Tela de Edição, (A mesma do Novo Cadastro)**.

![Tela Edição](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaEdicao.png)

 Após atualizar as informações do usuário, e clicar em **Salvar**, o programa irá salvar os dados no Banco de Dados e voltará para a tela **Listar Usuários** com uma mensagem de sucesso ou erro e com os dados atualizados.
 
![Tela Edição Salvo](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaedicaoSalvo.png)

### Tela Exclusão
Ao apertar no botão **Deletar**, o programa esconderá abrirá uma **Modal** perguntando ao usuário do sistema se ele tem certeza da operação. 

Caso **não**, a Modal irá se fechar.
Caso **sim**, o programa irá excluir o dado do Banco de Dados.

![Tela Excluir](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaExcluir.png)

 Após a exclusão,  o programa irá voltar para a tela **Listar Usuários** com uma mensagem de sucesso ou erro e com os dados atualizados.
 
  ![Tela Exclusão Sucesso](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaExcluirSucesso.png)

### Busca pelo o nome
Também é possível localizar usuários pelo nome de usuário completo ou parte do nome.

![Busca pelo o nome](https://github.com/Falcon-Br/DesafioDigiboard/blob/main/assets/telaBuscaNome.png)


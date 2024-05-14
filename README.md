<h1 align="center">Teste DTI Digital</h1>

<p align="center">Este é um aplicativo web para encontrar o petshop com o menor preço de acordo com a data e a quantidade de cães pequenos e grandes .</p>


## Funcionalidades

- Cadastro de Banho: Os usuários podem inserir a data da reserva e a quantidade de cães pequenos e grandes para fazer a busca.
- Comparação de Preços: O aplicativo compara os preços de banho em diferentes petshops e mostra o mais econômico e em caso de empate o petshop com menor distacia é o escolhido.
- Visualização de Resultados: Após a busca, os usuários podem ver os detalhes do petshop com o melhor preço.

# Backend
### Tecnologias Utilizadas
- Java 17
- Spring Boot 3.0.4
- Maven
- Lombok
- JUnit

### Como Executar o Projeto

1. Clone o Repositório: `https://github.com/rafaelsouzabe/teste-dti.git`
2. Acesse a pasta do Backend: `$ cd testeDTI`
3. Execute o comando na raiz do projeto para instalar as dependencias (certifique que tenha o Maven instalado local) `$ clean install`
4. Execute o comando do Spring para executar o projeto `./mvnw spring-boot:run`  

### Premissas Assumidas
* Foi criada uma classe Repository para simular um repositório de banco de dados.
* Nos três exemplos de petshops fornecidos, existem dois tipos de aumento nos finais de semana: por porcentagem no valor do preço dos cães ou um valor fixo de aumento. Para resolver essa diferença, foi adicionado um atributo Booleano chamado "porcentagem" na classe Petshop. Se esse atributo for verdadeiro, os valores recebidos para o aumento de cães pequenos e grandes são tratados como aumento percentual. Caso contrário, os valores são tratados como um aumento fixo.
* Foi criada uma interface que define a assinatura do método calcularPreçoTotal. As classes CalculadoraFimDeSemana e CalculadoraSemana implementam essa interface e realizam o cálculo de acordo com as regras estabelecidas.
* A utilização da interface permite que o código permaneça aberto para futuras extensões, possibilitando a incorporação de possíveis novas regras de negócio para o cálculo de custos.
  
# Frontend
### Tecnologias Utilizadas
- React.js 
- TypeScript
- CSS
- React Hook Form
- Axios
    
### Como Executar o Projeto

1. Clone o Repositório: `https://github.com/rafaelsouzabe/teste-dti.git`
2. Acesse a pasta do Backend: `$ cd dtiFront`
3. Instale as Dependências: `npm install`
4. Inicie o Servidor Frontend: `npm run dev` 
5. Acesse o Aplicativo: Navegue para http://localhost:5173 em seu navegador

### Estrutura do Projeto

```
petshop-app/
  ├── backend/
  │   ├── src/
  │   │   ├── main/
  │   │   │   ├── java/
  │   │   │   │   ├── com/
  │   │   │   │   │   ├── example/
  │   │   │   │   │   │   ├── testDTI/
  |   │   │   │   │   │   │   ├── controller/
  |   │   │   │   │   │   │   │   └──  PetshopController.java
  │   │   │   │   │   │   │   ├── core/
  |   │   │   │   │   │   │   │   ├── calculadora/
  |   |   │   │   │   │   │   │   │   ├── CalculadoraFimDeSemana.java
  |   |   │   │   │   │   │   │   │   ├── CalculadoraPreço.java
  |   |   │   │   │   │   │   │   │   └── CalculadoraSemana.java
  |   │   │   │   │   │   │   │   ├── entity/
  |   |   │   │   │   │   │   │   │   └──  Petshop.java
  │   │   │   │   │   │   │   ├── repository/
  |   |   │   │   │   │   │   │   │   └──  Repository.java
  │   │   │   │   │   │   │   ├── request/
  |   |   │   │   │   │   │   │   │   └──  MelhorPetshopRequest.java
  │   │   │   │   │   │   │   ├── response/
  |   |   │   │   │   │   │   │   │   └──  MelhorPetshopResponse.java
  |   │   │   │   │   │   │   ├── service/
  |   |   │   │   │   │   │   │   │   └── PetshopService.java
  |   │   │   │   │   │   │   └── CorsConfig.java
  |   |   │   │   │   │   │   └── TesteDtiApplication.java
  │   │   │   └── resources/
  │   │   │       └── application.properties
  │   │   └── test/
  │   │   │   ├── java/
  │   │   │   │   │   ├── example/
  │   │   │   │   │   │   ├── testDTI/
  |   │   │   │   │   │   │   ├── service/
  |   |   │   │   │   │   │   │   │   └──  PetshopServiceTest.java
  ├── frontend/
  │   ├── public/
  │   ├── src/
  │   │   ├── components/
  │   │   │   ├── MelhorPetshopDisplay.tsx
  │   │   │   ├── PetshopRequestForm.tsx
  │   │   │   └── PetshopStyles.css
  │   │   ├── api.ts
  │   │   ├── App.tsx
  │   │   └── main.tsx
  │   └── package.json
  └── README.md
```

# Aplicação Doadores de Sangue

## Para a implementação deste projeto a arquitetura foi estruturada em camadas, garantindo que cada componente tenha uma responsabilidade específica.

### Aqui estão os detalhes de cada camada e as interações entre elas:
***
## Camada de Apresentação
Esta camada é responsável por lidar com a base de dados de doadores e apresentar os dados processados.
### Componentes:
#### Controller: Controladores Spring Boot que recebem requisições HTTP e retornam respostas HTTP.
#### ObjConfig: Responsável por criar um Bean de ObjectMapper
#### DTOs: Records para transferência de dados
***
## Camada de Serviço
Esta camada contém a lógica de negócios. Processa os dados recebidos da camada de apresentação e interage com a camada de dados, se necessário.
### Componentes:
#### Service: Serviços Spring Boot que implementam a lógica de negócios, como cálculos de IMC, percentuais de obesidade, e outras métricas.
#### Validation: Validações das regras de negócios
***
## Camada de Dados
Nesta camada é implementado os recursos da aplicação e também a gestão de persistência e recuperação dos dados.
### Componentes:
#### Entity: Classes que representam os dados (entidades).
#### Repository: Interfaces Spring Data JPA.
#### Protocols: Interfaces de contrato para a camada de serviço

***  
Para compilar e executar este projeto, precisará ter instalado na máquina:
- Java Development Kit (JDK) versão 8 ou superior
- Maven

## Instruções de instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/jpcarrijo/blood-donors.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd blood-donors
    ```

3. Compile o projeto usando o Maven:
    ```sh
    mvn clean install
    ```

## Como executar o projeto

1. Inicie o servidor:
    ```sh
    java -jar target/blood-donors.jar
    ```

2. O servidor estará disponível em [http://localhost:8082](http://localhost:8082).

## Banco de Dados

Este projeto utiliza um banco de dados MySQL. Certifique-se de ter um servidor MySQL em execução e configure as propriedades de conexão no arquivo `application.yaml`.

## Outras informações

- Este projeto foi desenvolvido em Java e utiliza o framework Spring Boot.
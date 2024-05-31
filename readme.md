# Aplicação Doadores de Sangue

## Para a implementação deste projeto a arquitetura foi estruturada em camadas, garantindo que cada componente tenha uma responsabilidade específica.

### Aqui estão os detalhes de cada camada e as interações entre elas:
***
## Camada de Apresentação
Esta camada é responsável por lidar com a base de dados de doadores e apresentar os dados processados.
### Componentes:
#### Controller: Controladores Spring Boot que recebem requisições HTTP e retornam respostas HTTP.
***
## Camada de Serviço (Service Layer)
Esta camada contém a lógica de negócios. Processa os dados recebidos da camada de apresentação e interage com a camada de dados, se necessário.
### Componentes:
#### Service: Serviços Spring Boot que implementam a lógica de negócios, como cálculos de IMC, percentuais de obesidade, e outras métricas.
***
## Camada de Dados (Data Layer)
Nesta camada é implementado os recursos da aplicação e também a gestão de persistência e recuperação dos dados.
### Componentes:
#### Entity: Classes que representam os dados (entidades).
#### Repository: Interfaces Spring Data JPA.
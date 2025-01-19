# 🏆 Desafio de Código: Design Patterns com Spring Boot

Bem-vindo ao repositório do desafio de código sobre Design Patterns! Este projeto faz parte do bootcamp **DIO & Cognizant - Arquitetura com Spring Boot e Cloud** e aborda os padrões Singleton, Strategy/Repository e Facade.

## 🛠️ Tecnologias Utilizadas
- Java 17
- Spring Boot 3.3.5
- Maven
- Lombok
- H2 Database (para testes)

## 🎯 Objetivo
Implementar um sistema simples que demonstra a aplicação dos design patterns Singleton, Strategy/Repository e Facade utilizando Spring Boot e tecnologias relacionadas.


## 📌 Padrões Implementados

### Singleton
O padrão Singleton garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela. No projeto, ele é utilizado para gerenciar a conexão com o banco de dados H2.

### Strategy/Repository
O padrão Strategy permite que uma família de algoritmos seja definida, encapsulada e utilizada de forma intercambiável. O padrão Repository é usado para abstrair a lógica de armazenamento, recuperação e pesquisa, geralmente em um banco de dados. No projeto, a interface `Strategy` é implementada por diferentes estratégias de busca e as classes de repositório fazem uso dessas estratégias.

### Facade
O padrão Facade fornece uma interface simplificada para um subsistema complexo. No projeto, ele é utilizado para expor uma interface simples para operações complexas de negócios, integrando as estratégias e os repositórios.

## 🔍 Funcionalidades Principais
 - Gerenciamento de Conexão (Singleton): Gerencia a conexão com o banco de dados de forma única.
 - Operações de Busca (Strategy/Repository): Implementa diferentes estratégias de busca no repositório.
 - Interface Simples (Facade): Exposição de uma interface única para operações de negócios complexas.

## 🧑‍💻 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou enviar pull requests.



Desenvolvido por [Marcos Correa](https://github.com/correamarcos) .

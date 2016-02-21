Caixa Eletronico
===

Sistema de cadastro de usuários e caixas eletrônicos, com a funcionalidade de sacar o menor número de notas disponíveis por caixa eletrônico.

O Projeto consiste em 3 módulos:

* ce-crud: Responsável por realizar o cadastro dos usuários e caixas eletrônicos. Desenvolvido utilizando *spring-boot*, *JPA*, *Postgres*, *JUnit*, *Mockito*, *Java 8*;

* ce-core: Responsável pela lógica de saques dos caixas eletrônicos. Desenvolvido com: *spring-boot*, *JUnit*, *Mockito* *Java 8*, *RestTemplate*;

* ce-ui: Sistema front-end responsável por agrupar os outros dois sistemas. Feito utilizando *Angular*, *bootstrap*, *bower* e Gulp;

O que será necessário?
===

* Node instalado;
* Gulp instalado;
* Bower instalado;
* Maven instaldo e configurado;
* Java 8 instalado e configurado;

**Caso for rodar local o banco de dados**

* Postgres instaldo (Com db ceDB criado);

Como Rodar?
===

Docker
===

Normal
===

Após clonar o projeto:

* _ce-crud_: Dentro da pasta do projeto executar o comando: `mvn spring-boot:run -Dspring.profiles.active='elephant'` para usar o banco do ElephantSQL ou `mvn spring-boot:run -Dspring.profiles.active='local'` para rodar com a base local;

* _ce-core_: Dentro da pasta do projeto executar o comando: `mvn spring-boot:run`;

* _ce-ui: Dentro da pasta do projeto executar os comando: `npm install`, `bower install` na primeira vez que for executar o projeto. E, por fim, executar `gulp` para iniciar o server. *O projeto rodará na porta 9000*;

Qualquer dúvida entre em contato: Pedro Hos <pedro-hos@outlook.com>

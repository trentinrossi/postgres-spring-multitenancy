# Postgres Multitenancy

Projeto desenvolvido para criar um ambiente de testes utilizando o recurso de multi-tenant.

### Características

- É usado a estratégia de schema dedicado, ou seja, no Postgres existe somente um banco de dados, onde os tenants são os schemas, criados de forma separada dividindo totalmente um tenant de outro.
- Toda requisição é interceptada e obtido o HEADER de nome X-TENANT, onde o usuário deve passar o nome do tenant (schema) que deseja. O identificador do tenant então é armazenado em uma ThreadLocal para que seja acessado pelo Database.
- Os tenants são configurados no arquivo application.properties, onde serão criados/atualizados quando o sistema for reiniciado.
- É utilizado o Flyway para criar a estrutuda de cada tenant de forma versionada, ou seja, ao criar um novo arquivo de versão do Flyway este será executado em cada um dos tenants contidos no arquivo application.properties.

### Tecnologias utilizadas

- Java 11
- Spring Boot 2.3.2
- Postgres 12
# LeadManager

**LeadManager** é uma aplicação web para gerenciar leads com operações CRUD e autenticação de usuários, desenvolvida em Spring Boot.

## Database

- **Banco de Dados**: MySQL com tabelas para `Source`, `User`, `Lead`, `Tag`, e `Lead_Tag`.
- **Entidades Principais**:
  - **Source**: Armazena as origens dos leads.
  - **User**: Registra os usuários do sistema com autenticação.
  - **Lead**: Contém informações dos leads, como nome, e-mail, telefone e dados de origem.
  - **Tag**: Armazena tags associadas aos leads para segmentação.
  - **Lead_Tag**: Relacionamento many-to-many entre leads e tags.

 ![Diagrama ER do LeadManager](https://github.com/LucasJoseArantes/Projeto_BE_ORM/blob/main/lead-manager/src/main/resources/static/bd_lead_manager.png?raw=true)


## API

- **Documentação da API**: Utiliza **Swagger** com OpenAPI 3 para detalhar os endpoints e facilitar o uso por desenvolvedores.
- **Endpoints Principais**:
  - **Cadastro de Leads**: `POST /api/leads`
  - **Listagem de Leads**: `GET /api/leads`
  - **Obter Lead por ID**: `GET /api/leads/{id}`
  - **Atualização de Leads**: `PUT /api/leads/{id}`
  - **Exclusão de Leads**: `DELETE /api/leads/{id}`
  - **Autenticação de Usuários**: `POST /api/auth/login`
  - **Segmentação de Leads**: `GET /api/leads/segment`


Para mais detalhes, consulte a [documentação completa](https://docs.google.com/document/d/1kkk3oU1cYPHTluU0Z1AsOkjwUPB5759bU-GhmCJMI0I/edit) e a API documentada no Swagger.

---


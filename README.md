# Java Training Capstone Project
## Banking Services API

### Description:

The Banking Services API will allow users to track and maintain information related to their Bank Accounts. Users will be able to open a new User Account with a fictitious institution. The users can then open and operate many different Bank Accounts of various types (Checkings, Savings, etc.). Bank Accounts can be owned by multiple Users. Users of an account or appropriate Employee Personnel can execute deposits, withdrawals, or transfers upon accounts.



### Business Requirements
The institution would like to have a digital application to move into the Digital Era for their company. Tasks that are accomplished at the banking facilities should be managed by this application. The institution wants clients to be able to open new accounts with many Checking and Saving Bank Accounts attached to said account, so long as they put in an initial $100 deposit. The institutions bank accounts are owned by potentially several clients. Clients are free to close out of their account once all accounts are settled. Other approved employees should also be able to service basic operations on client's bank accounts. As paper trails are important, the institution wants all transactions on any account to be logged/documented. Users should be able to provide their credentials to authenticate other operations made within the system.


### User Stories
- As a User, I want to open a new User Account
- As a User, I should be able to open a new Bank Account

Add 6-10 more User Stories
- As a [Role], I ...



### Tech Specs
- Java 11
- Spring Boot App
- Spring MVC
- Spring Data JPA
- Spring Test
- Postman
- Spring Cloud Gateway
- Spring Cloud Config
- Consul
- Kafka
- PostgreSQL on AWS RDS
- Swagger

### Functional Requirements
- MSA design of at least 2 microservices
- Uses a Gateway and Config Service
- Uses Consul to register services and automate load balancing
- Application functionality should be demonstrated through primarily Postman API calls.
- All code is either stored and maintained within a Repository such as GitHub.
- Preferably, application is deployed to the Cloud. Only Gateway Service is Publicly Accessible.
- Preferably, incorporates Kafka to handle inter-microservice communications.

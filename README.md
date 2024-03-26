# What does this repository contain?

This repository contains a project that was developed for Software Engineering course on Technical University of Lodz.

This project was developed by a team of developers (from Infrastructure and Network Applications specialization).

# Project development

Basically, there were 8 teams of 2 developers and 2 project architects. Every single team was responsible for a functional module.

Together with Bartek Kałach [https://github.com/bkalach], our responsibility was to create and develop quiz module:

For system administrator:

* Adding new quizzes
* Editing exising quizzes
* Deleting existing quizzes

For system user:

* Viewing existing quiz details (along with the best user score)
* Solving quizzes

# How to run this project?

* Clone the GitHub repository using:

```
git clone https://github.com/pkwiatkowski242447/GreenGameIO.git
```

or with GitHub CLI:

```
gh repo clone pkwiatkowski242447/GreenGameIO
```

* Run docker containers with following commands:

```
cd docker
docker compose up
```

* Run Spring Boot application using:

```
mvn spring-boot:run         # With local maven installation 
./mvnw spring-boot:run      # With maven wrapper
```

* Enter web folder containing React.js SPA application:

```
cd web
```

* Download required dependencies:

```
yarn install
```

* Run the SPA application:

```
yarn dev
```


# Technological stack

* Docker containers
* Spring (with libraries like Spring Boot, Data and Security) 
* PostgreSQL database
* React.js

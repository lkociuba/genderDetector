- 👋 Hi, I’m Łukasz Kociuba
- 👀 I’m interested in resolving technical problems, new technology and creating fascinating programs
- 🌱 I’m currently learning Java, Spring Boot, JUnit, PostgreSql, Clean Code, Design Patterns, JavaScript, Node.js, MongoDB
- 💞️ I’m looking to collaborate on simple projects to improve my coding skills
- 📫 How to reach me - kociubalukasz@gmail.com

# Gender Detection

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Implemented functions](#implemented-functions)

## General info
This is a simple guess gender detection project.
	
## Technologies
Project is created with:
* Java version: 11
* Maven
* Spring Boot version: 2.4.4

## Implemented functions
1. Guess gender by first token of given name.
1. Guess gender by all tokens of given name use majority rule.
1. Endpoint to guess gender detection
   1. http://localhost:8080/gender?name=Jan&algorithmType=firstToken
   1. http://localhost:8080/gender?name=Maria%20Gertruda%20Olaf&algorithmType=allTokens
1. Endpoint to male & felmale token lists.
   1. http://localhost:8080/genderList?tokenListName=maleTokens
   1. http://localhost:8080/genderList?tokenListName=femaleTokens
1. Female Token List:
   1. ("Maria", "Anna", "Gertruda")
1. Male Token List:
   1. ("Jan", "Andrzej", "Olaf")

## Setup
To run this project:

```
$ git clone https://github.com/lkociuba/genderDetector.git
```
```
$ docker pull lukaszkociuba/gender-detector:latest
```


- 👋 Hi, I’m Łukasz Kociuba
- 👀 I’m interested in resolving technical problems, new technology and creating fascinating programs
- 🌱 I’m currently learning Java, Spring Boot, JUnit, PostgreSql, Clean Code, Design Patterns
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
This is a simple guess gender detection project.

## Implemented functions
1. Guess gender by first token of given name.
1. Guess gender by all tokens of given name use majority rule.
1. Endpoint to guess gender detection
  *  http://localhost:8080/gender?name=Jan&algorithmType=firstToken
  * http://localhost:8080/gender?name=Maria%20Gertruda%20Olaf&algorithmType=allTokens
1. Endpoint to male & felmale token lists.
  * http://localhost:8080/genderList?tokenListName=maleTokens
  * http://localhost:8080/genderList?tokenListName=femaleTokens
1. Female Token List:
  * ("Maria", "Anna", "Gertruda")
1. Male Token List:
  * ("Jan", "Andrzej", "Olaf")

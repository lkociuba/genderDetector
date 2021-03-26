- 👋 Hi, I’m Łukasz Kociuba
- 👀 I’m interested in resolving technical problems, new technology and creating fascinating programs
- 🌱 I’m currently learning Java, Spring Boot, JUnit, PostgreSql, Clean Code, Design Patterns
- 💞️ I’m looking to collaborate on simple projects to improve my coding skills
- 📫 How to reach me - kociubalukasz@gmail.com

# genderDetection
This is a simple guess gender detection project.

Implemented functions:

1. Guess gender by first token of given name.
2. Guess gender by all tokens of given name use majority role.
3. Endpoint to guess gender detection
 -   http://localhost:8080/gender?name=Jan&algorithmType=firstToken
 -   http://localhost:8080/gender?name=Maria Gertruda Olaf&algorithmType=allTokens
4. Endpoint to male & felmale token lists.
 -    http://localhost:8080//genderList?tokenListName=maleTokens
 -    http://localhost:8080//genderList?tokenListName=femaleTokens

Female Token List:
 -   ("Maria", "Anna", "Gertruda")
Male Token List:
 -   ("Jan", "Andrzej", "Olaf")

# Turtle Track

JOSÉ CARLOS SILVA - API/Back-end  
LEONARDO GUIMARÃES MARQUES - Mobile/Front-end  
MARIA LUIZA GOVEIA - Machine Learning/AI  
MARIANA MARQUES SABIO - DevOps/API/Back-end  
VINÍCIUS DE ABREU PENA - Engenharia de Dados  

## Descrição

O Turtle Track é um aplicativo desenvolvido visando auxiliar especialistas com a preservação das tartarugas marinhas que habitam a costa brasileira. O APP permite o tracking de ninhos de diferentes espécies em regiões de interesse, assim como o registro e monitoramento de incidentes que possam afetar o bem-estar dos animais, de uma maneira prática e simples.
O ecossistema de cloud da Microsoft Azure será o principal serviço de infraestrutura usado para a plataforma, por conta da familiaridade dos integrantes da equipe com sua interface e recursos e pela sua acessibilidade.

Por conta das dificuldades e desafios de infraestrutura inerentes em se ter um servidor físico, uma máquina virtual em cloud será essencial para o deploy da API Rest em Spring, que será usada para o back-end da plataforma. Um servidor Azure SQL será usado como o banco de dados relacional para a API Rest.
Para o deploy da API em si, será usado a ferramenta de Web App da Azure, com um contêiner Linux, tendo como runtime o JDK 17. Essa API alimentará o aplicativo, criando o meio de conexão entre as empresas e os vendedores.

## Instruções

Após clonar o repositório, rodar a classe _Main_ do projeto em sua IDE de preferência ou rodar o _.jar_ compilado com o _maven_ pelo terminal. O deployment principal está sendo feito pelo Deployment Center do Microsoft Azure, direto deste repositório do GitHub.

## Diagramas

**Diagrama Relacional:**  
![Diagrama Relacional](/assets/images/relacional.jpg)

**Diagrama Infraestrutura:**  
![Diagrama Infraestrutura](/assets/images/infra.png)
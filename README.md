# Turtle Track

![Logo](/assets/images/logo.jpg)

JOSÉ CARLOS SILVA - API/Back-end  
LEONARDO GUIMARÃES MARQUES - Mobile/Front-end  
MARIA LUIZA GOVEIA - Machine Learning/AI  
MARIANA MARQUES SABIO - DevOps/API/Back-end  
VINÍCIUS DE ABREU PENA - Engenharia de Dados  

## Descrição

Tartarugas marinhas são seres migratórios e desenvolvem um papel de extrema importância na manutenção do equilíbrio dos ecossistemas marinhos, sendo assim vitais para a preservação da biodiversidade nos mares. No Brasil, são encontradas 5 espécies de tartarugas marinhas (existindo 7 em todo o mundo) e todas essas (tanto no território marítimo brasileiro, quanto no resto do mundo) são atualmente classificadas com algum grau de vulnerabilidade em relação à extinção.

Considerando que o Brasil possui uma das 20 maiores áreas de litoral no mundo e cerca de 70% das espécies de tartaruga marinha existentes são encontradas no país, pode-se dizer que o papel que organizações e indivíduos brasileiros podem desempenhar na conservação das populações dessas tartarugas possui um grande peso na preservação do ecossistema marítimo mundial.

A Turtle Track vem para auxiliar todos os profissionais envolvidos nesse trabalho de tanta importância, com a missão de desenvolver um aplicativo que facilite o monitoramento das populações de tartarugas marinhas na costa brasileira. O aplicativo tem como foco majoritário a análise de dados relacionados ao monitoramento das populações para acompanhar seu crescimento ou diminuição, providenciando uma tela para a inserção de informações coletadas em trabalho de campo e uma seção que exibe esses dados em de forma organizada em números gráficos ao usuário.

O front-end do aplicativo foi desenvolvido em React Native e busca ser o mais amigável possível ao usuário, contando com uma interface minimalista e informações fáceis de entender. O back-end foi desenvolvido como uma API Rest Spring com JDK 17, usando Azure SQL Server para o banco de dados relacional. O deploy do back-end será realizado por um Web App em cloud, também no Microsoft Azure.

Por fim, o projeto também conta com redes neurais que desempenham um papel fundamental na análise dos dados relacionados à reprodução de quelônios: Com o TensorFlow como uma das principais ferramentas, implementando e treinando modelos de RNN de maneira eficiente e escalável. O TensorFlow fornece uma estrutura flexível para construir e otimizar redes neurais, enquanto as RNNs são adequadas para lidar com sequências temporais de dados, como registros de reprodução ao longo do tempo. Combinando RNNs e TensorFlow, exploramos padrões temporais nos dados, a fim de identificar correlações entre variáveis ​​e realizar previsões precisas sobre o sucesso reprodutivo dos quelônios, contribuindo assim para sua conservação e manejo adequado.

Além disso, também foi realizado um modelo de identificação de espécies de água-viva ou detecção de resíduos plásticos no oceano, utilizando TensorFlow e Keras, que permitiram o desenvolvimento de modelos capazes de analisar imagens de câmeras subaquáticas ou de satélite e identificar padrões associados a espécies de água-viva ou objetos de plástico.

## Instruções

Após clonar o repositório, rodar o projeto .NET em sua IDE de preferência ou rodar o .exe para *deployment*.

## Diagramas

**Diagrama Relacional:**  
![Diagrama Relacional](/assets/images/relacional.jpg)

**Diagrama Infraestrutura:**  
![Diagrama Infraestrutura](/assets/images/infra.png)

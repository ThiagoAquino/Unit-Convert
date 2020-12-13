# Web Service para conversão unidades

- Aplicação que recebe, através da URL, unidades a serem convertidas, e retorna dois valores:
    - **unit_name**: Que é a string de unidade da solicitação, com todas as unidades convertidas sua contraparte no SI.
    - **multiplication_factor**: É um bigdecimal que pode ser usado para converter qualquer entrada nas unidades originais para as novas unidades do si.
    
    
 - **Request Exemplo:** 
    
      
    <> GET /units/si?units=(degree/minute)
    
 
 - **Unidades**
    - minute
    - hour
    - day
    - degree
    - arcminute
    - arcsecond
    - hectare
    - litre
    - tonne   
 
  
  - **Tecnologia Utilizada**
    - Java 11
    - Spring Boot
    - JUnit
    - Docker
    
    
  ## DOCKER - Como construir e executar um projeto
  
  - Para construir um projeto com docker, cria-se um documento chamado **Dockerfile** na pasta raiz do projeto. Nesse arquivo, colocasse alguns parametros como _FROM_, _RUN_, ... entre outros.
  Já com a aplicação construída e com o Dockerfile feito, exectuta o comando __docker build -t "nome" .__ , para que seja gerado o executável da aplicação. Em seguida, é necessário fazer login no __Dockerhub__ para que a imagem criada seja armazenada.
  Após a imagem gerada, usa o comando __docker push "nomedaimagem"__, com a imagem já armazenada no repositório do Dockerhub, usa-se o __docker pull "nomedaimagem"__ para baixar a imagem, e por fim executa o comando __docker run -it "nomedaimagem__" para que o container comece a ser executado.
  
  

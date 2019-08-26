# Desafio_QA
Automatizando API Rest

**História:**

Abordei os pontos que devem ser levados em consideração durante os testes de uma API REST. O objetivo é mostrar como é fácil automatizar esse tipo de teste usando o framework Rest-Assured.

Rest-Assured é um framework open-source que possui suporte para automatizar os métodos GET, POST, PUT, DELETE, HEAD, OPTIONS e TRACE de uma API e permitir fazer validações no header, body e schema da resposta.

A URL a ser utilizada é de um serviço disponibilizado pelo Postman.

Foi criado um método que validará o envio de uma requisição do tipo POST. O serviço que ao receber um JSON com os atributos usuário e senha, retornará uma mensagem informando que o usuário foi criado com sucesso.

public class TestesAPI {
	
	public TestesAPI(){
		baseURI = "http://dump.getpostman.com/blog/users";
	}
  
 O método Given entende que a URL a ser chamada é à definida no construtor da classe) passando no body um JSON com os atributos username e password, quando (when) for por meio do método POST, então (then) o resultado esperado é que o status de retorno seja igual a 200 e que o atributo message enviado no retorno contenha a frase “User created successfully” indicando que o usuário foi criado com sucesso.

  
  @Test
	/*Chama o serviço pelo metodo POST*/
	public void testCriaUsuario() {
		String myJson = "{\"username\":\"abhinav\",\"password\": \"abc\"}";
    	
         given()
           .contentType("application/json")
    	   .body(myJson)
    	 .when()
    	   .post("/")
    	 .then()
    	   .statusCode(200)
    	   .body("message", containsString("User created successfully"));	 
	}
  
 Novo método na nossa classe de testes chamado “TestConsultaUsuario” onde será validado se os dados do usuário estão corretos e se a reposta veio com a estrutura esperada conforme definido no schema do serviço.
 
 @Test
	/*Chama o serviço pelo metodo GET*/
	public void testConsultaUsuario() {
		
		 given()
		 .when()
		    .get("/1")
		 .then()
		    .statusCode(200)
		    .body("created_at", is(1396006450))
		    .body("id", is(1))
		    .body("token", equalTo("JbaGIjDQMyvbTyRNsAqmOMijTnpUez"))
		    .body("username", equalTo("prakhar1989"))
		    .assertThat()
		       .body(matchesJsonSchemaInClasspath("schema_exemplo.json"));
	}
	
	
	
  
  
  **Schema:**
  ```
  {
  "$schema": "http://json-schema.org/draft-04/schema#",
  "id": "http://dump.getpostman.com/blog/users/1",
  "type": "object",
  "properties": {
    "created_at": {
      "id": "http://dump.getpostman.com/blog/users/1/created_at",
      "type": "integer"
    },
    "id": {
      "id": "http://dump.getpostman.com/blog/users/1/id",
      "type": "integer"
    },
    "token": {
      "id": "http://dump.getpostman.com/blog/users/1/token",
      "type": "string"
    },
    "username": {
      "id": "http://dump.getpostman.com/blog/users/1/username",
      "type": "string"
    }
  },
  "required": [
    "created_at",
    "id",
    "token",
    "username"
  ]
}




```
**Dependências usadas**
```
<dependências>
  <dependência>
      <groupId> com.jayway.restassured </ groupId>
      <artifactId> com certeza de repouso </ artifactId>
      <version> 2.4.1 </ version>
      <scope> test </ scope>
  </ dependency>
  <dependência>
      <groupId> com.jayway.restassured </ groupId>
      <artifactId> json-path </ artifactId>
      <version> 2.4.1 </ version>
  </ dependency>
  <dependência>
      <groupId> com.jayway.restassured </ groupId>
      <artifactId> json-schema-validator </ artifactId>
      <version> 2.4.1 </ version>
      <scope> test </ scope>
  </ dependency>
  <dependência>
      <groupId> junit </ groupId>
      <artifactId> junit </ artifactId>
      <versão> 4.12 </ version>
  </ dependency>		
</ dependencies>




```
**Tecnologias:**
```
Java (linguagem)
Rest-assured(framework)
Intellij(ferramenta de desenvolvimento)
```



**Github:**
```
Motivo de escolha:
O recurso de criar um repositório privado gratuito.
```



**Gerenciador de dependências:**

**O que é o Maven?**
```
Maven, uma palavra que é um acumulador de conhecimento, foi criada como uma tentativa de simplificar os processos de construção no projeto Turbina de Jacarta. Vários projetos, cada um com todos os seus arquivos de compilação Ant, todos os diferentes e os JARs não foram encontrados no CVS. O que é uma maneira padrão de fazer os projetos, uma clara idéia de projeto de consistência, uma maneira fácil de publicar informações sobre o projeto e uma maneira de compartilhar os JARs em vários projetos.
O resultado é uma máquina que pode ser usada para criar e organizar todo o projeto em Java. Esperamos que tenhamos feito algo que facilite o trabalho cotidiano dos desenvolvedores.
```
[Referência] ( https://maven.apache.org/what-is-maven.html )


**JUnit**
```
O JUnit é um framework open-source, que se assemelha ao raio de testes software java, criado por Erich Gamma e Kent Beck, com suporte à criação de testes automatizados na linguagem de programação Java. Esse framework facilita a criação e manutenção do código para a automação de testes com apresentação dos resultados.
```
[Referência] ( https://pt.wikipedia.org/wiki/JUnit )

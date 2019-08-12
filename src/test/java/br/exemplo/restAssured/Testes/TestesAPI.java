package br.exemplo.restAssured.Testes;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;
import org.junit.Test;

public class TestesAPI {
	
	public TestesAPI(){
		baseURI = "http://dump.getpostman.com/blog/users";
	}

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

}

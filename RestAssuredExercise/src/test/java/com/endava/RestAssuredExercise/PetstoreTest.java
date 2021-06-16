package com.endava.RestAssuredExercise;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PetstoreTest {

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}

	@Test
	public void addFindDeletePet() {
		List<String> photoUrls = new ArrayList<String>();
		photoUrls.add("https://i2.wp.com/mascooriente.co/wp-content/uploads/2020/02/mascooriente_schnauzer-miniatura.jpg");
		Pet pet = new Pet();
		pet.setPhotoUrls(photoUrls);
		pet.setName("loki");
		//pet.setId(System.currentTimeMillis()+"");
    	Response response = given()
		        .contentType(ContentType.JSON)
		        .body(pet,ObjectMapperType.GSON)
		        .when()
		        .post("/pet")
		        .then()
		        .extract().response();    	
    	Assertions.assertEquals(200, response.statusCode());       
    	String petId = response.jsonPath().getString("id");
    	Response response2 = given()          
    			.accept(ContentType.JSON)
                .when()
                .get("/pet/{petId}",petId)
                .then()
                .extract().response();
    	Assertions.assertEquals(200, response2.statusCode());
    	Assertions.assertEquals("loki", response2.jsonPath().getString("name"));    	
    	Response response3 = given()
    			.accept(ContentType.JSON)
                .when()
                .delete("/pet/{petId}",petId)
                .then()
                .extract().response();
		Assertions.assertEquals(200, response3.statusCode());
	}
}

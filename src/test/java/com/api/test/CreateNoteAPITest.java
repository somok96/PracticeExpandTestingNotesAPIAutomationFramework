package com.api.test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constant.Category;
import com.api.request.model.Note;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateNoteAPITest {

	@Test
	public void verifyCreateNote() {
		
		
		Note note = new Note("API Testing", "Learn API testing using RestAssured", Category.WORK);
		
		
		RestAssured.given()
		.baseUri(ConfigManager.getProperty("BASE_URI"))
		.contentType(ContentType.JSON)
		.header("x-auth-token", AuthTokenProvider.getToken())
		.body(note)
		.log().all()
		.when()
		.post("/notes")
		.then()
		.statusCode(200)
		.body("success", Matchers.equalTo(true)).log().body();
		
		
		
	}
	
}

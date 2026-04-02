package com.api.test;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAllNotesAPITest {

	@Test
	public void verifyAllNotesAreFetched() {
		
		for(int i=0; i<=100;i++) {
		RestAssured.given().baseUri(ConfigManager.getProperty("BASE_URI")).contentType(ContentType.JSON)
				.header("x-auth-token", AuthTokenProvider.getToken()).log().headers().when().get("/notes").then()
				.statusCode(200)
				.body("success", Matchers.equalTo(true))
				.body("data", Matchers.notNullValue())
				.log().body();
	}
	}
		
}

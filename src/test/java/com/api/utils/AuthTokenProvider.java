package com.api.utils;

import static io.restassured.RestAssured.given;

import com.api.request.model.UserCredentials;

import io.restassured.http.ContentType;

public class AuthTokenProvider {

	private AuthTokenProvider() {

	}

	public static String getToken() {

		UserCredentials usercredentials = new UserCredentials("t08@yopmail.com", "Slice@1996");

		String token = given().baseUri(ConfigManager.getProperty("BASE_URI")).contentType(ContentType.JSON)
				.body(usercredentials).when().post("/users/login").then().log().ifValidationFails().statusCode(200)
				.extract().body().jsonPath().getString("data.token");

		return token;
	}

}

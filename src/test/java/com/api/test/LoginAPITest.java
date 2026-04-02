package com.api.test;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class LoginAPITest {

	private static final String LOGIN_ENDPOINT = "/users/login";
	private UserCredentials userCredentials;

	@BeforeMethod(description = "Setting up the Login pre-requisites of the user")
	public void setup() {
		userCredentials = new UserCredentials("t08@yopmail.com", "Slice@1996");
	}

	@Test(description = "Verify if the customer is able to login with the valid credentials and should see success message", groups = {
			"smoke", "sanity" })
	public void verifyCustomerLogin() {

		given().baseUri(ConfigManager.getProperty("BASE_URI")).contentType(ContentType.JSON).body(userCredentials).log()
				.body().log().headers().when().post(LOGIN_ENDPOINT).then().statusCode(200)
				.time(Matchers.lessThan(2000L)).body("success", Matchers.equalTo(true))
				.body("message", Matchers.equalTo("Login successful")).body("data.id", Matchers.notNullValue())
				.body("data.name", Matchers.notNullValue()).body("data.email", Matchers.notNullValue())
				.body("data.token", Matchers.notNullValue())
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/loginAPIResponseJSONSchema.json")).log()
				.body();

	}

}

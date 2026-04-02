package com.api.test;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.User;
import com.api.utils.ConfigManager;

import io.restassured.http.ContentType;

public class RegisterAPITest {

	private static final String REGISTRATION_ENDPOINT = "/users/register";
	private User userPayload;

	@BeforeMethod(description = "Setting up the Registration pre-requisites of the user")
	public void setup() {
		userPayload = new User("Somok", "Slice@1996", "t11@yopmail.com");
	}

	@Test(description = "Verify if the customer is able to register using the RegisterAPI and should return success message", groups = {
			"smoke", "sanity", "regression" })
	public void verifyCustomerRegistration() {

		given().baseUri(ConfigManager.getProperty("BASE_URI")).contentType(ContentType.JSON).body(userPayload).log()
				.body().log().headers().when().post(REGISTRATION_ENDPOINT).then().statusCode(201)
				.body("success", Matchers.equalTo(true)).log().body();

	}

}

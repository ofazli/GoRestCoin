package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ApiValidation {
	public Response response;

	public Response postMethod(String name, String gender, String email, String status) {
		String requestBody = updateBody(name, gender, email, status);
		Response response = given()
				.headers("Authorization", "Bearer 702e5484ddf8d39e2d194b7fa753f33d38b8937e6c57a0101662fef7e202c425",
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.body(requestBody)
				.post();

		return response;
	}
	public Response putMethod(String name, String gender, String email, String status) {
		String requestBody = updateBody(name, gender, email, status);
		Response response = given()
				.headers("Authorization", "Bearer 702e5484ddf8d39e2d194b7fa753f33d38b8937e6c57a0101662fef7e202c425",
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.body(requestBody)
				.put();

		return response;
	}
	public Response postMethodCreate(String body, String title) {
		String requestBody = updatePostBody(body, title);
		Response response = given()
				.headers("Authorization", "Bearer 702e5484ddf8d39e2d194b7fa753f33d38b8937e6c57a0101662fef7e202c425",
						"Content-Type", "application/json", "Accept", ContentType.JSON)
				.body(requestBody)
				.post();

		return response;
	}

	private String updateBody(String name, String gender, String email, String status) {
		String body = "";
		try {
			body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "src/test/resources/data/userDetails.json")));
			body = body.replaceAll("replaceName", name);
			body = body.replaceAll("replaceEmail", email);
			body = body.replaceAll("replaceGender", gender);
			body = body.replaceAll("replaceStatus", status);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

	private String updatePostBody(String postbody, String title) {
		String body = "";
		try {
			body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + File.separator + "src/test/resources/data/postCreate.json")));
			body = body.replaceAll("replaceBody", postbody);
			body = body.replaceAll("replaceTitle", title);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}

}

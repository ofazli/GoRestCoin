package pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;

public class ApiValidation {
public Response response;

    public Response postMethod(String name, String gender, String email, String status) {
        String requestBody = updateBody(name, gender, email, status);
        Response response = given().headers("Authorization", "Bearer 398dea14addf3a13e9340740bf04e624ff2dedbcb2434366995412675a35a46a",
                "Content-Type", "application/json","Accept", ContentType.JSON)
                .body(requestBody)
                .post();

        return response;
    }

    private String updateBody(String name, String gender, String email, String status)  {
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

}

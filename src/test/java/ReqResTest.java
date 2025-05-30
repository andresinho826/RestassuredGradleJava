import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class ReqResTest {

    @Test
    public void loginTest(){
        String response = RestAssured
                .given()
                .baseUri("https://reqres.in")
                .log().all()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"email\": \"eve.holt@reqres.in\",\n" +
                        "    \"password\": \"cityslicka\"\n" +
                        "}")
                .post("/api/login")
                .then()
                .log().all()
                .extract().asString();


        //System.out.println(response);
    }

    @Test
    public void listUsers(){
        Response response = RestAssured
                .given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .when()
                .get("\n" +
                        "/api/users?page=2")
                .then().extract().response();

        //int statusCode = response.statusCode();
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response\n " + response.asPrettyString());

    }
}

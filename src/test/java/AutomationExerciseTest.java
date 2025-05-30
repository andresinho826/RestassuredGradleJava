import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class AutomationExerciseTest {

    @Test
    public void GetAllProductList(){
        Response response = RestAssured
                .given()
                .baseUri("https://automationexercise.com/")
                .when()
                .get("/api/productsList")
                .then().extract().response();

        //int statusCode = response.statusCode();
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Json: \n" + response.asPrettyString());

    }
}

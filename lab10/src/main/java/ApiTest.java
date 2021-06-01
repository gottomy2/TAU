import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ApiTest {
    String POSTMAN_API="http://localhost:9090/";
    private static Logger logger = LogManager.getLogger(Log4jExample.class);

    @Test
    public void createNewUser_ShouldReturnStatusCode201(){
        RestAssured.baseURI = POSTMAN_API;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type","application/json");
        String payload = "{\n" +
                "  \"email\": \"igor@email.com\",\n" +
                "  \"username\": \"gottomy\",\n" +
                "  \"password\" : \"test1password\",\n" +
                "  \"privilege\": \"admin\"\n" +
                "}";
        Response response = request.body(payload).post("user/createUser/");
        Assertions.assertEquals(201,response.getStatusCode());

        if(response.getStatusCode() == 201){
            logger.info("Successfully created new user - status code: " + response.getStatusCode());
        }
        else{
            logger.error("There was a problem while creating new user - status code: " + response.getStatusCode());
        }
    }

    @Test
    public void getExistingUser_ShouldContainProvidedString(){
        given()
                .when()
                .get(POSTMAN_API + "user/getUserById/1")
                .then()
                .assertThat()
                .body(containsString("igor@email.com"));
    }

    @Test
    public void updateUser_ShouldReturnStatusCode200_UserShouldBeChanged(){
        RestAssured.baseURI = POSTMAN_API;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type","application/json");
        String payload = "{\n" +
                "  \"id\": 1,\n" +
                "  \"email\": \"changed@test.com\",\n" +
                "  \"username\": \"changeduser\",\n" +
                "  \"password\": \"changedpassword\",\n" +
                "  \"privilege\": \"admin\"\n" +
                "}";
        Response response = request.body(payload).put("user/updateUser/");
        Assertions.assertEquals(200,response.getStatusCode());

        RequestSpecification request2 = RestAssured.given();
        request2.header("Content-Type","application/json");
        Response response2 = request2.get("user/getUserById/1");

        if(response2 != null) {
            response2.prettyPrint();
            logger.info("User successfully updated. User info has been printed.");
        }
        else{
            logger.error("There was a problem while updating user data");
        }
    }

    @Test
    public void deleteUser_ShouldReturnStatusCode200_UserShouldBeDeleted(){
        RestAssured.baseURI = POSTMAN_API;
        given()
                .when()
                .delete("user/deleteUser/1")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("user/getUserById/1")
                .then()
                .statusCode(404);
    }
}

package apitests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import apitests.utils.TokenAuth;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class PostOrderTest {

    @Test
    public void createOrder() {
        String token = TokenAuth.getBearerToken();

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .header("Accept", "application/json")
                .multiPart("quantity", "6")
                .multiPart("package_id", "merhaba-7days-1gb")
                .multiPart("type", "sim")
                .multiPart("description", "Example order")
                .post("/orders");

        response.prettyPrint();

        // Validate HTTP status
        assertEquals(response.getStatusCode(), 200);

        // Validate some of the HTTP response body fields
        assertEquals(response.jsonPath().getInt("data.quantity"), 6);
        assertEquals(response.jsonPath().getString("data.package_id"), "merhaba-7days-1gb");
        assertEquals(response.jsonPath().getString("data.package"), "Merhaba-1 GB - 7 Days");
        assertEquals(response.jsonPath().getList("data.sims").size(), 6);
        assertEquals(response.jsonPath().getString("meta.message"), "success");
    }
}

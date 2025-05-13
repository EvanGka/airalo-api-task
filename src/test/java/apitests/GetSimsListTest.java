package apitests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import apitests.utils.TokenAuth;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

/*
The link from the task document points to https://partners-doc.airalo.com/#994a7fbb-fbda-451d-a3bc-98028a8e676d
The Get eSIMs List endpoint returns all the eSIMs of the account and not only the ones we created by calling the POST order
On top of that the PARAMs don't help to filter the results and return only the "merhaba-7days-1gb"
So I'm not sure how to validate the following:
Ensure the list contains 6 eSIMs, and that all of them have the "merhaba-7days-1gb" package slug.
To validate this we could:store: the https://sandbox-partners-api.airalo.com/v2/orders/174808?include=sims
1. store the order id
2. call the https://sandbox-partners-api.airalo.com/v2/orders/order_id?include=sims

 */

public class GetSimsListTest extends BaseTest {

    @Test
    public void fetchSims() {
        String token = TokenAuth.getBearerToken();

        Response response = given()
                .header("Authorization", "Bearer " + token)
                .get("/sims");

        response.prettyPrint();
        assertEquals(response.getStatusCode(), 200);
    }
}

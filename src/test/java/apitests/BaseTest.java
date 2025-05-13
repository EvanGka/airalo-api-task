package apitests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

//I just use the BaseTest to set the base url which is always https://sandbox-partners-api.airalo.com/v2/
public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://sandbox-partners-api.airalo.com/v2";
    }
}

package apitests.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TokenAuth {

    public static String getBearerToken() {
        RestAssured.baseURI = "https://sandbox-partners-api.airalo.com/v2";

        Response response = given()
                .header("Accept", "application/json")
                .multiPart("client_id", "7e29e2facf83359855f746fc490443e6")
                .multiPart("client_secret", "e5NNajm6jNAzrWsKoAdr41WfDiMeS1l6IcGdhmbb")
                .multiPart("grant_type", "client_credentials")
                .post("/token");

        response.prettyPrint();

        return response.jsonPath().getString("data.access_token");
    }

}

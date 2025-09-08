package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {
    //curl -u "bsuser_1dr2kM:S52zPpUxckvmDS3C7USu" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("bsuser_1dr2kM", "S52zPpUxckvmDS3C7USu")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}

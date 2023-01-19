package utilities.JiraExecuteInZephyrTestCycles;

import com.thed.zephyr.cloud.rest.ZFJCloudRestClient;
import com.thed.zephyr.cloud.rest.client.JwtGenerator;
import io.restassured.response.Response;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLOutput;

import static io.restassured.RestAssured.given;

public class GetFixVersionID {
    public static void main(String args[]) throws URISyntaxException {
        String cycleName = "zephyrsquad_testcycle_name";
        String fixVersionName = "zephyrsquad_fixVersion_name";
        String baseURLZephyr = "https://prod-api.zephyr4jiracloud.com/connect";
        String accessKeyZephyr = "zephyr access key";
        String secretKeyZephyr = "zephyr secret key";
        String accIDJira = "account id from jira";

        ZFJCloudRestClient client = ZFJCloudRestClient.restBuilder(baseURLZephyr, accessKeyZephyr, secretKeyZephyr, accIDJira).build();
        JwtGenerator jwtGenerator = client.getJwtGenerator();
        String uriCreateCycle = baseURLZephyr + "/public/rest/api/1.0/zql/fields/values";
        URI uri = new URI(uriCreateCycle);
        int expirationInSec = 600;
        String jwt = jwtGenerator.generateJWT("GET", uri, expirationInSec);

        Response response =
                given()
                        .header("zapiAccessKey", accessKeyZephyr)
                        .header("Authorization", jwt)
                        .header("Content-Type", "application/json")
                        .when().get(uri);

        String filterVersionIDUsingTestCycleName = "fields.cycleName.findAll {it.name=='"+cycleName+"'}.versionId";
        String versionIDUsingTestCycleName = response.jsonPath().get(filterVersionIDUsingTestCycleName).toString().replace("[","").replace("]","");

        System.out.println("versionIDUsingTestCycleName "+versionIDUsingTestCycleName);

        String filterVersionIDUsingFixVersionName = "fields.fixVersion.findAll {it.name=='"+fixVersionName+"'}.id";
        String versionIDUsingFixVersionName = response.jsonPath().get(filterVersionIDUsingFixVersionName).toString().replace("[","").replace("]","");

        System.out.println("versionIDUsingFixVersionName "+versionIDUsingFixVersionName);
    }
}

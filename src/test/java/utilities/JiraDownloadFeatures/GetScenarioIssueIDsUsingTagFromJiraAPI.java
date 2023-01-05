package utilities.JiraDownloadFeatures;

import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * we are using this class to get scenarios from jira for execution,
 * not to use in execution status update purpose in zephyrsquad
 */
public class GetScenarioIssueIDsUsingTagFromJiraAPI {
  public static void main(String[] args){
/*
    jira api documentation link
    https://developer.atlassian.com/cloud/jira/platform/rest/v2/intro/
*/
    String gerURIForScenarioIssueIDsBasedOnTagFromJira =
            "http://your-domain.atlassian.net/rest/api/2/search";
    //your-domain example eastern
    String tag = "login";
    String jqlFilter = "labels="+ tag +"&project=QA";
    Response responseScenarioIssueIDsBasedOnTagsFromJira =
            given()
                    .queryParam("jql", jqlFilter)
                    .queryParam("fields", "id")
                    .queryParam("maxResults",2000)
                    .header("Authorization","authorization token from jira")
                    .when()
                    .get(gerURIForScenarioIssueIDsBasedOnTagFromJira);

    List<String> scenarioIssueIDsFromJiraAPI =
            responseScenarioIssueIDsBasedOnTagsFromJira.jsonPath().getList("issues.id");
    System.out.println(scenarioIssueIDsFromJiraAPI);
  }
}

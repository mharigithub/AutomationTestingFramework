package utilities.JiraExecuteInZephyrTestCycles;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * we are using this class to get issue id which is used in updating execution status in zephyrsquad,
 * not to get scenarios from jira
 */
public class Step2GetScenarioIssueIDsUsingKeyFromJiraAPI {
  public static void main(String[] args) {
    String issueKey = "QA-3";
/*
    jira api documentation link
    https://developer.atlassian.com/cloud/jira/platform/rest/v2/api-group-issues/#api-rest-api-2-issue-issueidorkey-get
*/
    String gerURIForScenarioIssueIDsBasedOnKeyFromJira =
            "http://eastern.atlassian.net/rest/api/2/issue/" + issueKey;

    Response responseScenarioIssueIDsBasedOnKeyFromJira =
            given()
                    .header("Authorization", "authorization token from jira")
                    .when()
                    .get(gerURIForScenarioIssueIDsBasedOnKeyFromJira);

    String scenarioIssueIDsUsingKeyFromJiraAPI =
            responseScenarioIssueIDsBasedOnKeyFromJira.jsonPath().getString("id");
    System.out.println(scenarioIssueIDsUsingKeyFromJiraAPI);
  }
}

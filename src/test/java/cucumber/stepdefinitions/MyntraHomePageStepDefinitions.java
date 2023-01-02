package cucumber.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import utilities.ThreadLocalDriver;

/**
 * this class contains java implementation for steps in feature files
 */
public class MyntraHomePageStepDefinitions extends BaseSteps {

  @Before
  public void setupLoginSteps() {
    if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
      setupScreens(ThreadLocalDriver.getAppiumDriverThreadLocal());
    } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")){
      setupScreensOnline(ThreadLocalDriver.getRemoteWebDriverThreadLocal());
    } else {
      setupScreensOnlineLocal(ThreadLocalDriver.getWebDriverThreadLocal());
    }
  }

  @Given("User is on home page")
  public void userisonhomepageandtapsCategories() {
    if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
      myntraHomePage.userOnHomePage();
    } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")){
      onlineMyntraHomePage.userOnHomePage();
    } else {
      localOnlineMyntraHomePage.userOnHomePage();
    }
  }

  @When("User clicks Studio {int} Two")
  public void userclicksStudio(int index) {
    if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
      myntraHomePage.clickStudio();
    } else {
      onlineMyntraHomePage.clickStudio();
    }
  }

  @Then("Verify Explore button")
  public void verifyExplorebutton() {
    myntraHomePage.assertExploreTitleIsExpected();
  }

  @When("User clicks on Profile Four")
  public void userClicksOnProfile() {
    myntraHomePage.clickProfile();

  }

  @And("User clicks on Home Five")
  public void userClicksOnHome() {
    myntraHomePage.clickHome();
  }

  @When("User clicks on Explore Three")
  public void userClicksOnExplore() {
    myntraHomePage.clickExplore();
  }

  @When("User clicks on Categories One")
  public void userClicksOnCategories() {
    if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Mobile")) {
      myntraHomePage.clickCategories();
    } else if (Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("OnlineOrMobile").equalsIgnoreCase("Online")) {
      onlineMyntraHomePage.clickCategories();
    } else {
      localOnlineMyntraHomePage.clickCategories();
    }
  }
}

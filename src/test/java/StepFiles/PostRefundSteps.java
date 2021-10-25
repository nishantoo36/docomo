package StepFiles;

import ActionClasses.PostDataAPI;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import org.testng.Assert;


import java.util.UUID;

public class PostRefundSteps extends Logging{

    final private static UUID uuid = UUID.randomUUID();
    final private static String uuidAsString = uuid.toString();

    TestContext testContext;
    PostDataAPI getPostDataAPI;

    public PostRefundSteps(TestContext context) {
        testContext = context;
        getPostDataAPI = testContext.getPageObjectManger().getPostDataAPI();
    }


    @When("^user post refund with valid uuid$")
    public void userPostRefundWithValidUuid() {
        getPostDataAPI.setPostEndPoint(uuidAsString);
    }



    @Then("^verify statusCode as (\\d+)$")
    public void verifyStatusCodeAs(int statsCode) {
        Assert.assertTrue(getPostDataAPI.isStatusCode(statsCode),"Verification failed, Expected status code is not "+statsCode);
    }

    @When("^user post refund with uuid \"([^\"]*)\"$")
    public void userPostRefundWithUuid(String invalidUdid) {
        getPostDataAPI.setPostEndPoint(invalidUdid);
    }

    @When("^user post refund with uuid in parallel$")
    public void userPostRefundWithUuidInParallel()  {
        Assert.assertTrue(getPostDataAPI.isStatusCodeAfterParallelPost(uuidAsString,10));
    }
}

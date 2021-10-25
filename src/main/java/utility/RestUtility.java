package utility;

import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import manager.FileReaderManager;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;


public class RestUtility {
    public static FilterableRequestSpecification httpRequest = null;

    public RestUtility() {
        baseURI = FileReaderManager.getInstance().getConfigReader().getBaseURL();
        httpRequest = (FilterableRequestSpecification) given();
    }

    public Response postData(String url) {
        return httpRequest.post(url);
    }

    public boolean isStatusCodeAfterParallelPost(String url,int callCount,int statusCode) {
        int temp = 0;
        for (int i=0;i<callCount;i++){
            if (statusCode!=temp) {
                temp = httpRequest.post(url).getStatusCode();
            }else {
                return true;
            }
        }
        return false;
    }

    public int getStatusCode(Response response) {
        return response.statusCode();
    }

}
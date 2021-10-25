package ActionClasses;

import io.restassured.response.Response;
import utility.RestUtility;

import java.util.UUID;

public class PostDataAPI extends RestUtility {

    static Response response;

    public void setPostEndPoint(String udid){
            response = postData("/operations/"+udid+"/refund");
    }

    public boolean isStatusCodeAfterParallelPost(String udid,int callCount){
       return super.isStatusCodeAfterParallelPost("/operations/"+udid+"/refund",callCount,423);
    }

    public boolean isStatusCode(int statusCode){
        return getStatusCode(response)==statusCode;
    }

}

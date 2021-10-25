
package manager;


import ActionClasses.PostDataAPI;

public class PageObjectManger {

    public PostDataAPI getPostDataAPI;

    public PostDataAPI getPostDataAPI() {
        return (getPostDataAPI == null) ? getPostDataAPI = new PostDataAPI() : getPostDataAPI;
    }

}

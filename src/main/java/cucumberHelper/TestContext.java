package cucumberHelper;


import manager.PageObjectManger;

public class TestContext {
    private PageObjectManger pageObjectManger;
    public TestContext(){
        pageObjectManger = new PageObjectManger();
    }

    public PageObjectManger getPageObjectManger() {
        return pageObjectManger;
    }

}
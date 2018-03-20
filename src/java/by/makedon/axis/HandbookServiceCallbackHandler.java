/**
 * HandbookServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.7  Built on : Nov 20, 2017 (11:41:20 GMT)
 */
package by.makedon.axis;


/**
 *  HandbookServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class HandbookServiceCallbackHandler {
    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     * @param clientData Object mechanism by which the user can pass in user data
     * that will be avilable at the time this callback is called.
     */
    public HandbookServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public HandbookServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */
    public Object getClientData() {
        return clientData;
    }

    /**
     * auto generated Axis2 call back method for takeArticleList method
     * override this method for handling normal response from takeArticleList operation
     */
    public void receiveResulttakeArticleList(
        by.makedon.axis.HandbookServiceStub.TakeArticleListResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from takeArticleList operation
     */
    public void receiveErrortakeArticleList(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for add method
     * override this method for handling normal response from add operation
     */
    public void receiveResultadd(
        by.makedon.axis.HandbookServiceStub.AddResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from add operation
     */
    public void receiveErroradd(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for updateArticle method
     * override this method for handling normal response from updateArticle operation
     */
    public void receiveResultupdateArticle(
        by.makedon.axis.HandbookServiceStub.UpdateArticleResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from updateArticle operation
     */
    public void receiveErrorupdateArticle(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for deleteArticle method
     * override this method for handling normal response from deleteArticle operation
     */
    public void receiveResultdeleteArticle(
        by.makedon.axis.HandbookServiceStub.DeleteArticleResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from deleteArticle operation
     */
    public void receiveErrordeleteArticle(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for takeArticle method
     * override this method for handling normal response from takeArticle operation
     */
    public void receiveResulttakeArticle(
        by.makedon.axis.HandbookServiceStub.TakeArticleResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from takeArticle operation
     */
    public void receiveErrortakeArticle(java.lang.Exception e) {
    }
}

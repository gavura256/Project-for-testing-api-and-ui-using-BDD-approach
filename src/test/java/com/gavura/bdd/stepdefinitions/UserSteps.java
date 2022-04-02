package com.gavura.bdd.stepdefinitions;

import com.gavura.api.model.User;
import com.gavura.api.model.core.heirs.requests.RqObject;
import com.gavura.api.model.core.heirs.requests.heirs.GetRequestObject;
import com.gavura.api.model.core.heirs.requests.heirs.PostRequestObject;
import com.gavura.api.model.core.heirs.responds.RsObject;
import com.gavura.api.model.core.heirs.responds.heirs.GetResponseObject;
import com.gavura.api.model.core.heirs.responds.heirs.PostResponseObject;
import com.gavura.api.store.SingletonRxStore;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class UserSteps {
    private SingletonRxStore rxStore = SingletonRxStore.getInstance();

    @Given("user has {string} request with following parameters")
    public void userHasRequestForCreatingUserWithFollowingParameters(String rqName, DataTable usersInfo) {
        PostRequestObject postRequestObject = new PostRequestObject(rqName);
        User user = User.builder()
                .username(usersInfo.cell(1, 0))
                .firstName(usersInfo.cell(1, 1))
                .lastName(usersInfo.cell(1, 2))
                .email(usersInfo.cell(1, 3))
                .password(usersInfo.cell(1, 4))
                .phone(usersInfo.cell(1, 5))
                .userStatus(Integer.parseInt(usersInfo.cell(1, 6)))
                .build();
        postRequestObject.createRequestForCreating(user);

        rxStore.putDataIntoStore(postRequestObject.getRxName(), postRequestObject);
    }

    @When("user sends {string} {string} request")
    public void userSendsRequest(String requestMethod, String rqName) {
        RqObject requestObject = (RqObject) rxStore.getDataFromStore(rqName);
        String rsName = rqName.replace("RQ", "RS");
        RsObject receivedResponse = switch (requestMethod) {
            case "GET" -> new GetResponseObject(rsName, requestObject.sendGetRequest());
            case "POST" -> new PostResponseObject(rsName, requestObject.sendPostRequest());
//            case "DELETE" -> new DeleteResponseObject(rsName, requestObject.sendDeleteRequest());
            default -> throw new IllegalStateException("Unexpected value: " + requestMethod);
        };

        rxStore.putDataIntoStore(receivedResponse.getRxName(), receivedResponse);
    }

    @Then("^\"([^\"]*)\" code is \"([^\"]*)\"$")
    public void responseStatusCodeEqualsExpected(String rsName, String statusCode) {
        RsObject actualResponse = (RsObject) rxStore.getDataFromStore(rsName);
        assertThat(statusCode, is(equalTo(String.valueOf(actualResponse.getStatusCode()))));
    }

//
//    @And("user name contains expected {string}")
//    public void usersNameEquals(String expectedUserName) {
//        GetResponseObject actualResponse = (GetResponseObject) rxStore.getDataFromStore("getUserByIdRS");
//        Assert.assertEquals(actualResponse.getUserName(), expectedUserName, "Found result doesn't contains username");

//    }
//
    @And("user has {string} request with username from {string} response")
    public void userHasRequestWithIdFromResponse(String rqName, String rsName) {
        PostResponseObject createUserResponse = (PostResponseObject) rxStore.getDataFromStore(rsName);

        GetRequestObject getRequestObject = new GetRequestObject(rqName);
        getRequestObject.createRequestForGettingUserBy(String.valueOf(createUserResponse.getUserId()));

        rxStore.putDataIntoStore(getRequestObject.getRxName(), getRequestObject);
    }

}

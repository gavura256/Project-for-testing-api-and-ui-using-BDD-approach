package com.gavura.api.model.core.heirs.responds.heirs;

import com.gavura.api.model.core.heirs.responds.RsObject;
import io.restassured.response.Response;

public class PostResponseObject extends RsObject {
    private static final String RESULT_ID_LOCATOR = "id";

    public PostResponseObject(String rsName, Response response) {
        super(rsName, response);
    }

    public int getUserId() {
        return response.jsonPath().get(RESULT_ID_LOCATOR);
    }
}
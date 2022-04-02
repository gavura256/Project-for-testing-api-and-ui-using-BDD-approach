package com.gavura.api.model.core.heirs.responds;

import com.gavura.api.model.core.RxObject;
import io.restassured.response.Response;

public class RsObject extends RxObject {
    protected Response response;

    public RsObject(String rsName, Response response) {
        super(rsName);
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }
}
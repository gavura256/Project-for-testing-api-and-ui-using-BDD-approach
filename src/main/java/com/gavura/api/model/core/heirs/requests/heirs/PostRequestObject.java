package com.gavura.api.model.core.heirs.requests.heirs;

import com.gavura.api.model.User;
import com.gavura.api.model.core.heirs.requests.RqObject;
import com.google.gson.Gson;

public class PostRequestObject extends RqObject {
    public static final String FORMAT_PATTER_FOR_URI = "%s%s";

    public PostRequestObject(String rqName) {
        super(rqName);
    }

    public void createRequestForCreating(User user) {
        setBaseUri(String.format(FORMAT_PATTER_FOR_URI, BASE_URI, "/user/"));
        setCommonParams();
        requestSpecification.body(new Gson().toJson(user));
    }
}
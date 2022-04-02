package com.gavura.api.model.core.heirs.requests.heirs;

import com.gavura.api.model.core.heirs.requests.RqObject;

public class GetRequestObject extends RqObject {
    public static final String FORMAT_PATTER_FOR_URI = "%s%s%s";

    public GetRequestObject(String rqName) {
        super(rqName);
    }

    public void createRequestForGettingUsers() {
        setBaseUri();
        setCommonParams();
    }

    public void createRequestForGettingUserBy(String userName) {
        setBaseUri(String.format(FORMAT_PATTER_FOR_URI, BASE_URI, "/user/", userName));
        setCommonParams();
    }
}
package com.gavura.api.model.core.heirs.requests.heirs;

import com.gavura.api.model.core.heirs.requests.RqObject;

public class DeleteRequestObject extends RqObject {
    public DeleteRequestObject(String rqName) {
        super(rqName);
    }

    public void createRequestForDeletingUser(String userName) {
        setBaseUri(String.format("%s%s%s",BASE_URI, "/user/", userName));
        setCommonParams();
    }


}
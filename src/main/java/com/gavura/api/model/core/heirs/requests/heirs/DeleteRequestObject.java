package com.gavura.api.model.core.heirs.requests.heirs;

import com.gavura.api.model.core.heirs.requests.RqObject;

public class DeleteRequestObject extends RqObject {

    public static final String FORMAT_PATTER_FOR_URI = "%s%s%s";

    public DeleteRequestObject(String rqName) {
        super(rqName);
    }

    public void createRequestForDeletingUserBy(String userName) {
        setBaseUri(String.format(FORMAT_PATTER_FOR_URI, BASE_URI, "/user/", userName));
        setCommonParams();
    }

    public void createRequestForDeletingPetBy(int petId) {
        setBaseUri(String.format(FORMAT_PATTER_FOR_URI, BASE_URI, "/pet/", petId));
        setCommonParams();
    }

    public void createRequestForDeletingPurchaseOrderBy(int orderId) {
        setBaseUri(String.format(FORMAT_PATTER_FOR_URI, BASE_URI, "/store/order/", orderId));
        setCommonParams();
    }
}
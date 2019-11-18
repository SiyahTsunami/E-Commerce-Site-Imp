package com.dolap.backend.ecommercesite.domain.product.command;

public class DeleteProductCommand {

    private String shipperId;

    private String procuductId;

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public String getProcuductId() {
        return procuductId;
    }

    public void setProcuductId(String procuductId) {
        this.procuductId = procuductId;
    }

}

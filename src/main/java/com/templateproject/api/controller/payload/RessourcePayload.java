package com.templateproject.api.controller.payload;

public class RessourcePayload {

    private String message;

    private Integer id;
    private String name;
    private Integer quantity;
    private Integer maxStock;

    public RessourcePayload() {}

    

    public RessourcePayload( String message, String name, Integer quantity, Integer maxStock) {
        this.message = message;
        this.name = name;
        this.quantity = quantity;
        this.maxStock = maxStock;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }



  

}

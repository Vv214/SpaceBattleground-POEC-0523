package com.templateproject.api.controller.payload;

import javax.print.DocFlavor.STRING;

public class Payload {
    
    private String messgae; 
    private Object data;

    public Payload(){}

    public Payload(String messgae, Object data) {
        this.messgae = messgae;
        this.data = data;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    
}

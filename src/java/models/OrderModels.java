/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author QUANG HUY
 */
public class OrderModels {
    private String OrderId;    
    private String UserId;    
    private String Code;

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public OrderModels(String OrderId, String UserId, String Code) {
        this.OrderId = OrderId;
        this.UserId = UserId;
        this.Code = Code;
    }

    public OrderModels() {
    }
    
}

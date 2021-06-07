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
public class ProductModels {
    private String ProductId;
    private String ProductName;
    private Integer Amout;
    private double Price;

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public Integer getAmout() {
        return Amout;
    }

    public void setAmout(Integer Amout) {
        this.Amout = Amout;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public ProductModels(String ProductId, String ProductName, Integer Amout, double Price) {
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.Amout = Amout;
        this.Price = Price;
    }

    public ProductModels() {
    }
    
    
}

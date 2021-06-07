/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ProductModels;
import repositories.ProductRepos;
import utilities.NumberUtils;
import utilities.ResponseUtils;

/**
 *
 * @author QUANG HUY
 */
@WebServlet(name = "ProductController", urlPatterns = {"/products/"})
public class ProductController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json");
        
        final String productId = request.getParameter("id");
                
        if(productId == null){
            try(PrintWriter out = response.getWriter()){
                ProductRepos.getProducts().stream().forEach(products -> this.printResponse(out, products));
            }
            return;
        }
        
        if (NumberUtils.isNotNumeric(productId)) {
            final String msg = String.format("Product id %s is invalid. Must be numberic.", productId);
            ResponseUtils.printError(response, HttpServletResponse.SC_BAD_REQUEST, msg);
            return;
        }
        
        final ProductModels product = ProductRepos.getProduct(Integer.parseInt(productId));
        
//        final Collection<ProductModels> product_test_parameter = ProductRepos.getProduct_1(Integer.parseInt(productId));        
        
        if(product == null){
            String msg = String.format("Product with id %s not found.", productId);
            ResponseUtils.printError(response, HttpServletResponse.SC_BAD_REQUEST, msg);
            return;
        }
            
        try(PrintWriter out = response.getWriter()){
            this.printResponse(out, product);
        }
               
    }
        
    private void printResponse(PrintWriter out, ProductModels product){
        out.print("Id: " + product.getProductId());
        out.print("\nProduct Name: " + product.getProductName());
        out.print("\nAmout: " + product.getAmout());
        out.print("\nPrice: " + product.getPrice());
        out.print("\n================================\n");
    }
            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

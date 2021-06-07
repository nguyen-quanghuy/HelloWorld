/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.OrderModels;
import repositories.OrderRepos;
import utilities.ResponseUtils;
import utilities.StringUtils;

/**
 *
 * @author QUANG HUY
 */
@WebServlet(name = "OrderController", urlPatterns = {"/orders/"})
public class OrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        //get Header
        final String userId = request.getHeader("user_id");
        
        if(StringUtils.isEmpty(userId)){
            ResponseUtils.printError(response, HttpServletResponse.SC_BAD_REQUEST, "user_id is missing.");
            return;
        }
        
        final String orderId = request.getParameter("id");
        
        if(orderId == null){
            try(PrintWriter out = response.getWriter()){
                OrderRepos.getOrder3(userId).forEach(object -> this.printResponse(out, object));                
            }
            return;
        }
        
//         if(orderId == null){
//            try(PrintWriter out = response.getWriter()){
//                OrderRepos.getOrders().stream().forEach(object -> this.printResponse(out, object));
//            }
//            return;
//         }
                
        final OrderModels order = OrderRepos.getOrder(Integer.parseInt(orderId));
        
        if(order == null || !order.getOrderId().equals(userId)){
            ResponseUtils.printError(response, HttpServletResponse.SC_BAD_REQUEST, String.format("OrderId: %s and userId: %s not found.", orderId, userId));
            return;
        }
        
        try(PrintWriter out = response.getWriter()){
            this.printResponse(out, order);
        }
    }
    
    private void printResponse(final PrintWriter out, OrderModels order){
        out.println("ID Order: " + order.getOrderId());
        out.println("\nID User: " + order.getUserId());
        out.println("\nOrder Code: " + order.getCode());
        out.println("\n =================================\n" );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

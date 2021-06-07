/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import models.OrderModels;

/**
 *
 * @author QUANG HUY
 */
public class OrderRepos {
    private final static Map<Integer, OrderModels> orders = new HashMap<Integer, OrderModels>(){
        {
            put(1, new OrderModels("1", "user_1", "code1"));
            put(2, new OrderModels("2", "user_2", "code2"));
            put(3, new OrderModels("3", "user_3", "code3"));
        }
    };
    
    public static OrderModels getOrder(final Integer OrderId){
        return orders.get(OrderId);
    }
    
    public static Collection<OrderModels> getOrders(){
        return orders.values();
    }
    
    public static Collection<OrderModels> getOrder1(final String user_id){
        return orders.values().stream()
                .filter(order -> order.getUserId().equals(user_id))
                .collect(Collectors.toList());
    }    
    
    public static Collection<OrderModels> getOrder2(final String user_id){
        final Collection<OrderModels> orderOfUser = new ArrayList<>();
        
        for(OrderModels o : orders.values()){
            if(o.getUserId().equals(user_id)){
                orderOfUser.add(o);
            }
        }
        return orderOfUser;
    }
    
    public static Collection<OrderModels> getOrder3(final String user_id){
        final Collection<OrderModels> orderOfUser = new ArrayList<>();
        
        orders.values().forEach(o -> 
        {
            if(o.getUserId().equals(user_id)){
                orderOfUser.add(o);
            }
        });
        return orderOfUser;
    }
    
//    public static Collection<OrderModels> getOrder4(final String order_id){
//        return orders.values()
//                .stream()
//                .filter(o -> o.getOrderId().equals(order_id))
//                .collect(Collectors.toList());
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import models.ProductModels;

/**
 *
 * @author QUANG HUY
 */
public class ProductRepos {
    private final static Map<Integer, ProductModels> products = new HashMap<Integer, ProductModels>(){
        {
            put(1, new ProductModels("1", "SamSung", 20, 50));
            put(2, new ProductModels("2", "Iphone", 10, 60));
            put(3, new ProductModels("3", "Huawei", 50, 40));
        }
    };

    public ProductRepos() {
    }
    
    public final static ProductModels getProduct(final Integer ProductId){
        return products.get(ProductId);
    }
    
    public final static Collection<ProductModels> getProducts(){
        return products.values();
    }
    
    public final static Collection<ProductModels> getProduct_1(final Integer product_id){
        return products.values()
                .stream()
                .filter(pro_id -> pro_id.getProductId().equals(product_id))
                .collect(Collectors.toList());
    }
}

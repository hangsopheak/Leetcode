/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS;

import java.util.*;

/**
 *
 * @author SONGSONG
 */
public class MyInventoryManagementSystem implements InventoryManagementSystem {

    private final Map<String, Product> products;

    public MyInventoryManagementSystem(Map<String, Product> products) {
        this.products = products;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    /**
     * pick product from the warehouse with productID and amount
     *
     * @param productId
     * @param amountToPick
     * @return PickingResult
     */
    @Override
    public PickingResult pickProduct(String productId, int amountToPick) {
        Product product = products.get(productId);
        boolean result = product.remove(amountToPick);
        String message;
        if (result) {
            message = "Success";
        } else {
            message = "Failure, the inventory is less than the amount you want to pick.";
            amountToPick = 0;
        }
        return new PickingResult(result, amountToPick, product.getLevel(), message);
    }

    /**
     * restock product to warehouse with the productId and amount
     *
     * @param productId
     * @param amountToRestock
     * @return RestockingResult
     */
    @Override
    public RestockingResult restockProduct(String productId, int amountToRestock) {
        Product product = products.get(productId);
        boolean result = product.add(amountToRestock);
        return new RestockingResult(result, amountToRestock, product.getLevel());
    }
}

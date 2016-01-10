/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IMS;

/**
 *
 * @author SONGSONG
 */
public class Product {

    private final String productId;
    private int level;
    private String location;

    public Product(String productId, int level, String location) {
        this.productId = productId;
        this.level = level;
        this.location = location;
    }

    public String getProductId() {
        return productId;
    }

    public synchronized int getLevel() {
        return level;
    }

    public String getLocation() {
        return location;
    }

    public synchronized boolean add(int amount) {
        level += amount;
        return true;
    }

    public synchronized boolean remove(int amount) {
        if (amount > level) {
            return false;
        }
        level -= amount;
        return true;
    }
}

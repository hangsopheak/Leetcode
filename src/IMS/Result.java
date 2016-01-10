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
public class Result {

    private final boolean result;
    private final int amount;
    private final int inventory;
    
    public Result(boolean result, int amount, int inventory) {
        this.result = result;
        this.amount = amount;
        this.inventory = inventory;
    }

    public boolean getResult() {
        return result;
    }

    public int getAmount() {
        return amount;
    }

    public int getInventory() {
        return inventory;
    }
}

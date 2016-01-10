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
public interface InventoryManagementSystem {
    /**
     * 
     * @param productId
     * @param amountToPick
     * @return 
     */
    PickingResult pickProduct (String productId, int amountToPick);
    /**
     * 
     * @param productId
     * @param amountToRestock
     * @return 
     */
    RestockingResult restockProduct (String productId, int amountToRestock);
}

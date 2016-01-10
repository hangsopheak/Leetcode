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
public class PickingResult extends Result {

    private final String message;

    public PickingResult(boolean result, int amount, int inventory, String message) {
        super(result, amount, inventory);
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}

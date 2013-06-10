/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wm.posist;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.wm.utils.xml.Parser;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author wm
 */
public class POSist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MultivaluedMap deps = new MultivaluedMapImpl();
        
        Map<String, Item> itemMap = new HashMap<>();
        
        // Get Items

        POSistClient poSistClient = new POSistClient();
        ClientResponse response = poSistClient.getItems(deps);
        
        Items items = response.getEntity(Items.class);
        for (Item item : items.getD()) {
            System.out.println(item);
            itemMap.put(item.getItemId(), item);
        }
        
        System.out.println("....Taxes...\n\n");
        deps.clear();
        
        response = poSistClient.getItemTaxes(deps);
        
        ItemTaxes taxes = response.getEntity(ItemTaxes.class);
        for (ItemTax itemTax : taxes.getD()) {
            System.out.println(itemTax);
            Item item = itemMap.get(itemTax.getItemId());
            if(item == null) {
                System.out.println("WARNING #### NOT FOUND: " + itemTax.getItemId());
                continue;
            }
            
            item.getTaxes().add(itemTax);
        }
        
        for (Item item : items.getD()) {
            System.out.println(item.getItemId() + " ## " + item.getRate() + " --- " + item.getTax());
        }
        
        // Initiate Order

        response = poSistClient.initiateOrder(POSistClient.Type.Table, "me");
        String orderId = response.getEntity(InitiateResponse.class).getD();
        System.out.println("Initiated: " + orderId);
       
        // Place Order

        try {
            items = buildItems();
            response = poSistClient.placeOrder(orderId, items);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    private static Items buildItems() throws Exception {
        Items items = new Items();
        //Parser.jsonise(new Item("item", 33), Item.class);
        items.getD().add(new Item("0bbd0ce1-a339-463d-aded-12cdc2504419", 3));
        items.getD().add(new Item("5b530c61-9a01-40e8-b2c0-5e53ca02b600", 6));

        return items;
    }
}

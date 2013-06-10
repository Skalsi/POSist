/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wm.posist;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.wm.utils.xml.Parser;
import java.io.CharArrayWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Jersey REST client generated for REST resource:AccessService [secure]<br>
 *  USAGE:
 * <pre>
 *        POSistClient client = new POSistClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author wm
 */
public class POSistClient {
    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://wcf_test.posist.com/";

    public static enum Type {
        Table("1"), Delivery("2"), TakeOut("3");
        
        private final String type;

        private Type(String type) {
            this.type = type;
        }
        
    }
    
    
    // Construct
    public POSistClient() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("service1.svc");
        
        webResource.addFilter(new ClientFilter() {

            @Override
            public ClientResponse handle(ClientRequest cr) throws ClientHandlerException {
                System.out.println(cr.getURI());
                return getNext().handle(cr);
            }
        });
    }

    
    // Get Items
    public ClientResponse getItems(MultivaluedMap<String, String> params) throws UniformInterfaceException {
        addAccessInfo(params);
        return webResource.path("GetItemsForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    
    // Get ItemTaxes
    public ClientResponse getItemTaxes(MultivaluedMap<String, String> params) throws UniformInterfaceException {
        addAccessInfo(params);
        return webResource.path("GetTabsItemsTaxesByPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    
    // Initiate Order from 
    
    public ClientResponse initiateOrder(Type orderType, String user) throws UniformInterfaceException {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("Opentime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        params.add("type", orderType.type);
        params.add("TabName", orderType.name());
        params.add("CustomerName", user);
        addAccessInfo(params);
        
        // &CustomerName=<string>&Opentime=<string>&Address=<string>&Email=<string>&MobileNu
        // mber=<string>&PhoneNumber=<string>&Type=2&
        // Street=<string>&City=<string>&State=<string>&Pin=<string>&TabName=Delivery
        
        
        return webResource.path("SetOnlineBillForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    
    // Place Order from
    
    public ClientResponse placeOrder(String orderId, Items items) throws Exception {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        addAccessInfo(params);
        params.add("OnlineBillId", orderId);
        
        
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (Item item : items.getD()) {
            Writer writer = new CharArrayWriter();
            Parser.jsonise(item, Item.class, writer);
            str.append(writer.toString()).append(',');
            
            writer.close();
        }
        str.deleteCharAt(str.length()-1);
        str.append(']');
        System.out.println("Item Data: " + str.toString());
        params.add("OnlineBillItemsData", str.toString());
        return webResource.path("SetOnlineBillItemForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    // ModOnlineBillItemForPartner

    public ClientResponse modifyOrder(String orderId, Items items) throws Exception {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        addAccessInfo(params);
        params.add("OnlineBillId", orderId);
        
        
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (Item item : items.getD()) {
            Writer writer = new CharArrayWriter();
            Parser.jsonise(item, Item.class, writer);
            str.append(writer.toString()).append(',');
            
            writer.close();
        }
        str.deleteCharAt(str.length()-1);
        str.append(']');
        System.out.println("Item Data: " + str.toString());
        params.add("OnlineBillItemsData", str.toString());
        return webResource.path("ModOnlineBillItemForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    // CancelOnlineBillItemForPartner

    public ClientResponse cancelOrder(String orderId, String reason_cancellation) throws Exception {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        addAccessInfo(params);
        params.add("OnlineBillId", orderId);
        params.add("ReasonCancellation", reason_cancellation);
        
        return webResource.path("CancelOnlineBillItemForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }
    
    // Generate Bill

    public ClientResponse generateBill(String orderId) throws Exception {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        addAccessInfo(params);
        params.add("OnlineBillId", orderId);
        
        return webResource.path("GenerateOnlineBillItemForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    // Regenerate Bill

    public ClientResponse regenerateBill(String orderId, String reason_regeneration) throws Exception {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        addAccessInfo(params);
        params.add("OnlineBillId", orderId);
        params.add("ReasonRegeneration", reason_regeneration);
        
        return webResource.path("RegenerateOnlineBillItemForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    // Settle Bill

    public ClientResponse settleBill(String orderId, PaymentDetails pd){
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        addAccessInfo(params);
        params.add("OnlineBillId", orderId);
        
        
        StringBuilder str = new StringBuilder();
        str.append('[');
        
        Writer writer = new CharArrayWriter();
        Parser.jsonise(pd, PaymentDetails.class, writer);
        str.append(writer.toString()).append(',');
        
        writer.close();

        str.deleteCharAt(str.length()-1);
        str.append(']');
        System.out.println("Item Data: " + str.toString());
        params.add("OnlineBillItemsData", str.toString());
        return webResource.path("SetOnlineBillItemForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    // Finish Order

    public ClientResponse finishOrder(String orderId) throws Exception {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        addAccessInfo(params);
        params.add("OnlineBillId", orderId);
        params.add("Finishtime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        
        return webResource.path("FinishOnlineBillItemForPartner").queryParams(params).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(ClientResponse.class);
    }

    //--------------------------------------------------------------------------
    // 
    //--------------------------------------------------------------------------
    
    private void addAccessInfo(MultivaluedMap<String, String> params) {
        params.add("DeploymentId", "274ECA24-A854-4264-972E-23CEFAD41AC7");
        params.add("API", "91476f4c-ff38-40d0-9e47-e07297aba468");
    }
    public void close() {
        client.destroy();
    }
    
}

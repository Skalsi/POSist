/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wm.posist;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wm
 */
@XmlRootElement
public class ItemTax implements Comparable<ItemTax> {
//    "__type": "ItemsTaxes:#WcfService1",
//           "IsInPercent": true,
//           "IsItVat": true,
//           "ItemId": "ea3d69e9-9446-492c-bd94-0083bc973be9",
//           "LastModified": "3/1/2012 3:47:11 PM",
//           "Priority": 11,
//           "Rate": 12.5
    
    
    private String itemId;
    private Integer priority;
    private Float rate;
    private Boolean isInPercent;
    private Boolean isItVat;

    @XmlElement(name="ItemId")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @XmlElement(name="Priority")
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @XmlElement(name="Rate")
    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @XmlElement(name="IsInPercent")
    public Boolean getIsInPercent() {
        return isInPercent;
    }

    public void setIsInPercent(Boolean isInPercent) {
        this.isInPercent = isInPercent;
    }

    @XmlElement(name="IsItVat")
    public Boolean getIsItVat() {
        return isItVat;
    }

    public void setIsItVat(Boolean isItVat) {
        this.isItVat = isItVat;
    }

    @Override
    public String toString() {
        return "ItemTax{" + "itemId=" + itemId + ", priority=" + priority + ", rate=" + rate + ", isInPercent=" + isInPercent + ", isItVat=" + isItVat + '}';
    }
    
    //--------------------------------------------------------------------------
    // 
    //--------------------------------------------------------------------------

    @Override
    public int compareTo(ItemTax o) {
        if(this.getPriority() == null) {
            return -1;
        }
        
        if(o.getPriority() == null) {
            return 1;
        }
        
        return o.getPriority() - this.getPriority();
    }
    
    
}

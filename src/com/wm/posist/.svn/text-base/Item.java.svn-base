/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wm.posist;

import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author wm
 */
@XmlRootElement
public class Item {
//    "__type": "Items:#WcfService1",
//           "CategoryId": "e0d8e1b9-68b7-44b0-98bc-02e4947ad987",
//           "CategoryName": "Tandoori Paratha Combo Special",
//           "ItemId": "e69de70a-9f09-400c-a5cd-40293cd40553",
//           "ItemName": "Aloo Parantha",
//           "ItemNumber": 47,
//           "Rate": 100
    
    
    private String CategoryId;
    private String ItemId;
    private String ItemName;
    private String ItemNumber;
    private Float Rate;
    
    private Set<ItemTax> taxes;
    
    //--------------------------------------------------------------------------
    // 
    //--------------------------------------------------------------------------
    
    private Integer quantity;
    
    //--------------------------------------------------------------------------
    // 
    //--------------------------------------------------------------------------

    public Item() {
    }

    public Item(String ItemId, Integer quantity) {
        this.ItemId = ItemId;
        this.quantity = quantity;
    }

    @XmlElement(name="CategoryId")
    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String CategoryId) {
        this.CategoryId = CategoryId;
    }

    @XmlElement(name="ItemId")
    public String getItemId() {
        return ItemId;
    }

    public void setItemId(String ItemId) {
        this.ItemId = ItemId;
    }

    @XmlElement(name="ItemName")
    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    @XmlElement(name="ItemNumber")
    public String getItemNumber() {
        return ItemNumber;
    }

    public void setItemNumber(String ItemNumber) {
        this.ItemNumber = ItemNumber;
    }

    @XmlElement(name="Rate")
    public Float getRate() {
        return Rate;
    }

    public void setRate(Float Rate) {
        this.Rate = Rate;
    }

    @XmlElement(name="Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Set<ItemTax> getTaxes() {
        if(taxes == null) {
            taxes = new HashSet<>();
        }
        
        return taxes;
    }
    
    @XmlTransient
    public float getTax() {
        if(taxes == null || taxes.isEmpty()) {
            return 0;
        }
        
        float taxableAmount = Rate;
        float tax = 0;
        
        for (ItemTax itemTax : taxes) {
            float rate = itemTax.getRate();
            
            if(itemTax.getIsInPercent()) {
                tax += rate*.01f*taxableAmount;
                taxableAmount = tax;
            }
        }
        return tax;
    }

    @Override
    public String toString() {
        return "Item{" + "CategoryId=" + CategoryId + ", ItemId=" + ItemId + ", ItemName=" + ItemName + ", ItemNumber=" + ItemNumber + ", Rate=" + Rate + '}';
    }
    
}

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
public class PaymentDetails {

//    "__type": "Items:#WcfService1",
//           "CategoryId": "e0d8e1b9-68b7-44b0-98bc-02e4947ad987",
//           "CategoryName": "Tandoori Paratha Combo Special",
//           "ItemId": "e69de70a-9f09-400c-a5cd-40293cd40553",
//           "ItemName": "Aloo Parantha",
//           "ItemNumber": 47,
//           "Rate": 100
    
    private String AmountDue;
    private String AmountPaid;
    private String Mode;

    public PaymentDetails() {
    }

    public PaymentDetails(String AmountDue, String AmountPaid, String Mode) {
        this.AmountDue = AmountDue;
        this.AmountPaid = AmountPaid;
        this.Mode = Mode;
    }

    @XmlElement(name="AmountPaid")
    public String getAmountPaid() {
        return AmountPaid;
    }

    public void setAmountPaid(String AmountPaid) {
        this.AmountPaid = AmountPaid;
    }

    @XmlElement(name="Mode")
    public String getMode() {
        return Mode;
    }

    public void setMode(String Mode) {
        this.Mode = Mode;
    }

    // @XmlTransient
    // public Set<ItemTax> getTaxes() {
    //     if(taxes == null) {
    //         taxes = new HashSet<>();
    //     }
        
    //     return taxes;
    // }
    
    // @XmlTransient
    // public float getTax() {
    //     if(taxes == null || taxes.isEmpty()) {
    //         return 0;
    //     }
        
    //     float taxableAmount = Rate;
    //     float tax = 0;
        
    //     for (ItemTax itemTax : taxes) {
    //         float rate = itemTax.getRate();
            
    //         if(itemTax.getIsInPercent()) {
    //             tax += rate*.01f*taxableAmount;
    //             taxableAmount = tax;
    //         }
    //     }
    //     return tax;
    // }

    @Override
    public String toString() {
        return "Item{" + "CategoryId=" + CategoryId + ", ItemId=" + ItemId + ", ItemName=" + ItemName + ", ItemNumber=" + ItemNumber + ", Rate=" + Rate + '}';
    }
    
}

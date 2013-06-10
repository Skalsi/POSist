/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wm.posist;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wm
 */
@XmlRootElement
public class ItemTaxes {
    
    private List<ItemTax> d;

    @XmlElement(name="d")
    public List<ItemTax> getD() {
        return d;
    }

    public void setD(List<ItemTax> d) {
        this.d = d;
    }
    
}

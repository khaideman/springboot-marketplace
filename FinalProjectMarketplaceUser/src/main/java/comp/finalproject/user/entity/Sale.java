package comp.finalproject.user.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="sales")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    // Unidirectional
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iditem", unique = false, referencedColumnName = "id")

    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    //private long iditem;
    private int quantity;
    private float subtotal;

    public Sale() {
    }

    public Sale(/*long iditem, */int quantity, float subtotal) {
        //this.iditem = iditem;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public Sale(long id/*, long iditem*/, int quantity, float subtotal) {
        this.id = id;
        //this.iditem = iditem;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    // getters and setters go here...

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*public long getIditem() {
        return iditem;
    }

    public void setIditem(long iditem) {
        this.iditem = iditem;
    }*/

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }




}

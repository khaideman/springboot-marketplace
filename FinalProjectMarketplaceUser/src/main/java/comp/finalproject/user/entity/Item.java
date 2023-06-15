package comp.finalproject.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private long id;

    private String name;
    private int quantity;
    private int amount;

    public Item(){}

    public Item(String name, int quantity, int amount) {
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;
    }

    public Item(int id, String name, int quantity, int amount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.amount = amount;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

/*    //==========================

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "id")
    private Sale sale;

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }*/
}

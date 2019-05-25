package milletshop.millet.entity;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.sql.Timestamp;

@Alias("pruchaseRecord")
public class PruchaseRecord implements Serializable {
    private static final long serialVersionUID = 5946093518336646818L;
    private long id;
    private long userId;
    private long productId;
    private double price;
    private int quantity;
    private double sum;
    private Timestamp purshaseTime;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Timestamp getPurshaseTime() {
        return purshaseTime;
    }

    public void setPurshaseTime(Timestamp purshaseTime) {
        this.purshaseTime = purshaseTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

package milletshop.millet.entity.ShoppingCar;

import org.apache.ibatis.type.Alias;

/**
 * 购物车中的手机属性
 * data:2019-04-02
 */
@Alias("shoppongcar_phone")
public class ShoppingCarPhone{
    private int  id;
    private String phoneName;
    private String phonePrice;
    private int count;
    private double totalCount;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(String phonePrice) {
        this.phonePrice = phonePrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(double totalCount) {
        this.totalCount = totalCount;
    }
}

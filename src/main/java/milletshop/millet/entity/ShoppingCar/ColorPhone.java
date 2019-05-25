package milletshop.millet.entity.ShoppingCar;

import org.apache.ibatis.type.Alias;

@Alias("color_phone")
public class ColorPhone {

    private int id;
    private int phone_id;
    private String phone_color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(int phone_id) {
        this.phone_id = phone_id;
    }

    public String getPhone_color() {
        return phone_color;
    }

    public void setPhone_color(String phone_color) {
        this.phone_color = phone_color;
    }
}

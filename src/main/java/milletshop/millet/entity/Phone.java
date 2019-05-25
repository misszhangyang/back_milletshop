package milletshop.millet.entity;

import org.apache.ibatis.type.Alias;
import sun.misc.Version;

import java.io.Serializable;
import java.util.List;

@Alias("phone")
public class Phone implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(double phonePrice) {
        this.phonePrice = phonePrice;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Version_Phone getVersion() {
        return version;
    }

    public void setVersion(Version_Phone version) {
        this.version = version;
    }

    private int id;
    private String phoneName;
    private String imagePath;
    private double phonePrice;
    private String overView;
    private String color;
    private Version_Phone version;

}

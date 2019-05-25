package milletshop.millet.entity.ShoppingCar;

import org.apache.ibatis.type.Alias;

@Alias("config_phone")
public class ConfigPhone {

    private int id;
    private int phone_id;
    private String phone_rom;
    private String phonr_ram;

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

    public String getPhone_rom() {
        return phone_rom;
    }

    public void setPhone_rom(String phone_rom) {
        this.phone_rom = phone_rom;
    }

    public String getPhonr_ram() {
        return phonr_ram;
    }

    public void setPhonr_ram(String phonr_ram) {
        this.phonr_ram = phonr_ram;
    }
}

package milletshop.millet.entity;

import org.apache.ibatis.type.Alias;

@Alias("version_phone")
public class Version_Phone {

    private int id;
    private int phone_id;
    private String phone_ram;
    private String phone_rom;

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

    public String getPhone_ram() {
        return phone_ram;
    }

    public void setPhone_ram(String phone_ram) {
        this.phone_ram = phone_ram;
    }

    public String getPhone_rom() {
        return phone_rom;
    }

    public void setPhone_rom(String phone_rom) {
        this.phone_rom = phone_rom;
    }
}

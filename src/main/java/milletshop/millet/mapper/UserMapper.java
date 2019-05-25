package milletshop.millet.mapper;

import milletshop.millet.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select password from user where username = #{username}")
    public String getPassword(String username);

    @Insert("insert into user(username,password,phoneNumber)values(#{username},#{password},#{phoneNumber})")
    public int insertUser(User user);

    @Select("select id,username,password,phoneNumber from user where username = #{username}")
    public User selIdByUserName(String username);

}

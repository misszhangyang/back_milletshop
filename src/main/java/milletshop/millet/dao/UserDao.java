package milletshop.millet.dao;

import milletshop.millet.entity.User;
import milletshop.millet.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public String userLogin(String username){
       return userMapper.getPassword(username);
    }

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public User selIdByUserName(String username){
        return userMapper.selIdByUserName(username);
    }

}

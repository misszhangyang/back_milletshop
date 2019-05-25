package milletshop.millet.service;

import milletshop.millet.dao.UserDao;
import milletshop.millet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String userLogin(String username){
        return userDao.userLogin(username);
    }

    public int insertUser(User user){
         return userDao.insertUser(user);
    }

    public User selIdByUserName(String username){
        return userDao.selIdByUserName(username);
    }

}

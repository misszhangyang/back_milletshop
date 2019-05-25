package milletshop.millet.mvcconfig;

import milletshop.millet.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 配置http请求时的自定义相关类型转化
 * date  1.18
 */
@Component
public class StringToUserConverter implements Converter<String,User> {
    @Override
    public User convert(String user1) {
        User user = new User();
        String[] strUser = user1.split("-");
        int id = Integer.parseInt(strUser[0]);
        int phoneNumber = Integer.parseInt(strUser[1]);
        String username = strUser[2];
        String password = strUser[3];
        user.setId(id);
        user.setPhoneNumber(phoneNumber);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}

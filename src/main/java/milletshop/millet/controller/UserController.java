package milletshop.millet.controller;

import milletshop.millet.entity.ResultMap;
import milletshop.millet.entity.User;
import milletshop.millet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/user/login")
    @ResponseBody
    public Map<String,ResultMap> userlogin(@RequestBody  User user){
        User userFromDb = userService.selIdByUserName(user.getUsername());
        ResultMap<User> resultMap = new ResultMap<>();
        if(userFromDb.getPassword().equals(user.getPassword())){
            resultMap.setResultType("user");
            resultMap.setResultValue(userFromDb);
            resultMap.setResultCode(100);
            return ResultMap.setSuccess(resultMap);
        }
        resultMap.setResultType("user");
        resultMap.setResultCode(200);
        return ResultMap.setError(resultMap);
    }

    @PostMapping(value="/user/register")
    public String insertUser(@RequestBody User user){
        User userFromDb = userService.selIdByUserName(user.getUsername());
         if(userFromDb != null){
             return "0";
         }
         int x = userService.insertUser(user);
         return String.valueOf(x);
    }
}

package milletshop.millet.controller.ShoppingCar;

import milletshop.millet.entity.ShoppingCar.ShoppingCarPhone;
import milletshop.millet.mapper.ShoppingCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 关于购物车的方法
 * 前台->点击手机->传入手机的id，phonename,->查询手机列表找到对应的手机数据
 */


@RestController
public class ShoppingCarController {


    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    /**
     * 添加手机信息到当前购物车对象
     * @param shoppingCarPhone
     * @return
     */
    @PostMapping("/addPhoneToShoppingCar")
    public List<ShoppingCarPhone> addPhoneToShoppingCar(@RequestBody ShoppingCarPhone shoppingCarPhone){
        //商品入库时，先检查是否有重读的商品名称，如果有，则将该商品的数量加一，如果没有，那就直接进行入库操作
        boolean isRepeatName = false;
        List<ShoppingCarPhone> list = shoppingCarMapper.getShoppingInfoByUserId(shoppingCarPhone.getUser_id());
        for(int i = 0; i < list.size(); i ++){
            //如果有商品名称重复了，则数量加一
            if(list.get(i).getPhoneName().equals(shoppingCarPhone.getPhoneName())){
                //数量存库
                if(shoppingCarMapper.updateCount(list.get(i).getId()) == 1){
                    isRepeatName = true;
                    list.get(i).setCount(2);
                }
            }
        }
        //将当前手机对象添加到库中，然后再返回
        if(!isRepeatName){
            shoppingCarMapper.addPhoneToShoppingCar(shoppingCarPhone.getPhoneName(),shoppingCarPhone.getPhonePrice(),
                    shoppingCarPhone.getCount(),shoppingCarPhone.getTotalCount(),shoppingCarPhone.getUser_id());
            return shoppingCarMapper.getShoppingInfoByUserId(shoppingCarPhone.getUser_id());
        }else {
            return list;
        }
    }

    @PostMapping("/getShoppingInfoByUserId")
    public List<ShoppingCarPhone> getShoppingPhoneListById(@RequestBody Integer user_id){
        List<ShoppingCarPhone> list = shoppingCarMapper.getShoppingInfoByUserId(user_id);
        return list;
    }

    @PostMapping("/delShoppingPhoneById")
    public int delShoppingPhoneById(@RequestBody int id){
        return shoppingCarMapper.delShoppingPhoneById(id);
    }

}

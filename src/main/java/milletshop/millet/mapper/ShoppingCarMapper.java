package milletshop.millet.mapper;

import milletshop.millet.entity.ShoppingCar.ShoppingCarPhone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {

    //添加手机到购物车中
    int addPhoneToShoppingCar(@Param("phoneName") String phoneName, @Param("phonePrice") String phonePrice,
                              @Param("count") int count, @Param("totalCount") double totalCount,@Param("user_id") int user_id);

    //从购物车中去除手机信息
    int removePhoneFromShoppingCar(Integer id);

    //依据用户名获取购物车中的信息
    List<ShoppingCarPhone> getShoppingInfoByUserId(int user_id);

    //将商品数量加一
    int updateCount(int id);

}

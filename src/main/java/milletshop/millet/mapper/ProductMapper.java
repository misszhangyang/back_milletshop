package milletshop.millet.mapper;

import milletshop.millet.entity.Phone;
import milletshop.millet.entity.Product;
import milletshop.millet.entity.Version_Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductMapper {

//    <!--获取商品列表 -->
    List<Product> getProductList();
//     <!--获取商品 -->
//    @Select("select id,product_name as productName,stock,price,version,note from t_product where id = #{id}")
    Product getProduct(long id);
//     <!--减库存 -->
//    @Update("update t_product set stock = stock - #{quantity} where id = #{id}")
    int decreaseProduct(@Param("id") long id,@Param("quantity") int quantity);

    /**
     * 获取手机列表
     * @return
     */
    List<Phone> getPhoneList();

    /**
     * 列表分页查询
     * @param pageSize
     * @return
     */
    List<Phone> getPhoneListByPage(int pageSize);

    /**
     * 依据点击的手机id获取对应的手机信息
     * @param id
     * @return
     */
    Phone getPhoneById(int id);

    /**
     * 手机页面的模糊查询，输入了手机名称
     * @param phoneName
     * @param minId
     * @param maxId
     * @return
     */
    List<Phone> getPhoneByFuzzySearchWithPhoneName(@Param("phoneName") String phoneName, @Param("minId") int minId, @Param("maxId") int maxId);

    /**
     * 手机页面的模糊查询，如果没有输入手机名称
     * @param minId
     * @param maxId
     * @return
     */
    List<Phone> getPhoneByFuzzySearch(@Param("minId") int minId, @Param("maxId") int maxId);

    /**
     * 依据手机名称获取对应的手机信息
     * @param phoneName
     * @return
     */
    Phone getPhoneWithName(String phoneName);

    /**
     * 依据手机名称获取对应的颜色
     * @param phoneName
     * @return
     */
    List<Phone> getPhoneColorWithName(String phoneName);

    /**
     * 依据手机名称获取对应的版本
     * @param phoneName
     * @return
     */
    List<Version_Phone> getPhoneVersionWithName(String phoneName);

}

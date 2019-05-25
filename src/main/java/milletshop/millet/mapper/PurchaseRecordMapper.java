package milletshop.millet.mapper;

import milletshop.millet.entity.PruchaseRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PurchaseRecordMapper {
//    插入购买记录
//    @Insert("insert into t_purchase_record(user_id,product_id,price,quantity,sum,purchase_data,note)\n" +
//            "values\n" +
//            "(#{userId},#{productId},#{price},#{quantity},#{sum},now(),#{note})")
    public int insertPruchaseRecord(PruchaseRecord pruchaseRecord);
}

package milletshop.millet.service.product;

import milletshop.millet.entity.Product;
import milletshop.millet.entity.PruchaseRecord;
import milletshop.millet.mapper.ProductMapper;
import milletshop.millet.mapper.PurchaseRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PurchaseServiceImpl implements  PurchaseService {

    private static int x = 0;

    @Autowired
    private ProductMapper productDao = null;

    @Autowired
    PurchaseRecordMapper purchaseRecordDao = null;


    /**
     * 购买业务的具体实现
     * @param userId  用户编号
     * @param productId 产品编号
     * @param quantity 数量
     * @return
     */
    @Transactional
    @Override
    public
    boolean purchase(Long userId, Long productId, int quantity) {
        //获取产品
        try {
            Product product = productDao.getProduct(productId);
            x++;
            //比较库存和购买数量
            if (product.getStock() < quantity) {
                return false;
            }
            //扣除库存d
            int i =  productDao.decreaseProduct(productId, quantity);
            //初始化购买记录
            PruchaseRecord pruchaseRecord = this.initPurchaseRecord(userId, product, quantity);
            //插入购买记录
            int ix = purchaseRecordDao.insertPruchaseRecord(pruchaseRecord);

            System.out.println(x);

        }catch (Exception e){
            System.out.println(e);
        }
        return true;
    }

    @Override
    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    //初始化购买记录
    public PruchaseRecord initPurchaseRecord(long userId,Product product,int quantity){
        PruchaseRecord pruchaseRecord = new PruchaseRecord();
        pruchaseRecord.setNote("购买日志：时间" + System.currentTimeMillis());
        pruchaseRecord.setPrice(product.getPrice());
        pruchaseRecord.setProductId(product.getId());
        pruchaseRecord.setQuantity(quantity);
        pruchaseRecord.setUserId(userId);
        double sum = product.getPrice()*quantity;
        pruchaseRecord.setSum(sum);
        return pruchaseRecord;
    }
}

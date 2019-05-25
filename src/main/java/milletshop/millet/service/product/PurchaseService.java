package milletshop.millet.service.product;

import milletshop.millet.entity.Product;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public interface PurchaseService {
    /**
     * 处理购买的业务逻辑
     * @param userId  用户编号
     * @param productId 产品编号
     * @param quantity 数量
     * @return  购买成功或者失败
     */
    public boolean purchase(Long userId,Long productId,int quantity);

    public List<Product> getProductList();
}

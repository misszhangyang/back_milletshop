package milletshop.millet.dao;

import milletshop.millet.entity.Product;
import milletshop.millet.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {


    @Autowired
    private ProductMapper productMapper;

    public Product getProduct(int id){
        return productMapper.getProduct(id);
    }

    public int decreaseProduct(long id,int quantity){
       return productMapper.decreaseProduct(id,quantity);
    }

}

package milletshop.millet.DBTest;

import milletshop.millet.mapper.ShoppingCarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCatFromDB {

    @Autowired
    ShoppingCarMapper shoppingCarMapper;

    @Test
    public void test(){
        if(shoppingCarMapper == null)
            System.out.println("the springcarMapper is null");
        else{
            int x = shoppingCarMapper.delShoppingPhoneById(3);
            System.out.println(x);
        }
    }
}

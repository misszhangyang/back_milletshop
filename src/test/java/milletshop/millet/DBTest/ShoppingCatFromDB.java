package milletshop.millet.DBTest;

import milletshop.millet.mapper.ShoppingCarMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCatFromDB {

    @Autowired
    ShoppingCarMapper shoppingCarMapper;

    @Test
    public void test(){

        Scanner scanner = new Scanner(System.in);
        char c = ' ';
        System.out.println("请输入一个数：");
        c = scanner.next().charAt(0);
        System.out.println("输入的数是："+c);
        System.out.println("qeqweqw");

        String str = "1212大旗网大旗网的";
//        if(str.length() > 10){
//            System.out.println(str.length());
//            System.out.println(str.substring(0,10));
//        }


//        if(shoppingCarMapper == null)
//            System.out.println("the springcarMapper is null");
//        else{
//            int x = shoppingCarMapper.delShoppingPhoneById(3);
//            System.out.println(x);
//        }
    }
}

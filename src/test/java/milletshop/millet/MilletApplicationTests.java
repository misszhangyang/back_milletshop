package milletshop.millet;

import milletshop.millet.dao.ProductDao;
import milletshop.millet.dao.PurchaseRecord;
import milletshop.millet.dao.RedisDao;
import milletshop.millet.entity.Product;
import milletshop.millet.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MilletApplicationTests {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RedisDao redisDao;

    @Test
    public void testRedis(){
        redisDao.setDataToRedis("12","1212");
        redisDao.setDataToRedis("13","nihao");
        System.out.println(redisDao.getDataFromRedis("12"));
        System.out.println(redisDao.getDataFromRedis("13"));
    }

    @Test
    public void testScheduled(){
        System.out.println("定时任务现在开启：" + new Date());
    }

    @Test
    public void testGetPhoneName(){

        Class<?> c1 = null;
        try{
            c1 = Class.forName("milletshop.millet.MilletApplicationTests");
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(c1);

//        List<Version_Phone> lists = productMapper.getPhoneVersionWithName("小米5c");
//        System.out.println(lists);
    }

    public double getSuiJiGalu(){
        int gailu = 0;
        double returnValue = 0;
        try {
            for(int x = 0; x < 100; x++){
                int x1 = (int)(1+Math.random()*3);//从1到3之间取随机数
                boolean isA = setMain(x1 - 1);
                System.out.println(isA);
                if(isA){
                    gailu++;
                }
                if(x == 99){
                    returnValue = (double)gailu/100;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean setMain(int x){
        List<String> lists = new ArrayList<>();
        lists.add("K");
        lists.add("K1");
        lists.add("A");
        String suiJiShu = lists.get(x);
        lists.remove(suiJiShu);//抽取一张之后还有俩张
        for(String param : lists){
            while(param != "A"){
                lists.remove(param);
                break;
            }
        }
        //此时还剩下一张牌，要不要和抽走的牌进行交换，交换
        String jiaoHuanShu = lists.get(0);
        lists.remove(0);
        lists.add(suiJiShu);//此时已经交换完成,判断得到的值是不是"A"
        return jiaoHuanShu == "A";
    }

    @Test
    public void testClassLoader(){
        int x = 7;
        System.out.println(x / 4);
        System.out.println("BootStrap :" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    @Test
    public void testSleep(){
        System.out.println(Thread.currentThread().getName() + "-----This is antion start");
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " ----this is new thread action");
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " ----this is new thread end");
        },"testThread").start();
        try {
            TimeUnit.MILLISECONDS.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +"------This is the end of thread");
    }




    @Autowired
    ProductDao productDao;

    @Autowired
    PurchaseRecord purchaseRecordDao;

    @Test
    public void contextLoads() {
        Product product  = productDao.getProduct(1);
    }

    @Test
    public void arrSort(){
        int [] arr = {1,4,2,14,23,67,12,34,13,22,31};

        //冒泡排序
        for(int i = 0;i < arr.length; i++){
            for(int j = 0;j < i;j ++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        //选择排序
        for(int i = 0; i < arr.length;i++){
            int m = i;
            for(int j = i + 1; j < arr.length;j++){
                if(arr[j] < arr[m]){
                    m = j;
                }
            }
            if(m != i){
                int news = arr[i];
                arr[i] = arr[m];
                arr[m] = news;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int x : arr){
            list.add(x);
        }
        List<Integer> list1 = quicksort(list);
        for(Integer y : list1){
            System.out.println(y);
        }
    }

    /**
     *
     *
     * 快速排序
     * @param items
     * @return
     */
    public static List<Integer> quicksort(List<Integer> items){
        if(items.size() > 1){

            List<Integer> smalls = new ArrayList<>();
            List<Integer> sames = new ArrayList<>();
            List<Integer> larges = new ArrayList<>();

            int choose = items.get(items.size() / 2);

            for(Integer item : items){
                if(item < choose){
                    smalls.add(item);
                }else if(item > choose){
                    larges.add(item);
                }else{
                    sames.add(item);
                }
            }

            quicksort(smalls);
            quicksort(larges);

            items.clear();
            items.addAll(smalls);
            items.addAll(sames);
            items.addAll(larges);
        }
        return items;
    }
}

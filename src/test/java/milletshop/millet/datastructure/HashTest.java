package milletshop.millet.datastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.ASCIICaseInsensitiveComparator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HashTest {

    @Test
    public void testHash(){

        int[] arr =  {1,2,3,45,6,7,7,8};

        HashSet hashSet = new HashSet();

        HashMap hashMap = new HashMap();

        System.out.println(hashMap);
        for(int i : arr){

            hashMap.put("1",i);
        }
        System.out.println(hashMap);
    }

    @Test
    public void testNewRounder(){
        System.out.println(new Random().nextInt(1000));
    }

    @Test
    public void testStr(){
        String str = "{{[{{dewqedwq}}]}}";
        System.out.println(symbalMarching(str));
    }

    /**
     * 利用栈实现字符串符号匹配
     * @param str
     * @return
     */
    public boolean symbalMarching(String str){
        HashMap<Character,Character> hashMap  = new HashMap<>();
        hashMap.put('}','{');
        hashMap.put(']','[');
        hashMap.put(')','(');
        Stack stack = new Stack();
        for(char c : str.toCharArray()){
            if(hashMap.containsValue(c)){
                stack.push(c);
            }else if (hashMap.containsKey(c)){
                if(stack.isEmpty())
                    return false;
                if(stack.peek() == hashMap.get(c)){
                    stack.peek();
                    System.out.println(hashMap.get(c));
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void checkoutData(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("2018-02-30");
        Date date = new Date("2018-02-30");
        simpleDateFormat.format(date);
        System.out.println(date);


    }

    @Test
    public void testGenerticy() {
        Genercity<Integer> genercity = new Genercity<Integer>();
        genercity.write(89);
        System.out.println(genercity.read());
        List<Integer> list = makeList(4);
    }

    class Genercity<AnyType> {

        private AnyType storeValue;

        public AnyType read() {
            return storeValue;
        }

        public void write(AnyType x) {
            storeValue = x;
        }
    }

    @Test
    public void testListArr() {
        List<Integer> lists = new LinkedList<>();
        for (int i = 0; i < 800000; i++) {
            lists.add(i);
        }
        long start = System.currentTimeMillis();
        System.out.println("开始移除相关偶数项---------------");
        System.out.println(lists.size());

        Iterator<Integer> iterator = lists.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public List<Integer> makeList(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
            list.trimToSize();
        }
        return list;
    }


    //测试案例
    @Test
    public void testSet() {
        Set set = new TreeSet(new ASCIICaseInsensitiveComparator());
        set.add("Hello");
        set.add("Hello");
        System.out.println("the set size is " + set.size());
    }

    @Test
    public void listPathFile() {
        File file = new File("G:\\workspace\\ssm_crud\\src\\main\\java\\com");
        listFile(file);
    }

    public void listFile(File f) {
        fileListAll(f, 0);
    }

    private void fileListAll(File f, int i) {
        printName(f, i);
        if (f.isDirectory()) {
            File[] fileLists = f.listFiles();
            for (File file : fileLists) {
                fileListAll(file, i + 1);
            }
        }
    }

    private void printName(File f, int x) {
        String name = f.getName();
//        for (int i = 0; i < x; i++) {
//            System.out.println(" ");
//        }
        if (f.isDirectory())
            System.out.println("Dir : " + f.getName());
        else
            System.out.println(f.getName() + " " + f.length());
    }


}

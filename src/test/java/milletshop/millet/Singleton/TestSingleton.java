package milletshop.millet.Singleton;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestSingleton {

    private byte arr[];

    public static TestSingleton singleton = new TestSingleton();

    //私有化构造器，不允许外部new
    private TestSingleton() {

    }

    private static TestSingleton getInstance() {
        return singleton;
    }

    private static class HolderInstance {
        private static TestSingleton instance = new TestSingleton();
    }


    public static TestSingleton getIHoldernstance() {
        return HolderInstance.instance;
    }

}

class CheckSingleton {
    private byte arr[];
    private static CheckSingleton doubleCheckSingleton = null;

    private CheckSingleton() {

    }

    public static synchronized CheckSingleton getInstance() {
        if (null == doubleCheckSingleton) {
            doubleCheckSingleton = new CheckSingleton();
        }
        return doubleCheckSingleton;
    }
}

class LanHanSingleton {
    private byte arr[];
    private String name;

    private LanHanSingleton lanHanSingleton = null;

    public LanHanSingleton getInstance() {
        return new LanHanSingleton();
    }
}

class DoubleCheckSingleton {
    private volatile DoubleCheckSingleton volatileSingleton;

    private DoubleCheckSingleton getInstance() {
        if (volatileSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (volatileSingleton == null) {
                    volatileSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return volatileSingleton;
    }


}


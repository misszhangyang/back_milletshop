package milletshop.millet.datastructure;

/**
 * 队列的简单实现(数组实现)
 */
public class QueueData {

    private int max;             //定义队列的小
    private int front = -1;      //定义队列的头（指向队列的头的前一个位置）
    private int real = -1;       //定义队列的尾部
    private int[] arr;

    public QueueData(int max){
        this.max = max;
        arr = new int[this.max];
    }

    //队列是否已经满
    public boolean isFull(){
        return this.arr.length == max;
    }

    //队列是否为空
    public boolean isNull(){
        return front == real;
    }

    //取出队列的数据
    public int getQueue(){
        if (isNull()){
            System.out.println("当前队列为空--");
        }
        front ++;
        return  arr[front];
    }

    //查看队列的头元素
    public int  showFirstQueue(){
        if(isNull()){
            throw new RuntimeException("当前队列为空，无法取出数据");
        }
        return arr[front++];
    }

    //查看当前队列的数据
    public void viewQueue(){
        if(isNull()){
            System.out.println("当前队列为空");
        }
        for(int i:arr){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    //向队列中新增一个数
    public void addQueue(int n){
        if(isFull()){
            System.out.println("当前队列已满，无法添加数据");
        }
        real ++;
        arr[real] = n;
    }


}

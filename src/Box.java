import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Box {
    //奶箱最带容量5
    public static final int MILK_MAX = 5;
    //奶箱中牛奶队列
    public Queue<Milk> queue = new LinkedBlockingQueue<>(MILK_MAX);
    //打印奶箱当前牛奶数量

    public void show() {
        System.out.println("奶箱：当前牛奶数量为" + queue.size());
    }

    //接收生产者生产的牛奶
    public synchronized void receive(Milk milk){
        if (queue.offer(milk)) {
            show();
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //提供牛奶给消费者
    public synchronized Milk provide() {
        Milk milk = queue.poll();
        if (milk != null){
            show();
            notifyAll();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return milk;
    }
}

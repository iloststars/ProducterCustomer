import org.omg.CORBA.CustomMarshal;

public class Demo {
    public static void main(String[] args) {
        /*需求：生产者生产牛奶放入奶箱，消费者从奶箱获取牛奶
          输出：
            生产者：生产第m瓶牛奶
            奶箱：剩余i瓶牛奶
            消费者：消费第n瓶牛奶
          对象：
            生产者
            消费者
            奶箱
            牛奶
        * */
        Box box = new Box();
        Producer producer = new Producer(box);
        Customer customer = new Customer(box);
        Thread t1 = new Thread(producer,"生产者");
        Thread t2 = new Thread(customer,"消费者");
        t1.start();
        t2.start();
    }
}

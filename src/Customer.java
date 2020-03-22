public class Customer implements Runnable{
    private Box box;
    private Milk milk;

    public Customer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true){
            milk = box.provide();
            if(milk!= null) {
                System.out.println(MyUtil.getThreadName() + ":消费第" + milk.getNum() + "瓶牛奶");
//                if(milk.getNum()>5)
//                    return;
            }
            else
                return;
        }
    }
}

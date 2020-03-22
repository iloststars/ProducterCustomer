public class Producer implements Runnable{
    private Box box;
    private Milk milk;

    public Producer(Box box) {
        this.box = box;
    }

    @Override
    public void run() {
        while(true){
            milk = new Milk();
            box.receive(milk);
            System.out.println(MyUtil.getThreadName()+":生产第"+milk.getNum()+"瓶牛奶");
//            if(milk.getNum()>5)
//                return;
        }

    }
}

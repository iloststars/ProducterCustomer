public class Milk {
    //牛奶实例对象计数
    public static int count = 0;
    //牛奶编号
    private int num;
    public Milk() {
        num = ++count;
    }

    //获取当前牛奶实例编号
    public int getNum() {
        return num;
    }
}

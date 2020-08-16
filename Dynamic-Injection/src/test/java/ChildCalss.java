public class ChildCalss extends ParentClass{

    public ChildCalss(){
        //父类没有默认构造函数，要显示调用父类构造函数
        super("lds");
    }
    public void childPrint(){
        print();
        System.out.println("-------------");
    }

    public static void main(String ...argv){
        ChildCalss childCalss = new ChildCalss();
        System.out.println(childCalss);
        childCalss.childPrint();


    }
}

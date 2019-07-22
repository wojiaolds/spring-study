import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class StringTest {

    public static void main(String... argv) {
        String s1 = "My name";
        String s2 = "My name";
        String s3 = new String("My name");
        String s4 = new String("My name");
        System.out.println(s1==s2);
        System.out.println(s3==s4);  //比较的是地址
        System.out.println(s1==s3);
        s1 = "23";

        String str = s1 + s2 ;

        int[] a = { 1, 2, 3, 4, 5, 6 };
        int temp;
        //联动for循环
        for (int star = 0, end = a.length - 1; star < end; star++, end--) {
            temp = a[star];
            a[star] = a[end];
            a[end] = temp;
        }
        System.out.print("arry[");    //优美的输出数组的内容
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.println(a[i] + "]");
            } else {
                System.out.print(a[i] + ", ");
            }
        }
        System.out.println("");
//        List<Integer> list = Ints.asList(a);
        System.out.println(a);
        //asList接受的参数是一个泛型的变长参数，而基本数据类型是无法泛型化的
        System.out.println( Arrays.asList(a).size());
        Arrays.asList(a).forEach(System.out::println);
        System.out.println(Arrays.toString(a));
        String[] s = {"123","234"};
        System.out.println(Arrays.toString(s));

        String sa= "11"+"11";

        String sb = "1111";
        String sc = new String("11") + new String("11");
        System.out.println(sa == sb);
        System.out.println(sa == sc);


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(1);
        stringBuffer.deleteCharAt(1);

        String.valueOf(1);



    }
}

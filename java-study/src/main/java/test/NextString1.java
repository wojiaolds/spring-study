package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//找出一个int[]中满足 2^n的数字，然后组成的新的数组
public class NextString1 {
    public static void main(String[] args) {
        int[] arr = {1,4,3,8,7,9,16,32,45};
        System.out.println(Arrays.toString(nextString(arr)));
    }
    public static boolean fun(int i){
        return (i > 0) && ((i & (i - 1)) == 0);
    }
    public static Integer[] nextString(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int a:arr) {
            if (fun(a))
                list.add(a);
        }
     
        Integer[] resultArr = new Integer[list.size()];

        return list.toArray(resultArr);

    }

}

package test;

import java.util.Arrays;
import java.util.Comparator;

public class GetColMin {

    public static void main(String[] args) {
        Integer[][] arr = {{5,6,1,16},{7,3,9}};
        System.out.println(Arrays.toString(getColMin(arr)));
    }

    public static Integer[] getColMin(Integer[][] arr) {
        Integer[] minArr = new Integer[arr.length];
        for(int i = 0;i<arr.length;i++) {
            Integer[] tmp = arr[i];
            Arrays.sort(tmp);
            Arrays.sort(tmp,  Comparator.comparingInt(Integer::intValue).reversed());
            minArr[i] = tmp[0];
        }
        return minArr;

    }

}

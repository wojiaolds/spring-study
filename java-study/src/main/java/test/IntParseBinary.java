package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntParseBinary {

    public static void main(String[] args) {
        int data = 6;
        System.out.println(Arrays.toString(getNumber(data)));
    }

    public static int[] getNumber(int data) {
//        char[] binaryStr = Integer.toBinaryString(data).toCharArray();
//        Map<Character,Integer> map = new HashMap<Character,Integer>();
//        for(int i = 0;i<binaryStr.length;i++) {
//            if(!map.containsKey(binaryStr[i])) {
//                map.put(binaryStr[i], 1);
//            }else{
//                map.put(binaryStr[i], map.get(binaryStr[i])+1);
//            }
//        }
//        return new int[]{map.get('0'),map.get('1')};
        int oneCount = 0, zeroCount = 0;
        while (data > 0) {
            if ((data & 1)== 0) {
                zeroCount++;
            } else {
                oneCount++;
            }
            data = data >> 1;
        }
        int[] result = {zeroCount, oneCount };
        return result;


    }

}

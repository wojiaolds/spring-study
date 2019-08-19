package test;

public class BitReverse {

    public static void main(String[] args) {
        String data = "1010";
        System.out.println(getNumber(data));
    }
    public static String getNumber(String data){
        char[] dataStr = data.toCharArray();
        int num = 0;
        for(int i = 0;i<dataStr.length;i++) {
//            if(dataStr[i] == '0') {
//                dataStr[i] = '1';
//            }else {
//                dataStr[i] = '0';
//            }
            if(dataStr[i] == '0')
                num += (int)Math.pow(2,dataStr.length-i-1);
        }

//        String str = String.valueOf(dataStr);
//
//        String res = Integer.valueOf(str, 2).toString();
        return String.valueOf(num);

    }

}

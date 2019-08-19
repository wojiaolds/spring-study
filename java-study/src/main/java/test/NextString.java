package test;

public class NextString {

    public static void main(String[] args) {
        String str = "aBxyZ";
        System.out.println(nextString(str));
    }

    public static String nextString(String str) {
        String result = "";
        char[] arr = str.toCharArray();
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] == 'z' || arr[i] == 'Z') {
                arr[i] = (char)(arr[i]-25);
            }else if(arr[i]<'z'&&arr[i]>='a' || arr[i]<'Z'&&arr[i]>='A') {
                arr[i] = (char)(arr[i]+1);
            }
        }

        return String.valueOf(arr);
    }

}

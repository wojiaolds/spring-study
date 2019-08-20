package test;

import java.util.Scanner;

//判断一个字符串中是否只含有相同的子字符串（子串长度>=2）
public class CheckStr {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean result=false;
        System.out.println("请输入一串字符：");
        String str = in.nextLine();
        in.close();
        if(str.length()==1 || str.length()==2){
            System.out.println("输入的字符串长度为"+str.length()+",不足以拆分,请输入3以上长度的字符串。");
        }else{
            result = checkString(str);
        }
        System.out.println("结果--" + result);
        in.close();
    }
    public static boolean checkString(String str) {
        boolean result=false;
        if(str.length()==3){
            if((str.charAt(0)==str.charAt(1))&&(str.charAt(0)==str.charAt(2))){
                result=true;
            }
        }else{
            for(int i=2;i<=str.length()/2&&(result==false);i++){
                for(int j=0;j<=str.length()-i;j++){
                    String strP=str.substring(j,j+i);
                    if(str.indexOf(strP,j+1)!=-1){
                        result=true;
                        break;
                    }
                }
            }
        }
        return result;
    }

}

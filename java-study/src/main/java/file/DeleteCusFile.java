package file;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 20:35 2019/9/28
 */

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 20:35 2019/9/28
 */
public class DeleteCusFile {

    public static void main(String[] args) throws Exception{
        scan("H:\\java\\javaproject\\wokspace");
    }

    public static void scan(String file) throws Exception{
        Files.list(Paths.get(file)).forEach(x->{
            try {
                File f = x.toFile();

                if (f.isDirectory() ) {
                    if(f.getPath().contains("idea") || f.getPath().contains("svn") || f.getPath().contains("target")) {
                        System.out.println("1 " + f.getPath());
                        delDirectory(f);

                    }else{
                        System.out.println("3 "+f.getPath());
                        scan(f.getPath());
                    }

                } else if (f.getName().endsWith("iml") || f.getName().endsWith("ipr") || f.getName().endsWith("iws")) {
                    System.out.println("2 "+f.getPath());
                    f.delete();

                }

            }catch (Exception e){
                System.out.println(e);
            }
        });
    }

    private static void delDirectory(File f) {
        //判断是否目录
        if (f.isDirectory()) {
            //是目录,判断是否有子文件
            if (f.listFiles().length>0) {
                for (File file : f.listFiles()) {
                    //有子文件再次调用本方法
                    delDirectory(file);
                }
            }else {
                //无子文件直接删除
                f.delete();
            }
        }
        //删除空目录 或 文件
        f.delete();
    }

}

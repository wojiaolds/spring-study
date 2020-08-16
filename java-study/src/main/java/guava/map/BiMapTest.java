package guava.map;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 20:24 2019/9/7
 */

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 20:24 2019/9/7
 */
public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","q");
        biMap.put("2","w");
        biMap.forcePut("3","w");//强制覆盖value为w的数据
        System.out.println(biMap.get("1"));
        System.out.println(biMap.inverse().get("1"));
        System.out.println(biMap.inverse().get("q"));
        System.out.println(biMap.keySet());
        System.out.println(biMap.values());
        biMap.replaceAll((s,s1)-> {

                if(s.equals("1")){
                    return "e";
                }else {
                    return "r";
                }

        });
        System.out.println(biMap.keySet());
        System.out.println(biMap.values());
        biMap.inverse().remove("e");
        System.out.println("---------");
        System.out.println(biMap.keySet());
        System.out.println(biMap.values());
    }
}

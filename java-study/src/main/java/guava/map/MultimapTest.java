package guava.map;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 19:15 2019/9/7
 */

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.Multimap;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 19:15 2019/9/7
 */
public class MultimapTest {
    public static void main(String[] args) {
        Multimap<String,String> multimap = ArrayListMultimap.create();
        multimap.put("1","dewc");
        multimap.put("1","dewc");
        multimap.put("1","dcerwcd");
        multimap.put("2","cedwc");
        System.out.println(multimap.get("1"));

    }
}

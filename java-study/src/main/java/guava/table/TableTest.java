package guava.table;/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 20:10 2019/9/7
 */

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * @Author: lds
 * @Desc:
 * @Date: Create in 20:10 2019/9/7
 */
public class TableTest {
    public static void main(String[] args) {
        Table<String,String,String> table = HashBasedTable.create();
        table.put("1","1","qwe");
        table.put("2","2","qwe");
        System.out.println(table.rowMap());
        System.out.println(table.columnMap());
        table.remove("2","2");
        System.out.println(table.rowMap());
        System.out.println(table.columnMap());

    }
}

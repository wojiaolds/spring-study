import com.lds.dyn.importBeanDefinitionRegistrar.config.MapperAutoConfig;
import com.lds.dyn.importSelector.bean.StudentBean;
import com.lds.dyn.importSelector.bean.User;
import com.lds.dyn.importSelector.config.MainConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding.Use;

/**
 * @Author: lds
 * @Date: 2019/7/16 14:24
 */
@RunWith (SpringRunner.class)
@ContextConfiguration (classes = { MainConfig.class})
public class importSelectorTest {

	@Autowired
	private StudentBean student;
	
//	@Autowired
//	private User user;
	
	@Test
	public void test(){
		System.out.println(student.getName());
		System.out.println(student.getId ());
	}

}

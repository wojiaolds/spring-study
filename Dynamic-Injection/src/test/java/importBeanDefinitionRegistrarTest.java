import com.lds.dyn.importBeanDefinitionRegistrar.CountryMapper;
import com.lds.dyn.importBeanDefinitionRegistrar.config.MapperAutoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: lds
 * @Date: 2019/7/16 9:49
 */
@RunWith (SpringRunner.class)
@ContextConfiguration (classes = { MapperAutoConfig.class})
public class importBeanDefinitionRegistrarTest {
	
//	@Autowired
//	private ApplicationContext applicationContext;
	
	@Autowired
	private CountryMapper countryMapper;
	
	@Test
	public void contextLoads () {
		
		System.out.println (countryMapper.getClass ());
	}
}

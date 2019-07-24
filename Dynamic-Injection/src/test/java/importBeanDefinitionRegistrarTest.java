import com.lds.dyn.importBeanDefinitionRegistrar.CountryMapper;
import com.lds.dyn.importBeanDefinitionRegistrar.IMessage;
import com.lds.dyn.importBeanDefinitionRegistrar.TeacherMapper;
import com.lds.dyn.importBeanDefinitionRegistrar.config.MapperAutoConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
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
	
//	@Autowired
//	private ApplicationContext applicationContext;
	
	@Autowired
	private CountryMapper countryMapper;
	
	@Autowired
	private IMessage iMessage;
	
	@Test
	public void contextLoads () {
		
		countryMapper.print ();
		/**
		 * 当bean类型是原型的时候
		 * beanfactory中只有BeanDefinition,并没有实例化
		 * 只有用到这个bean的地方才会去真正实例化它
		 */
		TeacherMapper teacherMapper = getTeachMapper ();
		System.out.println (teacherMapper);
		
		iMessage.send ("125481","3654");
	}
	
	/**
	 * 这是一个作用在方法上的注解，被其标注的方法会被重写，
	 * 然后根据其返回值的类型，容器调用BeanFactory的getBean()方法来返回一个bean。
	 * @return
	 */
	//不知道为什么在这里不生效
	@Lookup
	public TeacherMapper getTeachMapper(){return  null;}
}

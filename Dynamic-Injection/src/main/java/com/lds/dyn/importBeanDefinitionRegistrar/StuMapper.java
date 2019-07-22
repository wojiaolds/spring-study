package com.lds.dyn.importBeanDefinitionRegistrar;

import com.lds.dyn.importBeanDefinitionRegistrar.annotation.MyMapper;
import org.springframework.beans.factory.annotation.Lookup;

/**
 * @Author: lds
 * @Date: 2019/7/19 9:20
 */
@MyMapper
public class StuMapper {
	
	public void print(){
		TeacherMapper teacherMapper = getTeachMapper ();
		System.out.println (teacherMapper);
		System.out.println ("----StuMapper  print()---");
	}
	
	@Lookup
	public TeacherMapper getTeachMapper(){return  null;}
}

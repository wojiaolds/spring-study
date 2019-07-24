import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.util.AntPathMatcher;

/**
 * @Author: lds
 * @Date: 2019/7/18 11:59
 */
public class AntPathMatcherTest {
	
	public static void main ( String... argv ) {
		
		AntPathMatcher antPathMatcher = new AntPathMatcher ();
		
		System.out.println (antPathMatcher.isPattern ("/user/001"));// 返回 false
		System.out.println (antPathMatcher.isPattern ("/user/*")); // 返回 true
		System.out.println (antPathMatcher.match ("/user/001", "/user/001"));// 返回 true
		System.out.println (antPathMatcher.match ("/user/*", "/user/001"));// 返回 true
		System.out.println (antPathMatcher.matchStart ("/user/*", "/user/001")); // 返回 true
		System.out.println (antPathMatcher.matchStart ("/user/*", "/user")); // 返回 true
		System.out.println (antPathMatcher.matchStart ("/user/*", "/user001")); // 返回 false
		System.out.println (antPathMatcher.extractPathWithinPattern ("uc/profile*",
												 "uc/profile.html")); // 返回 profile.html
		System.out.println (antPathMatcher.combine ("uc/*.html", "uc/profile.html")); // uc/profile.html
		
	}
	
}

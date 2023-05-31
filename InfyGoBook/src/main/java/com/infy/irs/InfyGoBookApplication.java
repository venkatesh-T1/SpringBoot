package com.infy.irs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
@PropertySource(value={"classpath:configuration.properties"})
public class InfyGoBookApplication  implements WebMvcConfigurer{

	
	/*@Autowired
	RegistrationService rs;
	
	@Autowired
	Environment env;*/
	
	public static void main(String[] args) {
		SpringApplication.run(InfyGoBookApplication.class, args);
	}
	@Override
	
	public void configurePathMatch(PathMatchConfigurer configurer) {
	
		UrlPathHelper url= new UrlPathHelper();
		url.setRemoveSemicolonContent(false);
		configurer.setUrlPathHelper(url);
	}
	

	/*@Override
	public void run(String... args) throws Exception {
		User u = new User();
		try {
	Scanner sc= new Scanner(System.in);
	System.out.println("Enter Your UserID: ");
	String uid=sc.next();
	System.out.println("Enter password: ");
	String pwd = sc.next();
	System.out.println("Enter name: ");
	String name = sc.next();
	System.out.println("Enter city: ");
	String city = sc.next();
	System.out.println("Enter email: ");
	String mail = sc.next();
	System.out.println("Enter phone: ");
	String phone = sc.next();
	u.setUserId(uid);
	u.setName(name);
	u.setEmail(mail);
	u.setPassword(pwd);
	u.setPhone(phone);
	u.setCity(city);
	rs.registerUser(u);
	//System.out.println(env.getProperty(rs.registerUser(u)));
	sc.close();
		}
	
	catch(Exception ex) {
		System.out.println(env.getProperty(ex.getMessage()));
	}}*/

	

}

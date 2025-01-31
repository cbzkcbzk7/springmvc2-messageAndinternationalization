package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}


//	스프링 국제화 직접 등록 방식
	// 스프링부트는 자동으로 지원해줌
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new
//				ResourceBundleMessageSource();
//		messageSource.setBasenames("messages", "errors");	// messages.properties , errors.proterties를 읽음
//		messageSource.setDefaultEncoding("utf-8");
//		return messageSource;
//	}

}



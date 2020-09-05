package com.test.hplus.config;

import java.util.Locale;

import javax.xml.stream.XMLResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.CookieThemeResolver;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import com.test.hplus.beans.Login;
import com.test.hplus.convertors.StringToEnumConvertors;
import com.test.hplus.interceptors.LoginInterceptor;

@Configuration
@ComponentScan
public class ApplicationConfig extends WebMvcConfigurationSupport {
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		//This method help us to tell the spring that whenever you required any static files css/images you have to pick it up from specified path mentioned in this method.
		
		  registry.addResourceHandler("css/**","images/**")
		  .addResourceLocations("classpath:/static/css/","classpath:/static/images");
		  
		 
		
		//super.addResourceHandlers(registry);
	}
	
	@Override
	
	
	protected void addFormatters(FormatterRegistry registry) {
		
		registry.addConverter(new StringToEnumConvertors());
		
	}
	
	@Bean
	public InternalResourceViewResolver jspViewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);//so that it will render proper jsp pages
		return viewResolver;
	}

	 //  Veiw resolver methods InternalResourceViewResolver
	
	
	
	 @Bean public XmlViewResolver xmlViewResolver() { XmlViewResolver
	  viewResolver= new XmlViewResolver(); viewResolver.setLocation(new
	  ClassPathResource("views.xml")); 
	  viewResolver.setOrder(1);
	  return viewResolver; 
	  } //Veiw resolver methods xmlViewResolver jsp are getting rendered.
	 
	
	@Bean
	public ResourceBundleViewResolver resourceBunleViewResolver() {
		ResourceBundleViewResolver viewResolver= new ResourceBundleViewResolver();
		viewResolver.setBasename("views");
		return viewResolver;
	}
	
	//Application can configure multiple view resolver.Higher the order value later that view resolver placed in a chain.
	//use setOrder methods mentioned above 
	
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {//to register your custom interceptors
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/*");
		registry.addInterceptor(new ThemeChangeInterceptor());//provided by spring 
		//Interceptor that allows for changing the current theme on every request,
		// * via a configurable request parameter (default parameter name: "theme").
		//http://localhost:8080/home?theme=client-theme2 and http://localhost:8080/home?theme=client-theme1
		registry.addInterceptor(new LocaleChangeInterceptor());//defualt is Locale 
	}
//how do we access session and request attribute 
	//store a model in a session using @sessionAttributes,Attached at class level
	//access session data using @sessionAttribute,attached at method level
	//access request data using @requestAttribute,attached at method level
	///since we r using cookie resolver go to f12-> application->cookies-> themeChangeInteeceptor will take request param and using cookie resiolver it is going to store cookie insode ur browser
	@Bean
	public ThemeResolver themeResolver()
	{
		CookieThemeResolver cookieThemeResolver = new CookieThemeResolver();
		cookieThemeResolver.setCookieName("theme");
		cookieThemeResolver.setDefaultThemeName("client-theme1");//if didnt find any thee then it will take default as u mentioned
		return cookieThemeResolver;
		
	}
	//Default locale resolver is AcceptHeaderLocaleResolver 
	@Bean
	public LocaleResolver localeResolver()
	{
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.US);
		cookieLocaleResolver.setCookieName("locale");
		return cookieLocaleResolver;
	}
}
	


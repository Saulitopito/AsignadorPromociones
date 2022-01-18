package jpa.promociones;

import javax.management.modelmbean.ModelMBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.swagger2.mappers.ModelMapper;

@Configuration
public class ApplicationConfig {

	@Bean
    public WebMvcConfigurer CORSConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT","DELETE");
            }
        };
    }
	
	/*@Bean
	   public ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      return modelMapper;
	   }*/

}
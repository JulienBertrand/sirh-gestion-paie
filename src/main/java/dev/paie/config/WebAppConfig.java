package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

//@Configuration
//@EnableWebMvc
//@ComponentScan({ "dev.paie.web.controller", "dev.paie.web.services", "dev.paie.web.util" })
//

@Configuration 
@ComponentScan({ "dev.paie" }) 
@EnableJpaRepositories({ "dev.paie.repository" }) 
@ImportResource(value = { "classpath:cotisations-imposables.xml","classpath:cotisations-non-imposables.xml" ,"classpath:entreprises.xml","classpath:grades.xml","classpath:profils-remuneration.xml"})
@Import({ JpaConfig.class, DataSourceMySQLConfig.class })
public class WebAppConfig {
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
}
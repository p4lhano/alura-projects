package dev.palhano.ms.alurafood.ms.pagamento.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}

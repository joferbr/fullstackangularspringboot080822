package com.github.joferbr.clientes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

public class InternacionalizacaoConfig {

    //Define arquivo de mensagens//
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); //Injeta as mensagens do arquivo messages.properties//
        messageSource.setDefaultEncoding("ISO-8859-1"); //Para aceitar caracteres acentuados do Brasil//
        messageSource.setDefaultLocale(Locale.getDefault()); //Pega a localização via SO ou OS//
        return messageSource;
    }
    //Interpolaçãp
    public LocalValidatorFactoryBean validatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}

package com.zemoso.springboot.cruddemo.config;

import java.util.Map;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class ValidatorAddingCustomizer implements HibernatePropertiesCustomizer {

  private final ObjectProvider<Validator> provider;

  @Autowired
  public ValidatorAddingCustomizer(ObjectProvider<Validator> provider) {
    this.provider = provider;
  }

  @Override
  public void customize(Map<String, Object> hibernateProperties) {
    Validator validator = provider.getIfUnique();
    if (validator != null) {
      hibernateProperties.put("javax.persistence.validation.factory", validator);
    }
  }

}
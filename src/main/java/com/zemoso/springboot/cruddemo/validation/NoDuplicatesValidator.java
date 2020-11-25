package com.zemoso.springboot.cruddemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zemoso.springboot.cruddemo.dao.BookRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


//@Service
//@AllArgsConstructor
//@NoArgsConstructor
public class NoDuplicatesValidator implements ConstraintValidator<NoDuplicates,String> {

    private BookRepository bookRepository;
    
    private static final Logger LOGGER=LoggerFactory.getLogger(NoDuplicatesValidator.class);


	public NoDuplicatesValidator() {

	}


	@Autowired
	public NoDuplicatesValidator(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
    }
    


	@Override
    public void initialize(NoDuplicates title) {
		
    }

	@Override
	public boolean isValid(String theTitle, ConstraintValidatorContext theConstraintValidatorContext) {
		 LOGGER.info(theTitle);
		 return (theTitle != null && !bookRepository.findByTitle(theTitle).isEmpty());
		
	}


}

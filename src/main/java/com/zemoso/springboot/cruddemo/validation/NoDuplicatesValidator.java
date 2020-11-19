package com.zemoso.springboot.cruddemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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

    private final BookRepository bookRepository;
    



	public NoDuplicatesValidator(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
    }
    


	@Override
    public void initialize(NoDuplicates title) {
		
    }

	@Override
	public boolean isValid(String theTitle, ConstraintValidatorContext theConstraintValidatorContext) {
		System.out.println(theTitle);
		if(theTitle==null || bookRepository.existsByTitle(theTitle)) {
			return false;
		}
		else {
			
			return true;
		}
	}


}

package com.demo.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.app.request.DemoRequest;

@Component
public class CustomValidator  implements Validator {

    public boolean supports(Class<?> clazz) {
        return DemoRequest.class.isAssignableFrom(clazz);
    }
 
    public void validate(Object target, Errors errors) {
        DemoRequest demoRequest=(DemoRequest) target;
        String type=demoRequest.getType();
       if (type != null && type.equalsIgnoreCase("hello"))
            errors.rejectValue("type", "Custom.demoRequest.type");
   
    }
}

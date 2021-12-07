package com.emps.managementsystem.exception;



//custom exception  when a resource isnt found in the db
//if employee is not found it will return a message to the console
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String resourceName;
private String fieldName; //Id - name
private Object fieldValue; //id - value


public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
	super(String.format("%s not found with %s :'%s' ", resourceName, fieldName, fieldValue));
	this.resourceName = resourceName;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}

public String getResourceName() {
	return resourceName;
}

public String getFieldName() {
	return fieldName;
	
}

public Object getFieldValue() {
	return fieldValue;
}


}

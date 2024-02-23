package com.social.media.application.socialmediaapi.versioning;

public class PersonV2 {
   private String firstName;
   private String secondName;
   
public PersonV2(String firstName, String secondName) {
	super();
	this.firstName = firstName;
	this.secondName = secondName;
}

public String getFirstName() {
	return firstName;
}

public String getSecondName() {
	return secondName;
}

@Override
public String toString() {
	return "PersonV2 [firstName=" + firstName + ", secondName=" + secondName + "]";
}
   


     
}

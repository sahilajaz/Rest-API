package com.social.media.application.socialmediaapi.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class someBean {
   public String filed1;
   public String field2;
   public String field3;
   
public someBean(String filed1, String field2, String field3) {
	super();
	this.filed1 = filed1;
	this.field2 = field2;
	this.field3 = field3;
}

public String getFiled1() {
	return filed1;
}

public String getField2() {
	return field2;
}

public String getField3() {
	return field3;
}

@Override
public String toString() {
	return "someBean [filed1=" + filed1 + ", field2=" + field2 + ", field3=" + field3 + "]";
}

  
   
   
}

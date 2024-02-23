package com.social.media.application.socialmediaapi.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
   public PersonV1 getFirstVersionOfperson() {
	   return new PersonV1("Bob Charlie");
   }
	
	@GetMapping("/v2/person")
	   public PersonV2 getSecondVersionOfperson() {
		   return new PersonV2("Bob Charlie" , "ethan");
	   }  
	
	@GetMapping(path ="/person" , params = "version=1")
	   public PersonV1 getFirstVersionOfpersonRequestParameter() {
		   return new PersonV1("Bob Charlie");
	   }
	
	@GetMapping(path = "/person" , params ="version=2" )
	   public PersonV2 getSecondVersionOfpersonRequestParameter() {
		   return new PersonV2("Bob Charlie" , "ethan");
	   }
   
	@GetMapping(path ="/person/header" , headers = "X-API-VERSION=1")
	   public PersonV1 getFirstVersionOfpersonRequestHeader() {
		   return new PersonV1("Bob Charlie");
	   }
	
	@GetMapping(path = "/person/header" , headers ="X-API-VERSION=2" )
	   public PersonV2 getSecondVersionOfpersonRequestHeader() {
		   return new PersonV2("Bob Charlie" , "ethan");
	   }
	
	@GetMapping(path ="/person/header" , produces = "application/vnd.company.app-v1+json")
	   public PersonV1 getFirstVersionOfpersonRequestAcceptHeader() {
		   return new PersonV1("Bob Charlie");
	   }
	
	@GetMapping(path = "/person/header" , headers ="application/vnd.company.app-v2+json" )
	   public PersonV2 getSecondVersionOfpersonRequestAcceptHeader() {
		   return new PersonV2("Bob Charlie" , "ethan");
	   }
	
	
}

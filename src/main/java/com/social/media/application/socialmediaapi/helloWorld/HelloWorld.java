package com.social.media.application.socialmediaapi.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    private MessageSource message;
    
    public HelloWorld(MessageSource message) {
      this.message = message;	
    }
    
	@GetMapping("/hello-world")
	public String helloWord() {
		return "Good Morning";
	}
	
	@GetMapping("/hello-world-i18n")
	public String helloWordI18n() {
		Locale locale = LocaleContextHolder.getLocale();
	  return message.getMessage("good.morning.message", null, "default message", locale);
	}
}

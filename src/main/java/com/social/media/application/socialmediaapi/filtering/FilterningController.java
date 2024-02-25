/*
 * package com.social.media.application.socialmediaapi.filtering;
 * 
 * import org.springframework.http.converter.json.MappingJacksonValue; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.fasterxml.jackson.databind.ser.FilterProvider; import
 * com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter; import
 * com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
 * 
 * @RestController public class FilterningController {
 * 
 * 
 * 
 * @GetMapping("/filtering") public MappingJacksonValue filtering() { someBean
 * someBean = new someBean("val1" , "val2" , "val3"); MappingJacksonValue
 * mapping = new MappingJacksonValue(someBean); SimpleBeanPropertyFilter filter
 * = SimpleBeanPropertyFilter.filterOutAllExcept("val1"); FilterProvider filters
 * = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
 * mapping.setFilters(filters); return mapping; } }
 */
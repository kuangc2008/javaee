package com.kc._200_springboot3.readinglist;

import java.util.Map;

//import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
    Map<String, Object> attributes = super.getErrorAttributes(request, includeStackTrace);

    attributes.put("foo", "bar");

    return attributes;
  }
  
}

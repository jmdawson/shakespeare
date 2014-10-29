/*
 * File created on May 8, 2014
 *
 * Copyright 2008-2013 Virginia Polytechnic Institute and State University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.jmdawson.shakespeare.support.cdi;

  import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.naming.InitialContext;

  /**
   * The backing producer for the {@link AppProperty} annotation. Uses a 
   * properties file to inject the requested values.
   * 
   * @author Michael Irwin
   */
  @ApplicationScoped
  public class AppPropertyProducer {
    private static final String JNDI_NAME = "config.properties";
    private static final String LOCAL_NAME= "config.properties";
    
    private Properties properties;

    @PostConstruct
    public void setupProperties() {
      try {
        InputStream in = getInputStream();
        properties = new Properties();
        properties.load(in);
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Produces  @AppProperty("")
    public String getString(InjectionPoint point) {
      AppProperty annotation =
          point.getAnnotated().getAnnotation(AppProperty.class);
      String property = annotation.value();
      String value = properties.getProperty(property);
     
      if (value == null && annotation.required())
        throw new IllegalStateException("Couldn't find value for " + property);
      return value;
    }
    
    @Produces  @AppProperty("")
    public Boolean getBoolean(InjectionPoint point) {
      AppProperty annotation =
          point.getAnnotated().getAnnotation(AppProperty.class);
      String property = annotation.value();
      String value = properties.getProperty(property);
     
      if (value == null && annotation.required())
        throw new IllegalStateException("Couldn't find value for " + property);
      return Boolean.valueOf(value);
    }
    
    private InputStream getInputStream() {
      try {
        String location = 
            (String) (new InitialContext()).lookup("java:comp/env/" + JNDI_NAME);
        if (location.startsWith("classpath:"))
          return localStream(location.substring(10));
        
        return new FileInputStream(location.substring(5));
      } catch (Exception e) {
        return localStream(LOCAL_NAME);
      }
    }
    
    private InputStream localStream(String location) {
      return Thread.currentThread().getContextClassLoader()
          .getResourceAsStream(location);
    }
    
  }
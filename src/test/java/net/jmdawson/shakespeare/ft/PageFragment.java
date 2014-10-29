/*
 * File created on Oct 7, 2014 
 *
 * Copyright (c) 2014 Virginia Polytechnic Institute and State University
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
package net.jmdawson.shakespeare.ft;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * SuperClass for all the page fragments that has some useful common code.
 *
 * @author Jacob Dawson
 * @author Ben Sechrist
 */
public class PageFragment {
  
  public static final String VIEW_SEGMENTS_PAGE_TITLE = "View Segments";
 
  
  @Drone
  protected WebDriver browser;
  
  /**
   * Assert that the browser on the expected page by looking at page title
   * @param pageTitle
   */
  public void assertOnPage(String pageTitle) {
    assertThat(browser.getTitle(), is(equalTo(pageTitle)));
  }
  
  /**
   * Verify that there are no undefined messages
   */
  public void assertNoUndefinedMessages() {
    assertThat(browser.getPageSource(), not(containsString("???")));
  }
  
  /**
   * Verify that the specified string is present anywhere on the page
   * @param string
   */
  public void assertStringIsPresent(String string) {
    assertThat(browser.getPageSource(), containsString(string));
  }
  
  /**
   * Verify that the specified string is not present anywhere on the page
   * @param string
   */
  public void assertStringIsNotPresent(String string) {
    assertThat(browser.getPageSource(),not(containsString(string)));
  }
  
  
  /**
   * Asserts a table row is not present by searching for its id
   * @param elementId
   */
  public void assertElementNotPresent(String elementId){
    assertThat(browser.findElements(By.id(elementId)),is(empty()));
  }
  
  /**
   * Asserts a table row is not present by searching for its id
   * @param elementId
   */
  public void assertElementPresent(String elementId){
    assertThat(browser.findElements(By.id(elementId)),is(not(empty())));
  }

}

/*
 * File created on Sep 22, 2014 
 *
 * Copyright 2008-2014 Virginia Polytechnic Institute and State University
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

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.archive.importer.MavenImporter;

/**
 * A helper class that is used to generate deployments for Arquillian functional
 * testing.
 *
 * @author Michael Irwin
 */
public class Deployments {

  /**
   * Create a full deployment for this war
   * @return
   */
  public static WebArchive createFullDeployment() {
    return createFullDeployment(null);
  }
   
  /**
   * Create a full deployment and add the provided SQL import file to the 
   * archive
   * @param sqlImportFile The import file to add
   * @return
   */
  public static WebArchive createFullDeployment(String sqlImportFile) {
    WebArchive archive = createFullDeploymentWithAuth(sqlImportFile);
    
    archive.addAsWebInfResource("test-web.xml", "web.xml");
    
    return archive;
  }

  /**
   * @param sqlImportFile
   * @return
   */
  public static WebArchive createFullDeploymentWithAuth(String sqlImportFile) {
    WebArchive archive = ShrinkWrap.create(MavenImporter.class)
        .loadPomFromFile("pom.xml")
        .importBuildOutput()
        .as(WebArchive.class)
        .addAsWebInfResource("test-persistence.xml", "classes/META-INF/persistence.xml")
        .addAsWebInfResource("test-jboss-web.xml", "jboss-web.xml");
    
    if (sqlImportFile != null) {
      archive.addAsWebInfResource(sqlImportFile, "classes/load-script.sql");
    }
    return archive;
  }

  /**
   * @return
   */
  public static WebArchive createFullDeploymentWithAuth() {
    return createFullDeploymentWithAuth(null);
  }
  
}

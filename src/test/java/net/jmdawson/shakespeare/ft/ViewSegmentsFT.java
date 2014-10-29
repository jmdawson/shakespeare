package net.jmdawson.shakespeare.ft;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ViewSegmentsFT {

  @Deployment(testable = false)
  public static WebArchive createDeployment(){
    return Deployments.createFullDeployment("examplePods.sql");
  }
}

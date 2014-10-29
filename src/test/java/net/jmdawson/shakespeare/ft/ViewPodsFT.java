package net.jmdawson.shakespeare.ft;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ViewPodsFT {

  @Deployment(testable = false)
  public static WebArchive createDeployment(){
    return Deployments.createFullDeployment("examplePods.sql");
  }
  
  @Page
  private ViewPodPage viewPodPage;
  
  @Test
  public void testViewPodsSuccessfully() throws Exception {
   
    
  }
}

package net.jmdawson.shakespeare.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.domain.PodReportEntity;
import net.jmdawson.shakespeare.domain.SearchEntity;
import net.jmdawson.shakespeare.domain.SegmentEntity;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Rule;
import org.junit.Test;

public class ViewSegmentModelFactoryBeanTest {

  @Rule
  public final JUnitRuleMockery context = new JUnitRuleMockery(){
    {
      setImposteriser(ClassImposteriser.INSTANCE);
    }
  };

  @Mock
  private Segment segment;
  
  @Mock
  private SearchEntity search;
  
  @Mock
  private PodReportEntity pod;
  
  private ViewSegmentModelFactoryBean factory =
      new ViewSegmentModelFactoryBean();

  @Test
  public void testGetModelSuccessfully() throws Exception {
    
    SegmentEntity segment1 = new SegmentEntity();
    segment1.setCurrentPoa(50);
    segment1.setId(1);
    segment1.setSearch(search);
    segment1.addPod(pod);

    context.checking(new Expectations() {
      {
        
      }
    });

    ViewSegmentModel model = factory.createModel(segment);
    assertThat(model, is(not(nullValue())));
    assertThat(model.getId(), is(equalTo(segment1.getId())));
    assertThat(model.getPoa(), is(equalTo(segment1.getCurrentPoa())));
  }

}

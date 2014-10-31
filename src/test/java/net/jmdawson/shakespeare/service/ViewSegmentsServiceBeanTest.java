package net.jmdawson.shakespeare.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.repository.SegmentRepository;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class ViewSegmentsServiceBeanTest {
  
  @Rule
  public final JUnitRuleMockery context = new JUnitRuleMockery();
  
  @Mock
  private SegmentRepository repository;
  
  @Mock
  private ViewSegmentModelFactory factory;
  
  @Mock
  private ViewSegmentModel model1;
  
  @Mock
  private ViewSegmentModel model2;
  
  @Mock
  private Segment segment1;
  
  @Mock
  private Segment segment2;
  
  private ViewSegmentsServiceBean bean = new ViewSegmentsServiceBean();
  
  @Before
  public void setUp() throws Exception {
    bean.factory = factory;
    bean.segmentRepository = repository;
  }


  
  @Test
  public void testGetSegmentsSuccessfully() throws Exception {
    final List<Segment> segments = Arrays.asList(segment1,segment2);
     
    context.checking(new Expectations() {
      {
        oneOf(repository).getSegments();
        will(returnValue(segments));
        
        oneOf(factory).createModel(segment1);
        will(returnValue(model1));
        
        oneOf(factory).createModel(segment2);
        will(returnValue(model2));
      }
    });
   
    List<ViewSegmentModel> models = bean.getSegments();
    assertThat(models,is(not(nullValue())));
    assertThat(models,contains(model1,model2));
  }
  
  @Test
  public void testGetSegmentsEmptyIsNull() throws Exception {
    final List<Segment> segments = new ArrayList<>();
    List<ViewSegmentModel> models = new ArrayList<>();
    context.checking(new Expectations() {
      {
        oneOf(repository).getSegments();
        will(returnValue(segments));
      }
    });
    assertThat(bean.getSegments(),is(equalTo(models)));
    
  }

}

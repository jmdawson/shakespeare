package net.jmdawson.shakespeare.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import net.jmdawson.shakespeare.Segment;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ViewSegmentModelFactoryBeanTest {

  @Rule
  public final JUnitRuleMockery context = new JUnitRuleMockery();

  private ViewSegmentModelFactoryBean factory =
      new ViewSegmentModelFactoryBean();

  @Mock
  private Segment segment;

  @Test
  public void testGetModelSuccessfully() throws Exception {
    final int id = 5;
    final int poa = 50;
    final int lastPod = 30;

    context.checking(new Expectations() {
      {
        oneOf(segment).getId();
        will(returnValue(id));

        oneOf(segment).getLastPoa();
        will(returnValue(poa));

        oneOf(segment).getLastPod();
        will(returnValue(lastPod));
      }
    });

    ViewSegmentModel model = factory.createModel(segment);
    assertThat(model, is(not(nullValue())));
    assertThat(model.getId(), is(equalTo(id)));
    assertThat(model.getPoa(), is(equalTo(poa)));
  }

}

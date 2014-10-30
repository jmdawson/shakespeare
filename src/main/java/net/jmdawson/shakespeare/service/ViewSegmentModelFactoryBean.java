package net.jmdawson.shakespeare.service;

import javax.enterprise.context.ApplicationScoped;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Segment;

/**
 * 
 * An implementation of {@link ViewSegmentModelFactory}
 *
 * @author Jacob M. Dawson
 */
@ApplicationScoped
public class ViewSegmentModelFactoryBean implements ViewSegmentModelFactory {

  /**
   * {@inheritDoc}
   */
  @Override
  public ViewSegmentModel createModel(Segment segment) {
    ConcreteViewSegmentModel model = new ConcreteViewSegmentModel();
    model.setId(segment.getId());
    model.setPoa(segment.getLastPoa());

    int lastPodValue =
        segment.getLastPod() == null ? 0 : segment.getLastPod().getValue();
    model.setLastPod(lastPodValue);

    return model;
  }

}

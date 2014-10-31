package net.jmdawson.shakespeare.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.domain.PodReportEntity;
import net.jmdawson.shakespeare.domain.SegmentEntity;

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
    List<EditPodReportModel> pods = new ArrayList<>();

    for (PodReport pod : segment.getPods()) {
      pods.add(new ConcreteEditPodReportModel((PodReportEntity) pod));
    }
//    Set<Integer> dummyPods = new HashSet<>();
//    dummyPods
//    for (Integer pod : segment.getPods()){
//      pods.add(new ConcreteEditPodReportModel(pod));
//    }
//    pods.add(new ConcreteEditPodReportModel(50));
    Collections.sort(pods);

    return new ConcreteViewSegmentModel((SegmentEntity) segment, pods,
//        (ShakespeareUserEntity) segment.getLastUpdatedBy());
        segment.getLastUpdatedBy());
  }

}

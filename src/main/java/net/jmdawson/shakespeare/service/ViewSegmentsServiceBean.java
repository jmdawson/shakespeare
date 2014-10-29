package net.jmdawson.shakespeare.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.repository.SegmentRepository;

@Transactional
@ApplicationScoped
public class ViewSegmentsServiceBean implements ViewSegmentsService {
  
  @Inject
  protected SegmentRepository repository;
  
  @Inject
  protected ViewSegmentModelFactory factory;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<ViewSegmentModel> getSegments() {
    List<Segment> segments = repository.getSegments();
    List<ViewSegmentModel> models = new ArrayList<>();
    
    for (Segment segment : segments){
      models.add(factory.createModel(segment));
    }
   return models;
  }

}

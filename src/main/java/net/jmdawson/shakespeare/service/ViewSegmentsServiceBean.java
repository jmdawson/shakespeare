package net.jmdawson.shakespeare.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.repository.PodReportRepository;
import net.jmdawson.shakespeare.repository.SegmentRepository;

@Transactional
@ApplicationScoped
public class ViewSegmentsServiceBean implements ViewSegmentsService {

  @Inject
  protected SegmentRepository segmentRepository;
  
  @Inject
  protected PodReportRepository podReportRepository;
  
  @PersistenceContext
  protected EntityManager entityManager;

  @Inject
  protected ViewSegmentModelFactory factory;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<ViewSegmentModel> getSegments() {
    List<Segment> segments = segmentRepository.getSegments();
    List<ViewSegmentModel> models = new ArrayList<>();

    for (Segment segment : segments) {
      models.add(factory.createModel(segment));
    }
    return models;
  }

  @Override
  public void updateSegment(ViewSegmentModel model)
      throws SegmentRepositoryException {
    ConcreteViewSegmentModel concrete = (ConcreteViewSegmentModel) model;
    entityManager.merge(concrete.getEntity());
  }

}

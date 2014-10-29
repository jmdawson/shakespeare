package net.jmdawson.shakespeare.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.jmdawson.shakespeare.Segment;

/**
 * 
 * A JPA repository for segments.
 *
 * @author Jacob M. Dawson
 */
@ApplicationScoped
public class JpaSegmentRepository implements SegmentRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Segment> getSegments() {
    return entityManager.createNamedQuery("getAllSegments", Segment.class)
        .getResultList();
  }

}

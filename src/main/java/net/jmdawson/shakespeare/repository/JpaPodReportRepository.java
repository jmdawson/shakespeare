package net.jmdawson.shakespeare.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Segment;

/**
 * A JPA Repository for PoD Reports
 *
 * @author Jacob M. Dawson
 */
@ApplicationScoped
public class JpaPodReportRepository implements PodReportRepository {
  
  @PersistenceContext 
  private EntityManager entityManager;

  @Override
  public List<PodReport> getPodReportsForSegment(Segment segment) {
    return entityManager.createNamedQuery("getPodReportsForSegment", 
        PodReport.class).getResultList();
  }

}

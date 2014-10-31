package net.jmdawson.shakespeare.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import net.jmdawson.shakespeare.domain.PodReportEntity;
import net.jmdawson.shakespeare.domain.SearchEntity;
import net.jmdawson.shakespeare.domain.SegmentEntity;
import net.jmdawson.shakespeare.domain.ShakespeareUserEntity;

/**
 * 
 * A concrete implementation of {@link ViewSegmentModel}
 *
 * @author Jacob M. Dawson
 */
public class ConcreteViewSegmentModel implements ViewSegmentModel {

  private final SegmentEntity entity;
  private List<EditPodReportModel> pods = new ArrayList<>();
  private ShakespeareUserEntity user;

  private int newPod;
  
  public ConcreteViewSegmentModel(SegmentEntity entity,
      List<EditPodReportModel> pods, ShakespeareUserEntity user) {
    this.user = user;
    this.pods = pods;
    this.entity = entity;
  }

  /**
   * 
   * {@inheritDoc}
   */
  @Override
  public int getId() {
    return entity.getId();
  }

  /**
   * Set the ID of the segment;
   * @param id
   */
  public void setId(int id) {
    entity.setId(id);
  }

  /**
   * 
   * {@inheritDoc}
   */
  @Override
  public int getPoa() {
    return entity.getCurrentPoa();
  }

  /**
   * Set the POA on the segment
   * @param poa
   */
  public void setPoa(int poa) {

    entity.setCurrentPoa(poa);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getLastPod() {
    EditPodReportModel max = Collections.max(pods);
    return max.getPod();
  }

  @Override
  public void addPod() {
    PodReportEntity podEntity = new PodReportEntity();
    podEntity.setAddedBy(user);
    podEntity.setReportedDate(new Date());
//    podEntity.setSearch((SearchEntity) entity.getSearch());
    podEntity.setSegment(entity);
    podEntity.setValue(newPod);

    entity.addPod(podEntity);
    pods.add(new ConcreteEditPodReportModel (podEntity));
    Collections.sort(pods);

    newPod = 0;
  }

  public int getNewPod(){
    return newPod;
  }
  
  @Override
  public void setNewPod(int pod) {
    this.newPod = pod;
  }

  /**
   * Returns the entity
   * @return
   */
  public SegmentEntity getEntity() {
    return entity;
  }

}

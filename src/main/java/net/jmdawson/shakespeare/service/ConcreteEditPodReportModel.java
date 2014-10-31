package net.jmdawson.shakespeare.service;

import java.util.Date;

import net.jmdawson.shakespeare.domain.PodReportEntity;

public class ConcreteEditPodReportModel implements EditPodReportModel {
//  private final PodReportEntity entity;
  private final Integer pod;

//  public ConcreteEditPodReportModel(PodReportEntity podEntity) {
//    super();
//    this.entity = podEntity;
//  }
  public ConcreteEditPodReportModel(Integer pod){
    super();
    this.pod = pod;
  }

  @Override
  public int compareTo(EditPodReportModel o) {
    if (o == null) throw new NullPointerException();
    if(!(o instanceof EditPodReportModel))
      throw new ClassCastException();
    return this.getLastUpdated().compareTo(o.getLastUpdated());
  }

  @Override
  public int getPod() {
//    return entity.getValue();
    return pod;
  }

  @Override
  public Date getLastUpdated() {
//    return entity.getReportedDate();
    return new Date();
  }

  @Override
//  public ViewShakespeareUserModel getLastUpdatedBy() {
  public String getLastUpdatedBy(){
    return "dawson";
//    return new ConcreteViewShakespeareUserModel(entity.getAddedBy());
  }

}

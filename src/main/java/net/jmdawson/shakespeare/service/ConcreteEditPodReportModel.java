package net.jmdawson.shakespeare.service;

import java.util.Date;

import net.jmdawson.shakespeare.domain.PodReportEntity;

public class ConcreteEditPodReportModel implements EditPodReportModel {
  private final PodReportEntity entity;

  public ConcreteEditPodReportModel(PodReportEntity podEntity) {
    super();
    this.entity = podEntity;
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
    return entity.getValue();
  }

  @Override
  public Date getLastUpdated() {
    return entity.getReportedDate();
  }

  @Override
  public ViewShakespeareUserModel getLastUpdatedBy() {
    return new ConcreteViewShakespeareUserModel(entity.getAddedBy());
  }

}

package net.jmdawson.shakespeare.service;

public interface ViewSegmentModel {
  
  Integer getNumber();
  Integer getPoa();
  Integer getLastPod();
  
  void addPod();
  void setNewPod(int pod);

}

package net.jmdawson.shakespeare.service;

public interface ViewSegmentModel {
  
  int getId();
  int getPoa();
  int getLastPod();
  
  void addPod();
  void setNewPod(int pod);

}

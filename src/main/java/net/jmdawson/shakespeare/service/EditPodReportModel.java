package net.jmdawson.shakespeare.service;

import java.util.Date;

public interface EditPodReportModel extends Comparable<EditPodReportModel>{
  
  int getPod();
  
  Date getLastUpdated();
  
  ViewShakespeareUserModel getLastUpdatedBy();
  

}

package net.jmdawson.shakespeare;

import java.util.Date;

public interface Segment {

  int getId();

  PodReport getLastPod();
  
  Search getSearch();
  
  
  ShakespeareUser getCreatedBy();
  Date getCreatedDate();
  
  ShakespeareUser getLastUpdatedBy();
  Date getLastUpdatedDate();
  
  int getLastPoa();

}

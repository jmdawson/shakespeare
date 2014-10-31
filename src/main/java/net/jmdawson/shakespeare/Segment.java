package net.jmdawson.shakespeare;

import java.util.Date;
import java.util.Set;

public interface Segment {

  Integer getId();

//  Set<? extends PodReport> getPods();

//  Search getSearch();
String getSearch();
//  ShakespeareUser getCreatedBy();
String getCreatedBy();
  Date getCreatedDate();

//  ShakespeareUser getLastUpdatedBy();
String getLastUpdatedBy();
  
  Date getLastUpdatedDate();

  Integer getCurrentPoa();
  
  Integer getInitialPoa();
  
  /**
   * Add a PoD to the list of PoDs on this Segment
   * @param pod
   */
//  void addPod(PodReport pod);
  void addPod(Integer pod);

}

package net.jmdawson.shakespeare;

import java.util.Date;
import java.util.Set;

public interface Segment {

  int getId();

  Set<? extends PodReport> getPods();

  Search getSearch();

  ShakespeareUser getCreatedBy();

  Date getCreatedDate();

  ShakespeareUser getLastUpdatedBy();

  Date getLastUpdatedDate();

  int getCurrentPoa();
  
  int getInitialPoa();
  
  /**
   * Add a PoD to the list of PoDs on this Segment
   * @param pod
   */
  void addPod(PodReport pod);

}

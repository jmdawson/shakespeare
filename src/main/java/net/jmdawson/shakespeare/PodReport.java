package net.jmdawson.shakespeare;

import java.util.Date;

public interface PodReport {
  Integer getId();

  Segment getSegment();

//  Search getSearch();

  Date getReportedDate();

  ShakespeareUser getAddedBy();

  Integer getValue();

}

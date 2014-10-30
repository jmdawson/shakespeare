package net.jmdawson.shakespeare;

import java.util.Date;

public interface PodReport {
  int getId();

  Segment getSegment();

  Search getSearch();

  Date getReportedDate();

  ShakespeareUser getAddedBy();

  int getValue();

}

package net.jmdawson.shakespeare;

import java.util.Date;

public interface PodReport {
  int getId();

  int getValue();

  Date getReportedDate();

  ShakespeareUser getAddedBy();

  Search getSearch();

  Segment getSegment();

}

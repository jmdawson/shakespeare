package net.jmdawson.shakespeare;

import java.util.Date;

public interface Search {
  int getId();

  Date getInitiationDate();

  String getSearchNumber();

  ShakespeareUser getCreatedBy();

  Date getCreatedDate();
  
}

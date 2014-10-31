package net.jmdawson.shakespeare;

import java.util.Date;

public interface Search {
  Integer getId();

  Date getInitiationDate();

  String getSearchNumber();

  ShakespeareUser getCreatedBy();

  Date getCreatedDate();
  
}

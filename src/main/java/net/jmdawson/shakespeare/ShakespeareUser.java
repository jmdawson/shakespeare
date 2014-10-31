package net.jmdawson.shakespeare;

import java.util.Date;

public interface ShakespeareUser {
  Integer getId();

  String getCommonName();

  String getGivenName();

  String getSurname();

  Date getCreatedDate();

}

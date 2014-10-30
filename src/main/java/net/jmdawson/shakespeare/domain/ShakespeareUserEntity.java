package net.jmdawson.shakespeare.domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.jmdawson.shakespeare.ShakespeareUser;

@Entity
@Table(name = "user")
@Access(AccessType.FIELD)
public class ShakespeareUserEntity extends AbstractEntity
    implements ShakespeareUser {

  private static final long serialVersionUID = 9138075633233582114L;

  @Id
  @Column
  int id;

  @Column(name = "common_name")
  private String commonName;

  @Column(name = "given_name")
  private String givenName;

  @Column(name = "surname")
  private String surname;

  @Column(name = "created_date")
  private Date createdDate;

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String getCommonName() {
    return commonName;
  }

  public void setCommonName(String commonName) {
    this.commonName = commonName;
  }

  @Override
  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  @Override
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

}

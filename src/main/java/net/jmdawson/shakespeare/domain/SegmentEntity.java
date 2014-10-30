package net.jmdawson.shakespeare.domain;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Search;
import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.ShakespeareUser;

/**
 * An implementation of the Segment domain object
 *
 * @author Jacob M. Dawson
 */

@Entity
@Table(name="segment")
@Access(AccessType.FIELD)
public class SegmentEntity extends AbstractEntity implements Segment {
  
  private static final long serialVersionUID = -8115946629684686301L;
  
  @Id
  @Column(nullable=false)
  private int id;
  
  @Column
  @OneToMany(mappedBy="segmentNumber")
  private Set<PodReport> pods;
  
  @Column(name="last_poa")
  private int lastPoa;

  @Column(name = "search_id")
  private Search search;
  @Override
  public int getId() {
    return id;
  }
  
  public void setId(int id){
    this.id = id;
  }

  @Override
  public int getLastPoa() {
    return lastPoa;
  }
  
  public void setLastPoa(int poa){
    this.lastPoa = poa;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  
  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(!(obj instanceof SegmentEntity)) return false;
    SegmentEntity that = (SegmentEntity) obj;
    return Objects.equals(this.id, that.id);
  }

  @Override
  public PodReport getLastPod() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Search getSearch() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ShakespeareUser getCreatedBy() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Date getCreatedDate() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ShakespeareUser getLastUpdatedBy() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Date getLastUpdatedDate() {
    // TODO Auto-generated method stub
    return null;
  }

}

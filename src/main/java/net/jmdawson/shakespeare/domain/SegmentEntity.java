package net.jmdawson.shakespeare.domain;

import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.jmdawson.shakespeare.Segment;

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
  protected int id;
  
  @Column
  protected int lastPod;
  
  @Column
  protected int lastPoa;

  @Override
  public int getId() {
    return id;
  }
  
  public void setId(int id){
    this.id = id;
  }

  @Override
  public int getLastPod() {
    return lastPod;
  }
  
  public void setLastPod(int pod){
    this.lastPod = pod;
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

}

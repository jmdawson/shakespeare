package net.jmdawson.shakespeare.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.jmdawson.shakespeare.Search;
import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.ShakespeareUser;

/**
 * An implementation of the Segment domain object
 *
 * @author Jacob M. Dawson
 */

@Entity
@Table(name = "segment")
@Access(AccessType.FIELD)
public class SegmentEntity extends AbstractEntity implements Segment {

  private static final long serialVersionUID = -8115946629684686301L;

  @Id
  @Column(nullable = false)
  private int id;
  
  @Column(name = "initial_poa")
  private int initialPoa;

  @Column(name = "current_poa")
  private int currentPoa;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "segment_id")
  private Set<PodReportEntity> pods = new LinkedHashSet<>();

  @ManyToOne 
  @JoinColumn(name = "search_id")
  private Search search;

  private ShakespeareUserEntity createdBy;

  private Date createdDate;

  private ShakespeareUserEntity lastUpdatedBy;

  private Date lastUpdatedDate;

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  @Override
  public int getInitialPoa() {
    return initialPoa;
  }

  public void setInitialPoa(int poa) {
    this.initialPoa = poa;
  }

  @Override
  public int getCurrentPoa() {
    return currentPoa;
  }

  public void setLastPoa(int poa) {
    this.currentPoa = poa;
  }

  @Override
  public Set<PodReportEntity> getPods() {
    return pods;
  }

  @Override
  public Search getSearch() {
    return search;
  }

  @Override
  public ShakespeareUser getCreatedBy() {
    return createdBy;
  }

  @Override
  public Date getCreatedDate() {
    return createdDate;
  }

  @Override
  public ShakespeareUser getLastUpdatedBy() {
    return lastUpdatedBy;
  }

  @Override
  public Date getLastUpdatedDate() {
    return lastUpdatedDate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof SegmentEntity)) return false;
    SegmentEntity that = (SegmentEntity) obj;
    return Objects.equals(this.id, that.id);
  }
}

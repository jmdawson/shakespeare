package net.jmdawson.shakespeare.domain;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Search;
import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.ShakespeareUser;

/**
 * Implementation of the {@link Search} interface
 *
 * @author Jacob M. Dawson
 */

@Entity
@Table(name = "search")
@Access(AccessType.FIELD)
public class SearchEntity extends AbstractEntity implements Search {

  private static final long serialVersionUID = -1279612529231319968L;

  @Id
  @Column
  private int id;
  
  @Column (name = "initiation_date")
  private Date initiationDate;
  
  @Column (name = "search_number")
  private String searchNumber;
  
  @Column (name = "search")
  private ShakespeareUserEntity createdBy;
  
  @Column (name = "created_date")
  private Date createdDate;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "search_id")
  private Set<PodReportEntity> podReports = new LinkedHashSet<>(); 
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "search_id")
  private Set<SegmentEntity> segments = new LinkedHashSet<>();

  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public Date getInitiationDate() {
    return initiationDate;
  }

  public void setInitiationDate(Date initiationDate) {
    this.initiationDate = initiationDate;
  }

  @Override
  public String getSearchNumber() {
    return searchNumber;
  }

  public void setSearchNumber(String searchNumber) {
    this.searchNumber = searchNumber;
  }

  @Override
  public ShakespeareUser getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(ShakespeareUserEntity createdBy) {
    this.createdBy = createdBy;
  }

  @Override
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public Set<? extends PodReport> getPodReports(){
    return podReports;
  }
  
  public void setPodReports(Set<PodReportEntity> podReports){
    this.podReports = podReports;
  }
  
  public Set<? extends Segment> getSegments(){
    return segments;
  }
  
  public void setSegments(Set<SegmentEntity> segments){
    this.segments = segments;
  }

}
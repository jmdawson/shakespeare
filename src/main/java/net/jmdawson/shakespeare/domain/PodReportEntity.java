package net.jmdawson.shakespeare.domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Search;
import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.ShakespeareUser;

@Entity
@Table(name="pod_report")
@Access(AccessType.FIELD)
public class PodReportEntity implements PodReport {
  
  @Id
  @Column
  protected int id;
  
  @JoinColumn(name = "segment_id")
  @ManyToOne
  protected Segment segment;
  
  @JoinColumn(name = "search_id")
  @ManyToOne
  protected Search search;
  
  @JoinColumn(name = "added_by")
  @ManyToOne
  protected ShakespeareUser addedBy;
  
  @Column(name = "added_date")
  protected Date reportedDate;
  
  @Column(name = "pod")
  protected int value;

  @Override
  public int getId() {
    return id;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public Date getReportedDate() {
    return reportedDate;
  }

  @Override
  public ShakespeareUser getAddedBy() {
    return addedBy;
  }

  @Override
  public Search getSearch() {
    return search;
  }

  @Override
  public Segment getSegment() {
    return segment;
  }

}

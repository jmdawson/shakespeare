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
public class PodReportEntity extends AbstractEntity implements PodReport {
  
  private static final long serialVersionUID = 7822337088544034795L;

  @Id
  @Column
  protected int id;
  
  @JoinColumn(name = "segment_id")
  @ManyToOne
  private Segment segment;
  
  @JoinColumn(name = "search_id")
  @ManyToOne
  private Search search;
  
  @JoinColumn(name = "added_by")
  @ManyToOne
  private ShakespeareUser addedBy;
  
  @Column(name = "added_date")
  private Date reportedDate;
  
  @Column(name = "pod")
  private int value;

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

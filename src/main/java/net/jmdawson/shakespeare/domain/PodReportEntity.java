package net.jmdawson.shakespeare.domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Search;
import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.ShakespeareUser;

@Entity
@Table(name = "pod_report")
@Access(AccessType.FIELD)
public class PodReportEntity extends AbstractEntity
    implements PodReport {

  private static final long serialVersionUID = 7822337088544034795L;

  @Id
  @Column
  private Integer id;

  @ManyToOne (fetch = FetchType.LAZY)
  @JoinColumn(name = "segment_id")
  private SegmentEntity segment;

  @ManyToOne
  @JoinColumn(name = "search_id")
  private SearchEntity search;

  @ManyToOne
  @JoinColumn(name = "added_by")
  private ShakespeareUserEntity addedBy;

  @Column(name = "added_date")
  private Date reportedDate;

  @Column(name = "pod")
  private int value;

  @Override
  public Integer getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public Segment getSegment() {
    return segment;
  }

  public void setSegment(SegmentEntity segment) {
    this.segment = segment;
  }

  @Override
  public Search getSearch() {
    return search;
  }

  public void setSearch(SearchEntity search) {
    this.search = search;
  }

  @Override
  public ShakespeareUser getAddedBy() {
    return addedBy;
  }
  public void setAddedBy(ShakespeareUserEntity addedBy) {
    this.addedBy = addedBy;
  }

  @Override
  public Date getReportedDate() {
    return reportedDate;
  }

  public void setReportedDate(Date reportedDate) {
    this.reportedDate = reportedDate;
  }

  @Override
  public Integer getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

}

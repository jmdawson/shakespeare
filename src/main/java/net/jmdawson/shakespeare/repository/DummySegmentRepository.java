package net.jmdawson.shakespeare.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import net.jmdawson.shakespeare.Segment;
import net.jmdawson.shakespeare.domain.PodReportEntity;
import net.jmdawson.shakespeare.domain.SearchEntity;
import net.jmdawson.shakespeare.domain.SegmentEntity;

@ApplicationScoped
@Alternative
public class DummySegmentRepository implements SegmentRepository {

  @Override
  public List<Segment> getSegments() {
 List<Segment> fakeResults =  new ArrayList<Segment>();
    
    SearchEntity search = new SearchEntity();
    search.setCreatedDate(new Date());
    search.setSearchNumber("VA-000-14");
    search.setInitiationDate(new Date());
    search.setId(1);
    
    SegmentEntity segment1 = new SegmentEntity();
    segment1.setCurrentPoa(50);
    segment1.setId(1);
    segment1.setInitialPoa(45);
    segment1.setSearch(search);
    
    
    PodReportEntity pod1 = new PodReportEntity();
    pod1.setId(1);
    pod1.setReportedDate(new Date());
    pod1.setValue(40);
    pod1.setSegment(segment1);
    segment1.addPod(pod1);
    fakeResults.add(segment1);
    
    SegmentEntity segment2 = new SegmentEntity();
    segment2.setCurrentPoa(40);
    segment2.setId(2);
    segment2.setInitialPoa(50);
    segment2.setSearch(search);
    
    PodReportEntity pod2 = new PodReportEntity();
    pod2.setId(2);
    pod2.setReportedDate(new Date());
    pod2.setValue(60);
    pod2.setSegment(segment2);
    segment2.addPod(pod2);
    fakeResults.add(segment2);
    return fakeResults;
  }

}

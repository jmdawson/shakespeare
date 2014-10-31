package net.jmdawson.shakespeare.repository;

import java.util.List;

import net.jmdawson.shakespeare.PodReport;
import net.jmdawson.shakespeare.Segment;

public interface PodReportRepository {
  
  List<PodReport> getPodReportsForSegment(Segment segment);

}

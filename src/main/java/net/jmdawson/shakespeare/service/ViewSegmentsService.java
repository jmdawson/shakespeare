package net.jmdawson.shakespeare.service;

import java.util.List;

/**
 * A service to view segments and edit their pods
 *
 * @author Jacob M. Dawson
 */
public interface ViewSegmentsService {

  /**
   * Returns the list of all segments for the search
   * @return
   */
  List<ViewSegmentModel> getSegments();
  
  /**
   * Update a segment based on a model
   * @param model
   */
  void updateSegment(ViewSegmentModel model);

}

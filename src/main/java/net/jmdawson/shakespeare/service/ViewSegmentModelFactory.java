package net.jmdawson.shakespeare.service;

import net.jmdawson.shakespeare.Segment;

public interface ViewSegmentModelFactory {

  ViewSegmentModel createModel(Segment segment);

}

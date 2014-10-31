package net.jmdawson.shakespeare.web;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.jmdawson.shakespeare.service.ViewSegmentModel;
import net.jmdawson.shakespeare.service.ViewSegmentsService;

@Named
@RequestScoped
public class ViewPosBean implements Serializable {

  private static final long serialVersionUID = -4693914242994888744L;

//  @Inject
//  protected Conversation conversation;

  @Inject
  protected ViewSegmentsService service;

  private List<ViewSegmentModel> segments;

  @PostConstruct
  public void init() {
      segments = service.getSegments();
  }

  public List<ViewSegmentModel> getSegments() {
    return segments;
  }

}

package net.jmdawson.shakespeare.service;

import net.jmdawson.shakespeare.ShakespeareUser;

public class ConcreteViewShakespeareUserModel
    implements ViewShakespeareUserModel {

  public ConcreteViewShakespeareUserModel(ShakespeareUser addedBy) {
    // TODO Auto-generated constructor stub
  }

  @Override
  public String getCommonName() {
    return "Jacob M. Dawson";
  }

}

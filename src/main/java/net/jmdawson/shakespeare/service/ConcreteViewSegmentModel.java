package net.jmdawson.shakespeare.service;

/**
 * 
 * A concrete implementation of {@link ViewSegmentModel}
 *
 * @author Jacob M. Dawson
 */
public class ConcreteViewSegmentModel implements ViewSegmentModel {

  private int id;
  private int poa;
  private int lastPod;

  /**
   * 
   * {@inheritDoc}
   */
  @Override
  public int getId() {
    return id;
  }

  /**
   * Set the ID of the segment;
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Set the POA on the segment
   * @param poa
   */
  public void setPoa(int poa) {
    this.poa = poa;
  }

  /**
   * 
   * {@inheritDoc}
   */
  @Override
  public int getPoa() {
    return poa;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getLastPod() {
    return lastPod;
  }

  /**
   * Set the last-known PoD for this segment
   * @param lastPod
   */
  public void setLastPod(int lastPod) {
    this.lastPod = lastPod;
  }

}

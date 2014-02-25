package itb.ai.tubes1.entity;

/**
 * Class Orang
 */
public class Orang {

  /**
   * Strength yang dimiliki
   */
  protected int strength;

  /**
   * Charm yang dimiliki
   */
  protected int charm;

  /**
   * Brain yang dimiliki
   */
  protected int brain;

  public Orang() {
    this.strength = 0;
    this.charm = 0;
    this.brain = 0;
  }

  public Orang(final int strength, final int charm, final int brain) {
    this.strength = strength;
    this.charm = charm;
    this.brain = brain;
  }
}

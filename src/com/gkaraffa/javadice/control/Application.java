package com.gkaraffa.javadice.control;

import com.gkaraffa.javadice.ui.MasterFrame;
import com.gkaraffa.polyhedron.Results;
import com.gkaraffa.polyhedron.Roll;
import com.gkaraffa.polyhedron.Thrower;

public class Application {
  private int resAgg = 0;
  private int[] resAry = null;
  
  public static void main(String[] args) {
    Application application = new Application();
    application.startApplication();
  }
  
  public Application() {
    
  }
  
  public int getResAgg() {
    return resAgg;
  }

  public int[] getResAry() {
    return resAry;
  }

  private void startApplication() {
    MasterFrame frame = new MasterFrame(this);
    frame.setVisible(true);    
  }
  
  public void executeRoll(String sideString, String rollString) {
    Roll roll = Roll.createRoll(rollString + "d" + sideString);
    Results results = Thrower.throwRoll(roll);
  
    resAgg = results.getRollAggregate();
    resAry = results.getRollResults();
  }
}

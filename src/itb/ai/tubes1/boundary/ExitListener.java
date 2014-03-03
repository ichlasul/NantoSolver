package itb.ai.tubes1.boundary;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitListener extends WindowAdapter {
  @Override
public void windowClosing(WindowEvent event) {
    System.exit(0);
  }
}
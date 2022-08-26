package frc.team2641.peteriii.telemetry;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;

public class LogController {
  public LogController() {
  }

  public void start() {
    DataLogManager.start();
    DriverStation.startDataLog(DataLogManager.getLog());
  }
}

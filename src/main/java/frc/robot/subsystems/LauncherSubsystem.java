package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase {
    VictorSP controllerL1 = new VictorSP(1);

    
    public LauncherSubsystem(){
        
    }

    public void launcher(double launcherSpeed){

        controllerL1.set(launcherSpeed);

    }
}

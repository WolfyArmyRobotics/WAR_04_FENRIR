package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ChainSubsystem extends SubsystemBase {
    DoubleSolenoid solenoid1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 6, 7);

    public ChainSubsystem() {

    }

    public void MoveSolenoid(boolean up) {
        if (up) {
            solenoid1.set(Value.kReverse);
        } else {
            solenoid1.set(Value.kForward);
        }
    }
}

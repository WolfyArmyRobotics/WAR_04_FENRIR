package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class CollectorSubsystem extends SubsystemBase {
        
    
        // Criação de variável de controlador para sentido horário e sentido anti-horário
    VictorSP controlCollectSHSA = new VictorSP(3);


    public CollectorSubsystem () {


    }

    public void coletarNotas (double collectorSpeed){

       controlCollectSHSA.set(collectorSpeed);

    }

}



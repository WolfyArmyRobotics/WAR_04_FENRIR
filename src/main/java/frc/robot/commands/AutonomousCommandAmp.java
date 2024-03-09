package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.CollectorSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.TracaoSubsystem;


        // Esse comando será executado quando o robô iniciar a partida na posição à direita.


        // A extensão abaixo serve para o robô conseguir executar vários comandos ao mesmo tempo (ParallelRaceGroup).

public class AutonomousCommandAmp extends SequentialCommandGroup {

        // Essa é a classe que contém todo o escopo dos movimentos autônomos do robô.
    
         public AutonomousCommandAmp(TracaoSubsystem tracaoSubsystem, LauncherSubsystem launcherSubsystem, CollectorSubsystem collectorSubsystem){

        addCommands(new ParallelRaceGroup(new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(3)));
        addCommands(new ParallelRaceGroup(new CollectorCommand(collectorSubsystem, Constants.CollectorConstants.collectorSpeed), new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(2)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, 0, 0.7), new WaitCommand(1.2)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, 0.7, 0), new WaitCommand(0.7)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, 0, 0.7), new WaitCommand(2)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, 0.7, 0), new WaitCommand(0.3)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, 0, 0.7), new CollectorCommand(collectorSubsystem, Constants.CollectorConstants.collectorSpeed), new WaitCommand(0.5)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, -0.7, 0), new WaitCommand(0.3)));
        addCommands(new ParallelRaceGroup(new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(3)));
        addCommands(new ParallelRaceGroup(new CollectorCommand(collectorSubsystem, Constants.CollectorConstants.collectorSpeed), new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(2)));
    }   
}
    




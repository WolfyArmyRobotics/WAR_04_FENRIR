package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.Constants.LauncherConstants;
import frc.robot.subsystems.CollectorSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.TracaoSubsystem;


        // Esse comando será executado quando o robô iniciar a partida na posição frontal.


        // A extensão abaixo serve para o robô conseguir executar vários comandos ao mesmo tempo (ParallelRaceGroup).
public class AutonomousCommandF extends SequentialCommandGroup {
    
        // Esse é o construtor da classe, extendendo de todos os subsistemas necessários.
         public AutonomousCommandF(TracaoSubsystem tracaoSubsystem, LauncherSubsystem launcherSubsystem, CollectorSubsystem collectorSubsystem){


        // No primeiro movimento o robô ligará o Lançador por 3 segundos, logo em seguida ele liga o Coletor e mantém o Lançador ligado ao mesmo tempo, assim lançando a nota que está dentro dele. Para finalizar, ele anda para trás com o Coletor ligado por 3 segundos.
            
        addCommands(new ParallelRaceGroup(new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(3)));
        addCommands(new ParallelRaceGroup(new CollectorCommand(collectorSubsystem, Constants.CollectorConstants.collectorSpeed), new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(2)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, 0, 0.7), new CollectorCommand(collectorSubsystem, Constants.CollectorConstants.collectorSpeed), new WaitCommand(2)));
        addCommands(new ParallelRaceGroup(new AutonomousMove(tracaoSubsystem, 0, -0.7), new WaitCommand(2.5)));
        addCommands(new ParallelRaceGroup(new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(3)));
        addCommands(new ParallelRaceGroup(new CollectorCommand(collectorSubsystem, Constants.CollectorConstants.collectorSpeed), new LauncherCommand(launcherSubsystem, LauncherConstants.launcherUP), new WaitCommand(2)));
    }
}

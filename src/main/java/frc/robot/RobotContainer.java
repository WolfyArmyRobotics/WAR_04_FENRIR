
//Pseudocódigo Frente: SE O ANALOG ESTIVER APONTADO PARA FRENTE, 1 MOTOR GIRA COM VELOCIDADE 0.4 SENTIDO HORÁRIO, ENQUANTO OUTRO GIRA NO SENTIDO ANTI-HORÁRIO 0.4

//Pseudocódigo Trás: SE O ANALOG ESTIVER APONTADO PARA FRENTE, 1 MOTOR GIRA COM VELOCIDADE 0.4 SENTIDO ANTI-HORÁRIO, ENQUANTO OUTRO GIRA NO SENTIDO HORÁRIO 0.4

//Pseudocódigo Giro de Direita (Frente): SE O ANALOG ESTIVER APONTADO PARA DIREITA, 1 MOTOR GIRA COM VELOCIDADE 0.4 SENTIDO HORÁRIO, ENQUANTO OUTRO GIRA NO SENTIDO ANTI-HORÁRIO 0.1

//Pseudocódigo Giro de Esquerda (Frente): SE O ANALOG ESTIVER APONTADO PARA DIREITA, 1 MOTOR GIRA COM VELOCIDADE 0.1 SENTIDO HORÁRIO, ENQUANTO OUTRO GIRA NO SENTIDO ANTI-HORÁRIO 0.4

//Pseudocódigo Giro de Direita (Ré): SE O ANALOG ESTIVER APONTADO PARA DIREITA, 1 MOTOR GIRA COM VELOCIDADE 0.1 SENTIDO ANTI-HORÁRIO, ENQUANTO OUTRO GIRA NO SENTIDO HORÁRIO 0.4

//Pseudocódigo Giro de Esquerda (Ré): SE O ANALOG ESTIVER APONTADO PARA DIREITA, 1 MOTOR GIRA COM VELOCIDADE 0.4 SENTIDO ANTI-HORÁRIO, ENQUANTO OUTRO GIRA NO SENTIDO HORÁRIO 0.1

//RESUMO DA TRAÇÃO!!




package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutonomousCommandF;
import frc.robot.commands.AutonomousCommandSorce;
import frc.robot.commands.AutonomousCommandAmp;
import frc.robot.commands.ChainCommand;
import frc.robot.commands.CollectorCommand;
import frc.robot.commands.LauncherCommand;
import frc.robot.commands.TracaoCommand;
import frc.robot.subsystems.ChainSubsystem;
import frc.robot.subsystems.CollectorSubsystem;
import frc.robot.subsystems.LauncherSubsystem;
import frc.robot.subsystems.TracaoSubsystem;



public class RobotContainer {

  TracaoSubsystem tracaoSubsystem = new TracaoSubsystem();
  LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
  CollectorSubsystem collectorSubsystem = new CollectorSubsystem();
  ChainSubsystem chainSubsystem = new ChainSubsystem();
  XboxController controle = new XboxController(0);
  SendableChooser<Command> aChooser = new SendableChooser<>();

  public RobotContainer() {
    launcherSubsystem.setDefaultCommand(new LauncherCommand(launcherSubsystem, 0) );
    tracaoSubsystem.setDefaultCommand(new TracaoCommand(()-> controle.getLeftX(), () -> controle.getLeftY(), () -> controle.getRightTriggerAxis(), tracaoSubsystem));
    collectorSubsystem.setDefaultCommand(new CollectorCommand(collectorSubsystem, 0));
    chainSubsystem.setDefaultCommand(new ChainCommand(chainSubsystem, false));
    

    aChooser.addOption("AutonomousCommandF", new AutonomousCommandF(tracaoSubsystem, launcherSubsystem, collectorSubsystem));
    aChooser.addOption("AutonomousCommandSorce", new AutonomousCommandSorce(tracaoSubsystem, launcherSubsystem, collectorSubsystem));
    aChooser.addOption("AutonomousCommandAmp", new AutonomousCommandAmp(tracaoSubsystem, launcherSubsystem, collectorSubsystem));

    SmartDashboard.putData("Autonomous", aChooser);

    // Inicia a captura da câmera
    CameraServer.startAutomaticCapture();
    CvSink cvSink = CameraServer.getVideo(); 

    configureBindings();
  }

  private void configureBindings() {
    
    new JoystickButton(controle, 1).whileTrue(new LauncherCommand(launcherSubsystem, Constants.LauncherConstants.launcherUP));
    new JoystickButton(controle, 2).whileTrue(new LauncherCommand(launcherSubsystem, Constants.LauncherConstants.launcherDown));
    new JoystickButton(controle, 3).whileTrue(new CollectorCommand(collectorSubsystem, Constants.CollectorConstants.collectorSpeed));
    new JoystickButton(controle, 4).whileTrue(new CollectorCommand(collectorSubsystem, -Constants.CollectorConstants.collectorSpeed));
    new JoystickButton(controle, 5).whileTrue(new LauncherCommand(launcherSubsystem, -Constants.LauncherConstants.launcherUP));
    //new JoystickButton(controle, 6).whileTrue(new ChainCommand(chainSubsystem, true));
  }

  public Command getAutonomousCommand(){
    return (aChooser.getSelected());
  }
  
}


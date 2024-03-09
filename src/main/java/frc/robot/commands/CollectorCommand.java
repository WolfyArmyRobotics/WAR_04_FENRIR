package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CollectorSubsystem;

public class CollectorCommand extends Command {

    CollectorSubsystem collectorSubsystem;
    double collectorSpeed;

    public CollectorCommand (CollectorSubsystem collectorSubsystem, double collectorSpeed) {

        this.collectorSubsystem = collectorSubsystem;
        this.collectorSpeed = collectorSpeed;
        addRequirements(collectorSubsystem);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {

        collectorSubsystem.coletarNotas(collectorSpeed);

    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }

}

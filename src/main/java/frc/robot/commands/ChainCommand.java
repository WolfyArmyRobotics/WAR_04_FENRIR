package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ChainSubsystem;

public class ChainCommand extends Command {
    ChainSubsystem chainSubsystem;
    boolean up;

    public ChainCommand(ChainSubsystem chainSubsystem, boolean up) {
        this.chainSubsystem = chainSubsystem;
        this.up = up;
        addRequirements(chainSubsystem);
    }

    @Override
    public void execute() {
        chainSubsystem.MoveSolenoid(up);
    }
}

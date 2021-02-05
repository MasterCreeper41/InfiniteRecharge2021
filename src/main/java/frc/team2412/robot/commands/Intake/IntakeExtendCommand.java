package frc.team2412.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2412.robot.subsystems.IntakeSolenoidSubsystem;

public class IntakeExtendCommand extends CommandBase {
	private final IntakeSolenoidSubsystem intakeSolenoidSubsystem;

	public IntakeExtendCommand(IntakeSolenoidSubsystem intakeSolenoidSubsystem) {
		this.intakeSolenoidSubsystem = intakeSolenoidSubsystem;
	}

	public void execute() {
		intakeSolenoidSubsystem.extend();
	}

	public boolean isFinished() {
		return true;
	}
}

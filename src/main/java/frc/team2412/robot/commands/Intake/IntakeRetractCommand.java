package frc.team2412.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2412.robot.subsystems.IntakeSolenoidSubsystem;

public class IntakeRetractCommand extends CommandBase {
	private final IntakeSolenoidSubsystem intakeSolenoidSubsystem;

	public IntakeRetractCommand(IntakeSolenoidSubsystem intakeSolenoidSubsystem) {
		this.intakeSolenoidSubsystem = intakeSolenoidSubsystem;
	}

	public void execute() {
		intakeSolenoidSubsystem.retract();
	}

	public boolean isFinished() {
		return true;
	}
}

package frc.team2412.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.team2412.robot.subsystems.constants.IntakeConstants.*;

public class IntakeSolenoidSubsystem extends SubsystemBase {
	private final Solenoid intakeSolenoid;

	public IntakeSolenoidSubsystem(Solenoid intakeSolenoid) {
		this.intakeSolenoid = intakeSolenoid;
	}

	public void extend() {
		setSolenoid(INTAKE_EXTEND);
	}

	public void retract() {
		setSolenoid(INTAKE_RETRACT);
	}

	public void setSolenoid(boolean value) {
		intakeSolenoid.set(value);
	}

}

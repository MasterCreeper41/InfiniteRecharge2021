package frc.team2412.robot.Subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2412.robot.Subsystems.constants.IntakeConstants.IntakeState;
import io.github.oblarg.oblog.Loggable;
import io.github.oblarg.oblog.annotations.Config;
import io.github.oblarg.oblog.annotations.Log;

public class IntakeUpDownSubsystem extends SubsystemBase implements Loggable {

	@Log
	private DoubleSolenoid m_frontIntakeUpDown;
	@Log
	private DoubleSolenoid m_backIntakeUpDown;
	
	private IntakeState m_currentState = IntakeState.WITHDRAWN;

	public IntakeUpDownSubsystem(DoubleSolenoid frontIntakeUpDown, DoubleSolenoid backIntakeUpDown) {
		this.m_frontIntakeUpDown = frontIntakeUpDown;
		this.m_backIntakeUpDown = backIntakeUpDown;
	}

	public IntakeState getCurrentState() {
		return m_currentState;
	}

	public void frontIntakeUp() {
		setLift(IntakeState.WITHDRAWN, m_frontIntakeUpDown);
	}
	
	public void frontIntakeDown() {
		setLift(IntakeState.EXTENDED, m_frontIntakeUpDown);
	}
	
	public void backIntakeUp() {
		setLift(IntakeState.WITHDRAWN, m_backIntakeUpDown);
	}
	
	public void backIntakeDown() {
		setLift(IntakeState.EXTENDED, m_backIntakeUpDown);
	}

	@Config
	private void setLift(IntakeState newState, DoubleSolenoid doubleSolenoid) {
		m_frontIntakeUpDown.set(newState.value);
		m_currentState = newState;
	}

}

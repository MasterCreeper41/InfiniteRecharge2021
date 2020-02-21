package frc.team2412.robot.subsystems;

import static frc.team2412.robot.subsystems.constants.IndexerConstants.STOP_DISTANCE;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.team2412.robot.subsystems.constants.IndexerConstants;

public class IndexerMotorSubsystem extends SubsystemBase {

	private double frontTicks, backTicks;

	private CANEncoder m_frontEncoder, m_backEncoder;
	private CANPIDController m_frontPIDController, m_backPIDController;

	private CANSparkMax m_indexFrontMotor, m_indexMidMotor, m_indexBackMotor;
	private SpeedControllerGroup m_allMotors;
	private SpeedControllerGroup m_sideMotors;

	public IndexerMotorSubsystem(CANSparkMax frontMotor, CANSparkMax midMotor, CANSparkMax backMotor) {
		m_indexFrontMotor = frontMotor;
		m_indexMidMotor = midMotor;
		m_indexBackMotor = backMotor;

		m_frontEncoder = m_indexFrontMotor.getEncoder();
		m_frontPIDController = m_indexFrontMotor.getPIDController();
		configureMotorPID(m_frontPIDController);

		m_backEncoder = m_indexBackMotor.getEncoder();
		m_backPIDController = m_indexBackMotor.getPIDController();
		configureMotorPID(m_backPIDController);

		m_sideMotors = new SpeedControllerGroup(m_indexFrontMotor, m_indexBackMotor);
		m_allMotors = new SpeedControllerGroup(m_indexFrontMotor, m_indexMidMotor, m_indexBackMotor);

	}

	private void configureMotorPID(CANPIDController motorController) {
		motorController.setP(IndexerConstants.PID_P);
		motorController.setI(IndexerConstants.PID_I);
		motorController.setD(IndexerConstants.PID_D);
	}

	public void setFrontMotor(double val) {
		m_indexFrontMotor.set(val);
	}

	public void setMidMotor(double val) {
		m_indexMidMotor.set(val);
	}

	public void setBackMotor(double val) {
		m_indexBackMotor.set(val);
	}

	public void stopAllMotors() {
		m_allMotors.set(0);
	}

	public void stopSideMotors() {
		m_sideMotors.set(0);
	}

	public void stopFrontPID() {
		resetEncoderZero();
		if (m_indexFrontMotor.get() > 0) {
			m_frontPIDController.setReference(frontTicks + STOP_DISTANCE, ControlType.kPosition);
		} else {
			m_frontPIDController.setReference(frontTicks - STOP_DISTANCE, ControlType.kPosition);
		}
	}

	public void stopBackPID() {
		resetEncoderZero();
		if (m_indexBackMotor.get() > 0) {
			m_backPIDController.setReference(backTicks + STOP_DISTANCE, ControlType.kPosition);
		} else {
			m_backPIDController.setReference(backTicks - STOP_DISTANCE, ControlType.kPosition);
		}
	}

	public void resetEncoderZero() {
		frontTicks = m_frontEncoder.getPosition();
		backTicks = m_backEncoder.getPosition();
	}

}

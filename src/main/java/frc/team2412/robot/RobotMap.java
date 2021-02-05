package frc.team2412.robot;

import edu.wpi.first.wpilibj.Solenoid;

//This is the class in charge of all the motors, motor ids, and any other sensors the robot uses.
//remember to declare robot container at the bottom of this class
public class RobotMap {

	public static final int INTAKE_SOLENOID_PORT = 0;
	public static Solenoid intakeSolenoid = new Solenoid(INTAKE_SOLENOID_PORT);

	// Robot container
	public static RobotContainer m_robotContainer = new RobotContainer();

	// OI
	public static OI m_OI = new OI(m_robotContainer);

}

package frc.team2412.robot.subsystems;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import com.robototes.helpers.MockHardwareExtension;
import com.robototes.helpers.TestBase;
import com.robototes.helpers.TestWithScheduler;

import edu.wpi.first.wpilibj.Solenoid;
import frc.team2412.robot.commands.Intake.IntakeExtendCommand;
import frc.team2412.robot.commands.Intake.IntakeRetractCommand;
import frc.team2412.robot.subsystems.constants.IntakeConstants;

public class IntakeSolenoidSubsystemTest extends TestBase {
	private IntakeSolenoidSubsystem intakeSolenoidSubsystem;
	private Solenoid intakeSolenoid;

	@Before
	public void before() {
		TestWithScheduler.schedulerStart();
		TestWithScheduler.schedulerClear();
		MockHardwareExtension.beforeAll();

		intakeSolenoid = mock(Solenoid.class);
		intakeSolenoidSubsystem = new IntakeSolenoidSubsystem(intakeSolenoid);
	}

	@Test
	public void IntakeExtendCommandTest() {
		test(new IntakeExtendCommand(intakeSolenoidSubsystem), intakeSolenoid, IntakeConstants.INTAKE_EXTEND);

	}

	@Test
	public void IntakeRetractCommandTest() {
		test(new IntakeRetractCommand(intakeSolenoidSubsystem), intakeSolenoid, IntakeConstants.INTAKE_RETRACT);

	}

}

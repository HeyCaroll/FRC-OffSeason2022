// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final DifferentialDrive m_robotDrive =
      new DifferentialDrive(new PWMVictorSPX(0), new PWMVictorSPX(1));
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();

/**
 Esta função é executada quando o robô é iniciado pela primeira vez e deve ser usado para qualquer código de inicialização.
*/
  @Override
  public void robotInit() {}
/** Esta função é executada uma vez que o robô entra no modo autônomo. */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }
/** Esta função é chamada periodicamente durante a autonomia. */
  @Override
  public void autonomousPeriodic() {
/**  Dirija por 2 segundos */
    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); //dirigir para a frente na metade da velocidade
    } else {
      m_robotDrive.stopMotor(); // para o robo
    }
  }

  /** Esta função é chamada uma vez que o robô entra no modo manual. */
  @Override
  public void teleopInit() {}

  /** Esta função é chamada periodicamente durante o modo manual. */
  @Override
  public void teleopPeriodic() {
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
  }

  /** Esta função é chamada uma vez que o robô entra no modo de teste. */
  @Override
  public void testInit() {}

  /** Esta função é chamada periodicamente durante o modo de teste. */
  @Override
  public void testPeriodic() {}
}

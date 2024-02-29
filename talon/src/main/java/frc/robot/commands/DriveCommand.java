// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsytem;

public class DriveCommand extends Command {
  private DriveSubsytem train;
  private Joystick joy;
  /** Creates a new Joydrive. */
  public DriveCommand(DriveSubsytem train, Joystick joy) {
    addRequirements(train);

    this.train = train;
    this.joy = joy;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public Command setSpeedCommand(double speed){
    return run(() -> setSpeed(speed));
  }

  public void setSpeed(double speed){
    Constants.kDrivetrain.kspeedlimitConstant = speed;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    train.drive(joy.getRawAxis(0),joy.getRawAxis(2));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    train.drive(0 * Constants.kDrivetrain.kspeedlimitConstant, 0 * Constants.kDrivetrain.kspeedlimitConstant);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveSubsytem;

public class RobotContainer {
  
 

  private final Joystick stick = new Joystick(0);
  private final DriveSubsytem train = new DriveSubsytem();

  private JoystickButton slowDriveButton = new JoystickButton(stick, Constants.OperatorConstants.kSlowDriveButton);

  public RobotContainer() {

    CommandScheduler.getInstance().setDefaultCommand(train, new DriveCommand(train, stick));
   
    configureBindings();
    
  }

  private void configureBindings() {

    slowDriveButton.whileTrue(train.setSpeedCommand(0.5));
   
  }

}

package org.usfirst.frc.team2813.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    public Encoder arms_encoder;

	public class Arms extends PIDSubsystem {
    	public final Encoder encoder;
    	public final VictorSP motor;
    	public Arms(double Kp, double Ki, double Kd) {
    		super(Kp, Ki, Kd);
    		encoder=Shooter.this.arms_encoder;
    		motor=Shooter.this.arms;
    	}

		@Override
		protected double returnPIDInput() {
			// TODO Auto-generated method stub
			return encoder.pidGet();
		}

		@Override
		protected void usePIDOutput(double output) {
			// TODO Auto-generated method stub
			motor.pidWrite(output);
		}

		@Override
		protected void initDefaultCommand() {
			// TODO Auto-generated method stub
			
		}
    }
	public Arms arms_subsystem;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	VictorSP arms;
	VictorSP wheels;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public Shooter() {
    	arms=new VictorSP(4); // !!!!!! PLACEHOLDER
    	wheels=new VictorSP(5); // !!!!!!! PLACEHOLDER
    	arms_subsystem=this.new Arms(0, 0, 0);
    	arms_encoder=new Encoder(0, 0);
    }
    
}


package frc.robot.subsystems;

import static frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.WPI_CANCoder;

import static com.ctre.phoenix.motorcontrol.TalonFXControlMode.*;
import static com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice.*;

public class SwerveModule {
    
    private WPI_TalonFX drive;
    private WPI_TalonFX steer;
    private WPI_CANCoder encoder;

    private double steer_offset;

    private double pid_prime_cum_error = 0;
    private double pid_prime_prev_error = 0;
    private long time = 0;
    
    public SwerveModule(int drive_ID, int steer_ID, int encoder_ID, double steer_offset) {
        this.steer_offset = steer_offset;

        drive = new WPI_TalonFX(drive_ID);
        drive.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, kDriveCurrentLimitContinuous, kDriveCurrentLimitPeak, kDriveCurrentLimitTime));

        steer = new WPI_TalonFX(steer_ID);
        steer.configStatorCurrentLimit(new StatorCurrentLimitConfiguration(true, kDriveCurrentLimitContinuous, kDriveCurrentLimitPeak, kDriveCurrentLimitTime));
    
        drive.configFactoryDefault();
        drive.configSelectedFeedbackSensor(IntegratedSensor, kPIDLoopIdx, kTimeoutMs);
        drive.config_kF(kPIDLoopIdx, kSwerveDrive_K, kTimeoutMs);
        drive.config_kP(kPIDLoopIdx, kSwerveDrive_P, kTimeoutMs);
        drive.config_kI(kPIDLoopIdx, kSwerveDrive_I, kTimeoutMs);
        drive.config_kD(kPIDLoopIdx, kSwerveDrive_D, kTimeoutMs);

        steer.configFactoryDefault();
        steer.configSelectedFeedbackSensor(IntegratedSensor, kPIDLoopIdx, kTimeoutMs);
        steer.config_kF(kPIDLoopIdx, kSwerveSteer_K, kTimeoutMs);
        steer.config_kP(kPIDLoopIdx, kSwerveSteer_P, kTimeoutMs);
        steer.config_kI(kPIDLoopIdx, kSwerveSteer_I, kTimeoutMs);
        steer.config_kD(kPIDLoopIdx, kSwerveSteer_D, kTimeoutMs);

        encoder = new WPI_CANCoder(encoder_ID);
    }

    public void reset_prime_pid() {
        pid_prime_cum_error = 0;
    }

    private double get_offset(double a, double b) {
        double delta = b - a;
        if(delta < -180) {
            delta = 360 + delta;
        }
        if(delta > 180) {
            delta = -360 + delta;
        }
        return delta;
    }

    private double get_module_angle() {
        return encoder.getAbsolutePosition();
    }

    //Warning: Untested as of now
    private double calculate_steer_velocity(double target) {
        long new_time = System.currentTimeMillis();
        double result = kSwerveSteerPrime_K;                                    //K/F
        double offset = get_offset(get_module_angle() - steer_offset, target);  
        result += kSwerveSteerPrime_P * offset;                                 //P
        if(time != 0) {
            result += kSwerveSteerPrime_I * pid_prime_cum_error;                //I
            double dt = ((double) new_time) * 0.001;
            pid_prime_cum_error *= 0.99;//Make integral term die out. TODO: Make not depedant on update rate
            pid_prime_cum_error += offset * dt;
        }
        if(time != 0) {
            double d = offset - pid_prime_prev_error;
            result += d * kSwerveSteerPrime_D;                                  //D
            pid_prime_prev_error = offset;
        }
        time = new_time;
        return result;
    }

    public void update(double target_velocity, double target_steer) {
        double target_steer_velocity = calculate_steer_velocity(target_steer);

        steer.set(Velocity, target_steer_velocity);
        drive.set(Velocity, target_velocity);
    }
}

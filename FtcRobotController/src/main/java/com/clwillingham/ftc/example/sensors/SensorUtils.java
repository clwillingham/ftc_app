package com.clwillingham.ftc.example.sensors;

import android.hardware.SensorManager;

/**
 * Created by Chris Willingham on 10/3/2015.
 */
public class SensorUtils {
    public static float[] rotationVectorToOrientation(float[] rotationVector){
        float[] mRotationMatrix = new float[9];
        float[] orientationVals = new float[3];
        SensorManager.getRotationMatrixFromVector(mRotationMatrix, rotationVector);
        SensorManager
                .remapCoordinateSystem(mRotationMatrix,
                        SensorManager.AXIS_X, SensorManager.AXIS_Z,
                        mRotationMatrix);
        SensorManager.getOrientation(mRotationMatrix, orientationVals);

        // Optionally convert the result from radians to degrees
        orientationVals[0] = (float) Math.toDegrees(orientationVals[0]);
        orientationVals[1] = (float) Math.toDegrees(orientationVals[1]);
        orientationVals[2] = (float) Math.toDegrees(orientationVals[2]);
        return orientationVals;
    }
}

package model;

import org.junit.Test;
import java.io.*;


public class CelestialBodyTest extends DataReader{
    Vector3D position = new Vector3D(1, 2, 3);
    Vector3D velocity = new Vector3D(2, 2, 2);
    Vector3D acceleration = new Vector3D(3, 3, 3);;
    double timeStep = 1;
    public static final String DIR_EARTH = "Data/Planets/Earth.txt";

    @Test
    public void testTimeStep() throws Exception {
        CoordSet earthData = DataReader.lineReader(new File(DIR_EARTH));
        double julianTime = earthData.getJulianTime();
        CelestialBody Earth = new CelestialBody("Earth", julianTime, position, velocity);
        julianTime += timeStep;
        Vector3D position = Earth.getPosition().add(Earth.getVelocity().ska(timeStep));
        Vector3D velocity = Earth.getVelocity().add(acceleration.ska(timeStep));
        CelestialBody newEarth = new CelestialBody("Earth", julianTime, position, velocity);

        org.junit.Assert.assertFalse("Lig med hinanden", Earth.getJulianTime() == newEarth.getJulianTime());
        org.junit.Assert.assertFalse("Lig med hinanden", Earth.getVelocity() == newEarth.getVelocity());
    }

    @Test
    public void testCalculateAcceleration() throws Exception {
        CoordSet earthData = DataReader.lineReader(new File(DIR_EARTH));
        double julianTime = earthData.getJulianTime();
        CelestialBody Earth = new CelestialBody("Earth", julianTime, position, velocity);
        julianTime += timeStep;
        Vector3D position = Earth.getPosition().add(Earth.getVelocity().ska(timeStep));
        Vector3D velocity = Earth.getVelocity().add(acceleration.ska(timeStep));
        CelestialBody newEarth = new CelestialBody("Earth", julianTime, position, velocity);

        org.junit.Assert.assertFalse("Lig med hinanden", Earth.getVelocity() == newEarth.getVelocity());


    }

    @Test
    public void testGetDescription() throws Exception {
        CoordSet earthData = DataReader.lineReader(new File(DIR_EARTH));
        double julianTime = earthData.getJulianTime();
        CelestialBody Earth = new CelestialBody("Earth", julianTime, position, velocity);
        org.junit.Assert.assertSame(Earth.getDescription(), "Earth");
    }
}
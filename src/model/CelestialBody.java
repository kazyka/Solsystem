package model;


/**
 * Celestial Body represents a object in space
 */
public class CelestialBody extends CoordSet {

    public final static double GM_SUN = 0.0002959122082322128;
    private String description;

    public CelestialBody(String description, double julianTime, Vector3D position, Vector3D velocity){
        super(julianTime, position, velocity);
        this.description = description;
    }

    /**
     * Calculates a single step in the simulation
     * @param julianTime length of the step in time (Delta t)
     * @param sun we need to calculated the acceleration based on the suns gravity
     */
    public void timeStep(double julianTime, CelestialBody sun){
        Vector3D acceleration = calculateAcceleration(sun);
        Vector3D position = getPosition().add(getVelocity().ska(julianTime));
        setPosition(position);
        Vector3D velocity = getVelocity().add(acceleration.ska(julianTime));
        setVelocity(velocity);
        setJulianTime(getJulianTime() + julianTime);
    }

    /**
     *
     * @param sun we need to calculated the acceleration based on the suns gravity
     * @return acceleration vector
     */
    public Vector3D calculateAcceleration(CelestialBody sun){
        Vector3D positionToSun = getPosition().sub(sun.getPosition());
        double r = Math.sqrt(positionToSun.getX() * positionToSun.getX() + positionToSun.getY() * positionToSun.getY()
                + positionToSun.getZ() * positionToSun.getZ());
        double s = - GM_SUN / (r * r * r);
        return positionToSun.mul(s);
    }
    
    public String getDescription(){
    	return description;
    }

    public String toString(){
        return description + "\n" + super.toString()  + "\n";
    }
}

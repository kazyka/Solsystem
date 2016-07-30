package model;

/**
 * Shows a representable date format
 */
public class CoordSet {

    private double julianTime;
    private  Vector3D position;
    private  Vector3D velocity;

    public CoordSet(double julianTime, Vector3D position, Vector3D velocity) {
        this.julianTime = julianTime;
        this.position = position;
        this.velocity = velocity;
    }

    public double getJulianTime() {
        return julianTime;
    }

    public Vector3D getPosition() {
        return position;
    }

    public Vector3D getVelocity() {
        return velocity;
    }

    public void setJulianTime(double julianTime) {
        this.julianTime = julianTime;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }

    public void setVelocity(Vector3D velocity) {
        this.velocity = velocity;
    }

    public String toString(){
        return getJulianTime() + "; \n" + getPosition() + "; \n" + getVelocity();
    }
}

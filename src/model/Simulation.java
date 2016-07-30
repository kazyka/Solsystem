package model;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class checks the selected Julian date and checks when we reach the destination to end the simulation
 * with a constructor with all the needed information
 */
public class Simulation {
    private double timeStep;
    private ArrayList<CelestialBody> planets;
    private CelestialBody sun;
    private double endJulianDate;
    private double currentDate;

    public Simulation(double timeStep, ArrayList<CelestialBody> planets, CelestialBody sun, double endJulianDate) {
        this.timeStep = timeStep;
        this.planets = planets;
        this.sun = sun;
        this.endJulianDate = endJulianDate;
        currentDate = sun.getJulianTime();
    }

    public double getTimeStep() {
        return timeStep;
    }

    public ArrayList<CelestialBody> getPlanets() {
        return planets;
    }

    public CelestialBody getSun() {
        return sun;
    }

    /**
     * For every step adds an additional step
     */
    public void simulateStep(){
    	if(isFinished()) return;
    	
        for(CelestialBody planet : planets){
            planet.timeStep(timeStep, sun);
        }
        currentDate += timeStep;
    }
    
    public double getEndDate(){
    	return endJulianDate;
    }
    
    public boolean isFinished(){
    	return currentDate>=endJulianDate;
    }
    
    public ResultSet getResults() throws IOException{
    	while(!isFinished()) simulateStep();
    	return new ResultSet(this);
    }
}

package controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import model.CelestialBody;
import model.CoordSet;
import model.DataReader;
import model.ResultSet;
import model.Simulation;

/**
 * Responsible for the entire simulation
 */
public class SimulationController {
	
	
	public static final String DIR_PLANETS = "Data/Planets/";
	public static final String PATH_SUN = "Data/Sun.txt";
	
    private Simulation simulation;

    public void loadSimulation(double timeStep, double endJulianDate) throws IOException{
        ArrayList<CelestialBody> planets = DataReader.loadPlanets(DIR_PLANETS);
        CoordSet sunData = DataReader.lineReader(new File(PATH_SUN));
        CelestialBody sun = new CelestialBody("Sun", sunData.getJulianTime(), sunData.getPosition(), sunData.getVelocity());
        simulation = new Simulation(timeStep, planets, sun, endJulianDate);
    }

    public void simulateStep(){
        simulation.simulateStep();
    }

    public void simulateStep(int n){
        for(int i = 0; i <= n; i++){
            simulateStep();
        }
    }

    public ArrayList<CelestialBody> getPlanets(){
        return simulation.getPlanets();
    }
    
    public CelestialBody getSun(){
    	return simulation.getSun();
    }
    
    public Double[] getJulianDates() throws IOException{
    	
    	ArrayList<CoordSet> data = DataReader.readFile(new File(PATH_SUN));
    	ArrayList<Double> dates = new ArrayList<Double>();
    	for(CoordSet d : data){
    		dates.add(d.getJulianTime());
    	}
    	
    	return dates.toArray(new Double[dates.size()]);
    }

    public ResultSet getResultSet() throws IOException{
    	
    	return simulation.getResults();
    }
}

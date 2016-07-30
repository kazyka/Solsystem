package model;

import java.io.File;
import java.io.IOException;

import controller.SimulationController;

/**
 * Contains a set of result of a simulation
 */
public class ResultSet {

	
	private double julianTime;
	
	private Result[] results;

	/**
	 * Is a constructor builds a resultSet of the simulation
	 * @param simulation takes a simulation
	 * @throws IOException
	 */
	public ResultSet(Simulation simulation) throws IOException{

		
		julianTime = simulation.getEndDate();
		
		results = new Result[simulation.getPlanets().size()];
		for(int i=0; i<results.length; i++){
			
			CelestialBody planet = simulation.getPlanets().get(i);
			CoordSet expected = DataReader.loadByTime(new File(SimulationController.DIR_PLANETS+planet.getDescription()+".txt"), julianTime);
			results[i] = new Result(planet, expected);
			
		}
	
	}
	
	public double getJulianTime(){
		return julianTime;
	}
	
	public Result[] getResults(){
		return results;
	}

}

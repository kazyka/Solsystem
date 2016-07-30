package model;

/**
 * Calculates the euclidean Distance for the distance between the simulated and observed planet
 */
public class Result {
	
	private String description;
	private Vector3D actualResult;
	private Vector3D expectedResult;
	private double euclideanDistance;
	
	public Result(CelestialBody result, CoordSet expectedResult){
		actualResult = result.getPosition();
		description = result.getDescription();
		this.expectedResult = expectedResult.getPosition();
		
		Vector3D d = actualResult.sub(this.expectedResult);
		euclideanDistance = Math.sqrt(d.getX()*d.getX() + d.getY()*d.getY() + d.getZ()*d.getZ());
		
	}
	
	public Vector3D getActualResult(){
		return actualResult;
	}
	
	public Vector3D getExpectedResult(){
		return expectedResult;
	}

	public String getDescription(){
		return description;
	}
	
	public double getEuclideanDistance(){
		return euclideanDistance;
	}
}

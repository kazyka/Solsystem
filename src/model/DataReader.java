package model;
import java.io.*;
import java.util.ArrayList;


/**
 * Responsible to read and parses the JPL Ephemeris data
 */
public class DataReader {

    /**
     * Gets a directory and takes the names of the files for later use.
     * @param path the desired dictionary
     * @return list of Celestialbodies from the files
     * @throws IOException
     */
    public static ArrayList<CelestialBody> loadPlanets(String path) throws IOException{
        File directory = new File(path);
        File[] files = directory.listFiles();
        ArrayList<CelestialBody> result = new ArrayList<CelestialBody>();
        for(File f : files){
            String name = (f.getName().split(".txt")[0]);
            CoordSet data = lineReader(f);
            CelestialBody body = new CelestialBody(name, data.getJulianTime(), data.getPosition(), data.getVelocity());
            result.add(body);
        }
        return result;
    }

    /**
     * Parses the first line of a desired file
     * @param fileToRead the desired file you wish to parse
     * @return a coordset
     * @throws IOException
     */
    public static CoordSet lineReader(File fileToRead) throws IOException{

        FileReader fr = new FileReader(fileToRead);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        String [] temp = line.split(",");
        double julianTime = Double.parseDouble(temp[0]);
        Vector3D position = new Vector3D(Double.parseDouble(temp[2]), Double.parseDouble(temp[3]),
                Double.parseDouble(temp[4]));
        Vector3D velocity = new Vector3D(Double.parseDouble(temp[5]), Double.parseDouble(temp[6]),
                Double.parseDouble(temp[7]));
        br.close();
        return new CoordSet(julianTime, position, velocity);
    }

    /**
     *
     * @param fileToRead the desired file you wish to parse
     * @param queryTime reads the line with a specific julianDate
     * @return the desired coordSet with the specific Julian Date
     * @throws IOException
     */
    public static CoordSet loadByTime(File fileToRead, double queryTime) throws IOException{
    
    	 FileReader fr = new FileReader(fileToRead);
    	 
         BufferedReader br = new BufferedReader(fr);
     	
         while(br.ready()){
        	 String line = br.readLine();
        	 
             String [] temp = line.split(",");
             double julianTime = Double.parseDouble(temp[0]);
    
             if(julianTime==queryTime){
            	  Vector3D position = new Vector3D(Double.parseDouble(temp[2]), Double.parseDouble(temp[3]),
                          Double.parseDouble(temp[4]));
                  Vector3D velocity = new Vector3D(Double.parseDouble(temp[5]), Double.parseDouble(temp[6]),
                          Double.parseDouble(temp[7]));
                  br.close();
                  return new CoordSet(julianTime, position, velocity);
             }
           
         }
         br.close();
         return null;
         
    }

    /**
     * Parse a entire file
     * @param fileToRead the desired file you wish to parse
     * @return the entire file
     * @throws IOException
     */
    public static ArrayList<CoordSet> readFile(File fileToRead) throws IOException{
        FileReader fr = new FileReader(fileToRead);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<CoordSet> result = new ArrayList<CoordSet>();

        while (br.ready()){
            String line = br.readLine();
            String [] temp = line.split(",");
            double julianTime = Double.parseDouble(temp[0]);
            Vector3D position = new Vector3D(Double.parseDouble(temp[2]), Double.parseDouble(temp[3]),
                    Double.parseDouble(temp[4]));
            Vector3D velocity = new Vector3D(Double.parseDouble(temp[5]), Double.parseDouble(temp[6]),
                    Double.parseDouble(temp[7]));
            result.add(new CoordSet(julianTime, position, velocity));
        }
        br.close();
        return result;
    }
}

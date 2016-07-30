import controller.SimulationController;
import view.ConfigurationFrame;


public class Main {


    public static void main(String[] args) throws Exception{

        new ConfigurationFrame(new SimulationController());
    }
}

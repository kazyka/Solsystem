package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import controller.SimulationController;
import model.CelestialBody;
import model.Vector3D;

/**
 * SimulationFrame visualizes the simulation
 */
public class SimulationFrame extends JFrame{
	
	private final SimulationController controller;
	
	public static final int ORIGIN_X = 400;
	public static final int ORIGIN_Y = 400;
	
	public static final int BODY_SIZE = 7;
	public static final int SUN_SIZE = 20;
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	
	public static final int SCALE = 40;
	
	private Color[] planetColors;

	/**
	 *
	 * @param simulationController
	 * @param simulationSpeed tries to speed the simulation up - TAKE CARE IF HIGH VALUE YOU NEED A GOOD PC
	 */
	public SimulationFrame(SimulationController simulationController, double simulationSpeed) {
		setSize(WIDTH, HEIGHT);
		
		planetColors = new Color[] {Color.BLUE, new Color(232, 231, 118), Color.RED, new Color(232, 178, 59), new Color(59, 232, 219), 
				new Color(232, 178, 59), new Color(236, 140, 136), new Color(146, 238, 245), Color.YELLOW};
		
		this.controller=simulationController;
		final int delayMS =  (int) ((1/simulationSpeed)*1000);

		setVisible(true);

		Timer t = new Timer(delayMS, new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				controller.simulateStep();
				paintComponent(getGraphics());
			}
		});
		t.start();
	}
	
	public void paintComponent(Graphics g){

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		CelestialBody sun = controller.getSun();

		g.setColor(Color.ORANGE);
		g.fillOval(ORIGIN_X-SUN_SIZE/2, ORIGIN_Y-(SUN_SIZE/2), SUN_SIZE, SUN_SIZE);
		
		for(int i=0; i<controller.getPlanets().size(); i++){
			g.setColor(planetColors[i]);
			CelestialBody planet = controller.getPlanets().get(i);
			Vector3D position = planet.getPosition().sub(sun.getPosition());
			int x = (int) (position.getX() * SCALE) + ORIGIN_X;
			int y = (int) (position.getY() * SCALE) + ORIGIN_Y;
			
			g.fillOval(x, y, BODY_SIZE, BODY_SIZE);
		}
		
	}
	
	
	

}

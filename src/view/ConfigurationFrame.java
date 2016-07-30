package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.SimulationController;
import model.ResultSet;

/**
 * Main frame with basic ways to setup the simulation
 */
public class ConfigurationFrame extends JFrame{

	private JTextField tfStepLength;
	private JTextField tfSimulationSpeed;
	private JComboBox cbSelectDate;
	
	public ConfigurationFrame(final SimulationController controller) {
		
		setSize(200, 300);
	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Awesome simulation");
		getContentPane().setLayout(null);
		
		JLabel lblStepLength = new JLabel("Step length (days)");
		lblStepLength.setBounds(10, 122, 112, 14);
		getContentPane().add(lblStepLength);
		
		tfStepLength = new JTextField("1");
		tfStepLength.setBounds(10, 135, 100, 20);
		getContentPane().add(tfStepLength);
		
		JLabel lblSimulationSpeed = new JLabel("Simulation speed (steps/second)");
		lblSimulationSpeed.setBounds(10, 60, 200, 20);
		getContentPane().add(lblSimulationSpeed);
		
		
		tfSimulationSpeed = new JTextField("1");
		tfSimulationSpeed.setBounds(10, 80, 100, 20);;
		getContentPane().add(tfSimulationSpeed);
		
		JButton btnSimulate = new JButton("Start simulation");
		btnSimulate.setBounds(10, 174, 112, 23);
		getContentPane().add(btnSimulate);
		
		JLabel lblSelectDate = new JLabel("Select time of end (Julian time)");
		lblSelectDate.setBounds(10, 10, 200, 20);
		getContentPane().add(lblSelectDate);
		try {
			Double[] dates = controller.getJulianDates();
			
			DateCombo[] dateCombos = new DateCombo[dates.length];
			for(int i=0; i<dates.length; i++){
				dateCombos[i] = new DateCombo(dates[i]);
			}
			cbSelectDate = new JComboBox<DateCombo>(dateCombos);
			cbSelectDate.setBounds(10, 30, 100, 20);
			getContentPane().add(cbSelectDate);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		btnSimulate.addActionListener(new ActionListener(){
			/**
			 * Begins a new simulation based on the configuration set by the user
			 * @param event
			 */
			public void actionPerformed(ActionEvent event) {
				try {
					controller.loadSimulation(Double.parseDouble(tfStepLength.getText()), ((DateCombo) cbSelectDate.getSelectedItem()).getValue());
					ResultSet results = controller.getResultSet();
					new ResultFrame(results);
					
					controller.loadSimulation(Double.parseDouble(tfStepLength.getText()), ((DateCombo) cbSelectDate.getSelectedItem()).getValue());
					new SimulationFrame(controller, Double.parseDouble(tfSimulationSpeed.getText()));
					
				} catch (Exception e){
				}
			}
			
		});
		
		setVisible(true);
	}
}

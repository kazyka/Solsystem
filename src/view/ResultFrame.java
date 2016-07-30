package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.JulianToGregorian;
import model.Result;
import model.ResultSet;


/**
 * Represents the table that shows the expected and simulated values
 */
public class ResultFrame extends JFrame{
	
	
	
	public ResultFrame(ResultSet resultSet){
		setSize(800, 230);
		setTitle(JulianToGregorian.convert(resultSet.getJulianTime()));
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Result[] results = resultSet.getResults();
		String[] columnNames = {"Planet", "Expected Result in AU", "Actual Result in AU", "Difference in AU"};
		Object[][] data = new Object[results.length][4];
		for(int i=0; i<data.length; i++){
			data[i][0] = results[i].getDescription();
			data[i][1] = results[i].getExpectedResult();
			data[i][2] = results[i].getActualResult();
			data[i][3] = results[i].getEuclideanDistance();
			
		}
		
		JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		
		
		getContentPane().add(new JScrollPane(table));
	
		setVisible(true);
	}
}

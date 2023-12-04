package LAB8;



///--04-12-2023
 import javax.management.loading.PrivateClassLoader;
//write a java program that uses two text files and a button. 
//The first text accepts the temperature in celsius . When the 'convert button is clicked  
//the second text field displays the temperature in farenheit . Use appropriate Swing components and event handling techniques 
//f= (c+9/5+32)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class java extends JFrame implements ActionListener{
	private JTextField celsiusTextField;
	private JTextField farenheitTextField;
	java() {
	 setTitle(" Temperature converter");
	 setSize(300,159);             //-----------------frame size setting
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 //Creating JPanel
	 JPanel panel = new JPanel();
	 panel.setLayout(new GridLayout(3,2));
	 // Create and add components
	 JLabel celsiuslabel =new JLabel("celcius");
	 celsiusTextField = new JTextField();
	 JLabel farenlabel = new JLabel("Farenheit");
	 farenheitTextField = new JTextField();
	 farenheitTextField.setEditable(false); //---------- disable typing on farenheit
	 
	 //-------------creating convert button 
	 JButton convertbutton = new JButton("convert");
	 //-------------Registering  the button->actionbutton
	 convertbutton.addActionListener(this);
     
	 panel.add(celsiuslabel);
	 panel.add(celsiusTextField);
	 panel.add(farenlabel);
	 panel.add(farenheitTextField);
	 panel.add(convertbutton);
	 add (panel);
	 
	 }
	public static void main (String []args) {
		// ----creating object 
		java convertor = new java();
		convertor.setVisible(true);
	}
		public void actionPerformed(ActionEvent E) {
			//
			double celcius =Double.parseDouble( celsiusTextField.getText());
			Double farenheit=((celcius*9/5)+32);
			farenheitTextField.setText(String.format("%.2f",farenheit));
			
			
			
			
		}
	}



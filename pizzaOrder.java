package main;
/*
 * Year 2 
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class pizzaOrder extends JFrame {
	 JFrame frame = new JFrame("Pizza order");
	 JTextArea text = new JTextArea();
	 JMenuBar a = new JMenuBar();
	 JMenu users = new JMenu("User");
	 JMenu ingredients = new JMenu ("Ingredients");
	 JMenu chilli = new JMenu("Chilli Level");
	 JMenu orders = new JMenu("Orders");
	 ButtonGroup allGroup = new ButtonGroup();
	 
	


//MAIN METHOD
		public static void main(String[] args) {
			new pizzaOrder();
		}
		
public pizzaOrder() {

	//SETTING VISIBILITY TO TURE 
	frame.setVisible(true);
	
	//SETTNG THE DEFAULT CLOSE OPERATION
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//USERS FUNCTION
	JMenuItem login = new JMenuItem("Login");
	login.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
	login.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method 
			int result;
			
			JLabel userL = new JLabel("User:");
			JLabel passL = new JLabel("Password:");
			JTextField field = new JTextField();
			JPasswordField pass = new JPasswordField();
			String massage =( "Please enter your username and password");
			
			result = JOptionPane.showOptionDialog(frame, new Object[] { massage , userL, passL,field, pass}, "Login" ,
					JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
			if (result == JOptionPane.YES_OPTION){
				text.append( " \n Welcome! \n" + ""+ field.getText() + " has logged in with a password length of :" + pass.getPassword().length);
				
			}
			else
			{
				text.append("\n The login was cancelled by the user. \n");
			}
			
			
		}
		
		
	});
	JMenuItem logout = new JMenuItem("Logout");
	logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.SHIFT_DOWN_MASK));
	logout.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?");
			switch(result) {
			case JOptionPane.YES_OPTION:
					System.exit(0);break;
			case JOptionPane.CLOSED_OPTION:
					text.append("\n The login was cancelled by the user \n");break;
			}
		}
		
	});
	
	//adding to menu user
	users.add(login);
	users.add(logout);
	
	//INGREDIENTS FUNCTION#
	
	JCheckBoxMenuItem tomato = new JCheckBoxMenuItem ("Tomato sauce");
	JCheckBoxMenuItem cheese = new JCheckBoxMenuItem ("Cheese");
	JCheckBoxMenuItem pine = new JCheckBoxMenuItem ("Pineapple");
	JCheckBoxMenuItem olive = new JCheckBoxMenuItem ("Olives");
	JCheckBoxMenuItem mush = new JCheckBoxMenuItem ("Mushrooms");
	JCheckBoxMenuItem on = new JCheckBoxMenuItem ("Onions");
	JCheckBoxMenuItem pork = new JCheckBoxMenuItem ("Pork Meatballs");
	JCheckBoxMenuItem pep = new JCheckBoxMenuItem ("Pepperoni");
	JCheckBoxMenuItem ham = new JCheckBoxMenuItem ("Ham");
	JCheckBoxMenuItem bacon = new JCheckBoxMenuItem ("Bacon");
	
	ingredients.add(tomato);
	ingredients.add(cheese);
	ingredients.add(pine);
	ingredients.add(olive);
	ingredients.add(mush);
	ingredients.add(on);
	ingredients.addSeparator();
	ingredients.add(pork);
	ingredients.add(pep);
	ingredients.add(ham);
	ingredients.add(bacon);
	
	//MEAT LIST
	Set<String> meatIngredients = new HashSet<>();
	meatIngredients.add("Pork Meatballs");
	meatIngredients.add("Pepperoni") ;
	meatIngredients.add("Ham");
	meatIngredients.add("Bacon");
	
	//CHILLI FUNCTION
	JRadioButtonMenuItem l0 = new JRadioButtonMenuItem ("Level 0: No chilli" , null,true);
	JRadioButtonMenuItem l1 = new JRadioButtonMenuItem ("Level 1: Mild chilli");
	JRadioButtonMenuItem l2 = new JRadioButtonMenuItem ("Level 2: Hot chilli");
	JRadioButtonMenuItem l3 = new JRadioButtonMenuItem ("Level 3: Extra-hot chilli");
	JRadioButtonMenuItem l4 = new JRadioButtonMenuItem ("Level 4: Habanero-hot");

	
	

	allGroup.add(l0);
	allGroup.add(l1);
	allGroup.add(l2);
	allGroup.add(l3);
	allGroup.add(l4);
	
	
	chilli.add(l0);
	chilli.add(l1);
	chilli.add(l2);
	chilli.add(l3);
	chilli.add(l4);
	
	//ORDERS FUNCTION
	JMenuItem reg = new JMenuItem ("Prepare regular pizza");
	reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			boolean containsMeat = false;
			String ingredientsC = "";
			for (int x =0; x<ingredients.getItemCount()-1; x++)
			{
				JCheckBoxMenuItem choice = (JCheckBoxMenuItem) ingredients.getItem(x);
				if (choice != null && choice.isSelected())
				{
					if (ingredientsC.length()>0) 
						{
							ingredientsC +=",";
						}
					ingredientsC += choice.getText();
					if (meatIngredients.contains(choice.getText()))
					{
						containsMeat = true;
						//break;
					}
				}
			}
			
			if (!containsMeat)
			{
				JOptionPane.showMessageDialog(frame, 
					      "No meat selected.", "Your pizza does not contain any type of meat!", 	     	
					       JOptionPane.INFORMATION_MESSAGE);
			}

			String chilliLevel = "";
	        for (Enumeration<AbstractButton> buttons = allGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	            	chilliLevel = button.getText();
	            }
	        }
			
			text.append("\n Preparing a regular pizza with the ingredients: "+
					ingredientsC+" \n The level of chilli hotness: "+chilliLevel+"."+"\n");
		}});
		
	ButtonGroup group = new ButtonGroup();
	
	for (int x =0; x<=chilli.getItemCount()-1; x++)
	{
		JRadioButtonMenuItem object = (JRadioButtonMenuItem) chilli.getItem(x);
		group.add(object);
			
		object.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	        	if (object.isSelected())
	          text.append("\n New chilli hotness level selected: "+object.getText()+""+"\n");
	        }
	      });

	}
	
	
	
	JMenuItem veg = new JMenuItem("Prepare veggie pizza");
	veg.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			boolean containsMeat = false;
			String ingredientsC = "";
			for (int x =0; x<ingredients.getItemCount()-1; x++)
			{
				JCheckBoxMenuItem choice = (JCheckBoxMenuItem) ingredients.getItem(x);
				if (choice != null && choice.isSelected())
				{
					if (ingredientsC.length()>0) 
					{
						ingredientsC +=",";
					}
					ingredientsC += choice.getText();
					
					if (meatIngredients.contains(choice.getText()))
					{
						containsMeat = true;
					}
				}
			}
			
			String chilliLevel = "";

			Enumeration<AbstractButton> buttons = group.getElements();
	        while(buttons.hasMoreElements()) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	            	chilliLevel = button.getText();
	            }
	        }
			
			if (containsMeat)
			{
				JOptionPane.showMessageDialog(frame, 
					      "Meat selected.", "Your veggie pizza contains meat!", 	     	
					       JOptionPane.ERROR_MESSAGE);
				text.append("\n Your choice of ingredients contains meat, this veggie pizza cannot be cooked."+"\n");
			}
			else
			{
				text.append("Preparing a veggie pizza with the ingredients: "+
						ingredientsC+" \n The level of chilli hotness: "+chilliLevel+"."+"\n");
			}			

		}});
		
	
	orders.add(reg);
	orders.add(veg);
	
	
	//adding all to menu bar
	a.add(users);
	a.add(ingredients);
	a.add(chilli);
	a.add(orders);
	text.setEditable(false);
	
	 //adding to Jframe
    frame.setJMenuBar(a);
	frame.add(text);
	frame.setSize(600,600);
	frame.pack();
	
}
}


package main;
/*
 * STUDENT ID:C20390733
 * AUTHOR:IFEOMA ANIEWKENA 
 * FLIE:MAIN
 * DESCRIPTION OF CLASS:IN-LAB ASSESSMENT 
 * DATE:25/11/2021
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;

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
			JTextField field = new JTextField();
			JPasswordField pass = new JPasswordField();
			String massage =( "Please enter your username and password");
			result = JOptionPane.showConfirmDialog(frame, new Object[] { massage , field, pass}, "Login" , JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.OK_OPTION){
				text.append( "Welcome" + ""+ field.getText() + "" + pass.getPassword());
			}
			else
			{
				text.append("The login was cancelled by the user");
			}
			
			
		}
		
		
	});
	JMenuItem logout = new JMenuItem("Logout");
	logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.SHIFT_DOWN_MASK));
	logout.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int result = JOptionPane.showConfirmDialog(null, "Do you want to leave the system?");
			switch(result) {
			case JOptionPane.YES_OPTION:
					System.exit(0);break;
			case JOptionPane.CLOSED_OPTION:
					text.append("The login was cancelled by the user");break;
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
	
	tomato.addItemListener(this:: processIngredients );
	cheese.addItemListener(this :: processIngredients);
	pine.addItemListener(this:: processIngredients );
	olive.addItemListener(this :: processIngredients);
	mush.addItemListener(this:: processIngredients );
	on.addItemListener(this :: processIngredients);
	pork.addItemListener(this:: processIngredients );
	pep.addItemListener(this :: processIngredients);
	ham.addItemListener(this:: processIngredients );
	bacon.addItemListener(this :: processIngredients);

	//CHILLI FUNCTION
	JRadioButtonMenuItem l0 = new JRadioButtonMenuItem ("Level 0: No chilli" , true);
	JRadioButtonMenuItem l1 = new JRadioButtonMenuItem ("Level 1: Mild chilli");
	JRadioButtonMenuItem l2 = new JRadioButtonMenuItem ("Level 2; Hot chilli");
	JRadioButtonMenuItem l3 = new JRadioButtonMenuItem ("Level 3: Extra-hot chilli");
	JRadioButtonMenuItem l4 = new JRadioButtonMenuItem ("Level 4: Habanero-hot");
	
	l0.setActionCommand("Level 0: No chilli");
	l1.setActionCommand("Level 1: Mild chilli");
	l2.setActionCommand("Level 2: Hot chilli");
	l3.setActionCommand("Level 3: Extra-hot chilli");
	l4.setActionCommand("Level 4: Habanero-hot");
	
	

	allGroup.add(l0);
	allGroup.add(l1);
	allGroup.add(l2);
	allGroup.add(l3);
	allGroup.add(l4);
	
	
	l0.addItemListener(this :: processChilli);
	l1.addItemListener(this:: processChilli);
	l2.addItemListener(this :: processChilli);
	l3.addItemListener(this :: processChilli);
	l4.addItemListener(this :: processChilli);
	
	
	chilli.add(l0);
	chilli.add(l1);
	chilli.add(l2);
	chilli.add(l3);
	chilli.add(l4);
	
	//ORDERS FUNCTION
	JMenuItem reg = new JMenuItem ("Prepare regualar pizza");
	reg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if( ingredients.equals(tomato) || ingredients.equals(cheese) || ingredients.equals(pine)|| ingredients.equals(on) ||
			ingredients.equals(mush)){
			// if (ingredients.getAction() != null){
	                 JOptionPane.showMessageDialog(null,"This pizza contains no meat");
	                  text.append("\n"+ "Preparing a regular pizza with the following ingredients" + "\n" + ingredients.isSelected());
	                 text.append( "\n" + "The chilli:" + allGroup.getSelection());
					}
			}
	});
			
		
	
	
	
	
	JMenuItem veg = new JMenuItem("Prepare veggie pizza");
	veg.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JCheckBoxMenuItem a = (JCheckBoxMenuItem)e.getSource();
			// TODO Auto-generated method stub
			 if( ingredients.equals(bacon) ||ingredients.equals(pep) || ingredients.equals(ham) ||ingredients.equals(pork)){
				JOptionPane.showMessageDialog(null, "There is an error as meat is included in this veggie pizza");
				text.append("/n" + "There is an error in the selection of ingredients , so the pizza cannot be cooked");
			}
			else
			{
				 
				text.append("\n"+ "Preparing veggie pizz with the following ingredients" + ingredients.isSelected());
				text.append("\n" + "The chilli:" + allGroup.getSelection());
			
		
		}
		};
		
	});
		
	
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

private void processIngredients (ItemEvent e) {
	JCheckBoxMenuItem a = (JCheckBoxMenuItem)e.getSource();
	if (a.isSelected())
	
	{
		System.out.println("Adding"+ a.getText());
		text.append(a.getText()+"\n");
	}
		
		else {
			System.out.println("Removing" + a.getText());
			text.setText(text.getText().replace(a.getText()+"\n", " "));
			
}
}

private void processChilli(ItemEvent e) {
	
	ButtonModel model = allGroup.getSelection();
	if(model == null) {
		text.append("No selection");
	}
	else
	{
		text.append( "\n" + model.getActionCommand());
	}
	
}
}






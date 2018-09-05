PACKAGE: View						CLASS: AdminView
package view;

import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

import controller.*;


public class AdminView extends JFrame {
	
	private int width = 300;
	private int height = 200;
	
	JButton Viewbutt;
	JButton Add;
	JButton Change;
	JButton Logout;
	
	public AdminView()
	{
		Viewbutt = new JButton("View Items");
		Viewbutt.setBounds(15, 15, 120, 50);
		
		Add = new JButton("Add Items");
		Add.setBounds(150, 15, 120, 50);
		
		Change = new JButton("Change PassCode");
		Change.setBounds(60, 75, 160, 50);
		
		Logout = new JButton("LOGOUT");
		Logout.setBounds(180, 135, 100, 30);
		
		JLabel bGround = new JLabel(" ");
		

		add(Viewbutt);
		add(Add);
		add(Change);
		add(Logout);
		add(bGround);
		
		setUndecorated(true);
		setTitle("WELCOME ADMIN");
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
		
	}
		
		public void setViewbutt(ActionListener ViewbuttListener)
		{
			Viewbutt.addActionListener(ViewbuttListener);
		}
		public void setAdd(ActionListener AddListener)
		{
			Add.addActionListener(AddListener);
		}
		public void setChange(ActionListener ChangeListener)
		{
			Change.addActionListener(ChangeListener);
		}
		public void setLogout(ActionListener ChangeListener)
		{
			Logout.addActionListener(ChangeListener);
		}
		
	
}




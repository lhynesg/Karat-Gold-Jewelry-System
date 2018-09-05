PACKAGE: View						CLASS: CustomerUI
package view;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

public class CustomerUI extends JFrame
{
	private JButton p1btn, p2btn, Exit, Exit1;
	private JTextField name;
	private JPasswordField pass;
	private JPanel p1, p2;
	private JLabel p1lbl, p2lbl, lab;
	private int width = 710, height = 500;
	private Image img;
	
	public CustomerUI()
	{
		Border border = BorderFactory.createLineBorder(Color.black, 1);
		
		JLabel title = new JLabel("Welcome to Karat Gold!");
		
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Edwardian Script ITC", Font.PLAIN, 80));
		title.setBounds(50, 70, 610, 100);
		add(title);
			
		p1 = new JPanel();
		p1.setBounds(10, 260, 690, 300);
		p1.setOpaque(false);
		add(p1);
		p1.setLayout(null);
		
		p1lbl = new JLabel("Enter your name:");
		p1lbl.setBounds(-23, 46, 530, 30);
		p1lbl.setHorizontalAlignment(SwingConstants.CENTER);
		p1lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		p1.add(p1lbl);

		name = new JTextField();
		name.setBounds(204, 100, 291, 30);
		name.setFont(new Font("Modern No. 20", Font.PLAIN, 18));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBorder(border);
		p1.add(name);
		name.setColumns(10);
		
		p1btn = new JButton("ENTER");
		p1btn.setBounds(235, 160, 114, 43);
		p1btn.setIcon( new ImageIcon("C:/Users/User/Desktop/bg.jpg") );
    	p1btn.setHorizontalTextPosition(JButton.CENTER);
    	p1btn.setVerticalTextPosition(JButton.CENTER);
		p1btn.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		p1btn.setBorder(border);
		p1.add(p1btn);
		
		Exit = new JButton("EXIT");
		Exit.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		Exit.setIcon( new ImageIcon("C:/Users/User/Desktop/bg.jpg") );
    	Exit.setHorizontalTextPosition(JButton.CENTER);
    	Exit.setVerticalTextPosition(JButton.CENTER);
    	Exit.setBorder(border);
		Exit.setBounds(359, 161, 114, 43);
		p1.add(Exit);
		
		p2 = new JPanel();
		p2.setBounds(10, 260, 690, 299);
		p2.setOpaque(false);
		p2.setLayout(null);
		getContentPane().add(p2);

		Exit1 = new JButton("BACK");
		Exit1.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		Exit1.setIcon( new ImageIcon("C:/Users/User/Desktop/bg.jpg") );
    	Exit1.setHorizontalTextPosition(JButton.CENTER);
    	Exit1.setVerticalTextPosition(JButton.CENTER);
    	Exit1.setBorder(border);
		Exit1.setBounds(359, 161, 114, 43);
		p2.add(Exit1);
		
		p2lbl = new JLabel("Enter your password:");
		p2lbl.setBounds(-12, 46, 530, 30);
		p2lbl.setHorizontalAlignment(SwingConstants.CENTER);
		p2lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		p2.add(p2lbl);
		
		pass = new JPasswordField();
		pass.setBounds(204, 100, 291, 30);
		pass.setFont(new Font("Modern No. 20", Font.PLAIN, 15));
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		p2.add(pass);
		pass.setColumns(10);
		
		p2btn = new JButton("ENTER");
		p2btn.setBounds(235, 160, 114, 43);
		p2btn.setIcon( new ImageIcon("C:/Users/User/Desktop/bg.jpg") );
    		p2btn.setHorizontalTextPosition(JButton.CENTER);
    		p2btn.setVerticalTextPosition(JButton.CENTER);
		p2btn.setFont(new Font("Myriad Pro", Font.PLAIN, 15));
		p2btn.setBorder(border);
		p2.add(p2btn);
		
		lab = new JLabel();
		add(lab);
		JLabel lablab = new JLabel(new ImageIcon(new ImageIcon("C:/Users/User/Desktop/bg1.jpg").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
		add(lablab);
		
		setUndecorated(true);
		setVisible(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
		
		p1.setVisible(true);
		p2.setVisible(false);
		
	}
	public String getNameCode()
	{
		return name.getText().toUpperCase();
	}
	public String getPassCode()
	{
		return pass.getText();
	}
	
	public void setP1btn(ActionListener p1btnListener)
	{
		p1btn.addActionListener(p1btnListener);
	}
	public void setP2btn(ActionListener p2btnListener)
	{
		p2btn.addActionListener(p2btnListener);
	}
	public void setTxtFldLstnr(KeyListener txtFldListener)
	{
		name.addKeyListener(txtFldListener);
	}
	public void setPsswrdFldLstnr(KeyListener psswrdFldListener)
	{
		pass.addKeyListener(psswrdFldListener);
	}
	public void setExitbtn(ActionListener exitbtnListener)
	{
		Exit.addActionListener(exitbtnListener);
	}
	public void setBackbtn(ActionListener backbtnListener)
	{
		Exit1.addActionListener(backbtnListener);
	}
	public void setPanel(boolean b)
	{
		if (b == false)
		{
			p1.setVisible(true);
			p2.setVisible(b);
		}
		else if (b == true)
		{
			p1.setVisible(false);
			p2.setVisible(b);
		}
	}
	public void setPassCode(String s)
	{
		pass.setText(s);
	}
	public void setNameCode(String s) {
		name.setText(s);
	}
	public void setBGround(Image i)
	{
		img = (new ImageIcon(i).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		lab.setIcon(new ImageIcon(img));
	}
	public void setComponentLstnr(ComponentListener componentLstnr)
	{
		addComponentListener(componentLstnr);
	}
}




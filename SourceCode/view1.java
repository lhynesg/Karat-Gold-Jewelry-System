package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewingFrame extends JFrame
{
	private int width = 500, height = 300;
	private JButton back;
	private JLabel details, itemCode, price, description, img;
	private JPanel panel;
	private Image i;
	private String s, name;
	
	public ViewingFrame(String s, String n)
	{
		this.s = s;
		name = n;
		
		setUndecorated(true);
		setSize(width, height);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		panel = new JPanel();
		panel.setBounds(212, 11, 278, 278);
		panel.setLayout(null);
		add(panel);
		
		img = new JLabel();
		img.setBounds(0, 0, panel.getWidth(), panel.getHeight());
		panel.add(img);
		
		details = new JLabel("Details:");
		details.setBounds(10, 11, 110, 29);
		add(details);
		
		itemCode = new JLabel();
		itemCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		itemCode.setBounds(41, 87, 126, 23);
		add(itemCode);
		
		price = new JLabel();
		price.setFont(new Font("Tahoma", Font.PLAIN, 13));
		price.setBounds(41, 138, 126, 23);
		add(price);
		
		description = new JLabel("Desc");
		description.setFont(new Font("Tahoma", Font.PLAIN, 13));
		description.setBounds(41, 189, 126, 23);
		add(description);
		
		back = new JButton("Back");
		back.setBounds(10, 260, 89, 29);
		add(back);
		
		JLabel lab = new JLabel();
		add(lab);
	}
	public void setBackLstnr(ActionListener BackListener)
	{
		back.addActionListener(BackListener);
	}
	public void setImage(Image i)
	{
		this.i = (new ImageIcon(i).getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH));
		img.setIcon(new ImageIcon(this.i));
	}
	public void setEvrythng(String s1, String s2, String s3)
	{
		itemCode.setText(s1);
		price.setText(s2);
		description.setText(s3);
	}
	public String getS()
	{
		return s;
	}
	public String getName()
	{
		return name;
	}
}







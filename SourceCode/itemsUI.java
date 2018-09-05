PACKAGE: View						CLASS: ItemsUI
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemsUI extends JFrame
{
	private JButton ring, necklace, earring, bracelet, back;
	private int width = 390, height = 400;
	private String itemChoosed, name;
	
	public ItemsUI(String s)
	{
		name = s;
		JLabel title = new JLabel("welcome " + s);
		title.setForeground(Color.green);
		title.setBackground(new Color(255, 215, 0));
		title.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		title.setBounds(25, 20, 1000, 20);
		add(title);
	
		ring = new JButton("RING");
		ring.setBounds(130, 79, 132, 52);
		add(ring);
		
		necklace = new JButton("NECKLACES");
		necklace.setBounds(130, 149,132,52);
		add(necklace);
		
		earring = new JButton("EARRINGS");
		earring.setBounds(130, 219,132,52);
		add(earring);
		
		bracelet = new JButton("BRACELETS");
		bracelet.setBounds(130, 289, 132, 52);
		add(bracelet);
		
		back = new JButton("BACK");
		back.setBounds(280, 320, 70, 30);
		add(back);
		
		JLabel lablab = new JLabel(new ImageIcon(new ImageIcon("C:/Users/User/Desktop/icons/b1.jpg").getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT)));
		add(lablab);
		
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	public void setBackLstnr(ActionListener BackListener, ActionListener admnBackListener)
	{
		if (name == "ADMIN")
			back.addActionListener(admnBackListener);
		else
			back.addActionListener(BackListener);
	}
	public void setRingLstnr(ActionListener RingListener)
	{
		ring.addActionListener(RingListener);
	}
	public void setBraceletLstnr(ActionListener BraceletListener)
	{
		bracelet.addActionListener(BraceletListener);
	}
	public void setNecklaceLstnr(ActionListener NecklaceListener)
	{
		necklace.addActionListener(NecklaceListener);
	}
	public void setEarringLstnr(ActionListener EarringListener)
	{
		earring.addActionListener(EarringListener);
	}
	public String getItemChoosed()
	{
		return itemChoosed;
	}
	public String getCustomerName()
	{
		return name;
	}
	public void setItemChoosed(String s)
	{
		itemChoosed = s;
	}
}







PACKAGE: View						CLASS: ItemChooseUI
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ItemChooseUI extends JFrame
{
	private int width = 740, height = 500;
	private JButton back, backPanel, nextPanel, compare;
	private JButton[] but;
	private JPanel[] panel;
	private JLabel[] lab;
	private String name, s;
	private Image[] img;
	private int noOfButs = 0;
	
	public ItemChooseUI(String s, String n)
	{
		name = n;
		this.s = s;
		
		JLabel title = new JLabel("Welcome" + n);
		title.setForeground(Color.RED);
		title.setBackground(new Color(255, 215, 0));
		title.setFont(new Font("Algerian", Font.BOLD, 35));
		title.setBounds(30, 10, 1000, 52);
		setLayout(null);
		
		back = new JButton("Back");
		back.setBounds(630, 411, 70, 30);
		getContentPane().add(back);
		
		backPanel = new JButton("<");
		backPanel.setBounds(50, 411, 40, 30);
		add(backPanel);
		
		nextPanel = new JButton(">");
		nextPanel.setBounds(100, 411, 40, 30);
		add(nextPanel);
		
		compare = new JButton("COMPARE");
		compare.setBounds(310, 411, 100, 30);
		add(compare);
		
		JLabel none = new JLabel();
		none.setBounds(0, 0, 734, 471);
		getContentPane().add(none);
		
		setSize(width, height);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public void setBackPanelLstnr(ActionListener BackPanelListener)
	{
		backPanel.addActionListener(BackPanelListener);
	}
	public void setNextPanelLstnr(ActionListener NextPanelListener)
	{
		nextPanel.addActionListener(NextPanelListener);
	}
	public void setBackLstnr(ActionListener BackListener)
	{
		back.addActionListener(BackListener);
	}
	public String getCustomerName()
	{
		return name;
	}
	public void setCompareLstnr(ActionListener CompareListener)
	{
		compare.addActionListener(CompareListener);
	}
	public void setNoOfButs(int i)
	{
		noOfButs = i;
		but = new JButton[noOfButs];
		lab = new JLabel[noOfButs];
		img = new Image[noOfButs];
		
		if( noOfButs <= 4){
			panel = new JPanel[1];
			
		}
		else if(noOfButs <= 8){
			panel = new JPanel[2];
		}
		int y = 0;
		for (int x = 0; x<noOfButs; x++)
		{
			but[x] = new JButton();
			lab[x] = new JLabel();
			if(x<4){
				but[x].setBounds(170*x, 90, 120, 120);
				lab[x].setBounds(170*x, 210, 150, 20);
			}
			else if (x<8)
			{
				but[x].setBounds(170*y, 90, 120, 120);
				lab[x].setBounds(170*y, 210, 150, 20);
				y++;
			}
		}
		
		if(noOfButs<=4){
			
			panel[0] = new JPanel();
			panel[0].setBounds(50, 30, 680, 400);
			panel[0].setLayout(null);
			
			backPanel.setEnabled(false);
			nextPanel.setEnabled(false);
		}
		else if(noOfButs <= 8){
			
			panel[0] = new JPanel();
			panel[0].setBounds(50, 30, 680, 400);
			panel[0].setLayout(null);
			
			panel[1] = new JPanel();
			panel[1].setBounds(50, 30, 680, 400);
			panel[1].setLayout(null);
		}
		
		int x = 0;
		while (x<noOfButs)
		{
			if (x>=4)
			{
				panel[1].add(but[x]);
				panel[1].add(lab[x]);
			}
			else
			{
				panel[0].add(but[x]);
				panel[0].add(lab[x]);
			}
			x++;
		}
		
		add(panel[0]);
		if (noOfButs>=5)
		{
			add(panel[1]);
			panel[1].setVisible(false);
			backPanel.setEnabled(false);
		}
		panel[0].setVisible(true);
	}
	public void setPanelVisibility(boolean b)
	{
		if (noOfButs>=5)
		{
			if (b == true)
			{
				panel[1].setVisible(true);
				panel[0].setVisible(false);
				backPanel.setEnabled(true);
				nextPanel.setEnabled(false);
			}
			else if (b == false)
			{
				panel[0].setVisible(true);
				panel[1].setVisible(false);
				backPanel.setEnabled(false);
				nextPanel.setEnabled(true);
			}
		}
	}
	public void setArrayButtonLstnr(ActionListener ArrayButtonListener, int i)
	{
		but[i].addActionListener(ArrayButtonListener);
	}
	public void setLabels(String s, int i)
	{
		lab[i].setText(s);
	}
	public void setArrayButtonImg(Image img, int i)
	{
		this.img[i] = (new ImageIcon(img).getImage().getScaledInstance(but[i].getWidth(), but[i].getHeight(), Image.SCALE_SMOOTH));
		but[i].setIcon(new ImageIcon(this.img[i]));
	}
	public String getS()
	{
		return s;
	}
	public String getName()
	{
		return name;
	}
	public JButton getBut(int i)
	{
		return but[i];
	}
}

















PACKAGE: View						CLASS: CompareView
package view;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.*;

public class CompareView extends JFrame
{
	private int width = 700, height = 600;
	JPanel leftpanel,rightpanel;
	JComboBox Lcombobox,Rcombobox;
	JLabel p1image, p1name, p1price, p1info, p2image, p2name, p2price, p2info;
	Image img1, img2;
	JButton back;
	String s, name;
	
	public CompareView(String s, String x)
	{
		this.s = s;
		name = x;
		
		setSize(566, 607);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
		
		leftpanel = new JPanel();
		leftpanel.setBounds(10, 87, 265, 421);
		add(leftpanel);
		leftpanel.setLayout(null);
		
		p1image = new JLabel();
		p1image.setBounds(0, 0, 265, 265);
		leftpanel.add(p1image);
		
		p1name = new JLabel();
		p1name.setBounds(26, 286, 116, 23);
		leftpanel.add(p1name);
		
		p1price = new JLabel();
		p1price.setBounds(26, 317, 116, 23);
		leftpanel.add(p1price);
		
		p1info = new JLabel();
		p1info.setBounds(26, 351, 229, 59);
		leftpanel.add(p1info);
		
		rightpanel = new JPanel();
		rightpanel.setBounds(285, 87, 265, 421);
		add(rightpanel);
		rightpanel.setLayout(null);
		
		p2image = new JLabel();
		p2image.setBounds(0, 0, 265, 265);
		rightpanel.add(p2image);
		
		p2name = new JLabel();
		p2name.setBounds(27, 286, 124, 25);
		rightpanel.add(p2name);
		
		p2price = new JLabel();
		p2price.setBounds(27, 317, 187, 25);
		rightpanel.add(p2price);
		
		p2info = new JLabel();
		p2info.setBounds(27, 351, 228, 59);
		rightpanel.add(p2info);
		
		Lcombobox = new JComboBox();
		Lcombobox .setBounds(52, 45, 188, 20);
		add(Lcombobox );
		
		Rcombobox = new JComboBox();
		Rcombobox.setBounds(325, 45, 188, 20);
		add(Rcombobox);
		
		back = new JButton("Back");
		back.setBounds(428, 525, 89, 42);
		add(back);
		
		JLabel compare = new JLabel("Compare");
		compare.setBounds(10, 11, 76, 23);
		add(compare);
	}
	public void setComboBox(String a)
	{
		Lcombobox.addItem(a);
		Rcombobox.addItem(a);
	}
	public String getLComboBox()
	{
		return (String) Lcombobox.getSelectedItem();
	}
	public void setLPicture(Image img)
	{
		img1 = (new ImageIcon(img).getImage().getScaledInstance(p1image.getWidth(), p1image.getHeight(), Image.SCALE_SMOOTH));
		p1image.setIcon(new ImageIcon(img1));
	}
	public String getRComboBox()
	{
		return (String) Rcombobox.getSelectedItem();
	}
	public void setRPicture(Image img)
	{
		img2 = (new ImageIcon(img).getImage().getScaledInstance(p2image.getWidth(), p2image.getHeight(), Image.SCALE_SMOOTH));
		p2image.setIcon(new ImageIcon(img2));
	}
	public void setLComboBoxLstnr(ActionListener LComboBoxListener)
	{
		Lcombobox.addActionListener(LComboBoxListener);
	}
	public void setLevrythng(String s1, String s2, String s3)
	{
		p1name.setText(s1);
		p1price.setText(s2);
		p1info.setText(s3);
	}
	public void setRComboBoxLstnr(ActionListener RComboBoxListener)
	
	{
		Rcombobox.addActionListener(RComboBoxListener);
	}
	public void setRevrythng(String s1, String s2, String s3)
	{
		p2name.setText(s1);
		p2price.setText(s2);
		p2info.setText(s3);
	}
	
	public void setBackLstnr(ActionListener BackListener)
	{
		back.addActionListener(BackListener);
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



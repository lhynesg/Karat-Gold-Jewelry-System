
package modSime;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class About extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width = 1370, height = 770;
	private ImageIcon imgIcon;
	private Image img;
	private JPanel panel;
	private JLabel bg;
	private JLabel jj;
	private JButton back;
	private BackHandler bh;
	private JTextPane AboutUs;
	private JTextPane title1 , title2;
	
	public About()
	{
		panel = new JPanel();
		panel.setSize(width, height);
		panel.setOpaque(true);
		panel.setLayout(null);
		bh = new BackHandler();
		imgIcon = new ImageIcon("C:/Users/Daniel Penjan/Desktop/school pics/gg.jpg");
		img = imgIcon.getImage();
		bg = new JLabel();
		bg.setFont(new Font("Calibri", Font.PLAIN, 30));
		bg.setBackground(new Color(51, 204, 102));
		bg.setForeground(new Color(51, 0, 0));
		bg.setLocation(-4, 0);
		bg.setSize(width, height);
		bg.setIcon(new ImageIcon(img.getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH)));
		back = new JButton("BACK");
		back.setBackground(new Color(102, 0, 0));
		back.setForeground(new Color(255, 255, 255));
		back.setBorder(null);
		back.setFont(new Font("Tahoma", Font.BOLD, 26));
		back.setBounds(1218, 718, 116, 41);
		back.addActionListener(bh);
		panel.add(back);
		title1 = new JTextPane();
		title1.setText("Home Builders");
		title1.setSelectionColor(new Color(204, 102, 153));
		title1.setSelectedTextColor(Color.WHITE);
		title1.setForeground(Color.WHITE);
		title1.setFont(new Font("Calibri", Font.BOLD, 60));
		title1.setEditable(false);
		title1.setDisabledTextColor(Color.WHITE);
		title1.setBackground(new Color(0, 0, 0));
		title1.setBounds(10, 11, 384, 83);
		panel.add(title1);
title2 = new JTextPane();
		title2.setText("Payment Plan");
		title2.setSelectionColor(new Color(204, 102, 153));
		title2.setSelectedTextColor(Color.WHITE);
		title2.setForeground(Color.WHITE);
		title2.setFont(new Font("Calibri", Font.ITALIC, 60));
		title2.setEditable(false);
		title2.setDisabledTextColor(Color.WHITE);
		title2.setBackground(new Color(0, 204, 204));
		title2.setBounds(278, 68, 350, 86);
		panel.add(title2);
		JTextPane textPane = new JTextPane();
		textPane.setText("About Us");
		textPane.setSelectionColor(new Color(204, 102, 153));
		textPane.setSelectedTextColor(Color.WHITE);
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Calibri", Font.BOLD, 85));
		textPane.setEditable(false);
		textPane.setDisabledTextColor(Color.WHITE);
		textPane.setBackground(new Color(204, 204, 51));
		textPane.setBounds(10, 172, 343, 98);
		panel.add(textPane);
		AboutUs = new JTextPane();
		AboutUs.setBackground(new Color(255, 51, 102));
		AboutUs.setDisabledTextColor(new Color(255, 255, 255));
		AboutUs.setSelectionColor(new Color(204, 102, 153));
		AboutUs.setSelectedTextColor(new Color(255, 255, 255));
		AboutUs.setForeground(new Color(255, 255, 255));
		AboutUs.setFont(new Font("Calibri", Font.BOLD, 30));
		AboutUs.setText("\t HOME BUILDERS PAYMENT PLAN more than most management companies."
				+ " We believe that it's not the foundation, the dry wall or the bricks that make the home, but rather people."
				+ " People are the core of our business. Our group of employees are here for every aspect of every community’s needs."
				+ " This allows us to better communicate with our clients, be more personable, and above all else, focus on what really matters"
				+ " — the people. We want to help you make a home, your home.");
		AboutUs.setBounds(37, 260, 859, 329);
		AboutUs.setEditable(false);
		panel.add(AboutUs);
		imgIcon = new ImageIcon("C:/Users/Daniel Penjan/Desktop/school pics/jj.jpg");
		img = imgIcon.getImage();
		jj = new JLabel("New button");
		jj.setBounds(906, 169, 428, 526);
		jj.setIcon(new ImageIcon(img.getScaledInstance(jj.getWidth() + 11, jj.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(jj);
		imgIcon = new ImageIcon("C:/Users/Daniel Penjan/Desktop/school pics/floorplan.jpg");
		img = imgIcon.getImage();
		

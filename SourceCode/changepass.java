PACKAGE: View						CLASS: ChangePass
package view;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;

import javax.swing.*;

import controller.*;

	public class ChangePass extends JFrame
	{
		private int width = 290;
		private int height = 200;
		private JButton Cancel, Confirm;
		private JPasswordField oldField, passField, reTypeNew;
		
		public ChangePass()
		{
			JLabel oldPass = new JLabel("Old PassCode ");
			oldPass.setBounds(10, 10, 100, 30);
			
			oldField = new JPasswordField(20);
			oldField.setBounds(120, 10, 150, 30);
			
			JLabel newPass = new JLabel("New PassCode ");
			newPass.setBounds(10, 50, 100, 30);
			
			passField = new JPasswordField(20);
			passField.setBounds(120, 50, 150, 30);
			
			JLabel reType = new JLabel("Re-Type PassCode ");
			reType.setBounds(10, 90, 150, 30);
			
			reTypeNew = new JPasswordField(20);
			reTypeNew.setBounds(120, 90, 150, 30);
			
			Confirm = new JButton("CONFIRM");
			Confirm.setBounds(25, 140, 100, 20);
			
			Cancel = new JButton("CANCEL");
			Cancel.setBounds(160, 140, 100, 20);
			

			JLabel bGround = new JLabel(" ");
			
			add(oldPass);
			add(oldField);
			add(newPass);
			add(passField);
			add(reType);
			add(reTypeNew);
			add(Confirm);
			add(Cancel);
			add(bGround);
			
			setUndecorated(true);
			setSize(width, height);
			setResizable(false);
			setVisible(true);
			setLocationRelativeTo(null);
			setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
		}
		
		public void setConfirm(ActionListener ConfirmListener)
		{
			Confirm.addActionListener(ConfirmListener);
		}

		public void setCancel(ActionListener CancelListener)
		{
			Cancel.addActionListener(CancelListener);
		}
		public String getOldPass()
		{
			return oldField.getText();
		}
		public String getPassField()
		{
			return passField.getText();
		}
		public String getReTypeNew()
		{
			return reTypeNew.getText();
		}
		public void setOldPass(String s)
		{
			oldField.setText(s);
		}
		public void setPassField(String s)
		{
			passField.setText(s);
		}
		public void setReTypeNew(String s)
		{
			reTypeNew.setText(s);
		}
	}








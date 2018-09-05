PACKAGE: Model					CLASS: CustomerUIModel
package model;

import java.awt.Image;
import java.io.*;

import javax.swing.*;

public class CustomerUIModel 
{
	private BufferedReader file;
	private String password;
	private Image img;
	
	public CustomerUIModel()
	{
		try
		{
			file = new BufferedReader(new FileReader("C:/Users/user/Desktop/pass.txt"));
			password = file.readLine();
			
		} catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "no password file created");
		}
		ImageIcon img = new ImageIcon("C:/Users/user/Desktop/b7.jpg");
		this.img = img.getImage();
	}
	public String getPassword()
	{
		return password;
	}
	public Image getImage()
	{
		return img;
	}
}

PACKAGE: Model					CLASS: AddingFrameModel
package model;

import java.io.File;

public class AddingFrameModel 
{
	private String path;
	private File fileName;
	
	public AddingFrameModel()
	{
		path = "C:/Users/User/Desktop/icons/";
	}
	
	public void changePath(File s)
	{
		fileName = s;
		fileName.renameTo(new File(path+fileName.getName()));
	}
}

PACKAGE: Model						CLASS: BraceletModel
package model;

import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class BraceletModel extends connection{
	
	private String[] code, price, description;
	private int noOfItems = 0;
	private Image[] img;
	
	public BraceletModel()
	{	
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from bracelets");
			while (rs.next())
				noOfItems++;
			code = new String[noOfItems];
			price = new String[noOfItems];
			description = new String[noOfItems];
			img = new Image[noOfItems];
			st = conn.createStatement();
			rs = st.executeQuery("select * from bracelets");
			int x = 0;
			while (rs.next())
			{	
				code[x] = rs.getString(1);
				price[x] = rs.getString(2);
				description[x] = rs.getString(3);
				ImageIcon img = new ImageIcon("C:/Users/User/Desktop/icons/brace"+(x+1)+".JPG");
				this.img[x] = img.getImage();
				x++;
			}
		} catch (SQLException e) {
			System.out.println("The query did not execute properly");
		}
	}
	public int getNoOfItems()
	{
		return noOfItems;
	}
	public String getCode(int i)
	{
		return code[i];
	}
	public String getPrice(int i)
	{
		return price[i];
	}
	public String getDescription(int i)
	{
		return description[i];
	}
	public Image getImg(int i) {
		
		return img[i];
	}
}



PACKAGE: Model					CLASS: ChangePassModel
package model;

import java.io.*;

import javax.swing.*;

public class ChangePassModel 
{
	private BufferedReader read;
	private FileWriter write;
	private String password;
	
	public ChangePassModel()
	{
		try
		{
			read = new BufferedReader(new FileReader("C:/Users/user/Desktop/pass.txt"));
			password = read.readLine();
			
		} catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "no password file created");
		}
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String s)
	{
		try {
			write = new FileWriter("C:/Users/user/Desktop/pass.txt");
			write.write(s);
			write.close();
		} 
		catch (IOException e1) {	
		}
		JOptionPane.showMessageDialog(null, "PASSWORD CHANGED!");
	}
}

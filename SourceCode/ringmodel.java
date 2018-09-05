PACKAGE: Model						CLASS: RingModel
package model;

import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class RingModel extends connection{
	
	private String[] code, price, description;
	private int noOfItems = 0;
	private Image[] img;
	
	public RingModel()
	{	
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from rings");
			
			while (rs.next())
				noOfItems++;
			code = new String[noOfItems];
			price = new String[noOfItems];
			description = new String[noOfItems];
			img = new Image[noOfItems];
			
			st = conn.createStatement();
			rs = st.executeQuery("select * from rings");
			int x = 0;
			while (rs.next())
			{
				code[x] = rs.getString(1);
				price[x] = rs.getString(2);
				description[x] = rs.getString(3);
				ImageIcon img = new ImageIcon("C:/Users/User/Desktop/icons/ring"+(x+1)+".JPG");
				this.img[x] = img.getImage();
				x++;
			}
		} catch (SQLException e) {
			System.out.println("the query did not execute properly");
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
	public Image getImg(int i)
	{
		return img[i];
	}}

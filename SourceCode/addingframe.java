PACKAGE: View						CLASS: AddingFrame
package view;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

import javax.swing.*;
import javax.swing.table.*;

public class AddingFrame extends JFrame
{
	private File file;
	private JTable table = new JTable();
    private JTextField txtCode, txtPrice, txtDescription;
    private JButton btnAdd, btnDelete, btnUpdate, btnBack, imgfile;
    private JLabel lblcode, lblprice, lbldescription;
    private String [] columns;
    private Choice itemChooser;
    private Object[] row;
    private DefaultTableModel model;
    
	public AddingFrame()
	{
		
		columns = new String[] { "CODE #", "Price", "Description", "Item", "Image"};
		
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setBackground(Color.cyan);
        table.setForeground(Color.white);
        Font font = new Font("",5,18);
        table.setFont(font);
        table.setRowHeight(20);
     
        txtCode = new JTextField();
        txtPrice = new JTextField();
        txtDescription = new JTextField();
        
        lblcode = new JLabel("CODE #");
        lblprice = new JLabel("PRICE");
        lbldescription = new JLabel("DESCRIPTION");
        btnAdd = new JButton("ADD");
        btnDelete = new JButton("DELETE");
        btnBack = new JButton("BACK");
        btnUpdate = new JButton("UPDATE");
        imgfile = new JButton ("IMAGE");
        
        lblcode.setBounds(5,220,100,25);
        lblprice.setBounds(180,220,100,25);
        lbldescription.setBounds(350,220,100,25);
        txtCode.setBounds(60,220,100,25);
        txtPrice.setBounds(225,220,100,25);
        txtDescription.setBounds(440,220,100,25);
        btnAdd.setBounds(35,260,100,25);
        btnDelete.setBounds(150,260,100,25);
        btnBack.setBounds(270,260,100,25);
        btnUpdate.setBounds(390,260,100,25);
        imgfile.setBounds(510, 260, 100, 25);
        
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0,0,880,200);
        
        itemChooser = new Choice();
        itemChooser.setBounds(780, 220, 100,50);
        itemChooser.add("Ring");
        itemChooser.add("Earring");
        itemChooser.add("Necklace");
        itemChooser.add("Bracelet");
        
        setLayout(null);
        add(pane);
        add(txtCode);
        add(txtPrice);
        add(txtDescription);
        add(btnAdd);
        add(btnDelete);
        add(btnBack);
        add(btnUpdate);
        add(lblcode);
        add(lblprice);
        add(lbldescription);
        add(itemChooser);
        add(imgfile);
        
        row = new Object[5];
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width, height= screenSize.height;
		setSize(width/4, height/4);
		
		setSize(900,345);
		setLocationRelativeTo(null);
		setTitle("Karat Gold Jewelry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
	}
	public void BackbtnLstnr(ActionListener BackbtnListener)
	{
		btnBack.addActionListener(BackbtnListener);
	}
	public void AddbtnLstnr(ActionListener AddbtnListener)
	{
		btnAdd.addActionListener(AddbtnListener);
	}
	public void UpdatebtnLstnr(ActionListener UpdatebtnListener)
	{
		btnUpdate.addActionListener(UpdatebtnListener);
	}
	public void DeletebtnLstnr(ActionListener DeletebtnListener)
	{
		btnDelete.addActionListener(DeletebtnListener);
	}
	public void ImagebtnLstnr(ActionListener ImagebtnListener)
	{
		imgfile.addActionListener(ImagebtnListener);
	}
	public String getTxtCode()
	{
		return txtCode.getText();
	}
	public String getTxtPrice()
	{
		return txtPrice.getText();
	}
	public String getTxtDescription()
	{
		return txtDescription.getText();
	}
	public void setRowValue(Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
	{
		row[0] = obj1;
		row[1] = obj2;
		row[2] = obj3;
		row[3] = obj4;
		row[4] = obj5;
	
		model.addRow(row);
    	txtCode.setText("");
    	txtDescription.setText("");
    	txtPrice.setText("");
	}
	public String getItem()
	{
		return itemChooser.getSelectedItem();
	}
	public int getSelectedRow()
	{
		return table.getSelectedRow();
	}
	public void getRemoveRow(int i)
	{
		model.removeRow(i);
	}
	public String getRowValues(int x, int y)
	{
		return table.getValueAt(x, y).toString();
	}
	public void setMssg(String s)
	{
		JOptionPane.showMessageDialog(null, s);
	}
	public void setFile()
	{
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setSelectedFile(choose.getCurrentDirectory());
		choose.setDialogTitle("Get Picture");
		choose.setMultiSelectionEnabled(false);
		
		int retVal = choose.showOpenDialog(AddingFrame.this);
		 
		if (retVal == JFileChooser.APPROVE_OPTION)
			file = choose.getSelectedFile();
	}
	public String getFileName()
	{
		return file.getName();
	}
	public File getFile()
	{
		return file;
	}
}








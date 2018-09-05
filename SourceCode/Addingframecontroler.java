PACKAGE: Controller			CLASS: AddingFrameController
package controller;

import java.awt.event.*;
import java.io.File;

import javax.swing.JOptionPane;

import view.*;
import model.*;

public class AddingFrameController 
{
	private AddingFrame add;
	private AddingFrameModel addModel;
	private connection conn;
	private String row1, row2, row3, row4, row5;
	private File imgFile;
	public AddingFrameController(AddingFrame v, AddingFrameModel m, connection conn)
	{
		add = v;
		addModel = m;
		this.conn = conn;
		
		add.AddbtnLstnr(new AddbtnListener());
		add.UpdatebtnLstnr(new UpdatebtnListener());
		add.DeletebtnLstnr(new DeletebtnListener());
		add.BackbtnLstnr(new BackbtnListener());
		add.ImagebtnLstnr(new ImagebtnListener());
	}
	public class AddbtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			row1 = add.getTxtCode();
			row2 = add.getTxtPrice();
			row3 = add.getTxtDescription();
			row4 = add.getItem();
			row5 = add.getFileName();
			
			add.setRowValue(row1, row2, row3, row4, row5);
		}
	}
	public class UpdatebtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = add.getSelectedRow();
			row1 = add.getRowValues(i, 0);
			row2 = add.getRowValues(i, 1);
			row3 = add.getRowValues(i, 2);
			row4 = add.getRowValues(i, 3);
			addModel.changePath(add.getFile());
			
			conn.insertItem(row4, row1, row2, row3);
			
			if(i>=0){
				add.getRemoveRow(i);
			}
			else{
				add.setMssg("No Row Selected ");
			}
		}
	}
	public class DeletebtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int i = add.getSelectedRow();
					
			if(i>=0){
				add.getRemoveRow(i);
			}
			else{
				add.setMssg("No Row Selected ");
			}
		}
	}
	public class BackbtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			conn.closeConnection(false);
			AdminView admin = new AdminView();
			AdminViewController adminControl = new AdminViewController(admin);
			add.dispose();
		}
	}
	public class ImagebtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			add.setFile();
		}
	}
}












PACKAGE: Controller				CLASS: AdminViewController
package controller;

import java.awt.event.*;

import javax.swing.JOptionPane;

import controller.CustomerUIController.p1btnListener;
import controller.CustomerUIController.p2btnListener;
import controller.CustomerUIController.psswrdFldListener;
import controller.CustomerUIController.txtFldListener;
import model.*;
import view.*;

public class AdminViewController
{
	AdminView adminview;
	public AdminViewController(AdminView adminview)
	{
		this.adminview = adminview;
		this.adminview.setViewbutt(new ViewbuttListener());
		this.adminview.setAdd(new AddListener());
		this.adminview.setChange(new ChangeListener());
		this.adminview.setLogout(new LogoutListener());
	}
	public class ViewbuttListener implements ActionListener
		{
			public void actionPerformed(ActionEvent arg0) {
				ItemsUI item = new ItemsUI("ADMIN");
				ItemsUIController itemControl = new ItemsUIController(item);
				adminview.dispose();
			}
		}
	public class AddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			AddingFrame addFrame = new AddingFrame();
			AddingFrameModel addModel = new AddingFrameModel();
			connection conn = new connection();
			AddingFrameController addController = new AddingFrameController(addFrame, addModel, conn);
			adminview.dispose();
		}
	}
	public class ChangeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			ChangePass change = new ChangePass();
			ChangePassModel model = new ChangePassModel();
			ChangePassController control3 = new ChangePassController(change, model);
			adminview.dispose();
		}
	}
	public class LogoutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
			CustomerUI view = new CustomerUI();
			CustomerUIModel model = new CustomerUIModel();
			CustomerUIController control1 = new CustomerUIController(view, model);
			adminview.dispose();
		}
	}}


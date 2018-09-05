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


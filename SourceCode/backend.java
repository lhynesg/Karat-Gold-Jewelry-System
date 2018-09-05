PACKAGE: Controller			CLASS: BraceletCompareController
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.EarringItemController.CompareListener;
import controller.RingCompareController.LComboBoxListener;
import view.*;
import model.*;

public class BraceletCompareController 
{
	private CompareView view;
	private BraceletModel model;
	private int noOfItems;
	private String cbox1, cbox2;
	
	public BraceletCompareController(CompareView v, BraceletModel m)
	{
		view = v;
		model = m;
		
		noOfItems = model.getNoOfItems();
		
		for (int x = 0; x < noOfItems; x++)
		{
			view.setComboBox(model.getCode(x));
		}
		
		view.setLComboBoxLstnr(new LComboBoxListener());
		view.setRComboBoxLstnr(new RComboBoxListener());
		view.setBackLstnr(new BackListener());
	}
	public class LComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox1 = view.getLComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox1 == model.getCode(x))
				{
					view.setLPicture(model.getImg(x));
					view.setLevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class RComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox2 = view.getRComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox2 == model.getCode(x))
				{
					view.setRPicture(model.getImg(x));
					view.setRevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI choose = new ItemChooseUI(view.getS(), view.getName());
			BraceletItemController control = new BraceletItemController(choose, model);
			view.dispose();
			
		}
	}
}









PACKAGE: Controller			CLASS: BraceletController
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;

public class BraceletController 
{
	private ViewingFrame view;
	private BraceletModel model;
	private int i;
	private String code, price, info;
	private Image img;
	
	public BraceletController(ViewingFrame v, BraceletModel m, int i)
	{
		view = v;
		model = m;
		
		this.i = i;
		code = model.getCode(this.i);
		price = model.getPrice(this.i);
		info = model.getDescription(this.i);
		img = model.getImg(this.i);
		view.setImage(img);
		view.setEvrythng(code, price, info);
		
		view.setBackLstnr(new BackListener());
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ItemChooseUI item = new ItemChooseUI(view.getS(), view.getName());
			BraceletItemController control = new BraceletItemController(item, model);
			view.dispose();
		}
	}}

PACKAGE: Controller				CLASS: BraceletItemController
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.BraceletItemController.ArrayButtonListener;
import controller.BraceletItemController.BackPanelListener;
import controller.BraceletItemController.NextPanelListener;
import model.*;
import view.*;

public class BraceletItemController 
{
	
	private BraceletModel model;
	private ItemChooseUI view;
	private int i;
	private int[] num;
	
	public BraceletItemController(ItemChooseUI i, BraceletModel m)
	{
		model = m;
		view = i;
		
		this.i = model.getNoOfItems();
		view.setNoOfButs(model.getNoOfItems());
		for (int x = 0; x<this.i; x++)
		{
			view.setLabels(model.getCode(x), x);
			view.setArrayButtonImg(model.getImg(x), x);
		}
		view.setBackLstnr(new BackListener());
		view.setBackPanelLstnr(new BackPanelListener());
		view.setNextPanelLstnr(new NextPanelListener());
		view.setCompareLstnr(new CompareListener());
		num = new int[model.getNoOfItems()];
		
		for (int x = 0; x<this.i; x++)
		{
			view.setArrayButtonLstnr(new ArrayButtonListener(), x);
			num[x] = x;
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemsUI itemView = new ItemsUI(view.getCustomerName());
			ItemsUIController control = new ItemsUIController(itemView);
			view.dispose();
		}
	}
	public class NextPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(true);
		}
	}
	public class BackPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(false);
		}
	}
	public class ArrayButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ViewingFrame detail = new ViewingFrame(view.getS(), view.getName());
			for (int x = 0; x < i; x++)
			{
				if (arg0.getSource() == view.getBut(x))
				{
					BraceletController contRing = new BraceletController(detail, model, num[x]);
				}
			}
			view.dispose();
			
		}
	}
	public class CompareListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			CompareView comp = new CompareView(view.getS(), view.getName());
			BraceletCompareController cont = new BraceletCompareController(comp, model);
			view.dispose();
		}
	}
	
}









PACKAGE: Controller			CLASS: ChangePassController
package controller;

import model.*;
import view.*;

import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JOptionPane;

public class CustomerUIController 
{
	CustomerUI view;
	CustomerUIModel model;
	public CustomerUIController(CustomerUI view, CustomerUIModel model) 
	{
		this.view = view;
		this.model = model;
		
		this.view.setComponentLstnr(new componentLstnr());
		this.view.setBGround(model.getImage());
		this.view.setP1btn(new p1btnListener());
		this.view.setP2btn(new p2btnListener());
		this.view.setTxtFldLstnr(new txtFldListener());
		this.view.setPsswrdFldLstnr(new psswrdFldListener());
		this.view.setExitbtn(new exitbtnListener());
		this.view.setBackbtn(new backbtnListener());
	}
	
	public class p1btnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (view.getNameCode().equals("ADMIN"))
			{
				view.setPanel(true);
			}
			else if(view.getNameCode().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter your Name.");
			}
			else
			{
				ItemsUI item = new ItemsUI(view.getNameCode());
				ItemsUIController itemControl = new ItemsUIController(item);
				view.dispose();
			}
		}
	}
	public class p2btnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (view.getPassCode().equals(model.getPassword()))
			{
				AdminView Adminview = new AdminView();
				AdminViewController control1 = new AdminViewController(Adminview);
				view.dispose();
			}
			else if(view.getPassCode().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter your password");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect password.");
				view.setPassCode("");
			}
		}
	}
	public class txtFldListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getNameCode().equals("ADMIN"))
				{
					view.setPanel(true);
				}
				else if(view.getNameCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Your Fucking Name!!!");
				}
				else
				{
					ItemsUI item = new ItemsUI(view.getNameCode());
					ItemsUIController itemControl = new ItemsUIController(item);
					view.dispose();
				}
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
		
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getNameCode().equals("ADMIN"))
				{
					view.setPanel(true);
				}
				else if(view.getNameCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Your Name!!!");
				}
				else
				{
					ItemsUI item = new ItemsUI(view.getNameCode());
					ItemsUIController itemControl = new ItemsUIController(item);
					view.dispose();
					
				}
			}
		}
	}
	public class psswrdFldListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getPassCode().equals(model.getPassword()))
				{
					AdminView Adminview = new AdminView();
					AdminViewController control1 = new AdminViewController(Adminview);
					view.dispose();
				}
				else if(view.getPassCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "You didn't enter a password.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect password.");
					view.setPassCode("");
				}
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getPassCode().equals(model.getPassword()))
				{
					AdminView Adminview = new AdminView();
					AdminViewController control1 = new AdminViewController(Adminview);
					view.dispose();
				}
				else if(view.getPassCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "You didn't enter a password.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect password.");
					view.setPassCode("");
				}
			}
		}
	}
	public class exitbtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			view.dispose();
		}
	}
	
	public class backbtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			view.setPanel(false);
			view.setNameCode("");
			
		}
	}
	public class componentLstnr implements ComponentListener
	{
		@Override
		public void componentHidden(ComponentEvent arg0) {
			
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			view.setShape(new RoundRectangle2D.Double(0, 0, view.getWidth(), view.getHeight(), 60, 60));
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			view.setShape(new RoundRectangle2D.Double(0, 0, view.getWidth(), view.getHeight(), 60, 60));
		}
		
	}
}












PACKAGE: Controller				CLASS: CustomerUIController
package controller;

import model.*;
import view.*;

import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JOptionPane;

public class CustomerUIController 
{
	CustomerUI view;
	CustomerUIModel model;
	public CustomerUIController(CustomerUI view, CustomerUIModel model) 
	{
		this.view = view;
		this.model = model;
		
		this.view.setComponentLstnr(new componentLstnr());
		this.view.setBGround(model.getImage());
		this.view.setP1btn(new p1btnListener());
		this.view.setP2btn(new p2btnListener());
		this.view.setTxtFldLstnr(new txtFldListener());
		this.view.setPsswrdFldLstnr(new psswrdFldListener());
		this.view.setExitbtn(new exitbtnListener());
		this.view.setBackbtn(new backbtnListener());
	}
	
	public class p1btnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (view.getNameCode().equals("ADMIN"))
			{
				view.setPanel(true);
			}
			else if(view.getNameCode().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter your Name.");
			}
			else
			{
				ItemsUI item = new ItemsUI(view.getNameCode());
				ItemsUIController itemControl = new ItemsUIController(item);
				view.dispose();
			}
		}
	}
	public class p2btnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (view.getPassCode().equals(model.getPassword()))
			{
				AdminView Adminview = new AdminView();
				AdminViewController control1 = new AdminViewController(Adminview);
				view.dispose();
			}
			else if(view.getPassCode().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Please enter your password");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Incorrect password.");
				view.setPassCode("");
			}
		}
	}
	public class txtFldListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getNameCode().equals("ADMIN"))
				{
					view.setPanel(true);
				}
				else if(view.getNameCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Your Fucking Name!!!");
				}
				else
				{
					ItemsUI item = new ItemsUI(view.getNameCode());
					ItemsUIController itemControl = new ItemsUIController(item);
					view.dispose();
				}
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
		
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getNameCode().equals("ADMIN"))
				{
					view.setPanel(true);
				}
				else if(view.getNameCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please Enter Your Name!!!");
				}
				else
				{
					ItemsUI item = new ItemsUI(view.getNameCode());
					ItemsUIController itemControl = new ItemsUIController(item);
					view.dispose();
					
				}
			}
		}
	}
	public class psswrdFldListener implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getPassCode().equals(model.getPassword()))
				{
					AdminView Adminview = new AdminView();
					AdminViewController control1 = new AdminViewController(Adminview);
					view.dispose();
				}
				else if(view.getPassCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "You didn't enter a password.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect password.");
					view.setPassCode("");
				}
			}
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}
		@Override
		public void keyTyped(KeyEvent arg0) {
			int keyCode = arg0.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER)
			{
				if (view.getPassCode().equals(model.getPassword()))
				{
					AdminView Adminview = new AdminView();
					AdminViewController control1 = new AdminViewController(Adminview);
					view.dispose();
				}
				else if(view.getPassCode().equals(""))
				{
					JOptionPane.showMessageDialog(null, "You didn't enter a password.");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Incorrect password.");
					view.setPassCode("");
				}
			}
		}
	}
	public class exitbtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			view.dispose();
		}
	}
	
	public class backbtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			view.setPanel(false);
			view.setNameCode("");
			
		}
	}
	public class componentLstnr implements ComponentListener
	{
		@Override
		public void componentHidden(ComponentEvent arg0) {
			
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			view.setShape(new RoundRectangle2D.Double(0, 0, view.getWidth(), view.getHeight(), 60, 60));
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			view.setShape(new RoundRectangle2D.Double(0, 0, view.getWidth(), view.getHeight(), 60, 60));
		}
		
	}
}












PACKAGE: Controller			CLASS: EaringCompareController
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RingCompareController.LComboBoxListener;
import view.*;
import model.*;

public class EarringCompareController 
{
	private CompareView view;
	private EarringModel model;
	private int noOfItems;
	private String cbox1, cbox2;
	
	public EarringCompareController(CompareView v, EarringModel m)
	{
		view = v;
		model = m;
		
		noOfItems = model.getNoOfItems();
		
		for (int x = 0; x < noOfItems; x++)
		{
			view.setComboBox(model.getCode(x));
		}
		
		view.setLComboBoxLstnr(new LComboBoxListener());
		view.setRComboBoxLstnr(new RComboBoxListener());
		view.setBackLstnr(new BackListener());
	}
	public class LComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox1 = view.getLComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox1 == model.getCode(x))
				{
					view.setLPicture(model.getImg(x));
					view.setLevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class RComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox2 = view.getRComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox2 == model.getCode(x))
				{
					view.setRPicture(model.getImg(x));
					view.setRevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI choose = new ItemChooseUI(view.getS(), view.getName());
			EarringItemController control = new EarringItemController(choose, model);
			view.dispose();
			
		}
	}
}









PACKAGE: Controller				CLASS: EaringController
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RingController.BackListener;
import view.*;
import model.*;

public class EarringController 
{
	private ViewingFrame view;
	private EarringModel model;
	private int i;
	private String code, price, info;
	private Image img
	public EarringController(ViewingFrame v, EarringModel m, int i)
	{
		view = v;
		model = m;
		this.i = i;
		code = model.getCode(this.i);
		price = model.getPrice(this.i);
		info = model.getDescription(this.i);
		img = model.getImg(this.i);
		view.setImage(img);
		view.setEvrythng(code, price, info);
		view.setBackLstnr(new BackListener());
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ItemChooseUI item = new ItemChooseUI(view.getS(), view.getName());
			EarringItemController control = new EarringItemController(item, model);
			view.dispose();
		}
	}
}

PACKAGE: Controller			CLASS: EaringItemController
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RingItemController.ArrayButtonListener;
import controller.RingItemController.BackPanelListener;
import controller.RingItemController.NextPanelListener;
import model.*;
import view.*;

public class EarringItemController 
{
	
	private EarringModel model;
	private ItemChooseUI view;
	private int i;
	private int[] num;
	
	public EarringItemController(ItemChooseUI i, EarringModel m)
	{
		model = m;
		view = i;
		
		this.i = model.getNoOfItems();
		view.setNoOfButs(model.getNoOfItems());
		for (int x = 0; x<this.i; x++)
		{
			view.setLabels(model.getCode(x), x);
			view.setArrayButtonImg(model.getImg(x), x);
		}
		view.setBackLstnr(new BackListener());
		view.setBackPanelLstnr(new BackPanelListener());
		view.setNextPanelLstnr(new NextPanelListener());
		view.setCompareLstnr(new CompareListener());
		num = new int[model.getNoOfItems()];
		
		for (int x = 0; x<this.i; x++)
		{
			view.setArrayButtonLstnr(new ArrayButtonListener(), x);
			num[x] = x;
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemsUI itemView = new ItemsUI(view.getCustomerName());
			ItemsUIController control = new ItemsUIController(itemView);
			view.dispose();
		}
	}
	public class NextPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(true);
		}
	}
	public class BackPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(false);
		}
	}
	public class ArrayButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ViewingFrame detail = new ViewingFrame(view.getS(), view.getName());
			for (int x = 0; x < i; x++)
			{
				if (arg0.getSource() == view.getBut(x))
				{
					EarringController contRing = new EarringController(detail, model, num[x]);
				}
			}
			view.dispose();
			
		}
	}
	public class CompareListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			CompareView comp = new CompareView(view.getS(), view.getName());
			EarringCompareController cont = new EarringCompareController(comp, model);
			view.dispose();
		}
	}
	
}









PACKAGE: Controller			CLASS: ItemUIController
package controller;

import view.*;
import model.*;

import java.awt.event.*;

public class ItemsUIController 
{
	private ItemsUI itemUI
	public ItemsUIController(ItemsUI itemUI)
	{	this.itemUI = itemUI;
		itemUI.setBackLstnr(new BackListener(), new admnBackListener());
		itemUI.setRingLstnr(new RingListener());
		itemUI.setEarringLstnr(new EarringListener());
		itemUI.setBraceletLstnr(new BraceletListener());
		itemUI.setNecklaceLstnr(new NecklaceListener());
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			CustomerUI view = new CustomerUI();
			CustomerUIModel model = new CustomerUIModel();
			CustomerUIController controller = new CustomerUIController(view, model);
			itemUI.dispose();;
		}
	}
	public class admnBackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			AdminView Adminview = new AdminView();
			AdminViewController control1 = new AdminViewController(Adminview);
			itemUI.dispose();;
		}
	}
	public class RingListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI item = new ItemChooseUI(itemUI.getItemChoosed(), itemUI.getCustomerName());
			RingModel itemModel = new RingModel();
			RingItemController control = new RingItemController(item, itemModel);
			itemUI.dispose();
		}
	}
	public class BraceletListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI item = new ItemChooseUI(itemUI.getItemChoosed(), itemUI.getCustomerName());
			BraceletModel itemModel = new BraceletModel();
			BraceletItemController control = new BraceletItemController(item, itemModel);
			itemUI.dispose();
		}
	}
	public class NecklaceListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI item = new ItemChooseUI(itemUI.getItemChoosed(), itemUI.getCustomerName());
			NecklaceModel itemModel = new NecklaceModel();
			NecklaceItemController control = new NecklaceItemController(item, itemModel);
			itemUI.dispose();
		}
	}
	public class EarringListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI item = new ItemChooseUI(itemUI.getItemChoosed(), itemUI.getCustomerName());
			EarringModel itemModel = new EarringModel();
			EarringItemController control = new EarringItemController(item, itemModel);
			itemUI.dispose();
		}
	}
}
PACKAGE: Controller		CLASS: NecklaceCompareController
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RingCompareController.LComboBoxListener;
import view.*;
import model.*;

public class NecklaceCompareController 
{
	private CompareView view;
	private NecklaceModel model;
	private int noOfItems;
	private String cbox1, cbox2;
	
	public NecklaceCompareController(CompareView v, NecklaceModel m)
	{
		view = v;
		model = m;
		
		noOfItems = model.getNoOfItems();
		
		for (int x = 0; x < noOfItems; x++)
		{
			view.setComboBox(model.getCode(x));
		}
		
		view.setLComboBoxLstnr(new LComboBoxListener());
		view.setRComboBoxLstnr(new RComboBoxListener());
		view.setBackLstnr(new BackListener());
	}
	public class LComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox1 = view.getLComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox1 == model.getCode(x))
				{
					view.setLPicture(model.getImg(x));
					view.setLevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class RComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox2 = view.getRComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox2 == model.getCode(x))
				{
					view.setRPicture(model.getImg(x));
					view.setRevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI choose = new ItemChooseUI(view.getS(), view.getName());
			NecklaceItemController control = new NecklaceItemController(choose, model);
			view.dispose();
			
		}
	}
}









PACKAGE: Controller			CLASS: NecklaceController
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RingController.BackListener;
import view.*;
import model.*;

public class NecklaceController 
{
	private ViewingFrame view;
	private NecklaceModel model;
	private int i;
	private String code, price, info;
	private Image img;
	
	public NecklaceController(ViewingFrame v, NecklaceModel m, int i)
	{
		view = v;
		model = m;
		this.i = i;
		code = model.getCode(this.i);
		price = model.getPrice(this.i);
		info = model.getDescription(this.i);
		img = model.getImg(this.i);
		view.setImage(img);
		view.setEvrythng(code, price, info);
		view.setBackLstnr(new BackListener());
	}
	public class BackListener implements ActionListener
	{		@Override
		public void actionPerformed(ActionEvent arg0) {
			ItemChooseUI item = new ItemChooseUI(view.getS(), view.getName());
			NecklaceItemController control = new NecklaceItemController(item, model);
			view.dispose();
		}
	}
}

PACKAGE: Controller			CLASS: NecklaceItemController
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.NecklaceItemController.ArrayButtonListener;
import controller.NecklaceItemController.BackPanelListener;
import controller.NecklaceItemController.NextPanelListener;
import model.*;
import view.*;

public class NecklaceItemController 
{
	
	private NecklaceModel model;
	private ItemChooseUI view;
	private int i;
	private int[] num;
	
	public NecklaceItemController(ItemChooseUI i, NecklaceModel m)
	{
		model = m;
		view = i;
		
		this.i = model.getNoOfItems();
		view.setNoOfButs(model.getNoOfItems());
		for (int x = 0; x<this.i; x++)
		{
			view.setLabels(model.getCode(x), x);
			view.setArrayButtonImg(model.getImg(x), x);
		}
		view.setBackLstnr(new BackListener());
		view.setBackPanelLstnr(new BackPanelListener());
		view.setNextPanelLstnr(new NextPanelListener());
		view.setCompareLstnr(new CompareListener());
		num = new int[model.getNoOfItems()];
		
		for (int x = 0; x<this.i; x++)
		{
			view.setArrayButtonLstnr(new ArrayButtonListener(), x);
			num[x] = x;
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemsUI itemView = new ItemsUI(view.getCustomerName());
			ItemsUIController control = new ItemsUIController(itemView);
			view.dispose();
		}
	}
	public class NextPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(true);
		}
	}
	public class BackPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(false);
		}
	}
	public class ArrayButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			ViewingFrame detail = new ViewingFrame(view.getS(), view.getName());
			for (int x = 0; x < i; x++)
			{
				if (arg0.getSource() == view.getBut(x))
				{
					NecklaceController contRing = new NecklaceController(detail, model, num[x]);
				}
			}
			view.dispose();
			
		}
	}
	public class CompareListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			CompareView comp = new CompareView(view.getS(), view.getName());
			NecklaceCompareController cont = new NecklaceCompareController(comp, model);
			view.dispose();
		}
	}
	
}









PACKAGE: Controller			CLASS: RingCompareController
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;
import model.*;

public class RingCompareController 
{
	private CompareView view;
	private RingModel model;
	private int noOfItems;
	private String cbox1, cbox2;
	
	public RingCompareController(CompareView v, RingModel m)
	{
		view = v;
		model = m;
		
		noOfItems = model.getNoOfItems();
		
		for (int x = 0; x < noOfItems; x++)
		{
			view.setComboBox(model.getCode(x));
		}
		
		view.setLComboBoxLstnr(new LComboBoxListener());
		view.setRComboBoxLstnr(new RComboBoxListener());
		view.setBackLstnr(new BackListener());
	}
	public class LComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox1 = view.getLComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox1 == model.getCode(x))
				{
					view.setLPicture(model.getImg(x));
					view.setLevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class RComboBoxListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cbox2 = view.getRComboBox();
			for (int x = 0; x < noOfItems; x++)
			{
				if (cbox2 == model.getCode(x))
				{
					view.setRPicture(model.getImg(x));
					view.setRevrythng(model.getCode(x), model.getPrice(x), model.getDescription(x));
				}
			}
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemChooseUI choose = new ItemChooseUI(view.getS(), view.getName());
			RingItemController control = new RingItemController(choose, model);
			view.dispose();
			
		}
	}
}











PACKAGE: Controller			CLASS: RingController
package controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;
import model.*;

public class RingController 
{
	private ViewingFrame view;
	private RingModel model;
	private int i;
	private String code, price, info;
	private Image img;
	
	public RingController(ViewingFrame v, RingModel m, int i)
	{
		view = v;
		model = m;
		
		this.i = i;
		code = model.getCode(this.i);
		price = model.getPrice(this.i);
		info = model.getDescription(this.i);
		img = model.getImg(this.i);
		view.setImage(img);
		view.setEvrythng(code, price, info);
		
		view.setBackLstnr(new BackListener());
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ItemChooseUI item = new ItemChooseUI(view.getS(), view.getName());
			RingItemController control = new RingItemController(item, model);
			view.dispose();
		}	}}

PACKAGE: Controller			CLASS: RingItemController
package controller;

import java.awt.event.*;

import model.*;
import view.*;

public class RingItemController 
{
	private RingModel model;
	private ItemChooseUI view;
	private int i;
	private int[] num;
	
	public RingItemController(ItemChooseUI i, RingModel m)
	{
		model = m;
		view = i;
		
		this.i = model.getNoOfItems();
		view.setNoOfButs(model.getNoOfItems());
		for (int x = 0; x<this.i; x++)
		{
			view.setLabels(model.getCode(x), x);
			view.setArrayButtonImg(model.getImg(x), x);
		}
		view.setBackLstnr(new BackListener());
		view.setBackPanelLstnr(new BackPanelListener());
		view.setNextPanelLstnr(new NextPanelListener());
		view.setCompareLstnr(new CompareListener());
		num = new int[model.getNoOfItems()];
		for (int x = 0; x<this.i; x++)
		{
			view.setArrayButtonLstnr(new ArrayButtonListener(), x);
			num[x] = x;
		}
	}
	public class BackListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			ItemsUI itemView = new ItemsUI(view.getCustomerName());
			ItemsUIController control = new ItemsUIController(itemView);
			view.dispose();
		}
	}
	public class NextPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(true);
		}
	}
	public class BackPanelListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			view.setPanelVisibility(false);
		}
	}
	public class ArrayButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ViewingFrame detail = new ViewingFrame(view.getS(), view.getName());
			for (int x = 0; x < i; x++)
			{
				if (arg0.getSource() == view.getBut(x))
				{
					RingController contRing = new RingController(detail, model, num[x]);
				}			}
			view.dispose();
		}	}
	public class CompareListener implements ActionListener
	{		@Override
		public void actionPerformed(ActionEvent e) {
			CompareView comp = new CompareView(view.getS(), view.getName());
			RingCompareController cont = new RingCompareController(comp, model);
			view.dispose();
		}	}
}

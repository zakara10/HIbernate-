package com.hibernate.client;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.util.HibernateUtil;
import com.hibernate.model.*;

public class SwingClient extends JFrame implements ActionListener{
	Container cp;
	JLabel lbId,lbName,lbSal,lbJd;
	JTextField txtId,txtName,txtSal,txtJd;
	JButton btnSave,btnLoad,btnReset,btnDelete;
	
	public SwingClient(){
		cp=getContentPane();
		cp.setLayout(new GridLayout(6,2));
		
		lbId=new JLabel("Employee Id");
		lbName=new JLabel("Employee NAme");
		lbSal=new JLabel("Employee Salary");
		lbJd=new JLabel("Joining Date[yyyy-MM-dd]");
		
		txtId=new JTextField();
		txtName=new JTextField();
		txtSal=new JTextField();
		txtJd=new JTextField();
		
		btnSave=new JButton("Save");
		btnLoad=new JButton("Load");
		btnReset=new JButton("Reset");
		btnDelete=new JButton("Delete");
		
		cp.add(lbId);
		cp.add(txtId);
		cp.add(lbName);
		cp.add(txtName);
		cp.add(lbSal);
		cp.add(txtSal);
		cp.add(lbJd);
		cp.add(txtJd);
		cp.add(btnSave);
		cp.add(btnLoad);
		cp.add(btnReset);
		cp.add(btnDelete);
		
		
		btnLoad.addActionListener(this);
		btnSave.addActionListener(this);
		btnReset.addActionListener(this);
		btnDelete.addActionListener(this);
		
		
		
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SwingClient();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnReset){
			txtId.setText("");
			txtName.setText("");
			txtSal.setText("");
			txtJd.setText("");
		}
		if(e.getSource()==btnSave){
			//int eid=Integer.parseInt(txtId.getText());
			String ename=txtName.getText();
			double esal=Double.parseDouble(txtSal.getText());
			Date jd=java.sql.Date.valueOf(txtJd.getText());
			
			
				try {
					SessionFactory factory=HibernateUtil.obtainSessionFactory();
					Session session=factory.getCurrentSession();
					Transaction txn=session.beginTransaction();
					Employee emp=new Employee();
				//	emp.setEmpId(eid);
					emp.setEmpName(ename);
					emp.setEmpSalary(esal);
					emp.setJoiningDate(jd);
					
					session.save(emp);
					JOptionPane.showMessageDialog(this, "Record Saved!!");
					
					
					txn.commit();
				} catch (HibernateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
		}
		if(e.getSource()==btnLoad){
			try {
				int eid=Integer.parseInt(txtId.getText());
				SessionFactory factory=HibernateUtil.obtainSessionFactory();
				Session session=factory.getCurrentSession();
				Transaction txn=session.beginTransaction();
				Employee emp=(Employee) session.get(Employee.class, eid);
				if(emp!=null){
					txtName.setText(emp.getEmpName());
					txtSal.setText(""+emp.getEmpSalary());
					txtJd.setText(""+emp.getJoiningDate());
				}
				else{
					JOptionPane.showMessageDialog(this, "Record Not Found!!");
				}
				
				txn.commit();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}












package com.hibernate.client;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.model.Book;
import com.hibernate.util.HibernateUtil;

public class Client_Swing extends JFrame implements ActionListener{
	Container cp;
	JButton btnShow;
	JTable tb;
	
	public Client_Swing(){
		cp=getContentPane();
		cp.setLayout(new FlowLayout());
		
		btnShow=new JButton("Show");
		cp.add(btnShow);
		btnShow.addActionListener(this);
		
		//JTable design
		String[] columnNames={"Book Code","Book Title","Book Author","Book Price"};
		DefaultTableModel model=new DefaultTableModel(columnNames, 100);
		tb=new JTable(model);
		cp.add(new JScrollPane(tb));
		
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnShow){
			SessionFactory factory=HibernateUtil.obtainSessionFactory();
			Session session = factory.getCurrentSession();
			Transaction txn = session.beginTransaction();	//mandatory	
			Query q=session.createQuery("from Book b");
			List<Book> lst=q.list();
			Iterator<Book> itr=lst.iterator();
		//	tb.setValueAt("hello", 0, 0);
			
			int row=0,col=0;
			while(itr.hasNext()){
				Book b=itr.next();
				col=0;
				tb.setValueAt(b.getBookCode(), row, col++);
				tb.setValueAt(b.getTitle(), row, col++);
				tb.setValueAt(b.getAuthor(), row, col++);
				tb.setValueAt(b.getPrice(), row, col++);	
				row++;
			}
			
			txn.commit();
		}
		
	}
	
	public static void main(String[] args) {
		new Client_Swing();
	}


	

}

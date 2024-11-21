package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.Student_Swing;
import model.Student;

public class Uiview {
 protected static final Object[][] String = null;

public Uiview(){
	JFrame f= new JFrame("student");
	JLabel lb= new JLabel("Name:  ");
	lb.setBounds(50,40,100,40);
	JTextField tx=new JTextField();
    tx.setBounds(50, 80, 120, 40);
	JLabel lb1=new JLabel("Address:  ");
	lb1.setBounds(300, 40, 100, 40);
	JTextField tx1=new JTextField();
	tx1.setBounds(300, 80, 230, 80);
	JLabel lb2= new JLabel("Roll:  ");
	lb2.setBounds(600,40,120,40);
	JTextField tx2=new JTextField();
	tx2.setBounds(600,80,80,40);
    JButton b=new JButton("Insert");
    b.setBounds(50, 300, 80, 40);
    JButton b1=new JButton("Update");
    b1.setBounds(200,300, 80, 40);
    JButton b2=new JButton("Delete");
    b2.setBounds(350, 300, 80, 40);
    JButton b3=new JButton("Shows");
    b3.setBounds(500,300,80,40);
    JButton b4=new  JButton("Search");
    b4.setBounds(650, 300, 80, 40);
    
  
    
    b.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
				String name=tx.getText();
				String address=tx1.getText();
				int roll=Integer.parseInt(tx2.getText());
				
				Student s= new Student(roll,name,address);
				try{
					int a=new Student_Swing().insert(s);
					if(a>0)
					{
						JOptionPane.showMessageDialog(f, "Data inserted");
					}
				}
				catch(ClassNotFoundException  |  SQLException e1)
				{
					e1.printStackTrace();
				}
//				
			}	
    });
    b1.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
				String name=tx.getText();
				String address=tx1.getText();
	int roll=Integer.parseInt(tx2.getText());
				
				Student s= new Student(roll,name,address);
				try{
					int a=new Student_Swing().update(s);
					if(a>0)
					{
						JOptionPane.showMessageDialog(f, "Data Upadate");
					}
				}
				catch(ClassNotFoundException  |  SQLException e1)
				{
					e1.printStackTrace();
				}
			}	
    });
    b2.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
				int roll=Integer.parseInt(tx2.getText());
				Student s= new Student(roll);
				try{
					int a=new Student_Swing().delete(s);
					if(a>0)
					{
						JOptionPane.showMessageDialog(f, "Data Delete");
					}
				}
				catch(ClassNotFoundException  |  SQLException e1)
				{
					e1.printStackTrace();
				}
			}	
    });
    b3.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {
            try {
            	int len= new Student_Swing().len();
            	System.out.println(len);
                ResultSet rs = new Student_Swing().st();
                String[][] data = new String[len][3]; // Assuming max 10 rows for simplicity
                int row = 0;

                while (rs.next() && row < data.length) {
                    data[row][0] = rs.getString(1);
                    data[row][1] = rs.getString(2);
                    data[row][2] = rs.getString(3);
                    row++;
                }

                String[] column = {"Roll", "Name", "Address"};
                JTable jt = new JTable(data,column);
                jt.setBounds(25, 600, 700, 600);
                JScrollPane sp=new JScrollPane(jt);
                JScrollPane scrollableTextArea = new JScrollPane(jt);  
            
                f.add(sp);
                f.add(jt);
                // Ensure the frame refreshes to show the table
                
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
    });
    b4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent arg0) {
            try {
            	
            	int len= new Student_Swing().len();
            	System.out.println(len);
            	int roll=Integer.parseInt(tx2.getText());
				Student s= new Student(roll);
                ResultSet rs = new Student_Swing().st1(s);
                String[][] data = new String[len][3]; // Assuming max 10 rows for simplicity
                int row = 0;

                while (rs.next()) {
                    data[row][0] = rs.getString(1);
                    data[row][1] = rs.getString(2);
                    data[row][2] = rs.getString(3);
                    row++;
                }

                String[] column = {"Roll", "Name", "Address"};
                JTable jt = new JTable(data,column);
                jt.setBounds(25, 600, 700, 600);
                JScrollPane sp=new JScrollPane(jt);
           
                f.add(sp);
                f.add(jt);
                // Ensure the frame refreshes to show the table
                
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }	
    });
   
//	f.add(sp); 
    f.add(b4);
    f.add(b3);
    f.add(b2);
    f.add(b1);
    f.add(b);
	f.add(tx2);
	f.add(lb2);
	f.add(tx1);
	f.add(lb1);
	f.add(lb);	
	f.add(tx);
	f.setSize(800,1000);
	f.setLayout(null);
	f.setVisible(true);
	
}

 public static void main(String args[])
 {
 new Uiview();	
 }
}

package org.benary.java.school;

//import com.toedter.calendar.JDateChooserCellEditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import spesen.Spesen;

/**
 *
 * @author benaryorg
 */
public class Main
{

	public static void main(String... args)
	{
		final java.util.List<Spesen> list=new ArrayList<Spesen>();
		try
		{
			BufferedReader read=new BufferedReader(new InputStreamReader(new FileInputStream(new File("file.csv"))));
			String line;
			while((line=read.readLine())!=null)
			{
				Spesen s=Spesen.parse(line);
				if(s!=null)
				{
					list.add(s);
				}
			}
		}
		catch(IOException ex)
		{
		}

		final JFrame f=new JFrame();
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				try
				{
					PrintWriter write=new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("file.csv"))));
					for(Spesen s:list)
					{
						write.println(Spesen.print(s));
					}
				}
				catch(IOException ex)
				{
				}
			}
		});
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);

		f.setLayout(new BorderLayout());

		final MyTableModel tm=new MyTableModel();
		tm.add(list.toArray(new Spesen[0]));
		final JTable tab=new JTable(tm);
		tab.setDefaultEditor(Spesen.kategories(),new DefaultCellEditor(new JComboBox(Spesen.kategorievalues())));
		//tab.setDefaultEditor(Date.class,new JDateChooserCellEditor());
		tab.setDefaultRenderer(Double.class,new MyDoubleRenderer());
		JScrollPane pane=new JScrollPane(tab);
		f.add(pane,BorderLayout.CENTER);

		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout());
		f.add(panel,BorderLayout.SOUTH);

		final JLabel total=new JLabel();
		final Runnable update=new Runnable()
		{
			public void run()
			{
				total.setText(String.format("%.2f",tm.sum()));
			}
		};
		panel.add(total);

		tab.addPropertyChangeListener(new java.beans.PropertyChangeListener()
		{
			public void propertyChange(java.beans.PropertyChangeEvent evt)
			{
				update.run();
			}
		});

		JButton adda=new JButton("++");
		adda.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tm.add(Math.min(tab.getSelectedRow()+1,tm.getRowCount()),new Spesen());
				update.run();
			}
		});
		panel.add(adda);
		
		JButton addb=new JButton("+-");
		addb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tm.add(Math.max(tab.getSelectedRow(),0),new Spesen());
				update.run();
			}
		});
		panel.add(addb);

		JButton del=new JButton("-");
		del.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(tab.getSelectedRow()!=-1)
				{
					tm.remove(tab.getSelectedRow());
					update.run();
				}
			}
		});
		panel.add(del);

		f.pack();
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				f.setVisible(true);
			}
		});
	}
}


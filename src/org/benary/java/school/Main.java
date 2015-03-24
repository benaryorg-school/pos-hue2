package org.benary.java.school;

import com.toedter.calendar.JDateChooserCellEditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import spesen.Spesen;

/**
 *
 * @author benaryorg
 */
public class Main
{

	public static void main(String... args)
	{
		final JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);

		f.setLayout(new BorderLayout());

		final MyTableModel tm=new MyTableModel();
		JTable tab=new JTable(tm);
		TODO:tab.setDefaultEditor(Date.class,new JDateChooserCellEditor());
		JScrollPane pane=new JScrollPane(tab);
		f.add(pane,BorderLayout.CENTER);

		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout());
		f.add(panel,BorderLayout.SOUTH);

		JButton add=new JButton();
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				tm.add(new Spesen());
			}
		});
		panel.add(add);

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


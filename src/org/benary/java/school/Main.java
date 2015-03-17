package org.benary.java.school;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

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

		TableModel tm=new MyTableModel();
		JTable tab=new JTable(tm);
		f.add(tab,BorderLayout.CENTER);

		JPanel panel=new JPanel();

		JButton add=new JButton("xyz");
		add.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("click");
			}
		});
		f.add(add,BorderLayout.SOUTH);

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


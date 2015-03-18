package org.benary.java.school;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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


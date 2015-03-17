package org.benary.java.school.wow.what.is.that.strange.name.of.that.pkg.why.am.i.doing.those.horrible.things.like.writing.my.code.in.such.a.pkg.declaration;

import spesen.Spesen;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.event.TableModelListener;

/**
 *
 * @author benaryorg
 */
public class VeryPrivateAndEncapsulatedWindowClassWhichDoesOnlyContainAMainMethodBecauseIAmProgrammingCStyle
{

	public static void main(String... args)
	{
		final JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLocationRelativeTo(null);

		f.setLayout(new BorderLayout());

		TableModel tm=new AbstractTableModel()
		{
			//Java has no constructor initialisation of variables http://stackoverflow.com/questions/6822422/c-where-to-initialize-variables-in-constructor
			//FUCK JAVA
			List<Spesen> list=new ArrayList<Spesen>();

			public int getRowCount()
			{
				return this.list.size();
			}

			public int getColumnCount()
			{
				return 5;
			}

			/*public String getColumnName(int columnIndex)
			{
				//Java has no Internalisation. http://doc.qt.io/qt-5/internationalization.html
				//FUCK JAVA
				//return new String[]{""}[columnIndex];
				return "";
			}

			public Class<?> getColumnClass(int columnIndex)
			{
				//Java has no static variables in functions http://stackoverflow.com/questions/5033627/static-variable-inside-of-a-function-in-c
				//FUCK JAVA
				return new Class[]{Date.class,double.class,Spesen.kategories(),boolean.class,String.class}[columnIndex];
			}

			public boolean isCellEditable(int rowIndex,int columnIndex)
			{
				return true;
			}
*/
			public Object getValueAt(int rowIndex,int columnIndex)
			{
				//Java has no Operator Overloading http://courses.cms.caltech.edu/cs11/material/cpp/donnie/cpp-ops.html
				//FUCK JAVA
				return this.list.get(rowIndex).get(columnIndex);
			}
/*
			public void setValueAt(Object aValue,int rowIndex,int columnIndex)
			{
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}

			public void addTableModelListener(TableModelListener l)
			{
				super.addTableModelListener(l);
			}

			public void removeTableModelListener(TableModelListener l)
			{
				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
			}*/
		};
		//JTable tab=new JTable(tm);
		JTable tab=new JTable(new String[][]{{"uiae","uiae","eaiu","eaiu","dtrn"}},new Integer[]{1,2,3,4,5});
		f.add(tab,BorderLayout.CENTER);

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

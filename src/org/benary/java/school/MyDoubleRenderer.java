package org.benary.java.school;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class MyDoubleRenderer implements TableCellRenderer
{
	private DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();

	public Component getTableCellRendererComponent(JTable t,Object val,boolean sel,boolean focus,int row,int col)
	{
		JLabel l=(JLabel)dtcr.getTableCellRendererComponent(t,val,sel,focus,row,col);
		l.setText(String.format("%.2f",val));
		l.setHorizontalAlignment(4);
		return l;
	}
}


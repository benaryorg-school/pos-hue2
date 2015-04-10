package org.benary.java.school;

import spesen.Spesen;
import java.util.*;
import javax.swing.table.*;

public class MyTableModel extends AbstractTableModel
{
	//Java has no constructor initialisation of variables http://stackoverflow.com/questions/6822422/c-where-to-initialize-variables-in-constructor
	//FUCK JAVA
	private List<Spesen> list=new ArrayList<Spesen>();

	public void add(Spesen... s)
	{
		this.add(this.list.size(),s);
	}
	
	public void add(int i,Spesen... s)
	{
		this.list.addAll(i,Arrays.asList(s));
		fireTableRowsInserted(i,i+s.length-1);
	}
	
	public Collection<Spesen> list()
	{
		return new ArrayList(this.list);
	}

	public void remove(int i)
	{
		this.list.remove(i);
		fireTableRowsDeleted(i,i);
	}

	public int getRowCount()
	{
		return this.list.size();
	}

	public int getColumnCount()
	{
		return 5;
	}

	public String getColumnName(int columnIndex)
	{
		//Java has no Internalisation. http://doc.qt.io/qt-5/internationalization.html
		//FUCK JAVA
		//return new String[]{""}[columnIndex];
		return super.getColumnName(columnIndex);
	}

	public Class<?> getColumnClass(int columnIndex)
	{
		//Java has no static variables in functions http://stackoverflow.com/questions/5033627/static-variable-inside-of-a-function-in-c
		//FUCK JAVA
		return new Class[]{Date.class,Double.class,Spesen.kategories(),Boolean.class,String.class}[columnIndex];
	}

	public boolean isCellEditable(int rowIndex,int columnIndex)
	{
		return true;
	}

	public Object getValueAt(int rowIndex,int columnIndex)
	{
		//Java has no Operator Overloading http://courses.cms.caltech.edu/cs11/material/cpp/donnie/cpp-ops.html
		//FUCK JAVA
		return this.list.get(rowIndex).get(columnIndex);
	}

	public void setValueAt(Object aValue,int rowIndex,int columnIndex)
	{
		list.get(rowIndex).set(columnIndex,aValue);
	}

	public double sum()
	{
		double su=0;
		for(Spesen s:list)
		{
			su+=(Double)s.get(1);
		}
		return su;
	}
}


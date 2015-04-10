/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spesen;

import java.util.*;
import java.text.*;

/**
 *
 * @author reio
 */
public class Spesen
{

	// Innere Enum für die Kategorie
	enum Kategorie
	{

		REISEKOSTEN("Reisekosten"),
		HOTEL("Hotel"),
		ESSEN("Geschäftsessen"),
		ANDERE("Andere");

		private String bezeichnung;

		private Kategorie(String bezeichnung)
		{
			this.bezeichnung=bezeichnung;
		}

		@Override
		public String toString()
		{
			return bezeichnung;
		}
	}

	private Date datum;
	private double betrag;
	private Kategorie kategorie;
	private boolean genehmigt;
	private String beschreibung;

	public Spesen()
	{
		this(new Date(),0,Kategorie.ANDERE,false,"");
	}

	public Spesen(Date date,double price,Kategorie category,boolean accepted,String description)
	{
		this.datum=date;
		this.betrag=price;
		this.kategorie=category;
		this.genehmigt=accepted;
		this.beschreibung=description;
	}

	public static String print(Spesen s)
	{
		return new StringBuilder(new SimpleDateFormat("dd.MM.yyyy").format((Date)s.get(0)))
			.append(';').append(String.format("%.2f",s.get(1)).replace(",","."))
			.append(';').append(((Kategorie)s.get(2)).ordinal())
			.append(';').append((Boolean)s.get(3))
			.append(';').append((String)s.get(4)).append(' ')
			.toString();
	}

	public static Spesen parse(String s)
	{
		String[] f=s.split(";");
		if(f.length!=5)
		{
			return null;
		}
		try
		{
			return new Spesen(new SimpleDateFormat("dd.MM.yyyy").parse(f[0]),new Double(f[1]),Kategorie.values()[Integer.parseInt(f[2])],f[3].equals("true"),f[4].trim());
		}
		catch(NumberFormatException ex)
		{
			return null;
		}
		catch(ParseException ex)
		{
			return null;
		}
	}

	public static Class<?> kategories()
	{
		return Kategorie.class;
	}

	public static String[] kategorievalues()
	{
		List<String> l=new ArrayList<String>();
		for(Kategorie s:Kategorie.values())
		{
			l.add(s.toString());
		}
		return l.toArray(new String[0]);
	}

	public Object get(int col)
	{
		return new Object[]
		{
			this.datum,this.betrag,this.kategorie,this.genehmigt,this.beschreibung
		}[col];
	}

	public void set(int i,Object val)
	{
		switch(i)
		{
			case 0:
				this.datum=(Date)val;
				break;
			case 1:
				this.betrag=(Double)val;
				break;
			case 2:
				for(Kategorie k:Kategorie.values())
				{
					if(k.bezeichnung.equals(val))
					{
						this.kategorie=k;
						break;
					}
				}
				break;
			case 3:
				this.genehmigt=(Boolean)val;
				break;
			case 4:
				this.beschreibung=(String)val;
				break;
			//default:val=new String[]{}[1];break;//shorter than "throw new IndexOutOfBoundsException()"
		}
	}

	public void set(int i,String val)
	{
	}

	public static void main(String[] args)
	{
		Kategorie[] kats=Kategorie.values();
		for(Kategorie k:kats)
		{
			System.out.println(k.ordinal()+": "+k);
		}
	}
}

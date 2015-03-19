/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spesen;

import java.util.Date;

/**
 *
 * @author reio
 */
public class Spesen {
    
    // Innere Enum für die Kategorie
    enum Kategorie {
        REISEKOSTEN("Reisekosten"),
        HOTEL("Hotel"),
        ESSEN("Geschäftsessen"),
        ANDERE("Andere");
        
        private String bezeichnung;

        private Kategorie(String bezeichnung) {
            this.bezeichnung = bezeichnung;
        }

        @Override
        public String toString() {
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

	public static Class<?> kategories()
	{
		return Kategorie.class;
	}

	public Object get(int col)
	{
		return new Object[]{this.datum,this.betrag,this.kategorie,this.genehmigt,this.beschreibung}[col];
	}
    
	public void set(int i,Object val)
	{
		switch(i)
		{
			case 0:this.datum=(Date)val;break;
			case 1:this.betrag=(Double)val;break;
			case 2:this.kategorie=(Kategorie)val;break;
			case 3:this.genehmigt=(Boolean)val;break;
			case 4:this.beschreibung=(String)val;break;
			default:Object o=new Object[]{}[1];//shorter than "throw new IndexOutOfBoundsException()"
		}
	}
    
    public static void main(String[] args) {
        Kategorie []kats = Kategorie.values();
        for(Kategorie k : kats) {
            System.out.println(k.ordinal() + ": " + k);
        }
    }
}

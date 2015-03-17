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
    
	public static Class<?> kategories()
	{
		return Kategorie.class;
	}

	public Object get(int col)
	{
		return new Object[]{this.datum,this.betrag,this.kategorie,this.genehmigt,this.beschreibung}[col];
	}
    
    public static void main(String[] args) {
        Kategorie []kats = Kategorie.values();
        for(Kategorie k : kats) {
            System.out.println(k.ordinal() + ": " + k);
        }
    }
}

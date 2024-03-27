package application.WWM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class WWM
{
    private ArrayList<Frage> fragenKatalog = new ArrayList<Frage>();
    private ArrayList<Spiel> spielHistorie = new ArrayList<Spiel>();
    private Spiel aktuellesSpiel = null;
    
    public WWM(int anzahlZuGenerierenderTestFragen){
        if(anzahlZuGenerierenderTestFragen>0){
            
            int zufallszahlTitel,zufahllszahlFragenText, zufallsZahlStufe;
            int zuFallsZahlText;
            boolean zuFälligRichtigOderFalsch;
            
            for(int i=0;anzahlZuGenerierenderTestFragen>i;i++ ){
                
                zufallszahlTitel = Services.erzeugeZufallszahl(1000000,9000000);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                zufallsZahlStufe =  Services.erzeugeZufallszahl(1,15);
                Frage eineFrage = new Frage(new Integer(zufallszahlTitel).toString(),new Integer(zuFallsZahlText).toString(),new Stufe(zufallsZahlStufe));
                
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),true);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),false);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),false);
                zuFallsZahlText = Services.erzeugeZufallszahl(1000000,9000000);
                eineFrage.addAntwort(new Integer(zuFallsZahlText).toString(),false);
                
                fragenKatalog.add(eineFrage);
            }
            
            // Frage eineFrage = new Frage("Weltmeister","Wer war am häuigsten FIFA-Weltmeister?",3);
            // fragenKatalog.add(eineFrage);
            // eineFrage = new Frage("Hauptstadt","Wie heißt die Hauptstadt von Deutschland?",1);
            // fragenKatalog.add(eineFrage);
            // eineFrage = new Frage("Präsident","Welcher Präsident ist ein Berliner",5);
            // fragenKatalog.add(eineFrage);
            
            // erstelleSpiel();
        }
    }
    
    public WWM() throws ClassNotFoundException, SQLException{
        Services services = new Services();
        services.getFragenDB();
        for(int i=1 ; 15>=i ; i++){
            Stufe stufe = new Stufe(i);
            services.setRandomFrage(stufe.getGeld());
            
            Frage frage = new Frage("" + i, services.getCurrentFrage()[0], stufe);
            
            int rng1 = (int)(Math.random() * 4) + 1;
            int rng2 = (int)(Math.random() * 4) + 1;
            int rng3 = (int)(Math.random() * 4) + 1;
            int rng4 = (int)(Math.random() * 4) + 1;
            while (rng2==rng1) {
                rng2 = (int)(Math.random() * 4) + 1;
            }
            while (rng3==rng1 || rng3==rng2) {
                rng3 = (int)(Math.random() * 4) + 1;
            }
            while (rng4==rng1 || rng4==rng2 || rng4==rng3) {
                rng4 = (int)(Math.random() * 4) + 1;
            }
            
            for (int j=1 ; j<=4 ; j++) {
                if (rng1==j) {
                    frage.addAntwort(services.getCurrentFrage()[1], true);
                }
                else if (rng2==j) {
                    frage.addAntwort(services.getCurrentFrage()[2], false);
                }
                else if (rng3==j) {
                    frage.addAntwort(services.getCurrentFrage()[3], false);
                }
                else if (rng4==j) {
                    frage.addAntwort(services.getCurrentFrage()[4], false);
                }
            }
            
            fragenKatalog.add(frage);
        }
    }
    
    public void test(){
    	 Services services = new Services();
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:MySQL://localhost:3306/wmm_question";
			String user ="root";
			String pass ="";
			
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
			
			//ResultSet rs= st.executeQuery(query);
			//while(rs.next()) {
			//	System.out.println(rs.getString("Stufe"));
			
			
			
			for(int i=1; i<=15;i++) {
				Frage frage = null;
				
				Stufe stufe = new Stufe(i);
				services.setRandomFrage(stufe.getGeld());
				String query ="Select * from question Where Stufe="+i;
				ResultSet rs= st.executeQuery(query);
				
				while(rs.next()) {
					frage= new Frage(""+i, rs.getString("Frage"), stufe); 
				}
				 int rng1 = (int)(Math.random() * 4) + 1;
		            int rng2 = (int)(Math.random() * 4) + 1;
		            int rng3 = (int)(Math.random() * 4) + 1;
		            int rng4 = (int)(Math.random() * 4) + 1;
		            while (rng2==rng1) {
		                rng2 = (int)(Math.random() * 4) + 1;
		            }
		            while (rng3==rng1 || rng3==rng2) {
		                rng3 = (int)(Math.random() * 4) + 1;
		            }
		            while (rng4==rng1 || rng4==rng2 || rng4==rng3) {
		                rng4 = (int)(Math.random() * 4) + 1;
		            }
		            
		            for (int j=1 ; j<=4 ; j++) {
		                if (rng1==j) {
		                    frage.addAntwort(rs.getString("Richtige_Antwort"), true);
		                }
		                else if (rng2==j) {
		                    frage.addAntwort(rs.getString("Falsche_Antwort_1"), false);
		                }
		                else if (rng3==j) {
		                    frage.addAntwort(rs.getString("Falsche_Antwort_2"), false);
		                }
		                else if (rng4==j) {
		                    frage.addAntwort(rs.getString("Falsche_Antwort_3"), false);
		                }
		            }
		            
		            fragenKatalog.add(frage);
		        }
			
				
		}catch(Exception ex) {
			System.out.println("Error " + ex.getMessage());
		}
    }
    
    public void setFragenKatalog(ArrayList<Frage> fragenKatalog) {
        this.fragenKatalog = fragenKatalog;
    }
    public ArrayList<Frage> getFragenKatalog() {
        return this.fragenKatalog;
    }
    public void addFrageToFragenKatalog(Frage frage) {
        this.fragenKatalog.add(frage);
    }
    public void removeFrageFromFragenKatalog(Frage frage) {
        this.fragenKatalog.remove(frage);
    }
    public Frage getFrageFromFragenKatalog(int level) {
        for(Frage aktuelleFrage:fragenKatalog) {
            if(aktuelleFrage.getStufe().getLevel()==level && aktuelleFrage.getWurdeSchonMalBenutzt()==false ){
                //aktuelleFrage.setWurdeSchonMalBenutzt(true);
                return aktuelleFrage;
            }
        }
        return null;
    }
    public void resetFragenKatalog() {
        for (Frage aktuelleFrage : fragenKatalog) {
            aktuelleFrage.setWurdeSchonMalBenutzt(false);
        }
    }
    
    public void setSpielHistorie(ArrayList<Spiel> spielHistorie) {
        this.spielHistorie = spielHistorie;
    }
    public ArrayList<Spiel> getSpielHistorie() {
        return this.spielHistorie;
    }
    public void addSpielToSpielHistorie(Spiel spiel) {
        this.spielHistorie.add(spiel);
    }
    public void removeSpielfromSpielHistorie(Spiel spiel) {
        this.spielHistorie.remove(spiel);
    }
    
    public void setAktuellesSpiel(Spiel aktuellesSpiel) {
        this.aktuellesSpiel = aktuellesSpiel;
    }
    public Spiel getAktuellesSpiel() {
        return aktuellesSpiel;
    }
    
    public void erstelleSpiel(){
        Spiel einSpiel = new Spiel();
        int anzahlFragen = 15;
        for (int i=1; anzahlFragen>=i;i++){
            Frage eineFrage = getFrageFromFragenKatalog(i);
            if(eineFrage!=null){
                einSpiel.addFrage(eineFrage);
            }
        }
        aktuellesSpiel = einSpiel;
    }
}

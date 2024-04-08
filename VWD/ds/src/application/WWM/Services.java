package application.WWM;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Arrays;

public class Services
{
	int counter=0;
    private String[][] fragen;
    private String[] currFrage;
    
    public static int erzeugeZufallszahl(int min, int max){
         int zufallzahl = (int)(Math.random() * ((max - min) + 1)) + min;
         return zufallzahl;
    }
    
    public void leseFragen() {
        String line = "";
        fragen = new String[1][];
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/application/Fragen.csv"));
            int zeile = 0;
            
            while ((line = br.readLine()) != null) {
                String[] reihe = line.split(";");
                
                if (zeile >= fragen.length) {
                    fragen = Arrays.copyOf(fragen, zeile + 1);
                }
                
                fragen[zeile] = new String[reihe.length];
                for (int i=0 ; i<reihe.length ; i++) {
                    String tmp = reihe[i];
                    fragen[zeile][i] = tmp;
                }
                zeile++;
            }
        }
        catch (Exception e) {
            System.out.println("Fehler beim laden der Fragen");
            e.printStackTrace();
        }
    }
    
    public void getFragenDB() throws ClassNotFoundException, SQLException {
   	 fragen = new String[15][7];
   	Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:MySQL://localhost:3306/wmm";
		String user ="root";
		String pass ="";
		
		
		
		for(int i=0; i<16; i++) {
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement st = con.createStatement();
			String query ="Select * from question Where Stufe="+(i+1);
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				fragen[i][0]= rs.getString("Frage");
			}
			
		}	
		 
		for(int i=0; i<16; i++) {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
				String query ="Select * from question Where Stufe="+(i+1);
				ResultSet rs= st.executeQuery(query);
				while(rs.next()) {
					fragen[i][1]= rs.getString("Richtige_Antwort");
				}
				
				
			 
			}
		for(int i=0; i<16; i++) {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
				String query ="Select * from question Where Stufe="+(i+1);
				ResultSet rs= st.executeQuery(query);
				while(rs.next()) {
					fragen[i][2]= rs.getString("Falsche_Antwort_1");
				}
				
				
			 
			}
		for(int i=0; i<16; i++) {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
				String query ="Select * from question Where Stufe="+(i+1);
				ResultSet rs= st.executeQuery(query);
				while(rs.next()) {
					fragen[i][3]= rs.getString("Falsche_Antwort_2");
				}
				
				
			 
			}
		for(int i=0; i<16; i++) {
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();
				String query ="Select * from question Where Stufe="+(i+1);
				ResultSet rs= st.executeQuery(query);
				while(rs.next()) {
					fragen[i][4]= rs.getString("Falsche_Antwort_3");
				}
				
				
			 
			}for(int i=0; i<16; i++) {
				Connection con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
					String query ="Select * from question Where Stufe="+(i+1);
					ResultSet rs= st.executeQuery(query);
					while(rs.next()) {
						fragen[i][5]= rs.getString("Stufe");
					}
					
					
				 
				}
			for(int i=0; i<16; i++) {
				Connection con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
					String query ="Select * from question Where Stufe="+(i+1);
					ResultSet rs= st.executeQuery(query);
					while(rs.next()) {
						fragen[i][6]= rs.getString("Stufe_String");
					}
					
					
				 
				}
		
   }
    
    
    public void setRandomFrage(int stufe) {
        Random random = new Random();
        String stufeString = "" + stufe;
        int rng = random.nextInt(fragen.length);
        
        while (!fragen[rng][6].equals(stufeString)) {
            rng = random.nextInt(fragen.length);
        }
        
        currFrage = new String[fragen[0].length];
        for (int i=0 ; i<currFrage.length ; i++) {
            currFrage[i] = fragen[rng][i];
        }
    }
    
    public String[] getCurrentFrage() {
        return currFrage;
    }
}

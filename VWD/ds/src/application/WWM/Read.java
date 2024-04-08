package application.WWM;



import java.io.BufferedReader;  
import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileReader;  
import java.io.IOException;

public class Read {

public static void main(String[] args) {
    File file = new File("C:\\Users\\apost\\OneDrive - Stadt Hamm für Friedrich-List-Berufskolleg\\Schule\\MI2A12\\IFKT\\GUI\\WWMGUI\\src\\application\\WWM\\test.txt");
    System.out.print("Läuft!");
    try {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();

    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + file);
    } catch (IOException e) {
        System.out.println("Unable to read file: " + file);
    }

   }

 }
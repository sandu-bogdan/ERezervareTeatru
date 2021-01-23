package ERezervareTeatru;

import java.io.File; 
import java.io.IOException;
import java.io.FileWriter; 
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ticket {
    private String serie;
    private String nume;
    private String ora;
    private String data;
    private Boolean exist;
    
    ticket (String serie){
        this.serie = serie;
    }
    
    public String getSerie(){return serie;}
    
    
    public void generareTicket(String idNume, String idFilm, int loc, String data, String ora){
        serie = idNume + "-" + idFilm + "-" + loc;
       if(cautareTicket("Bilete.csv",serie)){  
       }
       else {
           scrieTicket(serie,data,ora);
           System.out.println("Ticket-ul a fost generat");
       }
    }
    
    //scrie ticket-ul intr-un fisier csv
    public void scrieTicket(String serie, String data, String ora){
        try
        {
            String filename= "Bilete.csv";
            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
            StringBuilder sb = new StringBuilder();
            sb.append(serie);
            sb.append(",");
            sb.append(data);
            sb.append(",");
            sb.append(ora);
            sb.append('\n');
            fw.write(sb.toString());//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    
    
    //cauta in fisierul csv
    public boolean cautareTicket(String fisier, String id) {
        try (Scanner scan = new Scanner(new File(fisier));){
            while(scan.hasNext()){
                String line = scan.nextLine().toLowerCase().toString();
                if(line.contains(id)){
                    String[] arrSplit = line.split(",");
                    System.out.println("Biletul exista, id: " + arrSplit[0] + " Data: " + arrSplit[1] + " Ora: " + arrSplit [2]);
                    exist = true;
                }
                else
                    exist = false;
            }
        } catch (FileNotFoundException e) {}   
        return exist;
    }
    

}

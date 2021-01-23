/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERezervareTeatru;

/**
 *
 * @author Bogdan
 */
public class Main {
    public static void main(String[] args) {

        ticket t = new ticket ("");
        
        //trebuie interfata grafica, asta e functia pentru generare ticket
        t.generareTicket("4", "2", 6,"12/12/2021","03:00");
        t.getSerie();
    }
    
}

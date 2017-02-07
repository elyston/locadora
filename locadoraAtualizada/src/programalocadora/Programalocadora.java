/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programalocadora;
import banco.*;
import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import jxl.write.WriteException;
/**
 *
 * @author elyston
 */
public class Programalocadora {

    
    /**
     * @param args the command line arguments 
     * @throws java.text.ParseException 
     */
    public static void main(String[] args) throws ParseException, IOException, WriteException{
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        sistema LOCADORA = new sistema("elyston", "788.476.212-91", "200 737", "95 3626 5002", "pricumã", "####", "#####", "123", "24/06/1984", 0);
        entrada C = new entrada();
        String dec;
        do {
            try {
                LOCADORA.LOGAR();
            } catch (IdadeMinimaException ex) {
                System.err.println(ex.getMessage());
            } catch (CodigoErradoException ex) {
                System.err.println(ex.getMessage());
            } catch (RestrictionException ex) {
                System.err.println(ex.getMessage());
            }
            System.out.print("digite SAIR para sair: ");
            dec = input.next();
        } while (!"SAIR".equals(dec));
    }
    
}

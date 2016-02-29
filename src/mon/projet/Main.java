/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mon.projet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Satellite
 */

public class Main {
     
public static ArrayList<ArrayList<Integer>> Incidence_matrix_bipartite=new ArrayList<ArrayList<Integer>>();
    static ArrayList<Integer> arrayVariable=new ArrayList<Integer>();
    static ArrayList<Integer> arrayContrainte=new ArrayList<Integer>();
    static ArrayList<Integer> Array=new ArrayList<Integer>();
    private static Object matrice;
public static void remplissage_matrix_incidence_bipartite(){
    //--------------------------------------------------------------------------------------------------------
//*************remplissage de la matrice d'incidence apartir d'un fichier texte********************************* 
    BufferedReader buf1=null;
    try {
String ligneDonnee=null;
if(ligneDonnee!=null){
}       boolean eof =false;
int n = 0;
StringTokenizer tokenizer = null;
        buf1 = new BufferedReader(new FileReader("matrix.txt"));
            try {
                ligneDonnee = buf1.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        if(ligneDonnee!=null){
            tokenizer = new StringTokenizer(ligneDonnee, " ");
            n=tokenizer.countTokens();
            for(int i=0;i<n;i++){
                String terme= tokenizer.nextToken();
                arrayVariable.add(Integer.parseInt(terme));
                
            }}
        while(eof!=true){
            Array=new ArrayList<Integer>();
            try {
                ligneDonnee = buf1.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(ligneDonnee!=null){
                tokenizer = new StringTokenizer(ligneDonnee, " ");
                n=tokenizer.countTokens();
                String terme= tokenizer.nextToken();
                arrayContrainte.add(Integer.parseInt(terme));
                for(int i=1;i<n;i++){
                    terme= tokenizer.nextToken();
                    Array.add(Integer.parseInt(terme));
                }
                
                Incidence_matrix_bipartite.add(Array);
                
            }else eof=true;}
       
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            buf1.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    
      
  
  
    public static void main(String[] args) {
     
        
        
   System.out.println("/*********************Matrice d'incidence d'un graphe biparti***************/");      
   remplissage_matrix_incidence_bipartite();
   
   for(int i=0;i<Incidence_matrix_bipartite.size();i++){
       for(int j=0;j<Incidence_matrix_bipartite.get(i).size();j++){
           System.out.print(Incidence_matrix_bipartite.get(i).get(j));
           System.out.print(" ");
       }
       System.out.println(" ");
   }
   
   Parcours bfs=new Parcours();
     
     
   }
    
}

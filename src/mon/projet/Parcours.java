/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mon.projet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static mon.projet.Main.Incidence_matrix_bipartite;
import org.omg.CORBA.SystemException;

/**
 *
 * @author Satellite
 */
public class Parcours {
static LinkedList<Integer> queue=new LinkedList<Integer>();  //create queue for bfs
static ArrayList<Integer> variableVisiter=new ArrayList<Integer>(); //create variable visiter for bfs
static int visitCount;
static int[] visitOrder;

    public Parcours() {
        int input;
        
        System.out.println("/***********Recherche d'un chemin entre deux sommets****************/");
        
        
        System.out.println("veuillez saisir la variable de sortie: ");
        
        
        Scanner sc= new Scanner(System.in);
        input= sc.nextInt();
        
        breadthFirstMatrixIterative(input);
        System.out.println(" BFS DE SE CHEMIN EST: ");
        
        
            
        
       
        
        
     }
    
     
    
 void initSearch ()
  {
    // IMPORTANT: all initializations will use "-1". We will test 
    // equality with "-1", so it's important not to change this cavalierly. 
    visitCount = -1;
    for (int i=0; i < variableVisiter.size(); i++) {
      visitOrder[i] = -1;
    }
  }
void breadthFirstMatrix ()
  {
    // 1. Initialize visit variables. 
    initSearch ();

    // 2. Create a queue. 
    queue = new LinkedList();

    // 3. Find an unvisited variable and apply breadth-first search to it. 
    //    variable: if the graph is connected, the call with i=0 will result 
    //          in visiting all variables. Nonetheless, we don't know this  
    //          in advance, so we need to march through all the variables. 

    for (int i=0; i < variableVisiter.size(); i++) {
      if (visitOrder[i] == -1) {
        // We call it "iterative" because depthFirst search is "recursive". 
        breadthFirstMatrixIterative (i);
      }
    } 
    
  }
    public static void breadthFirstMatrixIterative(int input)

    {
        
  // A fresh queue is used for a new breadth-first search.        
  queue.clear();
  
  // Start with the first variable: add of queue
  queue.addLast(new Integer(input));     
    
  while (! queue.isEmpty()) {

      // 3.1 Dequeue and extract variable
      Integer V = (Integer) queue.removeFirst();
      input = V.intValue();

      // 3.2 If the variable has been visited, skip. 
      if (visitOrder[input] != -1)
        continue;

      // 3.3 Otherwise, set its visit order. 
      visitCount++;
      visitOrder[input] = visitCount;

      // 3.4 Next, place its neighbors on the queue. 
      for (int i=0; i < variableVisiter.size(); i++) {
        // 3.4.1 First, check whether vertex i is a neighbor.
        if ( (Incidence_matrix_bipartite.get(input).get(i) > 0) && (i != input) ) {

          // 3.4.1.1 If i hasn't been visited, place in queue. 
          if (visitOrder[i] == -1) {
            queue.addLast (new Integer(i));
          }
        } 

      } // end-for 

    } // end-while 

  } 
    
   
     
    

   

   
   
}



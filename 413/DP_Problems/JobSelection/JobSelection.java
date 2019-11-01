/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Leetcode;

import java.util.ArrayList;

/**
 *
 * input: wages w1, w2, .... wn
 * goal: earn as much as possible
 * constraint: you cannot work 2 days in a row
 * return: indexes of jobs to work
 */
public class JobSelection {
    
    public static void JobSelection(int[] wages){
        
        ArrayList<Integer> optimal = GetOptimal(wages);
        PrintIndexes(optimal, wages, optimal.size() - 1);
        
    }
    
    public static void PrintIndexes(ArrayList<Integer> optimal, int[] wages, int i){
        if(i == 0) {
            System.out.print(i + " ");
            return;
        }
        if(i < 0) return;
        
        //if day before is equal to today, then it was optimal to work yesterday, so don't print this index, print yesterdays
        if(optimal.get(i - 1) == optimal.get(i)){
            PrintIndexes(optimal, wages, i - 1);
        }
        //else, day before is not equal to today, so it was optimal to work today, so print this index after printing the 2 days before index
        else{
            PrintIndexes(optimal, wages, i - 2);
            System.out.print(i + " ");
        }
           
        
        if(i == optimal.size() - 1)
        System.out.println("");
        

    }
    
    
    
    public static ArrayList<Integer> GetOptimal(int[] wages){
        ArrayList<Integer> optimal = new ArrayList<Integer>();
        
        if(wages.length == 0) return new ArrayList() {};
        if(wages.length == 1) return new ArrayList() {{add(wages[0]);}};
        
        if(wages.length >= 2){
            optimal.add(0, wages[0]);
            optimal.add(1, Math.max(wages[0], wages[1]));
        }
        
        for(int i = 2; i < wages.length; i++){
           if(optimal.get(i-2) + wages[i] > optimal.get(i - 1)){
               optimal.add(i,optimal.get(i-2) + wages[i]);
           }
           else{
               optimal.add(i, optimal.get(i-1));
           }
        }
        
        return optimal;
    }
    
    
    public static void main(String[] args){
        System.out.println("start");
      
        JobSelection(new int[]{4, 3, 2, 4, 1});
        JobSelection(new int[]{6, 9, 2, 1, 4, 5, 3});
        JobSelection(new int[]{6, 9, 2, 1, 4, 5, 3, 4});
        JobSelection(new int[]{6, 9, 2, 1, 4, 5, 3, 1});
        
        
        
    }
    
    
}

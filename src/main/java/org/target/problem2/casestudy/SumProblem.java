package org.target.problem2.casestudy;

import java.util.ArrayList;
import java.util.List;

public class SumProblem{
    
    private static int[] numbers ={6,5,4,7,4,2};
    private static int value =11;
    
    private static void sum(int i, int sum, List<Integer> list)
    {   
        for(int j = i+1; j<numbers.length; j++){
            if(sum+numbers[j] == value){
        	list.add(numbers[j]);
                System.out.println(list);
            }else{
        	List<Integer> innerList = new ArrayList<>(list);
        	innerList.add(numbers[j]);
                sum(j, sum+numbers[j],innerList);
            }
        }
    }

    public static void main(String[] args)
    {   
       
        for(int i =0; i<numbers.length; i++){
            List<Integer> list = new ArrayList<>();
            list.add(numbers[i]);
            sum( i, numbers[i],  list); 
        }

    }
}

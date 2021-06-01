package com.company;

import java.util.*;

public class Main {

    static final int HOW_MANY_NUMBERS = 5;
    static final int NUMBERS_OF_LOOP = 5; //1m

    public static void main(String[] args) {

        Map<Integer,Integer> mapNumbers = new TreeMap<>();

        fillInMap(mapNumbers);
        //PRINT THIS NUMBERS
        testMethod(mapNumbers);

    }

    //FILL IN MAP -> WITH RAND,NO
   private static void fillInMap(Map<Integer,Integer> mapNumbers) {
        int loopCount = 0;
       for(int i=0 ; i < NUMBERS_OF_LOOP; i++){
           loopCount++;
           int randomNumber = randomNumberGenerating();
           if(mapNumbers.containsKey(randomNumber)){
                    int valueCountAgain = mapNumbers.get(randomNumber);
                    mapNumbers.put(randomNumber,++valueCountAgain);
           }
           else {
               mapNumbers.put(randomNumber,1);
           }
       }

       System.out.println("LOOP COUNT : "+loopCount);

   }

   // GENERATING RANDOM NUMBERS
   private static int randomNumberGenerating() {
        int randomNumbers = ((int)(Math.random() * HOW_MANY_NUMBERS +1 ));
        return randomNumbers;

   }

    // PRINT
   private static void testMethod(Map<Integer,Integer> mapNumbers) {
        for( Map.Entry<Integer,Integer> numbers : mapNumbers.entrySet()){
            System.out.println("KEY : "+numbers.getKey()+" -> VAL : "+numbers.getValue());
        }
   }




}

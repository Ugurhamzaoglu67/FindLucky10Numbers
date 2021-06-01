package com.company;

import java.util.*;

public class Main {

    static final int HOW_MANY_NUMBERS = 100;
    static final int NUMBERS_OF_LOOP = 1000000; //1m
    static final int HOW_MANY_LUCKY_NUMBERS = 10;

    public static void main(String[] args) {

        Map<Integer,Integer> mapNumbers = new HashMap<>();
        List<Integer> createdNumberLists = new ArrayList<>();
        Set<Integer> luck10Numbers = new TreeSet<>();

        fillInMap(mapNumbers);
        printCreatedNumberLists(mapNumbers, createdNumberLists);

        findTenLuckyNumbers(luck10Numbers, createdNumberLists);

        System.out.println("List size : "+createdNumberLists.size());
        System.out.println("Map size : "+mapNumbers.size());
        System.out.println("Set size : "+luck10Numbers.size());




        //_____________________ LUCKY TEN NUMBERS ______________________
        System.out.println("\n************* LUCKY 10 NUMBERS ___________________");
        for(int temp : luck10Numbers){
            System.out.println("---"+temp +" -----");
        }



    }
    // FIND TEN LUCKY NUMBERS
    private static void findTenLuckyNumbers(Set<Integer> luck10Numbers, List<Integer> createdNumberLists) {
            Collections.shuffle(createdNumberLists);

            while(luck10Numbers.size() < HOW_MANY_LUCKY_NUMBERS ){
                int randomNums = ((int)(Math.random() * NUMBERS_OF_LOOP));
                luck10Numbers.add(createdNumberLists.get(randomNums));
            }
    }

    // PRINT CREATED NUMBER LISTS
    private static void printCreatedNumberLists(Map<Integer, Integer> mapNumbers, List<Integer> createdNumberLists) {
        for( Map.Entry<Integer,Integer> numbers : mapNumbers.entrySet()){
            int mykey = numbers.getKey();
            int myval = numbers.getValue();

            for(int i =0 ; i<myval ; i++){
                createdNumberLists.add(mykey);
            }
        }
    }


    //FILL IN MAP -> WITH RAND,NO
   private static void fillInMap(Map<Integer,Integer> mapNumbers) {

       for(int i=0 ; i < NUMBERS_OF_LOOP; i++){
           int randomNumber = randomNumberGenerating();
           if(mapNumbers.containsKey(randomNumber)){
                    int valueCountAgain = mapNumbers.get(randomNumber);
                    mapNumbers.put(randomNumber,++valueCountAgain);
           }
           else {
               mapNumbers.put(randomNumber,1);
           }
       }
   }


   // GENERATING RANDOM NUMBERS
   private static int randomNumberGenerating() {
        int randomNumbers = ((int)(Math.random() * HOW_MANY_NUMBERS +1 ));
        return randomNumbers;

   }




}

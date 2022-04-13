package com.example.ws.io.file.logicaltest;

import java.util.List;

public class BfiTestLogic {
    public static void main(String[] args) {
        int[] l = {10,15,3,7};
        System.out.println(maxPossibleSummary(l, 25));
    }

    public static int predatorGroup(List<Integer> predators) {
        Integer[] ints =  predators.toArray(new Integer[0]);
        int val = 1;
        int amountPredators = predators.size();
        for (Integer predator:predators) {
            int a = predators.indexOf(predator);
            int counter = 1;
            while (predator > -1 && predator < amountPredators && counter < amountPredators)
            {
                a = predator;
                counter++;
            }

            if (counter > val)
                val = counter;
        }
        return val;
    }

    public static boolean maxPossibleSummary(int[] array,int k){
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                if (array[i]+array[j]==k)
                    return true;
            }
        }
        return false;
    }
}

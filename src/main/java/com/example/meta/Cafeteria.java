package com.example.meta;

import java.util.Arrays;

public class Cafeteria {
    public static long getMaxAdditionalDinersCount(int N, int K, int M, int[] S) {
        Arrays.sort(S);
        int out=0;
        int space = 1+K;

        out+= ((S[0]-1)/space); // diners in front of first diner
        out+= ((N - (S[S.length-1]))/space); // diners after last diner

        for(int i=1;i<M;++i){
            int SpaceBetween = S[i] - S[i-1] - 1 - K;
            out+= ((Math.max(SpaceBetween,0))/space); // diners in between current and previous diner
        }
        return out;
    }
    public static void main(String[] args){
//        int[] s = {2,6};
//        System.out.println(getMaxAdditionalDinersCount(10,1,2,s));
//        int[] s = {11, 6, 14};
//        System.out.println(getMaxAdditionalDinersCount(15,2,3,s));
        int[] s = {5,10,14};
        System.out.println(getMaxAdditionalDinersCount(15,3,3,s));
    }
}




//
//Explaination:
//        My solution passed all 30 test cases. I broke it down by:
//
//        calculating number of guests that can be seated before the first diner
//        the number of guests that can be seated after the last diner
//        how many guests can be seated in between existing diners
//        If a diner is starting from a safe edge (start, end, or socially distanced position), we know that the space they require is 1+K (themself + social distance).
//        Using this space we can figure out how many diners can fit socially distancing themselves from each other.
//        We then proceed to use this logic to calculate the number of diners that fit before the first diner and after the last diner.
//        Finally, we need to calculate how many diners can fit in between each diner.
//
//        Feel free to skip this next session if all you want to see is the code. I wrote it to help people visualize the solution for calculating how many diners fit between two existing ones.
//        Envision an extreme example (15 seats, diners sitting at seats 1 and 15, and a K of 2):
//
//        [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15]
//        [x o o o o o o o o  o  o  o  o  o  x] // diners sitting at seats 1 and 15
//// We calculate how much free space we have [2,14] (or (1,15). This is done by 15 - 1 - 1.
//// As you may recall earlier, I wrote we can divide the space by (1+K) assuming we have a safe edge.
//// Since we know left (and right) has no buffer, we'll subtract the buffer (represented by underscores) size from the available space.
//        [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15]
//        [x _ _ o o o o o o  o  o  o  o  o  x]
//// The amount of room we have ends up being: 15 - 1 - 1 - K. We can now check how many diners can fit in this room by dividing it by (1 + K).
//        [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15] // Visual representation of the solution where:
//        [x _ _ x _ _ x _ _  x  _  _  o  o  x] // 'x' represents a sitting diner including those from S
//        // '_' represents the empty seats due to social distancing (K)
//        // 'o' are empty seats we don't touch because there wasn't enough room.
//        To calculate how many empty seats we have between the two diners, we subtract the seat indices 15 - 1 and subtract an additional 1 since we want to exclude 15.
//        We're calculating [2,14] or (1,15) whichever is easier for you to think about.
//        Once we know how much room exists between two diners we can divide it by the amount of space a diner needs and add that to our answer.
package com.example.dicecalculator;

import java.util.*;

/**
 * Created by walkmaster on 2/6/14.
 */
public class DiceRoll {

    int randD; // maximum size of die. 0 for
    int randR; // number of times in which a die must be rolled

    private Random rand = new Random();

    char[] textStr;
    int[] sumTrl; // a list explicitly used to keep track of all results

    public int randomGen(int r, int d)
    {
        int x = 0;

        for(int i = 0; i != r; i++) {
            x += rand.nextInt(d) + 1; // nextInt(range) + minimum
        }
        return x;
    }

}

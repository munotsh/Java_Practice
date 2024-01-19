package com.example.allPracticeProgram.uber.copy;

import java.util.*;

class Test 
{
static class pair
{ 
    int first, second; 
    public pair(int first, int second) 
    { 
        this.first = first; 
        this.second = second; 
    } 
} 
  
static boolean checkCheckMate(pair a[], int n,
                              int kx, int ky)
{
  
    // Pair of hash to mark the coordinates
    HashMap<pair, 
            Integer> mpp = new HashMap<pair, 
                                       Integer>();
  
    // iterate for Given N knights
    for (int i = 0; i < n; i++) 
    {
        int x = a[i].first;
        int y = a[i].second;
  
        // mark all the "L" shaped coordinates
        // that can be reached by a Knight
  
        // initial position
        mpp.put(new pair( x, y ), 1);
  
        // 1-st move
        mpp.put(new pair( x - 2, y + 1 ), 1);
  
        // 2-nd move
        mpp.put(new pair( x - 2, y - 1 ), 1);
  
        // 3-rd move
        mpp.put(new pair( x + 1, y + 2 ), 1);
  
        // 4-th move
        mpp.put(new pair( x + 1, y - 2 ), 1);
  
        // 5-th move
        mpp.put(new pair( x - 1, y + 2 ), 1);
  
        // 6-th move
        mpp.put(new pair( x + 2, y + 1 ), 1);
  
        // 7-th move
        mpp.put(new pair( x + 2, y - 1 ), 1);
  
        // 8-th move
        mpp.put(new pair( x - 1, y - 2 ), 1);
    }
  
    // iterate for all possible 8 coordinates
    for (int i = -1; i < 2; i++) 
    {
        for (int j = -1; j < 2; j++) 
        {
            int nx = kx + i;
            int ny = ky + j;
            if (i != 0 && j != 0)
            {
  
                // check a move can be made or not
                pair p =new pair(nx, ny );
                if (mpp.get(p) != null)
                {
                    return true;
                }
            }
        }
    }
  
    // any moves
    return false;
}
  
// Driver Code
public static void main(String[] args) 
{
    pair a[] = {new pair( 1, 0 ), new pair( 0, 2 ), 
                new pair( 2, 5 ), new pair( 4, 4 ), 
                new pair( 5, 0 ), new pair( 6, 2 )};
  
    int n = a.length;
  
    int x = 3, y = 2;
    if (checkCheckMate(a, n, x, y))
        System.out.println("Not Checkmate!");
    else
        System.out.println("Yes its checkmate!");
    }
}
  
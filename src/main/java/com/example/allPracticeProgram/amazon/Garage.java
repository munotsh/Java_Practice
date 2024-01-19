package com.example.allPracticeProgram.amazon;

import java.util.HashMap;

public class Garage {
	
	HashMap<Integer, Integer>capacityMp= new HashMap<Integer, Integer>();
	HashMap<Integer, Integer>ticketMp= new HashMap<Integer, Integer>();
    int ticket;

    Garage(int s,int m,int l){
    	capacityMp.put(0, s);
    	capacityMp.put(1, m);
    	capacityMp.put(2, l);
    }
    
    public int arrival(int bay) {
    	if(capacityMp.isEmpty()) return -1;
    	capacityMp.remove(bay);
    	++ticket;
    	ticketMp.put(ticket, bay);
    	return ticket;
    	
    }
    void depart( int id )
    {
        if( ticketMp.isEmpty()  ) return;
        int baySize = ticketMp.get(id);
        capacityMp.put(id, capacityMp.get(id)+1);
        ticketMp.remove(id);
    }
    
    public static void main(String[] args) {
    	Garage g= new Garage(1, 1, 2);
    	System.out.println(g.arrival(0));
    	System.out.println(g.arrival(2));
    	System.out.println(g.arrival(1));
    	System.out.println(g.arrival(2));
    	System.out.println(g.arrival(1));
    	g.depart(3);
    	System.out.println(g.arrival(1));
    	
    }
}

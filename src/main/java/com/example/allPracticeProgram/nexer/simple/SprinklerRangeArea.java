package com.example.allPracticeProgram.nexer.simple;

public class SprinklerRangeArea {
	int xCord;
    int yCord;
    int range;
    float maxy;
    float miny;
    
    SprinklerRangeArea(int xCord, int yCord, int range){
        this.xCord = xCord;
        this.yCord = yCord;
        this.range = range;
        this.miny = this.yCord - range;
        this.maxy = this.yCord + range;
    }
}

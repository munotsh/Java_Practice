package com.example.allPracticeProgram.nexer;

public class Circle1 {
	int h;
    int k;
    int r;
    float maxy;
    float miny;
    
    Circle1(int h, int k, int r){
        this.h = h;
        this.k = k;
        this.r = r;
        this.miny = this.k - r;
        this.maxy = this.k + r;
    }
}

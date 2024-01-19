package com.example.allPracticeProgram.nexer.simple1;

public class SprinklerRangeArea {
	int xCord;
    int yCord;
    int range;
//    float maxy;
//    float miny;
    
    SprinklerRangeArea(int xCord, int yCord, int range){
        this.xCord = xCord;
        this.yCord = yCord;
        this.range = range;
//        this.miny = this.yCord - range;
//        this.maxy = this.yCord + range;
    }
    
    public final boolean iswet(tangible.Pair<Float,Float> p)
	{
		if (Math.pow(this.r - 0.001, 2) > (Math.pow(p.first - this.h, 2) + Math.pow(p.second - this.k, 2)))
		{
			this.closest_pair(p);
			return true;
		}
		else
		{
			return false;
		}
	}

	public final void closest_pair(tangible.Pair<Float,Float> p)
	{
			float vx = p.first - this.h;
			float vy = p.second - this.k;
			float magv = Math.sqrt(vx * vx + vy * vy);
			p.first = this.h + vx / magv * this.r;
			p.second = this.k + vy / magv * this.r;
	}
}


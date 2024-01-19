package com.example.allPracticeProgram.nexer.simple1;

import java.util.List;

public class Circle {
	int h;
	int k;
	int r;
	float maxy;
	float miny;

	Circle(int h, int k, int r) {
		this.h = h;
		this.k = k;
		this.r = r;
		this.miny = this.k - r;
		this.maxy = this.k + r;
	}

//    bool iswet(pair<float,float>* p){
//        if (pow(this->r - 0.001, 2)  > (pow(p->first - this->h, 2) + pow(p->second - this->k, 2) ) ) {
//            this->closest_pair(p);
//            return true; 
//        }
//        else
//            return false;
//    };

	public boolean isWet(pair_hash ph) {
		if (Math.pow(this.r - 0.001, 2) > (Math.pow(ph.key - this.h, 2) + Math.pow(ph.value - this.k, 2))) {
			this.closest_pair(ph);
			return true;
		} else
			return false;
	}

//    void closest_pair(pair<float,float>* p){
//        float vx = p->first - this->h;
//        float vy = p->second - this->k; 
//        float magv = sqrt(vx * vx + vy * vy); 
//        p->first = this->h + vx / magv * this->r;
//        p->second = this->k + vy / magv * this->r;
//}

	private void closest_pair(pair_hash ph) {
		double vx = ph.key - this.h;
		double vy = ph.value - this.k;
		double magv = Math.sqrt(vx * vx + vy * vy);
		ph.key = this.h + vx / magv * this.r;
		ph.value = this.k + vy / magv * this.r;

	}
	
	
	
}

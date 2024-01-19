package com.example.allPracticeProgram.nexer.simple1;

import java.util.ArrayList;

public class EvaluateArea {


	public float maxy = -1F;
	public float miny = -1F;
	public ArrayList<SprinklerRangeArea> circles = new ArrayList<SprinklerRangeArea>();
	public float upper_endy = -1F;
	public float upper_starty = -1F;
	public float lower_endy = -1F;
	public float lower_starty = -1F;



	public final void add_circle(SprinklerRangeArea c)
	{

		if ((c.maxy > this.maxy) || this.circles.isEmpty())
		{
			this.maxy = c.maxy;
		}
		if ((c.miny < this.miny) || this.circles.isEmpty())
		{
			this.miny = c.miny;
		}
		this.circles.add(c);

		float root = (float) Math.sqrt(Math.pow(c.range, 2) - Math.pow(problemC.MINX - c.xCord, 2));
		float y1 = root + c.yCord;
		float y2 = -root + c.yCord;

		if (y1 > this.upper_starty)
		{
			this.upper_starty = y1;
		}
		if (y2 > this.lower_starty)
		{
			this.lower_starty = y2;
		}

		root = (float) Math.sqrt(Math.pow(c.range, 2) - Math.pow(problemC.MAXX - c.xCord, 2));
		y1 = root + c.yCord;
		y2 = -root + c.yCord;
		if (y1 > this.upper_endy)
		{
			this.upper_endy = y1;
		}
		if (y2 > this.lower_endy)
		{
			this.lower_endy = y2;
		}

	}
	public final boolean is_intersect(SprinklerRangeArea c1)
	{
		boolean flagIntersect = false;
		for (SprinklerRangeArea c2 : circles)
		{
			float dist = (float) (Math.sqrt(Math.pow(c1.xCord - c2.xCord,2)) + Math.sqrt(Math.pow(c1.yCord - c2.yCord,2)));
			flagIntersect = (dist < (c1.range + c2.range)) ? true : false;
		}
		return flagIntersect;
	}

}

package edu.pnu.sfcgal;

import edu.pnu.sfcgal.Algorithm;
import edu.pnu.sfcgal.Geometry;
import edu.pnu.sfcgal.LineString;
import edu.pnu.sfcgal.Point;
import edu.pnu.sfcgal.Polygon;
import edu.pnu.sfcgal.Solid;

//import org.bytedeco.sfcgal.SFCGAL.Coordinate;
public class testSFCGAL{
	public static void test() {
		Geometry p = Algorithm.getPoints(1).get(0);
		Point point = (Point) p;
		
		Geometry ls = Algorithm.getLineStrings(1).get(0);
		LineString lineString = (LineString) ls;
		
		Geometry poly = Algorithm.getPolygons(1).get(1);
		Polygon polygon = (Polygon) poly;
		
		Geometry sol = Algorithm.getSolids().get(0);
		Geometry sol1 = Algorithm.getSolids().get(1);
		Geometry sol2 = Algorithm.getSolids().get(2);
		System.out.println(sol.asText(0));
		System.out.println(sol2.asText(0));
		
		Geometry intersection = Algorithm.intersection3D(sol, lineString);
		System.out.println(intersection.asText(0));
		Solid solid = (Solid) sol;
		LineString inter = new LineString(intersection);
		
		Geometry convexhull = Algorithm.convexHull3D(polygon);
		System.out.println(convexhull.asText(0));
		
		intersection = Algorithm.intersection3D(sol, sol2);
		System.out.println(intersection.asText(0));
		
		intersection = Algorithm.intersection3D(sol1, point);
		System.out.println(intersection.asText(0));
		System.out.println(intersection.isEmpty());
		
		intersection = Algorithm.intersection3D(((Solid)sol1).exteriorShell(), point);
		System.out.println(intersection.asText(0));
		System.out.println(intersection.isEmpty());
		
		Point p2 = new Point(5, -1, 1);
		intersection = Algorithm.intersection3D(((Solid)sol1).exteriorShell(), p2);
		System.out.println(sol1.asText(0));
		System.out.println(intersection.asText(0));
		System.out.println(intersection.isEmpty());
		
	}
	
    public static void main(String[] args) {
    	//Algorithm.test2D();
    	//Algorithm.test3D();
    	
    	test();
    }	
}

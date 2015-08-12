package edu.pnu.sfcgal;

import java.util.ArrayList;

import edu.pnu.sfcgal.Algorithm;
import edu.pnu.sfcgal.Geometry;
import edu.pnu.sfcgal.LineString;
import edu.pnu.sfcgal.Point;
import edu.pnu.sfcgal.Polygon;
import edu.pnu.sfcgal.PolyhedralSurface;
import edu.pnu.sfcgal.Solid;

public class intersectionTest {
	public static void lineStringTest() {
		Solid solid = Algorithm.getSolids().get(0);
		PolyhedralSurface exterior = solid.exteriorShell();
		Geometry interior;
		Geometry boundary;
		
		Point p1 = new Point(-2,-1,2);
		Point p2 = new Point(0.5,-1,2);
		Point p3 = new Point(1,-1,2);
		Point p4 = new Point(1.5,-1,2);
		Point p5 = new Point(2,-1,2);
		Point p6 = new Point(4,-1,2);
		Point p7 = new Point(2,-1,1);
		Point p8 = new Point(4,-1,1);
		Point p9 = new Point(0,-1,1);
		Point p10 = new Point(0.5,-1,1);
		Point p11 = new Point(1,-1,1);
		Point p12 = new Point(1.5,-1,1);
		
		LineString ls1 = new LineString();
		LineString ls2 = new LineString();
		LineString ls3 = new LineString();
		LineString ls4 = new LineString();
		LineString ls5 = new LineString();
		LineString ls6 = new LineString();
		LineString ls7 = new LineString();
		LineString ls8 = new LineString();
		LineString ls9 = new LineString();
		LineString ls10 = new LineString();
		
		ls1.addPoint(p7);
		ls1.addPoint(p8);
		
		ls2.addPoint(p2);
		ls2.addPoint(p4);
		
		ls3.addPoint(p2);
		ls3.addPoint(p6);
		
		ls4.addPoint(p2);
		ls4.addPoint(p5);
		ls4.addPoint(p7);
		
		ls5.addPoint(p1);
		ls5.addPoint(p6);
		
		ls6.addPoint(p1);
		ls6.addPoint(p3);
		ls6.addPoint(p6);
		
		ls7.addPoint(p9);
		ls7.addPoint(p12);
		
		ls8.addPoint(p9);
		ls8.addPoint(p7);
		
		ls9.addPoint(p10);
		ls9.addPoint(p12);
		
		ls10.addPoint(p10);
		ls10.addPoint(p2);
		ls10.addPoint(p4);
		ls10.addPoint(p12);
		
		System.out.println(solid.asText(1));
		System.out.println(exterior.asText(1));
		
		System.out.println("----------------------------");
		System.out.println("ls1 : " + ls1.asText(1));
		test(solid, exterior, ls1);
		System.out.println("----------------------------");
		System.out.println("ls2 : " + ls2.asText(1));
		test(solid, exterior, ls2);
		System.out.println("----------------------------");
		System.out.println("ls3 : " + ls3.asText(1));
		test(solid, exterior, ls3);
		System.out.println("----------------------------");
		System.out.println("ls4 : " + ls4.asText(1));
		test(solid, exterior, ls4);
		System.out.println("----------------------------");
		System.out.println("ls5 : " + ls5.asText(1));
		test(solid, exterior, ls5);
		System.out.println("----------------------------");
		System.out.println("ls6 : " + ls6.asText(1));
		test(solid, exterior, ls6);
		System.out.println("----------------------------");
		System.out.println("ls7 : " + ls7.asText(1));
		test(solid, exterior, ls7);
		System.out.println("----------------------------");
		System.out.println("ls8 : " + ls8.asText(1));
		test(solid, exterior, ls8);
		System.out.println("----------------------------");
		System.out.println("ls9 : " + ls9.asText(1));
		test(solid, exterior, ls9);
		System.out.println("----------------------------");
		System.out.println("ls10 : " + ls10.asText(1));
		test(solid, exterior, ls10);
		
		interior = Algorithm.intersection3D(solid, ls8);
		boundary = Algorithm.intersection3D(exterior, ls8);
		System.out.println("equals : " + interior.equals(boundary));
		
		Polygon polygon = exterior.polygonN(2);
		System.out.println(Algorithm.intersection3D(solid, ls3).asText(1));
	}
	
	public static void polygonTest() {
		Solid solid = Algorithm.getSolids().get(0);
		
		Point p4 = new Point(0.5, -1.5, 2);
		Point p6 = new Point(2, -1.5, 2);
		Point p23 = new Point(2, -1.5, 0.5);
		Point p24 = new Point(2, -0.5, 0.5);
		Point p9 = new Point(2, -0.5, 2);
		Point p7 = new Point(0.5, -0.5, 2);
		
		ArrayList<Point> positions4 = new ArrayList<Point>();
		positions4.add(p4);
		positions4.add(p6);
		positions4.add(p23);
		positions4.add(p24);
		positions4.add(p9);
		positions4.add(p7);
		positions4.add(p4);
		LineString exteriorRing = new LineString(positions4);
		Polygon polygon = new Polygon(exteriorRing);
		ArrayList<Polygon> polygons = new ArrayList<Polygon>();
		polygons.add(polygon);
		PolyhedralSurface polyhedral = new PolyhedralSurface(polygons);
		
		Geometry intersection = Algorithm.intersection3D(solid, polyhedral);
		System.out.println(intersection.asText(1));
	}
	
	public static void test(Solid solid, PolyhedralSurface exterior, Geometry g) {
		Geometry interior;
		Geometry boundary;
		
		interior = Algorithm.intersection3D(solid, g);
		boundary = Algorithm.intersection3D(exterior, g);
		
		System.out.println(interior.asText(1));
		System.out.println(boundary.asText(1));
	}
	
	public static void main(String[] args) {
		//lineStringTest();
		polygonTest();
	}
}

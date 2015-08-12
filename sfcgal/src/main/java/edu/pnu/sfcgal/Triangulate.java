package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include="Triangulate.h")
public class Triangulate {
	static { Loader.load(); }
	
	public static native void triangulatePolygon3D(@ByRef Geometry g, @ByRef TriangulatedSurface triangulateSurface);
	
	public static void testTriangulate() {
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
		
		TriangulatedSurface triangulatedSurface = new TriangulatedSurface();
		triangulatePolygon3D(polygon, triangulatedSurface);
		System.out.println(triangulatedSurface.asText(1));
		/*
		PolyhedralSurface polyhedral = new PolyhedralSurface(polygons);
		
		Geometry intersection = Algorithm.intersection3D(solid, polyhedral);
		System.out.println(intersection.asText(1));
		*/
	}
	
	public static void main(String[] args) {
		testTriangulate();
	}
}

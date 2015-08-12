package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include="Algorithm.h")
public class Algorithm {
    static { Loader.load(); }

    public static native double area(@ByRef Geometry g);
    public static native double area3D(@ByRef Geometry g);
    public static native @ByRef Geometry convexHull(@ByRef Geometry g); 
    public static native @ByRef Geometry convexHull3D(@ByRef Geometry g);
    public static native @Cast("bool") boolean covers(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @Cast("bool") boolean covers3D(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @ByRef Geometry difference(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @ByRef Geometry difference3D(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native double distance(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native double distance3D(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @ByRef Geometry extrude(@ByRef Geometry g, double dx, double dy, double dz);
    public static native @ByRef Geometry intersection(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @ByRef Geometry intersection3D(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @Cast("bool") boolean intersects(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @Cast("bool") boolean intersects3D(@ByRef Geometry gA, @ByRef Geometry gB);
    //public static Validity isValid(Geometry g) { return isValid(g, 1e-9); }
    //public static native Validity isValid(@ByRef Geometry g, double toleranceAbs);
    public static native @ByRef Geometry minkowskiSum(@ByRef Geometry g, @ByRef Polygon polygon);
    public static native @ByRef MultiPolygon offset(@ByRef Geometry g, double r);
    public static native @Cast("bool") boolean hasPlane3D(@ByRef Polygon polygon);
    public static MultiLineString straightSkeleton(Geometry g) { return straightSkeleton(g, true); } 
    public static native @ByRef MultiLineString straightSkeleton(@ByRef Geometry g, @Cast("bool") boolean autoOrientation);
    public static native @ByRef Geometry tesselate(@ByRef Geometry g);
    public static native @ByRef Geometry union_(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native @ByRef Geometry union3D(@ByRef Geometry gA, @ByRef Geometry gB);
    public static native double volume(@ByRef Geometry g);
    
    public static ArrayList<Point> getPoints(int type){
    	Point p1 = new Point(0, 0, 0);
    	Point p2 = new Point(0, -2, 0);
    	Point p3 = new Point(2, -2, 0);    	
    	Point p4 = new Point(2, 0, 0);
    	Point p5 = new Point(0, 0, 2);
    	Point p6 = new Point(0, -2, 2);
    	Point p7 = new Point(2, -2, 2);
    	Point p8 = new Point(2, 0, 2);
    	
    	ArrayList<Point> points1 = new ArrayList<Point>();
    	points1.add(p1);
    	points1.add(p2);
    	points1.add(p3);
    	points1.add(p4);
    	points1.add(p5);
    	points1.add(p6);
    	points1.add(p7);
    	points1.add(p8);
    	
    	//
    	Point p11 = new Point(4, 0, 0);
    	Point p12 = new Point(4, -2, 0);
    	Point p13 = new Point(6, -2, 0);    	
    	Point p14 = new Point(6, 0, 0);
    	Point p15 = new Point(4, 0, 2);
    	Point p16 = new Point(4, -2, 2);
    	Point p17 = new Point(6, -2, 2);
    	Point p18 = new Point(6, 0, 2);
    	
    	ArrayList<Point> points2 = new ArrayList<Point>();
    	points2.add(p11);
    	points2.add(p12);
    	points2.add(p13);
    	points2.add(p14);
    	points2.add(p15);
    	points2.add(p16);
    	points2.add(p17);
    	points2.add(p18);
    	
    	//
    	Point p19 = new Point(5, 0, 0);
    	Point p20 = new Point(5, -2, 0);
    	Point p21 = new Point(7, -2, 0);    	
    	Point p22 = new Point(7, 0, 0);
    	Point p23 = new Point(5, 0, 1);
    	Point p24 = new Point(5, -2, 1);
    	Point p25 = new Point(7, -2, 1);
    	Point p26 = new Point(7, 0, 1);
    	
    	ArrayList<Point> points3 = new ArrayList<Point>();
    	points3.add(p19);
    	points3.add(p20);
    	points3.add(p21);
    	points3.add(p22);
    	points3.add(p23);
    	points3.add(p24);
    	points3.add(p25);
    	points3.add(p26);
    	
    	Point p27 = new Point(2, 0, 0);
    	Point p28 = new Point(2, -2, 0);
    	Point p29 = new Point(4, -2, 0);    	
    	Point p30 = new Point(4, 0, 0);
    	Point p31 = new Point(2, 0, 2);
    	Point p32 = new Point(2, -2, 2);
    	Point p33 = new Point(4, -2, 2);
    	Point p34 = new Point(4, 0, 2);
    	
    	ArrayList<Point> points4 = new ArrayList<Point>();
    	points4.add(p27);
    	points4.add(p28);
    	points4.add(p29);
    	points4.add(p30);
    	points4.add(p31);
    	points4.add(p32);
    	points4.add(p33);
    	points4.add(p34);
    	
    	Point p35 = new Point(0.5, -0.5, 0.5);
    	Point p36 = new Point(0.5, -1.5, 0.5);
    	Point p37 = new Point(1.5, -1.5, 0.5);    	
    	Point p38 = new Point(1.5, -0.5, 0.5);
    	Point p39 = new Point(0.5, -0.5, 1.5);
    	Point p40 = new Point(0.5, -1.5, 1.5);
    	Point p41 = new Point(1.5, -1.5, 1.5);
    	Point p42 = new Point(1.5, -0.5, 1.5);
    	
    	ArrayList<Point> points5 = new ArrayList<Point>();
    	points5.add(p35);
    	points5.add(p36);
    	points5.add(p37);
    	points5.add(p38);
    	points5.add(p39);
    	points5.add(p40);
    	points5.add(p41);
    	points5.add(p42);
    	
    	Point p43 = new Point(2, 0, 2);
    	Point p44 = new Point(2, -2, 2);
    	Point p45 = new Point(4, -2, 2);    	
    	Point p46 = new Point(4, 0, 2);
    	Point p47 = new Point(2, 0, 4);
    	Point p48 = new Point(2, -2, 4);
    	Point p49 = new Point(4, -2, 4);
    	Point p50 = new Point(4, 0, 4);
    	
    	ArrayList<Point> points6 = new ArrayList<Point>();
    	points6.add(p43);
    	points6.add(p44);
    	points6.add(p45);
    	points6.add(p46);
    	points6.add(p47);
    	points6.add(p48);
    	points6.add(p49);
    	points6.add(p50);
    	
    	Point p51 = new Point(1, -1, 0);
    	Point p52 = new Point(1, -2, 0);
    	Point p53 = new Point(2, -2, 0);    	
    	Point p54 = new Point(2, -1, 0);
    	Point p55 = new Point(1, -1, 1);
    	Point p56 = new Point(1, -2, 1);
    	Point p57 = new Point(2, -2, 1);
    	Point p58 = new Point(2, -1, 1);
    	
    	ArrayList<Point> points7 = new ArrayList<Point>();
    	points7.add(p51);
    	points7.add(p52);
    	points7.add(p53);
    	points7.add(p54);
    	points7.add(p55);
    	points7.add(p56);
    	points7.add(p57);
    	points7.add(p58);
    	
    	if(type == 0) return points1;
    	else if(type == 1) return points2;
    	else if(type == 2) return points3;
    	else if(type == 3) return points4;
    	else if(type == 4) return points5;
    	else if(type == 5) return points6;
    	else if(type == 6) return points7;
    	
    	return points7;
    }
    
    public static ArrayList<LineString> getLineStrings(int type){
    	ArrayList<Point> points = getPoints(type);
    	ArrayList<LineString> lineStrings = new ArrayList<LineString>();
    	
    	Point p1 = points.get(0);    	Point p5 = points.get(4);
    	Point p2 = points.get(1);    	Point p6 = points.get(5);
    	Point p3 = points.get(2);    	Point p7 = points.get(6);
    	Point p4 = points.get(3);    	Point p8 = points.get(7);
    	
    	LineString ls1 = new LineString();
    	ls1.addPoint(p1);
    	ls1.addPoint(p4);
    	ls1.addPoint(p3);
    	ls1.addPoint(p2);
    	ls1.addPoint(p1);
    	
    	ArrayList<Point> pointList = new ArrayList<Point>();
    	pointList.add(p3);
    	pointList.add(p4);
    	pointList.add(p8);
    	pointList.add(p7);
    	pointList.add(p3);
    	LineString ls2 = new LineString(pointList);
    	
    	LineString ls3 = new LineString();
    	ls3.addPoint(p5);
    	ls3.addPoint(p6);
    	ls3.addPoint(p7);
    	ls3.addPoint(p8);
    	ls3.addPoint(p5);
    	
    	LineString ls4 = new LineString();
    	ls4.addPoint(p6);
    	ls4.addPoint(p5);
    	ls4.addPoint(p1);
    	ls4.addPoint(p2);
    	ls4.addPoint(p6);
    	
    	LineString ls5 = new LineString();
    	ls5.addPoint(p2);
    	ls5.addPoint(p3);
    	ls5.addPoint(p7);
    	ls5.addPoint(p6);
    	ls5.addPoint(p2);
    	
    	LineString ls6 = new LineString();
    	ls6.addPoint(p4);
    	ls6.addPoint(p1);
    	ls6.addPoint(p5);
    	ls6.addPoint(p8);
    	ls6.addPoint(p4);
    	
    	lineStrings.add(ls1);
    	lineStrings.add(ls2);
    	lineStrings.add(ls3);
    	lineStrings.add(ls4);
    	lineStrings.add(ls5);
    	lineStrings.add(ls6);
    	
    	return lineStrings;
    }
    
    public static ArrayList<Polygon> getPolygons(int type){
    	ArrayList<LineString> lineStrings = getLineStrings(type);
    	ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    	
    	for(int i=0; i<lineStrings.size(); i++){
    		polygons.add(new Polygon(lineStrings.get(i)));
    	}
    	
    	return polygons;
    }
    
    public static ArrayList<Solid> getSolids(){
    	ArrayList<Solid> solids = new ArrayList<Solid>();
    	
    	ArrayList<Polygon> polygons1 = getPolygons(0);
    	solids.add(new Solid(new PolyhedralSurface(polygons1)));
    	
    	ArrayList<Polygon> polygons2 = getPolygons(1);
    	solids.add(new Solid(new PolyhedralSurface(polygons2)));
    	
    	ArrayList<Polygon> polygons3 = getPolygons(2);
    	solids.add(new Solid(new PolyhedralSurface(polygons3)));
    	
    	ArrayList<Polygon> polygons4 = getPolygons(3);
    	solids.add(new Solid(new PolyhedralSurface(polygons4)));
    	
    	ArrayList<Polygon> polygons5 = getPolygons(4);
    	solids.add(new Solid(new PolyhedralSurface(polygons5)));
    	
    	ArrayList<Polygon> polygons6 = getPolygons(5);
    	solids.add(new Solid(new PolyhedralSurface(polygons6)));
    	
    	ArrayList<Polygon> polygons7 = getPolygons(6);
    	solids.add(new Solid(new PolyhedralSurface(polygons7)));
    	
    	return solids;
    }
    
    public static void test2D(){
    	ArrayList<Polygon> polygons = getPolygons(0);
    	
    	Polygon polygon1 = polygons.get(0);
    	Polygon polygon2 = polygons.get(1);
    	Polygon polygon3 = polygons.get(2);
    	
    	System.out.println("polygon1 area() : " + Algorithm.area(polygon1));
    	
    	Geometry convexhull = Algorithm.convexHull(polygon1);
    	System.out.println("convexhull geometryType() : " + convexhull.geometryType());
    	
    	System.out.println("polygon1 distance() : " + Algorithm.distance(polygon1, polygon3));
    	
    	Geometry extrudee = Algorithm.extrude(polygon1, 2, -2, 2);
    	System.out.println("extrude geometryType() : " + extrudee.geometryType());
    	Solid extrude = new Solid(extrudee);
    	System.out.println("extrude numShells() : " + extrude.numShells());
    	System.out.println("extrude exteriorShell().numPolygons() : " + extrude.exteriorShell().numPolygons());
    	System.out.println("extrude asText() : " + extrude.asText(0));
    	
    	Point p1 = new Point(1.0, 0, 0);	Point p2 = new Point(1.0, 1.0, 0);
    	Point p3 = new Point(3.0, 1.0, 0);	Point p4 = new Point(3.0, 0, 0);
    	LineString intersectionLS = new LineString();
    	intersectionLS.addPoint(p1);
    	intersectionLS.addPoint(p2);
    	intersectionLS.addPoint(p3);
    	intersectionLS.addPoint(p4);
    	intersectionLS.addPoint(p1);
    	Polygon intersectionPolygon = new Polygon(intersectionLS);
    	Geometry intersection = Algorithm.intersection(polygon1, intersectionPolygon);
    	System.out.println("intersection geometryType() : " + intersection.geometryType());
    	
    	System.out.println("polygon1 <-> polygon3 intersects() : " + Algorithm.intersects(polygon1, polygon3));
    	System.out.println("polygon1 <-> intersectionPolygon intersects() : " + Algorithm.intersects(polygon1, intersectionPolygon));
    	
    	System.out.println("polygon1 asText() : " + polygon1.asText(0));
    	System.out.println("polygon1 hasPlane3D() : " + Algorithm.hasPlane3D(polygon1));
    	System.out.println("polygon2 asText() : " + polygon2.asText(0));
    	System.out.println("polygon2 hasPlane3D() : " + Algorithm.hasPlane3D(polygon2));
    	
    	MultiLineString skeleton = Algorithm.straightSkeleton(polygon1);
    	System.out.println("polygon1 skeleton numGeometries() " + skeleton.numGeometries());
    	System.out.println("polygon1 skeleton numGeometries() " + skeleton.asText(0));
    }
    
    public static void test3D(){
    	Solid solid1 = getSolids().get(0);
    	
    	System.out.println("Solid1 volume : " + Algorithm.volume(solid1));
    	System.out.println("solid1 asText() : " + solid1.asText(0));
    	
    	Solid solid2 = getSolids().get(1);
    	Solid solid3 = getSolids().get(2);
    	Polygon polygon = getPolygons(2).get(2);
    	
    	Geometry intersection = Algorithm.intersection3D(solid2, solid3);
    	System.out.println(intersection.asText(0));
    	System.out.println(intersection.numGeometries());
    	
    	Polygon poly1 = Algorithm.getPolygons(1).get(0);
    	Polygon poly2 = Algorithm.getPolygons(2).get(0);
    	Geometry difference = Algorithm.difference3D(poly1, poly2);
    	System.out.println(poly1.asText(0));
    	System.out.println(poly2.asText(0));
    	System.out.println(difference.asText(0));
    	
    	System.out.println("aa");
    	System.out.println(Algorithm.covers3D(solid3.exteriorShell().polygonN(2), polygon));
    	System.out.println(solid3.exteriorShell().polygonN(2).asText(0));
    	System.out.println(polygon.asText(0));
    	
    	
    }
    
    public static void testSolid() {
    	Solid solid1 = getSolids().get(0);
    	Solid solid2 = getSolids().get(3);
    	Solid solid3 = getSolids().get(1);
    	Solid solid4 = getSolids().get(2);
    	Solid solid5 = getSolids().get(4);
    	Solid solid6 = getSolids().get(5);
    	Solid solid7 = getSolids().get(6);
    	
    	PolyhedralSurface shell1 = solid1.exteriorShell();
    	PolyhedralSurface shell2 = solid2.exteriorShell();
    	PolyhedralSurface shell3 = solid3.exteriorShell();
    	PolyhedralSurface shell4 = solid4.exteriorShell();
    	PolyhedralSurface shell5 = solid5.exteriorShell();
    	PolyhedralSurface shell6 = solid6.exteriorShell();
    	PolyhedralSurface shell7 = solid7.exteriorShell();
    	
    	//Geometry intersectionII = (new Solid(intersection3D(solid3, solid4))).exteriorShell().toTriangulatedSurface();
    	Geometry intersectionII = intersection3D(solid7, solid1);
    	Geometry intersectionBI = intersection3D(shell7, solid1);
    	Geometry intersectionIB = intersection3D(solid7, shell1);
    	Geometry intersectionBB = intersection3D(shell7, shell1);
    	
    	System.out.println("solid1 : " + solid1.asText(1));
    	System.out.println("solid2 : " + solid2.asText(1));
    	System.out.println("solid3 : " + solid3.asText(1));
    	System.out.println("solid4 : " + solid4.asText(1));
    	System.out.println("solid5 : " + solid5.asText(1));
    	System.out.println("solid6 : " + solid6.asText(1));
    	System.out.println("solid7 : " + solid7.asText(1));
    	
    	System.out.println("shell1 : " + shell1.asText(1));
    	System.out.println("shell2 : " + shell2.asText(1));
    	System.out.println("shell3 : " + shell3.asText(1));
    	System.out.println("shell4 : " + shell4.asText(1));
    	System.out.println("shell5 : " + shell5.asText(1));
    	System.out.println("shell6 : " + shell6.asText(1));
    	System.out.println("shell7 : " + shell7.asText(1));
    	
    	System.out.println("------------ intersection ------------");
    	System.out.println(intersectionII.asText(1));
    	System.out.println(intersectionIB.asText(1));
    	System.out.println(intersectionBI.asText(1));
    	System.out.println(intersectionBB.asText(1));
    	
    	System.out.println(intersectionII.equals(intersectionIB));
    	System.out.println(intersectionII.equals(intersectionBI));
    	System.out.println(intersectionIB.equals(intersectionBB));
    	
    	System.out.println(intersectionII.dimension());
    	System.out.println(intersectionIB.dimension());
    	System.out.println(intersectionBI.dimension());
    	System.out.println(intersectionBB.dimension());
    	
    	System.out.println(covers3D(solid1, solid5));
    	
    }
    
    public static void main(String[] args){
    	/*
    	Point p = new Point(3.0, 5.0);
    	Point p1 = new Point(0.0, 0.0);
    	Point p2 = new Point(2.0, 0.0);
    	Point p3 = new Point(4.0, 0.0);
    	
    	LineString ls1 = new LineString();
    	ls1.addPoint(p1);
    	ls1.addPoint(p2);
    	ls1.addPoint(p3);
    	
    	Point p4 = new Point(2.0, 3.0);
    	Point p5 = new Point(4.0, 3.0);
    	Point p6 = new Point(5.0, 3.0);
    	
    	
    	LineString ls2 = new LineString();
    	ls2.addPoint(p4);
    	ls2.addPoint(p5);
    	ls2.addPoint(p6);
    	
    	System.out.println("p <-> ls1 distance : " + Algorithm.distance(p, ls1));
    	System.out.println("ls1 <-> ls2 distance : " + Algorithm.distance(ls1, ls2));
    	System.out.println("ls1 geometryType : " + ls1.geometryType());
    	Geometry ls_geom = (Geometry)ls1;
    	System.out.println("ls_geom.geometryType() : " + ls_geom.geometryType());
    	
    	Geometry convexhull = Algorithm.convexHull(ls1);
    	System.out.println("ls1 convexhull geometry type : " + convexhull.geometryType());
    	LineString convex_ls = new LineString(convexhull);
    	System.out.println("convexhull numPoints() : " + convex_ls.numPoints());
    	
    	
    	
    	LineString exteriorRing = new LineString(ls1);
    	exteriorRing.addPoint(p4);
    	exteriorRing.addPoint(p5);
    	
    	Polygon polygon = new Polygon();
    	polygon.setExteriorRing(exteriorRing);
    	Geometry poly_geom = (Geometry)polygon;
    	System.out.println("poly_geom.geometryType() : " + poly_geom.geometryType());
    	
    	convexhull = Algorithm.convexHull(polygon);
    	System.out.println("ls1 convexhull geometry type : " + convexhull.geometryType());
    	Polygon convex_poly = new Polygon(convexhull);
    	System.out.println("convexhull numPoints() : " + convex_poly.exteriorRing().numPoints());
    	*/
    	
    	//test2D();
    	//test3D();
    	testSolid();
    }
}
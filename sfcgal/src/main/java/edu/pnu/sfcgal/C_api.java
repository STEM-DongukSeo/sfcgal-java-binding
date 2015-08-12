package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="C_api.h")
public class C_api {
    static { Loader.load(); }

    public static native @ByRef Geometry SFCGAL_io_read_wkt(@ByRef @StdString String str, @Cast("size_t") int len);
    public static void SFCGAL_io_write_binary_prepared(PreparedGeometry geom, String buffer, int len) {
    	System.out.println("call1");
    	SFCGAL_io_write_binary_prepared(geom, buffer.toCharArray(), len);
    	System.out.println("call2");
    }
    public static native void SFCGAL_io_write_binary_prepared( PreparedGeometry geom, @Cast("char *") char[] buffer, @Cast("size_t") int len);
    public static native @ByRef PreparedGeometry SFCGAL_io_read_binary_prepared(@StdString String str, @Cast("size_t") int len);
    public static native @ByRef PreparedGeometry SFCGAL_io_read_ewkt(@StdString String str, @Cast("size_t") int len);
    public static native @ByRef Geometry SFCGAL_geometry_force_lhr(@ByRef Geometry g);
    public static native @ByRef Geometry SFCGAL_geometry_force_rhr(@ByRef Geometry g);
    public static native @ByRef TriangulatedSurface SFCGAL_geometry_triangulate_2dz(@ByRef Geometry g);
    
    
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
    	
    	if(type == 1) return points1;
    	return points2;
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
    	
    	ArrayList<Polygon> polygons1 = getPolygons(1);
    	solids.add(new Solid(new PolyhedralSurface(polygons1)));
    	
    	ArrayList<Polygon> polygons2 = getPolygons(2);
    	solids.add(new Solid(new PolyhedralSurface(polygons2)));
    	
    	return solids;
    }
    
    public static void test2D(){
    	ArrayList<Polygon> polygons = getPolygons(1);
    	
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
    
    public static void main(String[] args){
    	Polygon polygon = getPolygons(1).get(0);
    	PreparedGeometry pg = new PreparedGeometry(polygon, 5);
    	Polygon polygon2 = new Polygon(pg.geometry());
    	
    	String wkt = polygon2.asText();
    	
    	System.out.println("polygon2.asText() : " + wkt);
    	Geometry g = C_api.SFCGAL_io_read_wkt(wkt, wkt.length());
    	System.out.println("g asText() : " + g.asText());
    	/*
    	int len = 0;
    	String binary = null;
    	C_api.SFCGAL_io_write_binary_prepared(pg, binary, len);
    	System.out.println("binary : " + binary);
    	*/
    	String ewkt = pg.asEWKT();
    	System.out.println("pg.asEWKT() : " + ewkt);
    	PreparedGeometry pgFromEWKT = C_api.SFCGAL_io_read_ewkt(ewkt, ewkt.length());
    	System.out.println("pgFromEWKT.asEWKT() : " + pgFromEWKT.asEWKT());
    	
    	
    	Geometry forcelhr = C_api.SFCGAL_geometry_force_lhr(polygon);
    	System.out.println("polygon1 forcelhr.asText() : " + forcelhr.asText());
    	Geometry forcerhr = C_api.SFCGAL_geometry_force_rhr(polygon);
    	System.out.println("polygon1 forcerhr.asText() : " + forcerhr.asText());
    	
    	TriangulatedSurface surf = C_api.SFCGAL_geometry_triangulate_2dz(polygon);
    	System.out.println("polygon1 triangulated.asText() : " + surf.asText());
    	
    	Polygon polygon3 = getPolygons(1).get(1);
    	surf = C_api.SFCGAL_geometry_triangulate_2dz(polygon3);
    	System.out.println("polygon2 triangulated.asText() : " + surf.asText(0));
    }
}
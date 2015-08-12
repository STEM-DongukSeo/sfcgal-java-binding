package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="MultiPolygon.h")
public class MultiPolygon extends GeometryCollection {
    static { Loader.load(); }
    public MultiPolygon() { allocate(); }
    public MultiPolygon(Pointer p) { super(p); }
    private native void allocate();
    
    @Name("operator=")
    public native @ByRef MultiPolygon assign(@ByRef MultiPolygon other);
    
    public native MultiPolygon clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    
    public native @ByRef Polygon polygonN(@Cast("size_t") int n);

    public static MultiPolygon makeMultiPolygon(ArrayList<Point> pointList){
    	Point p1 = pointList.get(0);    	Point p5 = pointList.get(4);
    	Point p2 = pointList.get(1);    	Point p6 = pointList.get(5);
    	Point p3 = pointList.get(2);    	Point p7 = pointList.get(6);
    	Point p4 = pointList.get(3);    	Point p8 = pointList.get(7);
    	
    	LineString ls1 = new LineString();
    	ls1.addPoint(p1);
    	ls1.addPoint(p4);
    	ls1.addPoint(p3);
    	ls1.addPoint(p2);
    	ls1.addPoint(p1);
    	
    	ArrayList<Point> points = new ArrayList<Point>();
    	points.add(p3);
    	points.add(p4);
    	points.add(p8);
    	points.add(p7);
    	points.add(p3);
    	LineString ls2 = new LineString(points);
    	
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
    	ArrayList<LineString> rings = new ArrayList<LineString>();
    	rings.add(ls4);
    	
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
    	
    	Polygon polygon1 = new Polygon(ls1);
    	Polygon polygon2 = new Polygon(ls2);
    	Polygon polygon3 = new Polygon(ls3);
    	Polygon polygon4 = new Polygon(ls4);
    	Polygon polygon5 = new Polygon(ls5);
    	Polygon polygon6 = new Polygon(ls6);
    	
    	MultiPolygon MultiPolygon = new MultiPolygon();
    	MultiPolygon.addGeometry(polygon1);
    	MultiPolygon.addGeometry(polygon2);
    	MultiPolygon.addGeometry(polygon3);
    	MultiPolygon.addGeometry(polygon4);
    	MultiPolygon.addGeometry(polygon5);
    	MultiPolygon.addGeometry(polygon1);
    	
    	return MultiPolygon;
    }

    public static void main(String[] args){
    	Point p1 = new Point(0, 0, 0);
    	Point p2 = new Point(0, -2, 0);
    	Point p3 = new Point(2, -2, 0);    	
    	Point p4 = new Point(2, 0, 0);
    	Point p5 = new Point(0, 0, 2);
    	Point p6 = new Point(0, -2, 2);
    	Point p7 = new Point(2, -2, 2);
    	Point p8 = new Point(2, 0, 2);
    	
    	ArrayList<Point> points = new ArrayList<Point>();
    	points.add(p1);
    	points.add(p2);
    	points.add(p3);
    	points.add(p4);
    	points.add(p5);
    	points.add(p6);
    	points.add(p7);
    	points.add(p8);
    	
    	MultiPolygon multiPolygon = MultiPolygon.makeMultiPolygon(points);
    	
    	if(multiPolygon.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	System.out.println("multiPolygon.geomtryType() : " + multiPolygon.geometryType());
    	System.out.println("multiPolygon.numGeometries() : " + multiPolygon.numGeometries());
    	System.out.println("multiPolygon.lineStringN(0).geometryType() : " + multiPolygon.polygonN(0).geometryType());
    	System.out.println("multiPolygon.lineStringN(0).asText(-1) : " + multiPolygon.polygonN(0).asText(-1));
    	System.out.println("multiPolygon.lineStringN(0).numRings() : " + multiPolygon.polygonN(0).numRings());
    	System.out.println("multiPolygon.lineStringN(0).numGeometries() : " + multiPolygon.polygonN(0).numGeometries());
    }
    
}

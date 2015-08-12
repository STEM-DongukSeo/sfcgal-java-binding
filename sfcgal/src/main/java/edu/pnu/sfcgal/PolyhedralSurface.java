package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="PolyhedralSurface.h")
public class PolyhedralSurface extends Surface {
    static { Loader.load(); }
    public PolyhedralSurface() { allocate(); }    
    public PolyhedralSurface(ArrayList<Polygon> polygons) {
    	PointerVector vector = new PointerVector(polygons.size());
    	
    	for(int i = 0; i < polygons.size(); i++){
    		vector.get(i).put(polygons.get(i));
    	}
    	
    	allocate(vector);
    }
    public PolyhedralSurface(Pointer p) { super(p); }
    private native void allocate();
    private native void allocate(@ByRef PointerVector p);
   
    @Name("operator=")
    public native @ByRef PolyhedralSurface assign(@ByRef PolyhedralSurface tr);
    
    public native PolyhedralSurface clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native @ByRef TriangulatedSurface toTriangulatedSurface();
    public native @Cast("size_t") int numPolygons();
    public native @ByRef Polygon polygonN(@Cast("size_t") int n);
    public native void addPolygon(Polygon polygon);
    public native void addPolygons(@ByRef PolyhedralSurface other);
    
    public native @Cast("size_t") int numGeometries();
    public native @ByRef Polygon geometryN(@Cast("size_t") int n);

    public static void main(String[] args){
    	Point p1 = new Point(0, 0, 0);
    	Point p2 = new Point(0, -2, 0);
    	Point p3 = new Point(2, -2, 0);    	
    	Point p4 = new Point(2, 0, 0);
    	Point p5 = new Point(0, 0, 2);
    	Point p6 = new Point(0, -2, 2);
    	Point p7 = new Point(2, -2, 2);
    	Point p8 = new Point(2, 0, 2);
    	LineString ls1 = new LineString();
    	ls1.addPoint(p1);
    	ls1.addPoint(p2);
    	ls1.addPoint(p3);
    	ls1.addPoint(p4);
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
    	ls4.addPoint(p2);
    	ls4.addPoint(p1);
    	ls4.addPoint(p5);
    	ls4.addPoint(p6);
    	ls4.addPoint(p2);
    	ArrayList<LineString> rings = new ArrayList<LineString>();
    	rings.add(ls4);
    	
    	Polygon polygon1 = new Polygon();
    	polygon1.setExteriorRing(ls1);
    	Polygon polygon2 = new Polygon(ls2);
    	Polygon polygon3 = new Polygon(ls3);
    	Polygon polygon4 = new Polygon(rings);
    	
    	ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    	polygons.add(polygon1);
    	polygons.add(polygon2);
    	polygons.add(polygon3);
    	
    	PolyhedralSurface polyhedral = new PolyhedralSurface(polygons);
    	polyhedral.addPolygon(polygon4);
    	
    	System.out.println("polygon1 <-> polygon3 distance : " + polygon1.distance(polygon3));
    	System.out.println("polygon1 <-> polygon3 distance3D : " + polygon1.distance3D(polygon3));
    	//System.out.println("polygon1 <-> polygon2 distance : " + polygon1.distance(polygon2)); // polygon2(2D polygon) is invalid
    	System.out.println("polygon1 <-> polygon2 distance3D : " + polygon1.distance3D(polygon2));
    	
    	System.out.println("PolyhedralSurface toString() : " + polyhedral.asText(0));
    	System.out.println("PolyhedralSurface GeometryType() : " + polyhedral.geometryType());
    	System.out.println("PolyhedralSurface numPolygons() : " + polyhedral.numPolygons());
    	System.out.println("PolyhedralSurface polygonN(3).geometryType() : " + polyhedral.polygonN(3).geometryType());
    	System.out.println("PolyhedralSurface polygonN(3).asText() : " + polyhedral.polygonN(3).asText(0));
    	System.out.println("PolyhedralSurface polygonN(3).numInteriorRings() : " + polyhedral.polygonN(3).numInteriorRings());
    	System.out.println("PolyhedralSurface polygonN(3).numRings() : " + polyhedral.polygonN(3).numRings());
    	System.out.println("PolyhedralSurface polygonN(3).numGeometries() : " + polyhedral.polygonN(3).numGeometries());
    	System.out.println("PolyhedralSurface geometryN(3).numGeometries() : " + polyhedral.geometryN(3).numGeometries());
    	System.out.println("PolyhedralSurface geometryN(3).hasInterioRings() : " + polyhedral.geometryN(3).hasInteriorRings());
    	System.out.println("PolyhedralSurface geometryN(0).hasInterioRings() : " + polyhedral.geometryN(0).hasInteriorRings());
    	System.out.println("PolyhedralSurface geometryN(3).isCounterClockWiseOriented() : " + polyhedral.geometryN(3).isCounterClockWiseOriented());
    	System.out.println("PolyhedralSurface geometryN(0).isCOunterClockWiseOriented() : " + polyhedral.geometryN(0).isCounterClockWiseOriented());
    }
    
}

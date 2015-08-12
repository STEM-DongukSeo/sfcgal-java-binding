package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="LineString.h")
public class LineString extends Geometry {
    static { Loader.load(); }
    public LineString() { allocate(); }
    
    public LineString(ArrayList<Point> p) {
    	PointerVector vector = new PointerVector(p.size());
    	
    	for(int i = 0; i < p.size(); i++){
    		vector.get(i).put(p.get(i));
    	}
    	
    	allocate(vector);
    }
    
    public LineString(Point startPoint, Point endPoint) {allocate(startPoint, endPoint); }
    public LineString(Pointer p) { super(p); }
    private native void allocate();
    private native void allocate(@ByRef PointerVector p);
    private native void allocate(@ByRef Point startPoint, @ByRef Point endPoint);
    
    @Name("operator=")
    public native @ByRef LineString assign(@ByRef LineString ls);
    
    public native LineString clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native void clear();
    public native void reverse();
    public native @Cast("size_t") int numPoints();
    public native @Cast("size_t") int numSegments();
    public native @ByRef Point pointN(@Cast("size_t") int n);
    public native @ByRef Point startPoint();
    public native @ByRef Point endPoint();
    
    public native void addPoint(Point p);
    public native @Cast("bool") boolean isClosed();
    public native void reserve(@Cast("size_t") int n);
    

    public static void main(String[] args){
    	Point p1 = new Point(1.1, 2.2, 3.3, 1);
    	Point p2 = new Point(0.5, 1.5, 2.5, 2);
    	
    	LineString ls = new LineString(p1, p2);
    	
    	Point p3 = new Point(9.4, 10.2, 1.1, 3);
    	
    	ls.addPoint(p3);
    	
    	if(ls.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	if(ls.isClosed()){
    		System.out.println("closed");
    	}else{
    		System.out.println("not closed");
    	}
    	
    	System.out.println("p3 coodinateDemension : " + ls.pointN(2).coordinateDimension());
    	System.out.println("p3 demension : " + ls.pointN(2).dimension());
    	System.out.println("p3 m : " + ls.pointN(2).m());
    	
    	ArrayList<Point> points = new ArrayList<Point>();
    	points.add(p2);
    	points.add(p3);
    	points.add(p1);
    	
    	LineString ls1 = new LineString(points);
    	System.out.println("p3 coodinateDemension : " + ls1.pointN(2).coordinateDimension());
    	System.out.println("p3 demension : " + ls1.pointN(2).dimension());
    	System.out.println("p3 m : " + ls1.pointN(2).m());    
    	
    	System.out.println("ls1 numpoins : " + ls1.numPoints() + " ls1 numsegments : " + ls1.numSegments());
    	
    	//
    	Geometry boundary = ls1.boundary();
    	System.out.println("ls1 boundary type : " + boundary.geometryType());
    	System.out.println("ls1 boundary numGeometries : " + boundary.numGeometries());
    	
    	Envelope envelope = ls1.envelope();
    	System.out.println("envelope.is3D() : " + envelope.is3D());
    	System.out.println("envelope.xmin() : " + envelope.xMin());
    	System.out.println("envelope.ymin() : " + envelope.yMin());
    	System.out.println("envelope.zmin() : " + envelope.zMin());
    	System.out.println("envelope.xmax() : " + envelope.xMax());
    	System.out.println("envelope.ymax() : " + envelope.yMax());
    	System.out.println("envelope.zmax() : " + envelope.zMax());
    	//
    	
    	System.out.println("ls1.clear");
    	ls1.clear();
    	System.out.println("ls1 numpoins : " + ls1.numPoints() + " ls1 numsegments : " + ls1.numSegments());
    	

    }
    
}

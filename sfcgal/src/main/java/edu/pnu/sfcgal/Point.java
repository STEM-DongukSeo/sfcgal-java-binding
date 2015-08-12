package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="Point.h")
public class Point extends Geometry {
    static { Loader.load(); }
    public Point() { allocate(); }
    public Point(@ByRef Coordinate c) { allocate(c); }
    public Point(double x, double y) { allocate(x, y); }
    public Point(double x, double y, double z) { allocate(x, y, z); }
    public Point(double x, double y, double z, double m) { allocate(x, y, z, m); }
    public Point(Pointer p) { super(p); }
    private native void allocate();
    private native void allocate(@ByRef Coordinate c);
    private native void allocate(double x, double y, double z);
    private native void allocate(double x, double y);
    private native void allocate(double x, double y, double z, double m);
    
    @Name("operator=")
    public native @ByRef Point assign(@ByRef Point c);
  
    public native Point clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native double x();
	public native double y();
    public native double z();
    public native double m();
    public native void setM(double m);    
    
    @Name("operator<")
    public native @Cast("bool") boolean isSmallerThan(@ByRef Point p);
    
    @Name("operator==")
    public native @Cast("bool") boolean equals(@ByRef Point p);
    
    @Name("operator!=")
    public native @Cast("bool") boolean notEquals(@ByRef Point p);

    public native @ByRef Coordinate coordinate();

    public static void main(String[] args){
    	Point p = new Point(2.0, 1.5, 0);
    	Point p2 = new Point(p);
    	Point p3 = new Point(1, 1, 1);
    	
    	if(p.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	p.setM(2.5);
    	System.out.println("x : " + p.x());
    	System.out.println("y : " + p.y());
    	System.out.println("z : " + p.z());
    	System.out.println("m : " + p.m());
    	System.out.println("dimension : " + p.dimension());
    	System.out.println("coordinateDimension : " + p.coordinateDimension());
    	System.out.println("SFCGAL::Geometry::asText() = " + p.asText(-1));
    	
    	System.out.println("p == p2 ? " + p.equals(p2));
    	System.out.println("p != p3 ? " + p.notEquals(p3));
    	
    	System.out.println("p1 <-> p3 distance : " + p.distance(p3));
    	System.out.println("p1 <-> p3 distance3D : " + p.distance3D(p3));
    }
    
}

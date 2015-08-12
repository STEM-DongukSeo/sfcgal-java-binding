package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include={"Triangle.h", "Triangle.cpp"})
public class Triangle extends Surface {
    static { Loader.load(); }
    public Triangle() { allocate(); }    
    public Triangle(Point p, Point q, Point r) {allocate(p, q, r); }
    public Triangle(Pointer p) { super(p); }
    private native void allocate();
    private native void allocate(@ByRef Point p, @ByRef Point q, @ByRef Point r);
   
    @Name("operator=")
    public native @ByRef Triangle assign(@ByRef Triangle tr);
    
    public native Triangle clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native void reverse();
    public native @ByRef Polygon toPolygon();
    public native @ByRef Point vertex(int i);

    public static void main(String[] args){
    	Point p1 = new Point(1.1, 2.2, 3.3, 1);
    	Point p2 = new Point(0.5, 1.5, 2.5, 2);
    	Point p3 = new Point(9.4, 10.2, 1.1, 3);
    	
    	Triangle tr = new Triangle(p1, p2, p3);
    	    	
    	if(tr.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	System.out.println("tr.vertex(2) coodinateDemension : " + tr.vertex(2).coordinateDimension());
    	System.out.println("tr.vertex(2) demension : " + tr.vertex(2).dimension());
    	System.out.println("tr.vertex(2) m : " + tr.vertex(2).m());
    	
    	Triangle tr2 = new Triangle(tr);
    	System.out.println("tr2 = tr.reverse()");
    	tr2.reverse();
    	System.out.println("tr2.vertex(2) coodinateDemension : " + tr2.vertex(2).coordinateDimension());
    	System.out.println("tr2.vertex(2) demension : " + tr2.vertex(2).dimension());
    	System.out.println("tr2.vertex(2) m : " + tr2.vertex(2).m());
    	
    	Polygon polygon = tr.toPolygon();
    	System.out.println("polygon.numRings() " + polygon.numRings());
    }
    
}

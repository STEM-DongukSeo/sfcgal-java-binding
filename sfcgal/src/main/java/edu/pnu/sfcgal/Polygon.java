package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="Polygon.h")
public class Polygon extends Surface {
    static { Loader.load(); }
    public Polygon() { allocate(); }
    public Polygon(ArrayList<LineString> rings) {
    	PointerVector vector = new PointerVector(rings.size());
    	
    	for(int i = 0; i < rings.size(); i++){
    		vector.get(i).put(rings.get(i));
    	}
    	
    	allocate(vector);
    }
    
    public Polygon(LineString exteriorRing) { allocate(exteriorRing); }
    public Polygon(Triangle triangle) { allocate(triangle); }
    public Polygon(Pointer p) { super(p); }
    private native void allocate();
    
    private native void allocate(@ByRef PointerVector p);
    private native void allocate(@ByRef LineString exteriorRing);
    private native void allocate(@ByRef Triangle triangle);
    
    @Name("operator=")
    public native @ByRef Polygon assign(@ByRef Polygon polygon);
    
    public native Polygon clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native @Cast("bool") boolean isCounterClockWiseOriented();
    public native void reverse();
    public native @ByRef LineString exteriorRing();
    public native void setExteriorRing(@ByRef LineString exteriorRing);
    public native @Cast("bool") boolean hasInteriorRings();
    public native @Cast("size_t") int numInteriorRings();
    public native @ByRef LineString interiorRingN(@Cast("size_t") int n);
    public native @Cast("size_t") int numRings();
    public native @ByRef LineString ringN(@Cast("size_t") int n);
    public native void addInteriorRing(@ByRef LineString ls);
    public native void addRing(@ByRef LineString ls);
    

    public static void main(String[] args){
    	Point p1 = new Point(1.1, 2.2, 3.3, 1);
    	Point p2 = new Point(0.5, 1.5, 2.5, 2);
    	Point p3 = new Point(9.4, 10.2, 1.1, 3);
    	
    	LineString ls = new LineString(p1, p2);
    	
    	ls.addPoint(p3);
    	ls.addPoint(p1);
    	
    	Polygon polygon = new Polygon(ls);
    	
    	ArrayList<Point> points = new ArrayList<Point>();
    	points.add(p2);
    	points.add(p3);
    	points.add(p1);
    	points.add(p2);
    	LineString ls1 = new LineString(points);
    	polygon.addInteriorRing(ls1);
    	
    	if(polygon.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	if(polygon.isCounterClockWiseOriented()){
    		System.out.println("counter clockwised");
    	}else{
    		System.out.println("not counterclockwised");
    	}
    	
    	System.out.println("polygon coodinateDemension : " + polygon.coordinateDimension());
    	System.out.println("geometryType : " + polygon.geometryType());
    	System.out.println("numrings : " + polygon.numRings());
    	System.out.println("interior numPoints : " + polygon.interiorRingN(0).numPoints());
    	
    	Polygon polygon2 = new Polygon(polygon);
    	
    	System.out.println(polygon2.geometryType());
    }
}

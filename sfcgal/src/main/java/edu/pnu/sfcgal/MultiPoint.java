package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="MultiPoint.h")
public class MultiPoint extends GeometryCollection {
    static { Loader.load(); }
    public MultiPoint() { allocate(); }
    public MultiPoint(Pointer p) { super(p); }
    private native void allocate();
    
    @Name("operator=")
    public native @ByRef MultiPoint assign(@ByRef MultiPoint other);
    
    public native MultiPoint clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    
    public native @ByRef Point pointN(@Cast("size_t") int n);


    public static void main(String[] args){
    	Point p1 = new Point(1.1, 2.2, 3.3, 1);
    	Point p2 = new Point(0.5, 1.5, 2.5, 2);
    	
    	MultiPoint multiPoint = new MultiPoint();
    	
    	Point p3 = new Point(9.4, 10.2, 1.1, 3);
    	
    	multiPoint.addGeometry(p1);
    	multiPoint.addGeometry(p2);
    	multiPoint.addGeometry(p3);
    	
    	if(multiPoint.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	System.out.println("multiPoint.geomtryType() : " + multiPoint.geometryType());
    	System.out.println("multiPoint.numGeometries() : " + multiPoint.numGeometries());
    	System.out.println("multiPoint.pointN(2).coodinateDemension : " + multiPoint.pointN(2).coordinateDimension());
    	System.out.println("multiPoint.pointN(2).demension : " + multiPoint.pointN(2).dimension());
    	System.out.println("multiPoint.pointN(2).m : " + multiPoint.pointN(2).m());
    }
    
}

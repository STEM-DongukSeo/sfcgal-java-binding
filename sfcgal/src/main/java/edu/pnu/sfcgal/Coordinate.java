package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include="Coordinate.h")
public class Coordinate extends Pointer {
    static { Loader.load(); }
    public Coordinate() { allocate(); }
    public Coordinate(double x, double y) { allocate(x, y); }
    public Coordinate(double x, double y, double z) { allocate(x, y, z); }
    public Coordinate(Pointer p) { super(p); }
    private native void allocate();
    private native void allocate(double x, double y, double z);
    private native void allocate(double x, double y);
    
    @Name("operator=")
    public native @ByRef Coordinate assign(@ByRef Coordinate c);
  
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    
    public native double x();
    public native double y();
    public native double z();
  
    public native @ByRef Coordinate round(@ByRef long scaleFactor);
    
    @Name("operator<")
    public native @Cast("bool") boolean isSmallerThan(@ByRef Coordinate c);
    
    @Name("operator==")
    public native @Cast("bool") boolean equals(@ByRef Coordinate c);
    
    @Name("operator!=")
    public native @Cast("bool") boolean notEquals(@ByRef Coordinate c);

    public static void main(String[] args){
    	Coordinate c = new Coordinate(1.4, 2.1);
    	
    	if(c.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	System.out.println("c.x() : " + c.x());
    	System.out.println("c.y() : " + c.y());
    	System.out.println("c.z() : " + c.z());
    }
    
}

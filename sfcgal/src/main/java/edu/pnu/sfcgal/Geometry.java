package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="Geometry.h")
public class Geometry extends Pointer{
	static { Loader.load(); }
    public Geometry() { allocate(); }
    public Geometry(Pointer p) { super(p); }
    private native void allocate();
    
    public native Geometry clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();    
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    
    public native @Cast("bool") boolean isMeasured();
    public String asText() { return asText(-1); }
    public native @StdString String asText(int numDcimals);
    public native @ByRef Envelope envelope();
    public native @ByRef Geometry boundary();
    public native double distance(@ByRef Geometry other);
    public native double distance3D(@ByRef Geometry other);
    
    public native void round(long scale);
    
    public native int numGeometries();
    public native @ByRef Geometry geometryN(int n);
    
    //public native @Cast("bool") boolean is();
    //public native @Cast("bool") boolean as();

    //public native void accept();
    @Name("operator==")
    public native @Cast("bool") boolean equals(@ByRef Geometry other);
 
    public static void main(String[] args){
    	Geometry geometry = new Geometry();
    	
    	System.out.println(geometry.is3D());
    }
}
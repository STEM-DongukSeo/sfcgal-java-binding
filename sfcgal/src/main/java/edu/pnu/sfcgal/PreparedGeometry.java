package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="PreparedGeometry.h")
public class PreparedGeometry extends Pointer {
    static { Loader.load(); }
    public PreparedGeometry() { allocate(); }
    public PreparedGeometry(Geometry g) { this(g, 0); }
	public PreparedGeometry(Geometry g, long srid) { allocate(g, srid); }
    private native void allocate();
    private native void allocate(@ByRef Geometry g, long srid);
    
    public native @ByRef Geometry geometry();
    public native void resetGeometry(Geometry g);
    public native @ByRef @Cast("srid_t") long SRID();
    public native void resetSRID(@Cast("srid_t") long srid);
    public native @ByRef Envelope envelope();
    public native void invalidateCache();
    public String asEWKT() { return asEWKT(-1); }
    public native @StdString String asEWKT(int numDecimals);
    
    public static void main(String[] args){
    	PreparedGeometry c = new PreparedGeometry();
    	
    	Solid solid = Algorithm.getSolids().get(0);
    	c.resetGeometry(solid);
    	
    	System.out.println("srid : " + c.SRID());
    	long srid = 5;
    	c.resetSRID(srid);
    	System.out.println("srid : " + c.SRID());
    	
    	System.out.println("preparedGeometry asEWKT() : " + c.asEWKT());
    }    
}

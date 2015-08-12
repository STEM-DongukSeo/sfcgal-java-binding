package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include="Surface.h")
public class Surface extends Geometry {
    static { Loader.load(); }
    public Surface() { allocate(); }
    public Surface(Pointer p) { super(p); }
    private native void allocate();
    
    public native int dimension();
    
    public static void main(String[] args){
    	Surface surface = new Surface();
    		
    	System.out.println(surface.geometryType());
    }    
}

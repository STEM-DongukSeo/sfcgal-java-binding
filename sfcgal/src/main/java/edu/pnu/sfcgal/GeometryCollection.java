package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="GeometryCollection.h")
public class GeometryCollection extends Geometry {
    static { Loader.load(); }
    public GeometryCollection() { allocate(); }
    public GeometryCollection(Pointer p) { super(p); }
    private native void allocate();
    
    @Name("operator=")
    public native @ByRef GeometryCollection assign(@ByRef GeometryCollection other);
    
    public native GeometryCollection clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native @Cast("size_t") int numGeometries();
    public native @ByRef Geometry geometryN(@Cast("size_t") int n);
    public native void addGeometry(@ByRef Geometry geometry);    

    public static void main(String[] args){
    	Point p1 = new Point(1.1, 2.2, 3.3, 1);
    	Point p2 = new Point(0.5, 1.5, 2.5, 2);
    	
    	GeometryCollection collection = new GeometryCollection();
    	
    	Point p3 = new Point(9.4, 10.2, 1.1, 3);
    	
    	collection.addGeometry(p1);
    	collection.addGeometry(p2);
    	collection.addGeometry(p3);
    	
    	if(collection.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	LineString ls = new LineString();
    	ls.addPoint(p1);
    	ls.addPoint(p2);
    	ls.addPoint(p3);
    	
    	collection.addGeometry(ls);
    	
    	System.out.println("collection geometryType() : " + collection.geometryType());
    	System.out.println("collection geometryTypeId() : " + collection.geometryTypeId());
    	System.out.println("collection asText() : " + collection.asText(0));
    	System.out.println("collection numGeometries : " + collection.numGeometries());
    	System.out.println("collection geometryN(1).geometryType() : " + collection.geometryN(1).geometryType());
    	System.out.println("collection geometryN(1).asText() : " + collection.geometryN(1).asText(0));
    	System.out.println("collection geometryN(1).address() : " + collection.geometryN(1).address());
    	System.out.println("collection geometryN(3).geometryType() : " + collection.geometryN(3).geometryType());
    	System.out.println("collection geometryN(3).pointN(1).asText() : " + new LineString(collection.geometryN(3)).pointN(1).asText(0));
    	System.out.println("collection geometryN(3).pointN(1).address : " + new LineString(collection.geometryN(3)).pointN(1).address());
    }
    
}

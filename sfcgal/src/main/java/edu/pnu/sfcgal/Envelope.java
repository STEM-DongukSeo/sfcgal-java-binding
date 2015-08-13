package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include={"Envelope.h", "Envelope.cpp"})
public class Envelope extends Pointer {
    static { Loader.load(); }
    public Envelope() { allocate(); }
    public Envelope(double xmin, double xmax, double ymin, double ymax) { allocate(xmin, xmax, ymin, ymax); }
    public Envelope(double xmin, double xmax, double ymin, double ymax, double zmin, double zmax) { allocate(xmin, xmax, ymin, ymax, zmin, zmax); }
    public Envelope(Coordinate p) { allocate(p); }
    public Envelope(Coordinate p1, Coordinate p2) { allocate(p1, p2); }
    public Envelope(Pointer p) { super(p); }
    private native void allocate();
    private native void allocate(double xmin, double xmax, double ymin, double ymax);
    private native void allocate(double xmin, double xmax, double ymin, double ymax, double zmin, double zmax);
    private native void allocate(@ByRef Coordinate p);
    private native void allocate(@ByRef Coordinate p1, @ByRef Coordinate p2);
    
    @Name("operator=")
    public native @ByRef Envelope assign(@ByRef Envelope c);
  
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native void expandToInclude(@ByRef Coordinate coordinate);
    public native @ByRef double xMin();
    public native @ByRef double yMin();
    public native @ByRef double zMin();
    public native @ByRef double xMax();
    public native @ByRef double yMax();
    public native @ByRef double zMax();
    
    public static native @Cast("bool") boolean contains(@ByRef Envelope a, @ByRef Envelope b);
    public static native @Cast("bool") boolean overlaps(@ByRef Envelope a, @ByRef Envelope b);
    
    public native @ByRef LineString toRing();
    public native @ByRef Polygon toPolygon();
    public native @ByRef Solid toSolid();
    
    @Name("operator==")
    public native @Cast("bool") boolean equals(@ByRef Envelope other);
  
    public static void main(String[] args){
    	Coordinate c1 = new Coordinate(0.0, 0.0, 0.0);
    	Coordinate c2 = new Coordinate(2.0, 2.0, 2.0);
    	Envelope envelope1 = new Envelope(c1, c2);
    	
    	Coordinate c3 = new Coordinate(4.0, 0.0, 0.0);
    	Coordinate c4 = new Coordinate(6.0, 2.0, 2.0);
    	Envelope envelope2 = new Envelope(c3);
    	envelope2.expandToInclude(c4);
    	
    	Coordinate c5 = new Coordinate(1.0, 0.0, 0.0);
    	Coordinate c6 = new Coordinate(3.0, 3.0, 3.0);
    	Envelope envelope3 = new Envelope();
    	envelope3.expandToInclude(c5);
    	envelope3.expandToInclude(c6);
    	
    	Coordinate c7 = new Coordinate(4.5, 0.5, 0.5);
    	Coordinate c8 = new Coordinate(5.5, 1.5, 1.5);
    	Envelope envelope4 = new Envelope(c7);
    	envelope2.expandToInclude(c8);
    	
    	if(envelope1.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	System.out.println("envelope1.is3D() : " + envelope1.is3D());
    	System.out.println("envelope1.xmin() : " + envelope1.xMin());
    	System.out.println("envelope1.ymin() : " + envelope1.yMin());
    	System.out.println("envelope1.zmin() : " + envelope1.zMin());
    	System.out.println("envelope1.xmax() : " + envelope1.xMax());
    	System.out.println("envelope1.ymax() : " + envelope1.yMax());
    	System.out.println("envelope1.zmax() : " + envelope1.zMax());
    	System.out.println("Envelope.contains(envelope1, envelope2) : " + Envelope.contains(envelope1, envelope2));
    	System.out.println("Envelope.overlaps(envelope1, envelope2) : " + Envelope.overlaps(envelope1, envelope2));
    	System.out.println("Envelope.contains(envelope1, envelope3) : " + Envelope.contains(envelope1, envelope3));
    	System.out.println("Envelope.overlaps(envelope1, envelope3) : " + Envelope.overlaps(envelope1, envelope3));
    	System.out.println("Envelope.contains(envelope2, envelope4) : " + Envelope.contains(envelope2, envelope4));
    	System.out.println("Envelope.overlaps(envelope2, envelope4) : " + Envelope.overlaps(envelope2, envelope4));
    	
    	Solid solid1 = envelope1.toSolid();
    	System.out.println("solid1.exteriorShell().polygon(0).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(0).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(1).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(1).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(2).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(2).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(3).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(3).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(4).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(4).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(5).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(5).exteriorRing().asText(0));
    }
    
}

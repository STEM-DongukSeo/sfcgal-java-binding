package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="MultiSolid.h")
public class MultiSolid extends GeometryCollection {
    static { Loader.load(); }
    public MultiSolid() { allocate(); }
    public MultiSolid(Pointer p) { super(p); }
    private native void allocate();
    
    @Name("operator=")
    public native @ByRef MultiSolid assign(@ByRef MultiSolid other);
    
    public native MultiSolid clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    
    public native @ByRef Solid solidN(@Cast("size_t") int n);

    public static MultiSolid makeMultiSolid(){
    	Point p1 = new Point(0, 0, 0);
    	Point p2 = new Point(0, -2, 0);
    	Point p3 = new Point(2, -2, 0);    	
    	Point p4 = new Point(2, 0, 0);
    	Point p5 = new Point(0, 0, 2);
    	Point p6 = new Point(0, -2, 2);
    	Point p7 = new Point(2, -2, 2);
    	Point p8 = new Point(2, 0, 2);
    	
    	ArrayList<Point> points1 = new ArrayList<Point>();
    	points1.add(p1);
    	points1.add(p2);
    	points1.add(p3);
    	points1.add(p4);
    	points1.add(p5);
    	points1.add(p6);
    	points1.add(p7);
    	points1.add(p8);
    	
    	Point p11 = new Point(4, 0, 0);
    	Point p12 = new Point(4, -2, 0);
    	Point p13 = new Point(6, -2, 0);    	
    	Point p14 = new Point(6, 0, 0);
    	Point p15 = new Point(4, 0, 2);
    	Point p16 = new Point(4, -2, 2);
    	Point p17 = new Point(6, -2, 2);
    	Point p18 = new Point(6, 0, 2);
    	
    	ArrayList<Point> points2 = new ArrayList<Point>();
    	points2.add(p11);
    	points2.add(p12);
    	points2.add(p13);
    	points2.add(p14);
    	points2.add(p15);
    	points2.add(p16);
    	points2.add(p17);
    	points2.add(p18);
    	
    	Solid solid1 = Solid.makeSolid(points1);
    	Solid solid2 = Solid.makeSolid(points2);
    	
    	MultiSolid multiSolid = new MultiSolid();
    	multiSolid.addGeometry(solid1);
    	multiSolid.addGeometry(solid2);
    	
    	return multiSolid;
    }

    public static void main(String[] args){
    	MultiSolid multiSolid = MultiSolid.makeMultiSolid();
    	
    	if(multiSolid.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	System.out.println("multiSolid.geomtryType() : " + multiSolid.geometryType());
    	System.out.println("multiSolid.numGeometries() : " + multiSolid.numGeometries());
    	System.out.println("multiSolid.solidN(0).geometryType() : " + multiSolid.solidN(0).geometryType());
    	System.out.println("multiSolid.solidN(0).asText(-1) : " + multiSolid.solidN(0).asText(-1));
    	System.out.println("multiSolid.solidN(0).numShells() : " + multiSolid.solidN(0).numShells());
    	System.out.println("multiSolid.solidN(1).asText(-1) : " + multiSolid.solidN(1).asText(-1));
    	System.out.println("multiSolid.solidN(1).numShells(): " + multiSolid.solidN(1).numShells());
    	
    }
    
}


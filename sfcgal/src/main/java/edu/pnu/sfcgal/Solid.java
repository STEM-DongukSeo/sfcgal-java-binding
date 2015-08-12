package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="Solid.h")
public class Solid extends Geometry {
    static { Loader.load(); }
    public Solid() { allocate(); }    
    public Solid(ArrayList<PolyhedralSurface> shells) {
    	PointerVector vector = new PointerVector(shells.size());
    	
    	for(int i = 0; i < shells.size(); i++){
    		vector.get(i).put(shells.get(i));
    	}
    	
    	allocate(vector);
    }
    public Solid(Pointer p) { super(p); }
    public Solid(PolyhedralSurface exteriorShell) { allocate(exteriorShell); }
    private native void allocate();
    private native void allocate(@ByRef PointerVector p);
    private native void allocate(@ByRef PolyhedralSurface exteriorShell);
   
    @Name("operator=")
    public native @ByRef Solid assign(@ByRef Solid tr);
    
    public native Solid clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native @ByRef PolyhedralSurface exteriorShell();
    public native @Cast("size_t") int numInteriorShells();
    public native @ByRef PolyhedralSurface interiorShellN(@Cast("size_t") int n);
    public native void addInteriorShell(@ByRef PolyhedralSurface shell);
    public native @Cast("size_t") int numShells();
    public native @ByRef PolyhedralSurface shellN(@Cast("size_t") int n);

    
    public static Solid makeSolid(ArrayList<Point> pointList){
    	Point p1 = pointList.get(0);    	Point p5 = pointList.get(4);
    	Point p2 = pointList.get(1);    	Point p6 = pointList.get(5);
    	Point p3 = pointList.get(2);    	Point p7 = pointList.get(6);
    	Point p4 = pointList.get(3);    	Point p8 = pointList.get(7);
    	LineString ls1 = new LineString();
    	ls1.addPoint(p1);
    	ls1.addPoint(p4);
    	ls1.addPoint(p3);
    	ls1.addPoint(p2);
    	ls1.addPoint(p1);
    	
    	ArrayList<Point> points = new ArrayList<Point>();
    	points.add(p3);
    	points.add(p4);
    	points.add(p8);
    	points.add(p7);
    	points.add(p3);
    	LineString ls2 = new LineString(points);
    	
    	LineString ls3 = new LineString();
    	ls3.addPoint(p5);
    	ls3.addPoint(p6);
    	ls3.addPoint(p7);
    	ls3.addPoint(p8);
    	ls3.addPoint(p5);
    	
    	LineString ls4 = new LineString();
    	ls4.addPoint(p6);
    	ls4.addPoint(p5);
    	ls4.addPoint(p1);
    	ls4.addPoint(p2);
    	ls4.addPoint(p6);
    	ArrayList<LineString> rings = new ArrayList<LineString>();
    	rings.add(ls4);
    	
    	LineString ls5 = new LineString();
    	ls5.addPoint(p2);
    	ls5.addPoint(p3);
    	ls5.addPoint(p7);
    	ls5.addPoint(p6);
    	ls5.addPoint(p2);
    	
    	LineString ls6 = new LineString();
    	ls6.addPoint(p4);
    	ls6.addPoint(p1);
    	ls6.addPoint(p5);
    	ls6.addPoint(p8);
    	ls6.addPoint(p4);
    	
    	Polygon polygon1 = new Polygon();
    	polygon1.setExteriorRing(ls1);
    	Polygon polygon2 = new Polygon(ls2);
    	Polygon polygon3 = new Polygon(ls3);
    	Polygon polygon4 = new Polygon(rings);
    	Polygon polygon5 = new Polygon(ls5);
    	Polygon polygon6 = new Polygon(ls6);
    	
    	ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    	polygons.add(polygon1);
    	polygons.add(polygon2);
    	polygons.add(polygon3);
    	polygons.add(polygon4);
    	polygons.add(polygon5);
    	polygons.add(polygon6);
    	
    	PolyhedralSurface polyhedral = new PolyhedralSurface(polygons);
    	return new Solid(polyhedral);
    }
    
    public static void main(String[] args){
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
    	
    	Point p19 = new Point(5, 0, 0);
    	Point p20 = new Point(5, -2, 0);
    	Point p21 = new Point(7, -2, 0);    	
    	Point p22 = new Point(7, 0, 0);
    	Point p23 = new Point(5, 0, 1);
    	Point p24 = new Point(5, -2, 1);
    	Point p25 = new Point(7, -2, 1);
    	Point p26 = new Point(7, 0, 1);
    	
    	ArrayList<Point> points3 = new ArrayList<Point>();
    	points3.add(p19);
    	points3.add(p20);
    	points3.add(p21);
    	points3.add(p22);
    	points3.add(p23);
    	points3.add(p24);
    	points3.add(p25);
    	points3.add(p26);
    	
    	Solid solid1 = Solid.makeSolid(points1);
    	Solid solid2 = Solid.makeSolid(points2);
    	Solid solid3 = Solid.makeSolid(points3);

    	System.out.println("solid1.exteriorShell().polygon(0).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(0).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(1).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(1).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(2).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(2).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(3).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(3).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(4).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(4).exteriorRing().asText(0));
    	System.out.println("solid1.exteriorShell().polygon(5).exteriorRing().asText() : \n\t" +solid1.exteriorShell().polygonN(5).exteriorRing().asText(0));
    	
    	//System.out.println("solid1 <-> solid2 distance : " + solid1.distance(solid2));
    	System.out.println("solid2 <-> solid2 distance3D : " + solid1.distance3D(solid2));
    	
    	System.out.println("solid1.geometryType() : " + solid1.geometryType());
    	System.out.println("solid1.geometryTypeId() : " + solid1.geometryTypeId());
    	System.out.println("solid1.numGeometries() : " + solid1.numGeometries());
    	System.out.println("solid1.numInteriorShells() : " + solid1.numInteriorShells());
    	System.out.println("solid1.numShells() : " + solid1.numShells());
    	System.out.println("solid1.geometryN(0).asText() : " + solid1.geometryN(0).asText(0));
    	System.out.println("solid1.shellN(0).asText(0) : " + solid1.shellN(0).asText(0));

    	//
    	Envelope envelope1 = solid1.envelope();
    	System.out.println("envelope1.is3D() : " + envelope1.is3D());
    	System.out.println("envelope1.xmin() : " + envelope1.xMin());
    	System.out.println("envelope1.ymin() : " + envelope1.yMin());
    	System.out.println("envelope1.zmin() : " + envelope1.zMin());
    	System.out.println("envelope1.xmax() : " + envelope1.xMax());
    	System.out.println("envelope1.ymax() : " + envelope1.yMax());
    	System.out.println("envelope1.zmax() : " + envelope1.zMax());
    	
    	//Geometry boundary = solid1.boundary();
    	//System.out.println("solid1 boundary.geometryType()" + boundary.geometryType());
    	
    	Geometry intersection  = Algorithm.intersection3D(solid2, solid3);
    	System.out.println(intersection.asText(0));
    	System.out.println(new Solid(intersection).exteriorShell().numPolygons());
    }
    
}

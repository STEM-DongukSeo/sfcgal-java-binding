package edu.pnu.sfcgal;

import java.util.ArrayList;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="TriangulatedSurface.h")
public class TriangulatedSurface extends Surface {
    static { Loader.load(); }
    public TriangulatedSurface() { allocate(); }    
    public TriangulatedSurface(ArrayList<Triangle> triangle) {
    	PointerVector vector = new PointerVector(triangle.size());
    	
    	for(int i = 0; i < triangle.size(); i++){
    		vector.get(i).put(triangle.get(i));
    	}
    	
    	allocate(vector);
    }
    public TriangulatedSurface(Pointer p) { super(p); }
    private native void allocate();
    private native void allocate(@ByRef PointerVector p);
   
    @Name("operator=")
    public native @ByRef TriangulatedSurface assign(@ByRef TriangulatedSurface tr);
    
    public native TriangulatedSurface clone();
    public native @StdString String geometryType();
    public native int geometryTypeId();
    public native int dimension();
    public native int coordinateDimension();
    public native @Cast("bool") boolean isEmpty();
    public native @Cast("bool") boolean is3D();
    public native @Cast("bool") boolean isMeasured();
    
    public native @Cast("size_t") int numTriangles();
    public native @ByRef Triangle triangleN(@Cast("size_t") int n);
    public native void addTriangle(Triangle triangle);
    public native void addTriangles(@ByRef TriangulatedSurface other);
    
    public native @Cast("size_t") int numGeometries();
    public native @ByRef Triangle geometryN(@Cast("size_t") int n);
    public native void reserve(@Cast("size_t") int n);

    public static void main(String[] args){
    	Point p1 = new Point(1.1, 2.2, 3.3, 1);
    	Point p2 = new Point(0.5, 1.5, 2.5, 2);
    	Point p3 = new Point(9.4, 10.2, 1.1, 3);
    	
    	Point p4 = new Point(2.1, 3.2, 4.3, 1);
    	Point p5 = new Point(1.5, 2.5, 3.5, 2);
    	Point p6 = new Point(10.4, 11.2, 2.1, 3);
    	
    	Point p7 = new Point(3.1, 4.2, 5.3, 1);
    	Point p8 = new Point(2.5, 3.5, 4.5, 2);
    	Point p9 = new Point(11.4, 12.2, 3.1, 3);
    	
    	Point p10 = new Point(4.1, 5.2, 6.3, 1);
    	Point p11 = new Point(3.5, 4.5, 5.5, 2);
    	Point p12 = new Point(12.4, 13.2, 4.1, 3);
    	
    	Point p13 = new Point(5.1, 6.2, 7.3, 1);
    	Point p14 = new Point(4.5, 5.5, 6.5, 2);
    	Point p15 = new Point(13.4, 14.2, 5.1, 3);
    	
    	Triangle tr1 = new Triangle(p1, p2, p3);
    	Triangle tr2 = new Triangle(p4, p5, p6);
    	Triangle tr3 = new Triangle(p7, p8, p9);
    	Triangle tr4 = new Triangle(p10, p11, p12);
    	Triangle tr5 = new Triangle(p13, p14, p15);

    	ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    	triangles.add(tr1);
    	triangles.add(tr2);
    	
    	ArrayList<Triangle> triangles2 = new ArrayList<Triangle>();
    	triangles2.add(tr3);
    	triangles2.add(tr4);
    	
    	TriangulatedSurface trs = new TriangulatedSurface(triangles);
    	
    	if(trs.isEmpty()){
    		System.out.println("empty");
    	}else{
    		System.out.println("not empty");
    	}
    	
    	System.out.println("trs coodinateDemension : " + trs.coordinateDimension());
    	System.out.println("trs demension : " + trs.dimension());
    	System.out.println("trs numTriangles : " + trs.numTriangles());
    	System.out.println("trs numGeometries : " + trs.numGeometries());
    	System.out.println("trs toString : " + trs.toString());
    	
    	TriangulatedSurface trs2 = new TriangulatedSurface(trs);
    	
    	trs2.addTriangle(tr5);
    	System.out.println("\ntrs2.addTriangle(tr5)");
    	System.out.println("trs2 numTriangles : " + trs2.numTriangles());
    	System.out.println("trs2 numGeometries : " + trs2.numGeometries());
    	
    	System.out.println("trs numTriangles()" + trs.numTriangles());
    	trs2.addTriangles(trs);
    	System.out.println("\ntrs2.addTriangles(trs)");
    	System.out.println("trs2 numTriangles : " + trs2.numTriangles());
    	System.out.println("trs2 numGeometries : " + trs2.numGeometries());
    	System.out.println("trs2.triangle(2) toString : " + trs2.triangleN(2).toString());
    	System.out.println("trs2.triangle(2) vertex(2).m() : " + trs2.triangleN(2).vertex(2).m());
    	
    	//System.out.println("trs boundary " + trs.boundary().geometryType());
    }
    
}

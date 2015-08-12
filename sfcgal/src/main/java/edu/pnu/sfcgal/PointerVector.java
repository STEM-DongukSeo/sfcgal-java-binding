package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Namespace;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include = "<vector>")
@Namespace("std")
@Name("vector<void*>")
public class PointerVector extends Pointer {
	static { Loader.load(); }
	public PointerVector() {
		allocate();
	}

	public PointerVector(long n) {
		allocate(n);
	}

	// this = (vector<void*>*)p
	public PointerVector(Pointer p) {
		super(p);
	} 

	// this = new std::vector<void*>()
	private native void allocate(); 

	// this = new std::vector<void*>(n)
	private native void allocate(long n); 

	@Name("operator=")
	public native @ByRef PointerVector copy(@ByRef PointerVector x);

	public native long size();

	public native @Cast("bool") boolean empty();

	@Name("operator[]")
	public native @ByRef PointerPointer get(long n);

	public native @ByRef PointerPointer at(long n);
    
    public static void main(String[] args){
    	PointerVector v = new PointerVector(5);
    	
    	Point p = new Point(1.1, 2.2) ;
    	
    	v.get(0).put(p);
    	
    	System.out.println( new Point(v.get(0).get()).coordinateDimension() );
    	/*
    	Pointer p1 = new Pointer() { { address = 0xDEADBEEFL; } };
    	v.get(0).put(p1);
    	Pointer p2 = v.get(0).get();
    	System.out.println(p1);
    	System.out.println(p2);
    	 * */
    }
}
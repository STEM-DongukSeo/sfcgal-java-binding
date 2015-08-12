//package org.bytedeco.javacpp.example;
package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.ByRef;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;

@Platform(include="Coordinate.h")
//@Namespace("SFCGAL")
public class SFCGAL {
    public static class Coordinate extends Pointer {
        static { Loader.load(); }
        public Coordinate() { allocate(); }
        public Coordinate(double x, double y) { allocate(x, y); }
        public Coordinate(double x, double y, double z) { allocate(x, y, z); }
        public Coordinate(Pointer p) { super(p); }
        private native void allocate();
        private native void allocate(double x, double y, double z);
        private native void allocate(double x, double y);
        // to call the getter and setter functions 
        //public native @StdString String get_property(); public native void set_property(String property);

        // to access the member variable directly
        //public native @StdString String property();     public native void property(String property);
        
        @Name("operator=")
        public native @ByRef Coordinate put1(@ByRef Coordinate c);
      
        public native int coordinateDimension();
        public native @Cast("bool") boolean isEmpty();
        public native @Cast("bool") boolean is3D();
      
        public native @ByRef Coordinate round(@ByRef long scaleFactor);
        
        @Name("operator<")
        public native @Cast("bool") boolean isSmallerThan(@ByRef Coordinate c);
        
        @Name("operator==")
        public native @Cast("bool") boolean put3(@ByRef Coordinate c);
        
        @Name("operator!=")
        public native @Cast("bool") boolean put4(@ByRef Coordinate c);

	//public native @Cast("double") double x();
	//public native @Cast("double") double y();
	//public native @Cast("double") double z();
        
    }

    
    public static void main(String[] args) {
        // Pointer objects allocated in Java get deallocated once they become unreachable,
        // but C++ destructors can still be called in a timely fashion with Pointer.deallocate()
	Coordinate c = new Coordinate();
        Coordinate c1 = new Coordinate(5.0, 4.9, 16.1);

	//System.out.println("c1 : (" + c1.x() + ", " + c1.y() + ", " + c1.z() + ")");

        if(c1.isEmpty()){
        	System.out.println("c1 is empty");
        }else{
        	System.out.println("c1 is not empty");
        }

	if(c1.is3D()){
        	System.out.println("c1 is 3D");
        }else{
        	System.out.println("c1 is not 3D");
        }

	System.out.println("c1 coordinate dimension is " + c1.coordinateDimension());

	Coordinate c2 = c1.round(1);
	//System.out.println("c2 : (" + c2.x() + ", " + c2.y() + ", " + c2.z() + ")");
	if(c1.isSmallerThan(c2)){
		System.out.println("c1 is smaller than c2");
	}else{
		System.out.println("c1 is not smaller than c2");
	}

    }
}

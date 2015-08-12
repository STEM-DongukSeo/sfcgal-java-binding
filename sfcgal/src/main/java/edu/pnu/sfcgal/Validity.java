package edu.pnu.sfcgal;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.StdString;

@Platform(include="Validity.h")
public class Validity extends Pointer{
	static { Loader.load(); }
    public Validity() { allocate(); }
    
    //public Validity(String reason) { allocate(reason); }
    //public Validity(Pointer p) { super(p); }
    private native void allocate();
    
    //private native void allocate(String reason);
    
    //@Name("operator bool")
    //public native @Cast("bool") boolean isValid();
    
    //public native @StdString String reason();
    
    public static void main(String[] args){
    	//Validity validity = new Validity();
    	//Validity validity2 = new Validity("test");
    	
    	//System.out.println(validity.isValid());
    	//System.out.println(validity2.isValid());
    	//System.out.println(validity2.reason());
    }
}
#ifndef JAVACPP_SFCGAL_TriangulatedSurface_H
#define JAVACPP_SFCGAL_TriangulatedSurface_H

#include <SFCGAL/TriangulatedSurface.h>
#include "Point.h"
#include "Surface.h"
#include "Triangle.h"

class TriangulatedSurface : public Surface {
public:	
	TriangulatedSurface() : Surface(new SFCGAL::TriangulatedSurface()) { }
	TriangulatedSurface(const std::vector< void * > & triangle) {
		std::vector<SFCGAL:: Triangle>* cpp_base_triangle = new std::vector<SFCGAL::Triangle>();

		for(size_t i=0; i<triangle.size(); i++){
			cpp_base_triangle->push_back( *(SFCGAL::Triangle *)(((Triangle *)triangle.at(i))->get_data()) );
		}

		data = new SFCGAL::TriangulatedSurface(*cpp_base_triangle);
	}
	
	//TriangulatedSurface(const TriangulatedSurface& other) : Surface(new SFCGAL::TriangulatedSurface(*other.data)) { }
	TriangulatedSurface(const SFCGAL::TriangulatedSurface& other) : Surface(new SFCGAL::TriangulatedSurface(other)) { }
	TriangulatedSurface(SFCGAL::TriangulatedSurface* other) : Surface(other) { }
	//TriangulatedSurface( const CGAL::TriangulatedSurface_2& other );
	//TriangulatedSurface( const CGAL::TriangulatedSurface_3& other );

	TriangulatedSurface& operator=(const TriangulatedSurface& other) {
		data = other.data;
		
		return *this;
	}
	
	~TriangulatedSurface() { }
	
	
	//--SFCGAL::Geometry
	TriangulatedSurface* clone() const {
		return new TriangulatedSurface(*this);
	}
	
	std::string geometryType() const {
		return data->geometryType();
	}	
	
	int geometryTypeId() const {
		return data->geometryTypeId();
	}
	
	int dimension() const {
		return data->dimension();
	}
	
	int coordinateDimension() const {
		return data->coordinateDimension();
	}

	bool isEmpty() const {
		return data->isEmpty();
	}

	bool is3D() const {
		return data->is3D();
	}
	
	bool isMeasured() const {
		return data->isMeasured();
	}

	
	size_t numTriangles() const {
		return ((SFCGAL::TriangulatedSurface *)data)->numTriangles();
	}

	const Triangle& triangleN( size_t const& n ) const {
		return *(new Triangle(((SFCGAL::TriangulatedSurface *)data)->triangleN(n)));
	}
	
	Triangle& triangleN( size_t const& n) {
		return *(new Triangle(((SFCGAL::TriangulatedSurface *)data)->triangleN(n)));
	}

	void addTriangle( const Triangle& triangle ) {
		((SFCGAL::TriangulatedSurface *)data)->addTriangle(*(SFCGAL::Triangle *)(triangle.get_data()));
	}

	void addTriangle( Triangle* triangle ) {
		((SFCGAL::TriangulatedSurface *)data)->addTriangle(*(SFCGAL::Triangle *)(triangle->get_data()));
	}

	
	void addTriangles( TriangulatedSurface& other ) {
		((SFCGAL::TriangulatedSurface *)data)->addTriangles(
			*(new SFCGAL::TriangulatedSurface( *((SFCGAL::TriangulatedSurface *)other.data)) )
			);
	}

	size_t numGeometries() const {
		return ((SFCGAL::TriangulatedSurface *)data)->numGeometries();
	}

	/*
	const Triangle& geometryN(size_t const& n) const {
		return *(new Triangle( (((SFCGAL::TriangulatedSurface *)data)->geometryN(n)).clone() ));
	}
	*/

	Triangle& geometryN(size_t const& n) const {
		return *(new Triangle( ((SFCGAL::TriangulatedSurface *)data)->geometryN(n) ));
	}

	void reserve(const size_t& n) {
		((SFCGAL::TriangulatedSurface *)data)->reserve(n);
	}

/* Polyhedron -> CGAL::Polyhedron_3
	Polyhedron toPolyhedron_3() const { //virtual std::auto_ptr<Polyehedron> toPolyhedron_3() const;
		//if(data == NULL) return NULL;
		std::auto_ptr<SFCGAL::Polyhedron> ph = ((SFCGAL::TrangulatedSurface *)data)->toPolyhedron_3();

		Polyhedron *polyhedron = new Polyhedron(ph.release);

		return *polyhedron;
	}
*/
	//iterator begin();
	//iterator begin() const;
	//iterator end();
	//iterator end() const;
	
	//Kernel::TriangulatedSurface_2 toTriangulatedSurface_2() const;
	//Kernel::TriangulatedSurface_3 toTriangulatedSurface_3() const;
	

	//void accept(GeometryVisitor& visitor);
	//void accept(ConstGeometryVisitor& visitor) const ;
};

#endif

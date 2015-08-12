#ifndef JAVACPP_SFCGAL_PolyhedralSurface_H
#define JAVACPP_SFCGAL_PolyhedralSurface_H

#include <SFCGAL/PolyhedralSurface.h>
#include "Point.h"
#include "Surface.h"
#include "Polygon.h"
#include "TriangulatedSurface.h"

class PolyhedralSurface : public Surface {
public:	
	PolyhedralSurface() : Surface(new SFCGAL::PolyhedralSurface()) { }
	PolyhedralSurface(const std::vector< void * > & polygons) {
		std::vector<SFCGAL:: Polygon>* cpp_base_polygon = new std::vector<SFCGAL::Polygon>();

		for(size_t i=0; i<polygons.size(); i++){
			cpp_base_polygon->push_back( *(SFCGAL::Polygon *)(((Polygon *)polygons.at(i))->get_data()) );
		}

		data = new SFCGAL::PolyhedralSurface(*cpp_base_polygon);
	}
	
	//PolyhedralSurface(const PolyhedralSurface& other) : Surface(new SFCGAL::PolyhedralSurface(*other.data)) { }
	PolyhedralSurface(const SFCGAL::PolyhedralSurface& other) : Surface(new SFCGAL::PolyhedralSurface(other)) { }
	//PolyhedralSurface(const detail::MarkedPolyhedron& poly);	

	//PolyhedralSurface( const CGAL::PolyhedralSurface_2& other );
	//PolyhedralSurface( const CGAL::PolyhedralSurface_3& other );

	PolyhedralSurface& operator=(const PolyhedralSurface& other) {
		data = other.data;
		
		return *this;
	}
	
	~PolyhedralSurface() { }
	
	
	//--SFCGAL::Geometry
	PolyhedralSurface* clone() const {
		return new PolyhedralSurface(*this);
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


	TriangulatedSurface& toTriangulatedSurface() const{
		return *(new TriangulatedSurface(((SFCGAL::PolyhedralSurface *)data)->toTriangulatedSurface()));
	}
	
	size_t numPolygons() const {
		return ((SFCGAL::PolyhedralSurface *)data)->numPolygons();
	}

	const Polygon& polygonN( size_t const & n) const {
		return *(new Polygon(((SFCGAL::PolyhedralSurface *)data)->polygonN(n)));
	}
	
	Polygon& polygonN( size_t const & n) {
		return *(new Polygon(((SFCGAL::PolyhedralSurface *)data)->polygonN(n)));
	}

	void addPolygon( const Polygon& polygon ) {
		((SFCGAL::PolyhedralSurface *)data)->addPolygon(*(SFCGAL::Polygon *)(polygon.get_data()));
	}

	void addPolygon( Polygon* polygon ) {
		((SFCGAL::PolyhedralSurface *)data)->addPolygon(*(SFCGAL::Polygon *)(polygon->get_data()));
	}
	
	void addPolygons( PolyhedralSurface& other ) {
		((SFCGAL::PolyhedralSurface *)data)->addPolygons(
			*(new SFCGAL::PolyhedralSurface( *((SFCGAL::PolyhedralSurface *)other.data)) )
			);
	}

	size_t numGeometries() const {
		return ((SFCGAL::PolyhedralSurface *)data)->numGeometries();
	}
/*
	const Triangle& geometryN(size_t const& n) const {
		return *(new Triangle( ((SFCGAL::PolyhedralSurface *)data)->geometryN(n) ));
	}
*/
	Polygon& geometryN(size_t const& n) const {
		return *(new Polygon( ((SFCGAL::PolyhedralSurface *)data)->geometryN(n) ));
	}

/*	Polyhedron -> CGAL::Polyhedron_3
	Polyhedron toPolyhedron_3() const { //virtual std::auto_ptr<Polyehedron> toPolyhedron_3() const;
		//if(data == NULL) return NULL;
		std::auto_ptr<SFCGAL::Polyhedron> ph = ((SFCGAL::PolyhedralSurface *)data)->toPolyhedron_3();

		Polyhedron *polyhedron = new Polyhedron(ph.release());

		return *polyhedron;
	}
*/
	//iterator begin();
	//iterator begin() const;
	//iterator end();
	//iterator end() const;
	
	//Kernel::PolyhedralSurface_2 toPolyhedralSurface_2() const;
	//Kernel::PolyhedralSurface_3 toPolyhedralSurface_3() const;
	

	//void accept(GeometryVisitor& visitor);
	//void accept(ConstGeometryVisitor& visitor) const ;
};

#endif

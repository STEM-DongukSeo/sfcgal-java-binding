#ifndef JAVACPP_SFCGAL_Polygon_H
#define JAVACPP_SFCGAL_Polygon_H

#include <SFCGAL/Polygon.h>
#include "Geometry.h"
#include "LineString.h"
#include "Surface.h"
#include "Triangle.h"

class Polygon : public Surface {
public:	
	Polygon() : Surface(new SFCGAL::Polygon()) { }
	Polygon(const std::vector< void * > & rings) {
		std::vector<SFCGAL::LineString>* cpp_base_rings = new std::vector<SFCGAL::LineString>();

		for(size_t i=0; i<rings.size(); i++){
			cpp_base_rings->push_back( *(SFCGAL::LineString *)(((LineString *)rings.at(i))->get_data()) );
		}

		data = new SFCGAL::Polygon(*cpp_base_rings);
	}
	Polygon(const LineString& exteriorRing) : Surface(new SFCGAL::Polygon(*(SFCGAL::LineString *)(exteriorRing.get_data()))) { }
	//Polygon(LineString* exteriorRing) : Surface(new SFCGAL::Polygon(*(SFCGAL::LineString *)(exteriorRing->get_data()))) { }
	//Polygon(const SFCGAL::LineString& exteriorRing) : Surface(new SFCGAL::Polygon(exteriorRing)) { }
	//Polygon(SFCGAL::LineString* exteriorRing) : Surface(new SFCGAL::Polygon(*exteriorRing)) { }

	Polygon(Triangle& triangle) : Surface(new SFCGAL::Polygon(*(SFCGAL::Triangle *)(triangle.get_data()))) { }
	//Polygon(const SFCGAL::Triangle& triangle);

	//Polygon(const Polygon& other) : Surface(new SFCGAL::Polygon(*(SFCGAL::Polygon *)(other.data))) { }
	//Polygon(Polygon& other) : Surface(new SFCGAL::Polygon(*(SFCGAL::Polygon *)(other.data))) { }
	Polygon(const SFCGAL::Polygon& other) : Surface(new SFCGAL::Polygon(other)) { }
	Polygon(SFCGAL::Polygon* other) : Surface(other) { }

	//Polygon( const CGAL::Polygon_2< Kernel >& other );
	//Polygon( const CGAL::Polygon_with_holes_2< Kernel >& other );

	Polygon& operator=(const Polygon& other) {
		data = other.data;
		
		return *this;
	}
	
	~Polygon() { }
	
	
	//--SFCGAL::Geometry
	Polygon* clone() const {
		return new Polygon(*this);
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



	bool isCounterClockWiseOriented() {
		return ((SFCGAL::Polygon *)data)->isCounterClockWiseOriented();
	}
	
	void reverse() {
		((SFCGAL::Polygon *)data)->reverse();
	}

	
	LineString& exteriorRing() const { // not used
		return *(new LineString(((SFCGAL::Polygon *)data)->exteriorRing()));
	}

	LineString& exteriorRing() {
		return *(new LineString(((SFCGAL::Polygon *)data)->exteriorRing()));
	}

	void setExteriorRing(const LineString& ring) {
		((SFCGAL::Polygon *)data)->setExteriorRing(*(SFCGAL::LineString *)(ring.get_data()));
	}
	//void setExteriorRing(const SFCGAL::LineString& ring);
	
	bool hasInteriorRings() const {
		return ((SFCGAL::Polygon *)data)->hasInteriorRings();
	}

	size_t numInteriorRings() const {
		return ((SFCGAL::Polygon *)data)->numInteriorRings();
	}

	const LineString& interiorRingN(const size_t& n) const {
		return *(new LineString(((SFCGAL::Polygon *)data)->interiorRingN(n)));
	}

	LineString& interiorRingN(const size_t& n) {
		return *(new LineString(((SFCGAL::Polygon *)data)->interiorRingN(n)));
	}

	size_t numRings() const {
		return ((SFCGAL::Polygon *)data)->numRings();
	}

	const LineString& ringN( size_t const & n) const {
		return *(new LineString(((SFCGAL::Polygon *)data)->ringN(n)));
	}
	
	LineString& ringN( size_t const & n) {
		return *(new LineString(((SFCGAL::Polygon *)data)->ringN(n)));
	}
	
	
	void addInteriorRing(const LineString& ls){
		((SFCGAL::Polygon *)data)->addInteriorRing(*(SFCGAL::LineString *)(ls.get_data()));
	}

	void addInteriorRing(LineString* ls){
		((SFCGAL::Polygon *)data)->addInteriorRing(*(SFCGAL::LineString *)(ls->get_data()));
	}
	//void addInteriorRing(SFCGAL::LineString* ls);

	void addRing( const LineString& ls ) {
		((SFCGAL::Polygon *)data)->addRing(*(SFCGAL::LineString *)(ls.get_data()));
	}

	void addRing( LineString* ls ) {
		((SFCGAL::Polygon *)data)->addRing(*(SFCGAL::LineString *)(ls->get_data()));
	}

	
	// iterator begin() ;
	// const_iterator begin();
	// iterator end() ;
	// const_iterator end();

	//CGAL::Polygon_2<Kernel> toPolygon_2(bool fixOrientation = true) const;
	//CGAL::Polygon_2<Kernel> toPolygon_with_holes_2(bool fixOrientation = true) const;

	//void accept(GeometryVisitor& visitor);
	//void accept(ConstGeometryVisitor& visitor) const ;
};

#endif

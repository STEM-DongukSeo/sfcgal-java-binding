#ifndef JAVACPP_SFCGAL_MultiPolygon_H
#define JAVACPP_SFCGAL_MultiPolygon_H

#include <SFCGAL/MultiPolygon.h>
#include "GeometryCollection.h"
#include "Polygon.h"

class MultiPolygon : public GeometryCollection {
public:	
	MultiPolygon() : GeometryCollection(new SFCGAL::MultiPolygon()) { }
	//MultiPolygon(const MultiPolygon& other) : Geometry(other.data) { }
	MultiPolygon(const SFCGAL::MultiPolygon& other) : GeometryCollection(new SFCGAL::MultiPolygon(other)) { }
	//MultiPolygon(SFCGAL::MultiPolygon& other) : Geometry(new SFCGAL::MultiPolygon(other)) { }
	MultiPolygon(SFCGAL::MultiPolygon* other) : GeometryCollection(other) { }

	MultiPolygon& operator=(const MultiPolygon& other) {
		data = other.data;
		
		return *this;
	}
	
	~MultiPolygon() { }
	
	
	//--SFCGAL::Geometry
	MultiPolygon* clone() const {
		return new MultiPolygon(*this);
	}
	
	std::string geometryType() const {
		return data->geometryType();
	}	
	
	int geometryTypeId() const {
		return data->geometryTypeId();
	}
	

	const Polygon& polygonN( size_t const & n) const {
		return *(new Polygon(((SFCGAL::MultiPolygon *)data)->polygonN(n)));
	}
	
	Polygon& polygonN(size_t const& n) {
		return *(new Polygon(((SFCGAL::MultiPolygon *)data)->polygonN(n)));
	}
	
};

#endif

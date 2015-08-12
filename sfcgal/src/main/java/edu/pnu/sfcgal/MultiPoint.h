#ifndef JAVACPP_SFCGAL_MultiPoint_H
#define JAVACPP_SFCGAL_MultiPoint_H

#include <SFCGAL/MultiPoint.h>
#include "GeometryCollection.h"
#include "Point.h"

class MultiPoint : public GeometryCollection {
public:	
	MultiPoint() : GeometryCollection(new SFCGAL::MultiPoint()) { }
	//MultiPoint(const MultiPoint& other) : Geometry(other.data) { }
	MultiPoint(const SFCGAL::MultiPoint& other) : GeometryCollection(new SFCGAL::MultiPoint(other)) { }
	//MultiPoint(SFCGAL::MultiPoint& other) : Geometry(new SFCGAL::MultiPoint(other)) { }
	//MultiPoint(SFCGAL::MultiPoint* other) : Geometry(other) { }

	MultiPoint& operator=(const MultiPoint& other) {
		data = other.data;
		
		return *this;
	}
	
	~MultiPoint() { }
	
	
	//--SFCGAL::Geometry
	MultiPoint* clone() const {
		return new MultiPoint(*this);
	}
	
	std::string geometryType() const {
		return data->geometryType();
	}	
	
	int geometryTypeId() const {
		return data->geometryTypeId();
	}
	

	const Point& pointN( size_t const & n) const {
		return *(new Point(((SFCGAL::MultiPoint *)data)->pointN(n)));
	}
	
	Point& pointN(size_t const& n) {
		return *(new Point(((SFCGAL::MultiPoint *)data)->pointN(n)));
	}
	
};

#endif

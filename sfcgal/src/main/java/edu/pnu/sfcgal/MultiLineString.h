#ifndef JAVACPP_SFCGAL_MultiLineString_H
#define JAVACPP_SFCGAL_MultiLineString_H

#include <SFCGAL/MultiLineString.h>
#include "GeometryCollection.h"
#include "LineString.h"

class MultiLineString : public GeometryCollection {
public:	
	MultiLineString() : GeometryCollection(new SFCGAL::MultiLineString()) { }
	//MultiLineString(const MultiLineString& other) : Geometry(other.data) { }
	MultiLineString(const SFCGAL::MultiLineString& other) : GeometryCollection(new SFCGAL::MultiLineString(other)) { }
	//MultiLineString(SFCGAL::MultiLineString& other) : Geometry(new SFCGAL::MultiLineString(other)) { }
	MultiLineString(SFCGAL::MultiLineString* other) : GeometryCollection(other) { }

	MultiLineString& operator=(const MultiLineString& other) {
		data = other.data;
		
		return *this;
	}
	
	~MultiLineString() { }
	
	
	//--SFCGAL::Geometry
	MultiLineString* clone() const {
		return new MultiLineString(*this);
	}
	
	std::string geometryType() const {
		return data->geometryType();
	}	
	
	int geometryTypeId() const {
		return data->geometryTypeId();
	}
	

	const LineString& lineStringN( size_t const & n) const {
		return *(new LineString(((SFCGAL::MultiLineString *)data)->lineStringN(n)));
	}
	
	LineString& lineStringN(size_t const& n) {
		return *(new LineString(((SFCGAL::MultiLineString *)data)->lineStringN(n)));
	}
	
};

#endif

#ifndef JAVACPP_SFCGAL_MultiSolid_H
#define JAVACPP_SFCGAL_MultiSolid_H

#include <SFCGAL/MultiSolid.h>
#include "GeometryCollection.h"
#include "Solid.h"

class MultiSolid : public GeometryCollection {
public:	
	MultiSolid() : GeometryCollection(new SFCGAL::MultiSolid()) { }
	//MultiSolid(const MultiSolid& other) : Geometry(other.data) { }
	MultiSolid(const SFCGAL::MultiSolid& other) : GeometryCollection(new SFCGAL::MultiSolid(other)) { }
	//MultiSolid(SFCGAL::MultiSolid& other) : Geometry(new SFCGAL::MultiSolid(other)) { }
	//MultiSolid(SFCGAL::MultiSolid* other) : Geometry(other) { }

	MultiSolid& operator=(const MultiSolid& other) {
		data = other.data;
		
		return *this;
	}
	
	~MultiSolid() { }
	
	
	//--SFCGAL::Geometry
	MultiSolid* clone() const {
		return new MultiSolid(*this);
	}
	
	std::string geometryType() const {
		return data->geometryType();
	}	
	
	int geometryTypeId() const {
		return data->geometryTypeId();
	}
	

	const Solid& solidN( size_t const & n) const {
		return *(new Solid(((SFCGAL::MultiSolid *)data)->solidN(n)));
	}
	
	Solid& solidN(size_t const& n) {
		return *(new Solid(((SFCGAL::MultiSolid *)data)->solidN(n)));
	}
	
};

#endif

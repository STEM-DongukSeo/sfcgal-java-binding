#ifndef JAVACPP_SFCGAL_GeometryCollection_H
#define JAVACPP_SFCGAL_GeometryCollection_H

#include <SFCGAL/GeometryCollection.h>
#include "Geometry.h"

class GeometryCollection : public Geometry {
public:	
	GeometryCollection() : Geometry(new SFCGAL::GeometryCollection()) { }
	
	//GeometryCollection(const GeometryCollection& other) : Geometry(other.data) { }
	GeometryCollection(const SFCGAL::GeometryCollection& other) : Geometry(new SFCGAL::GeometryCollection(other)) { }
	//GeometryCollection(SFCGAL::GeometryCollection& other) : Geometry(new SFCGAL::GeometryCollection(other)) { }
	GeometryCollection(SFCGAL::GeometryCollection* other) : Geometry(other) { }

	GeometryCollection& operator=(const GeometryCollection& other) {
		data = other.data;
		
		return *this;
	}
	
	~GeometryCollection() { }
	
	
	//--SFCGAL::Geometry
	GeometryCollection* clone() const {
		return new GeometryCollection(*this);
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

	size_t numGeometries() const {
		return data->numGeometries();
	}


	const Geometry& geometryN(size_t const& n) const {
		return *(new Geometry( ((SFCGAL::GeometryCollection *)data)->geometryN(n) ));
	}

	Geometry& geometryN(size_t const& n) {
		return *(new Geometry( ((SFCGAL::GeometryCollection *)data)->geometryN(n) ));
	}
	
	void addGeometry(Geometry* geometry) {
		((SFCGAL::GeometryCollection *)data)->addGeometry(geometry->get_data());
	}

	void addGeometry(const Geometry& geometry){
		((SFCGAL::GeometryCollection *)data)->addGeometry(*geometry.get_data());
	}
	
	// iterator begin() ;
	// iterator end() ;

	//void accept(GeometryVisitor& visitor);
	//void accept(ConstGeometryVisitor& visitor) const ;
};

#endif

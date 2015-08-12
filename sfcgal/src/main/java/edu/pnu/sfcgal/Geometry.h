#ifndef JAVACPP_SFCGAL_Geometry_H
#define JAVACPP_SFCGAL_Geometry_H

#include <SFCGAL/Geometry.h>
#include "Envelope.h"

class Point;
class LineString;
class Polygon;
class GeometryCollection;
class MultiPoint;
class MultiLineString;
class MultiPolygon;

class Triangle;
class TriangulateSurface;
class PolyhedralSurface;

class Solid;
class MultiSolid;
//class Grid;

class Envelope;

class Geometry{
protected:
	SFCGAL::Geometry* data;
public:
	typedef SFCGAL::Geometry cpp_base;
	const cpp_base* get_data() const { return data; }
	cpp_base* get_data() { return data; }

	Geometry() : data(NULL) { }
	Geometry(const Geometry& other) : data(other.data) { }
	Geometry(SFCGAL::Geometry& other) : data(&other){ }
	//Geometry(const SFCGAL::Geometry& other) : data(&other){ }
	//Geometry(const SFCGAL::Geometry* other) : data(other){ }
	Geometry(SFCGAL::Geometry* other) : data(other){ }
	
	virtual ~Geometry() {
		if(data != NULL) delete data;
	}
	
	//--SFCGAL::Geometry
	virtual Geometry* clone() const {
		if(data == NULL) return NULL;

		return new Geometry(data->clone());
	}

	virtual std::string geometryType() const {
		if(data == NULL) return "";

		return data->geometryType();
	}
	
	virtual int geometryTypeId() const {
		if(data == NULL) return -1;

		return data->geometryTypeId();
	}
	
	virtual int dimension() const {
		if(data == NULL) return -1;

		return data->dimension();
	}
	
	virtual int coordinateDimension() const {
		if(data == NULL) return -1;

		return data->coordinateDimension();
	}

	virtual bool isEmpty() const {
		if(data == NULL) return false;
		
		return data->isEmpty();
	}


	virtual bool is3D() const {
		if(data == NULL) return false;

		return data->is3D();
	}
	
	virtual bool isMeasured() const {
		if(data == NULL) return false;

		return data->isMeasured();
	}

	std::string asText(const int& numDecimals = -1) const {
		if(data == NULL) return "";

		return data->asText(numDecimals);
	}

	Envelope& envelope() const {
		return *(new Envelope(data->envelope()));
	}
		
	virtual Geometry& boundary() const {	//virtual std::auto_ptr<Geometry> boundary() const;
		//if(data == NULL) return NULL;
		std::auto_ptr<SFCGAL::Geometry> p = data->boundary();

		Geometry *geometry = new Geometry(p.release());

		return *geometry;
	}

	double distance(const Geometry& other) const {
		if(data == NULL) return -1;

		return data->distance(*(other.get_data()));
	}

	double distance3D(const Geometry& other) const {
		if(data == NULL) return -1;

		return data->distance3D(*(other.get_data()));
	}

	void round(const long& scale = 1) {
		if(data == NULL) return ;

		data->round(scale);
	}

	virtual size_t numGeometries() const {
		//if(data == NULL) return -1;

		return data->numGeometries();
	}
	
	virtual const Geometry& geometryN(size_t const& n) const {
		return *(new Geometry(data->geometryN(n)));
	}

	virtual Geometry& geometryN(size_t const &n) {
		return *(new Geometry(data->geometryN(n)));
	}

	//template<typename Derived>
	//bool is() const;

	//template<typename Derived>
	//Derived& as();
	/*
	virtual void accept(SFCGAL::GeometryVisitor& visitor) {
		if(data == NULL) return;

		data->accept(visitor);
	}

	virtual void accept(SFCGAL::ConstGeometryVisitor& visitor) {
		if(data == NULL) return;

		data->accept(visitor);
	}
	*/

	bool operator==(const Geometry& other){
		return ( *data == *(other.data) );
	}
};

#endif

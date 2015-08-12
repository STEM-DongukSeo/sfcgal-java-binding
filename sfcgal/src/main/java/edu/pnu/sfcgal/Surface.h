#ifndef JAVACPP_SFCGAL_Surface_H
#define JAVACPP_SFCGAL_Surface_H

#include <SFCGAL/Surface.h>
#include "Geometry.h"

class Surface : public Geometry {
public:
	Surface() : Geometry() { }
	//Surface(const Surface& other) : Geometry(other.data) { }
	//Surface(Surface* other) : Geometry(other->data) { }
	//Surface(const SFCGAL::Surface& other) : Geometry(new SFCGAL::Surface(other)) { }
	Surface(SFCGAL::Surface* other) : Geometry(other) { }

	~Surface() { }

	//--SFCGAL::Geometry
	int dimension() const {
		return data->dimension();
	}
};

#endif

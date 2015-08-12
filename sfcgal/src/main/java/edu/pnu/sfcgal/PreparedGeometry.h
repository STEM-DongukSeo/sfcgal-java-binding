#ifndef JAVACPP_SFCGAL_PreparedGeometry_H
#define JAVACPP_SFCGAL_PreparedGeometry_H

#include <SFCGAL/PreparedGeometry.h>
#include <stdint.h>
#include "Geometry.h"

//typedef uint32_t srid_t;
typedef SFCGAL::srid_t srid_t;

class PreparedGeometry{
	SFCGAL::PreparedGeometry data;
public:
	typedef SFCGAL::PreparedGeometry cpp_base;
	const cpp_base& get_data() const { return data; }
	cpp_base& get_data() { return data; }
	
	PreparedGeometry() : data() { }
	PreparedGeometry(Geometry& g, srid_t srid) : data(g.get_data(), srid) { }
	//PreparedGeometry(SFCGAL::PreparedGeometry* other) : data(*other) { }
	
	~PreparedGeometry() { }
/*	
	const Geometry& geometry() const { // not used
		return *(new Geometry(data.geometry()));
	}
*/
	Geometry& geometry() {
		return *(new Geometry(data.geometry()));
	}

	void resetGeometry( Geometry* geom ) {
		data.resetGeometry(geom->get_data());
	}

	srid_t& SRID() {
		return data.SRID();
	}

	void resetSRID(srid_t srid) {
		data.SRID()=srid;
	}

	//const Envelope& envelope() const // not used
	Envelope& envelope() const {
		return *(new Envelope(data.envelope()));
	}

	void invalidateCache() {
		data.invalidateCache();
	}

	std::string asEWKT( const int numDecimals ) const {
		return data.asEWKT(numDecimals);
	}
};

#endif

#include "Envelope.h"
#include "LineString.h"
#include "Polygon.h"
#include "Solid.h"

LineString& Envelope::toRing() const {
	std::auto_ptr<SFCGAL::LineString> p = data.toRing();
	
	LineString *lineString = new LineString(p.release());

	return *lineString;
}

Polygon& Envelope::toPolygon() const {
	std::auto_ptr<SFCGAL::Polygon> p = data.toPolygon();

	Polygon *polygon = new Polygon(p.release());

	return *polygon;
}

Solid& Envelope::toSolid() const {
	std::auto_ptr<SFCGAL::Solid> p = data.toSolid();

	Solid *solid = new Solid(p.release());

	return *solid;
}

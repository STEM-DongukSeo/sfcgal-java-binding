#include "Envelope.h"
#include "LineString.h"
#include "Polygon.h"
#include "Solid.h"

LineString* Envelope::toRing() const {
	std::auto_ptr<SFCGAL::LineString> p = data.toRing();

	return new LineString(p.release());
}

Polygon* Envelope::toPolygon() const {
	std::auto_ptr<SFCGAL::Polygon> p = data.toPolygon();

	return new Polygon(p.release());
}

Solid* Envelope::toSolid() const {
	std::auto_ptr<SFCGAL::Solid> p = data.toSolid();

	return new Solid(p.release());
}

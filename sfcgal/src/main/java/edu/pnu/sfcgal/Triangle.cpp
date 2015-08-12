#include "Triangle.h"
#include "Polygon.h"

Polygon& Triangle::toPolygon() {
	return *(new Polygon(((SFCGAL::Triangle *)data)->toPolygon()));
}

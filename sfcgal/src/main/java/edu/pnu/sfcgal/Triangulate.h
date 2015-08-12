#include <SFCGAL/triangulate/triangulatePolygon.h>

#include "Geometry.h"
#include "TriangulatedSurface.h"

void triangulatePolygon3D(const Geometry& g, const TriangulatedSurface& triangulatedSurface) {
	SFCGAL::triangulate::triangulatePolygon3D(*(g.get_data()), *(SFCGAL::TriangulatedSurface *)(triangulatedSurface.get_data()));
}

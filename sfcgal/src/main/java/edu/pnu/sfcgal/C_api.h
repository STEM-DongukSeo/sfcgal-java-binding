#include <SFCGAL/capi/sfcgal_c.h>
#include <string>
#include <iostream>

#include "Geometry.h"
#include "PreparedGeometry.h"
#include "TriangulatedSurface.h"

Geometry& SFCGAL_io_read_wkt( const std::string& str, size_t len ) {
	SFCGAL::Geometry* p = (SFCGAL::Geometry *)sfcgal_io_read_wkt(str.c_str(), len);

	Geometry *geometry = new Geometry(p);

	return *geometry;
}

void SFCGAL_io_write_binary_prepared( PreparedGeometry* geom, char* buffer, size_t len ) {
	std::cout << "binary prepared call" << std::endl;
	sfcgal_io_write_binary_prepared(geom, &buffer, &len);
}


PreparedGeometry& SFCGAL_io_read_binary_prepared( const std::string& str, size_t len ) {
	SFCGAL::PreparedGeometry* p = (SFCGAL::PreparedGeometry *)sfcgal_io_read_binary_prepared(str.c_str(), len);
	Geometry *geometry = new Geometry(p->geometry());
	PreparedGeometry *pg = new PreparedGeometry();
	pg->resetGeometry(geometry);
	pg->SRID() = p->SRID();

	return *pg;
}

PreparedGeometry& SFCGAL_io_read_ewkt( const std::string& str, size_t len ) {
	SFCGAL::PreparedGeometry* p = (SFCGAL::PreparedGeometry *)sfcgal_io_read_ewkt(str.c_str(), len);

	Geometry *geometry = new Geometry(p->geometry());
	PreparedGeometry *pg = new PreparedGeometry();
	pg->resetGeometry(geometry);
	pg->SRID() = p->SRID();

	return *pg;
}

Geometry& SFCGAL_geometry_force_lhr( const Geometry& g ) {
	SFCGAL::Geometry* p = (SFCGAL::Geometry *)sfcgal_geometry_force_lhr(g.get_data());

	Geometry *geometry = new Geometry(p);

	return *geometry;
}

Geometry& SFCGAL_geometry_force_rhr( const Geometry& g ) {
	SFCGAL::Geometry* p = (SFCGAL::Geometry *)sfcgal_geometry_force_lhr(g.get_data());

	Geometry *geometry = new Geometry(p);

	return *geometry;
}

TriangulatedSurface& SFCGAL_geometry_triangulate_2dz( const Geometry& g ) {
	SFCGAL::TriangulatedSurface* p = (SFCGAL::TriangulatedSurface *)sfcgal_geometry_triangulate_2dz(g.get_data());

	TriangulatedSurface *surf = new TriangulatedSurface(p);

	return *surf;
}

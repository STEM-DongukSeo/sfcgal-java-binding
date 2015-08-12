#include <SFCGAL/algorithm/area.h>
#include <SFCGAL/algorithm/convexHull.h>
#include <SFCGAL/algorithm/covers.h>
#include <SFCGAL/algorithm/difference.h>
#include <SFCGAL/algorithm/distance.h>
#include <SFCGAL/algorithm/distance3d.h>
#include <SFCGAL/algorithm/extrude.h>
#include <SFCGAL/algorithm/intersection.h>
#include <SFCGAL/algorithm/intersects.h>
#include <SFCGAL/algorithm/isValid.h>
#include <SFCGAL/algorithm/minkowskiSum.h>
#include <SFCGAL/algorithm/offset.h>
#include <SFCGAL/algorithm/plane.h>
#include <SFCGAL/algorithm/straightSkeleton.h>
#include <SFCGAL/algorithm/tesselate.h>
#include <SFCGAL/algorithm/union.h>
#include <SFCGAL/algorithm/volume.h>

#include <SFCGAL/Kernel.h>

#include "Coordinate.h"
#include "Geometry.h"
#include "Point.h"
#include "LineString.h"
#include "Polygon.h"
#include "MultiLineString.h"
#include "MultiPolygon.h"


double area( const Geometry& g ) {
	return SFCGAL::algorithm::area(*(g.get_data()));
}

double area3D( const Geometry& g) {
	return SFCGAL::algorithm::area3D(*(g.get_data()));
}

Geometry& convexHull( const Geometry& g ) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::convexHull(*(g.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

Geometry& convexHull3D( const Geometry& g) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::convexHull3D(*(g.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

bool covers(const Geometry& gA, const Geometry& gB ) {
	return SFCGAL::algorithm::covers(*(gA.get_data()), *(gB.get_data()));
}

bool covers3D(const Geometry& gA, const Geometry& gB ) {
	return SFCGAL::algorithm::covers3D(*(gA.get_data()), *(gB.get_data()));
}

Geometry& difference( const Geometry& gA, const Geometry& gB ) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::difference(*(gA.get_data()), *(gB.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

Geometry& difference3D( const Geometry& gA, const Geometry& gB ) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::difference3D(*(gA.get_data()), *(gB.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

double distance( const Geometry& gA, const Geometry& gB ) {
	return SFCGAL::algorithm::distance(*(gA.get_data()), *(gB.get_data()));
}

double distance3D( const Geometry& gA, const Geometry& gB) {
	return SFCGAL::algorithm::distance3D(*(gA.get_data()), *(gB.get_data()));
}

Geometry& extrude( const Geometry& g, double dx, double dy, double dz) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::extrude(*(g.get_data()), dx, dy, dz);
	
	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

Geometry& intersection( const Geometry& gA, const Geometry& gB) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::intersection(*(gA.get_data()), *(gB.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

Geometry& intersection3D( const Geometry& gA, const Geometry& gB) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::intersection3D(*(gA.get_data()), *(gB.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

bool intersects( const Geometry& gA, const Geometry& gB ){
	return SFCGAL::algorithm::intersects(*(gA.get_data()), *(gB.get_data()));
}

bool intersects3D( const Geometry& gA, const Geometry& gB ){
	return SFCGAL::algorithm::intersects3D(*(gA.get_data()), *(gB.get_data()));
}
/*
Validity isValid( const Geometry& ga, const double toleranceAbs) {
	return SFCGAL::algorithm::isValid(*(gA.get_data()), toleranceAbs);
}
*/

Geometry& minkowskiSum( const Geometry& g, const Polygon& polygon ) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::minkowskiSum(*(g.get_data()), *(SFCGAL::Polygon *)(polygon.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

MultiPolygon& offset( const Geometry& g, const double r) {
	std::auto_ptr<SFCGAL::MultiPolygon> p = SFCGAL::algorithm::offset(*(g.get_data()), r);

	MultiPolygon *multiPolygon = new MultiPolygon(p.release());

	return *multiPolygon;	
}

bool hasPlane3D( const Polygon& polygon ) {
	return SFCGAL::algorithm::hasPlane3D<SFCGAL::Kernel>(*(SFCGAL::Polygon *)(polygon.get_data()));
}

MultiLineString& straightSkeleton( const Geometry& g, bool autoOrientation ) {
	std::auto_ptr<SFCGAL::MultiLineString> p = SFCGAL::algorithm::straightSkeleton(*(g.get_data()), autoOrientation);

	MultiLineString *multiLineString = new MultiLineString(p.release());

	return *multiLineString;
}

Geometry& tesselate( const Geometry& g ) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::tesselate(*(g.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

Geometry& union_( const Geometry& gA, const Geometry& gB ) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::union_(*(gA.get_data()), *(gB.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

Geometry& union3D( const Geometry& gA, const Geometry& gB ) {
	std::auto_ptr<SFCGAL::Geometry> p = SFCGAL::algorithm::union3D(*(gA.get_data()), *(gB.get_data()));

	Geometry *geometry = new Geometry(p.release());

	return *geometry;
}

double volume( const Geometry& g ){
	return CGAL::to_double(SFCGAL::algorithm::volume(*(g.get_data())));
}

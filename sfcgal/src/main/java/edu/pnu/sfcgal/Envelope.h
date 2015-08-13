#ifndef JAVACPP_SFCGAL_Envelope_H
#define JAVACPP_SFCGAL_Envelope_H

#include <SFCGAL/Envelope.h>
#include "Coordinate.h"

class LineString;
class Polygon;
class Solid;

class Envelope{
	SFCGAL::Envelope data;
public:
	typedef SFCGAL::Envelope cpp_base;
	const cpp_base& get_data() const { return data; }
	cpp_base& get_data() { return data; }
	
	Envelope() : data() { }
	Envelope(
		const double& xmin, const double& xmax,
		const double& ymin, const double& ymax) : data(xmin, xmax, ymin, ymax) { }
	Envelope(
		const double& xmin, const double& xmax,
		const double& ymin, const double& ymax,
		const double& zmin, const double& zmax) : data(xmin, xmax, ymin, ymax, zmin, zmax) { }
	Envelope(const Coordinate& p) : data(p.get_data()) { }
	Envelope(const Coordinate& p1, const Coordinate& p2) : data(p1.get_data(), p2.get_data()) { }
	//Envelope(const Kernel::Point2& other) : data(other) { }
	//Envelope(const Kernel::Point3& other) : data(other) { }
	Envelope(const Envelope& other) : data(other.data) { }
	Envelope(const SFCGAL::Envelope& other) : data(other) { }
	
	Envelope& operator=(const Envelope& other) {
		data = other.data;
		
		return *this;
	}
	
	~Envelope() { }
	

	bool isEmpty() const {
		return data.isEmpty();
	}

	bool is3D() const {
		return data.is3D();
	}

	void expandToInclude(const Coordinate& coordinate) {
		data.expandToInclude(coordinate.get_data());
	}

	const double& xMin() const {
		return data.xMin();
	}

	const double& yMin() const {
		return data.yMin();
	}

	const double& zMin() const {
		return data.zMin();
	}

	const double& xMax() const {
		return data.xMax();
	}

	const double& yMax() const {
		return data.yMax();
	}

	const double& zMax() const {
		return data.zMax();
	}

	//detail::interval boundsN(const size_t& n);
	//const detail::Interval boundsN(const size_t& n) const;

	//CGAL::Bbox_2 toBbox_2() const;
	//CGAL::Bbox_3 toBbox_3() const;

	static bool contains(const Envelope& a, const Envelope& b) {
		return SFCGAL::Envelope::contains(a.data, b.data);
	}

	static bool overlaps(const Envelope& a, const Envelope& b) {
		return SFCGAL::Envelope::overlaps(a.data, b.data);
	}

	LineString& toRing() const;
	/*
	LineString& toRing() const {
		std::auto_ptr<SFCGAL::LineString> p = data.toRing();
		
		LineString *lineString = new LineString(p.release());

		return *lineString;
	}
	*/

	Polygon& toPolygon() const;
	/*
	Polygon& toPolygon() const {
		std::auto_ptr<SFCGAL::Polygon> p = data.toPolygon();

		Polygon *polygon = new Polygon(p.release());

		return *polygon;
	}
	*/

	Solid& toSolid() const;
	/*	
	Solid& toSolid() const {
		std::auto_ptr<SFCGAL::Solid> p = data.toSolid();

		Solid *solid = new Solid(p.release());

		return *solid;
	}
	*/

	bool operator==(const Envelope& other) {
		return (this->data == other.data);
	}
};

#endif

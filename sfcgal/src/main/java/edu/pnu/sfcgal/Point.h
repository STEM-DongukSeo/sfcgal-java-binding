#ifndef JAVACPP_SFCGAL_Point_H
#define JAVACPP_SFCGAL_Point_H

#include <SFCGAL/Point.h>
#include "Geometry.h"
#include "Coordinate.h"

class Point : public Geometry{
public:
	Point() : Geometry(new SFCGAL::Point()) { }
	Point(Coordinate& coordinate) : Geometry(new SFCGAL::Point(coordinate.get_data())) { }
	Point(double x, double y) : Geometry(new SFCGAL::Point(x, y)) { }
	Point(double x, double y, double z) : Geometry(new SFCGAL::Point(x, y, z)) { }
	Point(double x, double y, double z, double m) : Geometry(new SFCGAL::Point(x, y, z, m)) { }
	//Point(const SFCGAL::Kernel::FT& x, const SFCGAL::Kernel::FT& y);
	//Point(const SFCGAL::Kernel::FT& x, const SFCGAL::Kernel::FT& y, const SFCGAL::Kernel::FT& z, const double& m = SFCGAL::NaN());
	//Point(const SFCGAL::Kernel::Point2& other) : data(other) { }
	//Point(const Kernel::Point3& other) : data(other) { }
	Point(const Point& other) : Geometry(other.data) { }
	Point(const SFCGAL::Point& other) : Geometry(new SFCGAL::Point(other)) { }

	
	Point& operator=(const Point& other) {
		data = other.data;
		
		return *this;
	}
	
	~Point() { }
	
	
	//--SFCGAL::Geometry
	Point* clone() const {
		return new Point(*this);
	}
	
	std::string geometryType() const {
		return data->geometryType();
	}	
	
	int geometryTypeId() const {
		return data->geometryTypeId();
	}
	
	int dimension() const {
		return data->dimension();	
	}
	
	int coordinateDimension() const {
		return data->coordinateDimension();
	}

	bool isEmpty() const {
		return data->isEmpty();
	}

	bool is3D() const {
		return data->is3D();
	}
	
	bool isMeasured() const {
		return data->isMeasured();
	}

	double x() const {
		return CGAL::to_double(((SFCGAL::Point *)data)->x());
	}

	double y() const {
		return CGAL::to_double(((SFCGAL::Point *)data)->y());
	}

	double z() const {
		return CGAL::to_double(((SFCGAL::Point *)data)->z());
	}

	double m() const {
		return ((SFCGAL::Point *)data)->m();
	}
	
	void setM(const double& m) {
		((SFCGAL::Point *)data)->setM(m);
	}

	bool operator<(const Point& other) const {
		return ( *((SFCGAL::Point *)data) < *((SFCGAL::Point *)other.data) ) ;
	}

	bool operator==(const Point& other) const {
		return ( *((SFCGAL::Point *)data) == *((SFCGAL::Point *)other.data) ) ;
	}

	bool operator!=(const Point& other) const {
		return ( *((SFCGAL::Point *)data) != *((SFCGAL::Point *)other.data) ) ;
	}
	
	//void accept( GeometryVisitor& visitor);
	//void accept( ConstGeometryVisitor& visitor) const;

	/*
	Kernel::Vector_2 toVector_2() const {
		return data.toVector_2();
	}
	
	Kernel::Vector_3 toVector_3() const {
		return data.to_vector_3();
	}

	Kernel::Point_2 toPoint_2() const {
		return data.toPoint_2();
	}
	
	Kernel::Point_3 toPoint_3() const {
		return data.toPoint_3();
	}
	*/
	
	Coordinate& coordinate() {		
		return *(new Coordinate(((SFCGAL::Point *)data)->coordinate()));
	}
	
	Coordinate& coordinate() const {
		return *(new Coordinate(((SFCGAL::Point *)data)->coordinate()));
	}
};

#endif

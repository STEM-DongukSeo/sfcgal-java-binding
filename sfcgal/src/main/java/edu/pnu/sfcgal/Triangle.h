#ifndef JAVACPP_SFCGAL_Triangle_H
#define JAVACPP_SFCGAL_Triangle_H

#include <SFCGAL/Triangle.h>
#include "Point.h"
#include "Surface.h"

class Polygon;

class Triangle : public Surface {
public:	
	Triangle() : Surface(new SFCGAL::Triangle()) { }
	Triangle(const Point& p, const Point& q, const Point& r)
	 : Surface(new SFCGAL::Triangle(*(SFCGAL::Point *)(p.get_data()),
					*(SFCGAL::Point *)(q.get_data()),
					*(SFCGAL::Point *)(r.get_data())) ) { }
	
	//Triangle(const Triangle& other) : Surface(new SFCGAL::Triangle(*other.data)) { }
	Triangle(const SFCGAL::Triangle& other) : Surface(new SFCGAL::Triangle(other)) { }
	//Triangle( const CGAL::Triangle_2& other );
	//Triangle( const CGAL::Triangle_3& other );
	Triangle& operator=(const Triangle& other) {
		data = other.data;
		
		return *this;
	}
	
	~Triangle() { }
	
	
	//--SFCGAL::Geometry
	Triangle* clone() const {
		return new Triangle(*this);
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

	
	void reverse() {
		((SFCGAL::Triangle *)data)->reverse();
	}

	Polygon& toPolygon();	
	
	Point& vertex(const int& i) const { // not used
		return *(new Point(((SFCGAL::Triangle *)data)->vertex(i)));
	}

	Point& vertex(const int &i) {
		return *(new Point(((SFCGAL::Triangle *)data)->vertex(i)));
	}

	//Kernel::Triangle_2 toTriangle_2() const;
	//Kernel::Triangle_3 toTriangle_3() const;
	

	//void accept(GeometryVisitor& visitor);
	//void accept(ConstGeometryVisitor& visitor) const ;
};

#endif

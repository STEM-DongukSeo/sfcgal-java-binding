#ifndef JAVACPP_SFCGAL_LineString_H
#define JAVACPP_SFCGAL_LineString_H

#include <SFCGAL/LineString.h>
#include "Geometry.h"
#include "Point.h"

class LineString : public Geometry {
public:	
	LineString() : Geometry(new SFCGAL::LineString()) { }
	LineString(const std::vector< void * > & points) {
		std::vector<SFCGAL::Point>* cpp_base_points = new std::vector<SFCGAL::Point>();

		for(size_t i=0; i<points.size(); i++){
			cpp_base_points->push_back( *(SFCGAL::Point *)(((Point *)points.at(i))->get_data()) );
		}

		data = new SFCGAL::LineString(*cpp_base_points);
	}

	LineString(const Point& startPoint, const Point& endPoint)
	 : Geometry(new SFCGAL::LineString(	*(SFCGAL::Point *)(startPoint.get_data()),
						*(SFCGAL::Point *)(endPoint.get_data()) )) { }

	//LineString(const LineString& other) : Geometry(other.data) { }
	LineString(const SFCGAL::LineString& other) : Geometry(new SFCGAL::LineString(other)) { }
	//LineString(SFCGAL::LineString& other) : Geometry(new SFCGAL::LineString(other)) { }
	LineString(SFCGAL::LineString* other) : Geometry(other) { }

	LineString& operator=(const LineString& other) {
		data = other.data;
		
		return *this;
	}
	
	~LineString() { }
	
	
	//--SFCGAL::Geometry
	LineString* clone() const {
		return new LineString(*this);
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



	void clear() {
		((SFCGAL::LineString *)data)->clear();
	}
	
	void reverse() {
		((SFCGAL::LineString *)data)->reverse();
	}

	size_t numPoints() const {
		return ((SFCGAL::LineString *)data)->numPoints();
	}

	size_t numSegments() const {
		return ((SFCGAL::LineString *)data)->numSegments();
	}

	const Point& pointN( size_t const & n) const {
		return *(new Point(((SFCGAL::LineString *)data)->pointN(n)));
	}
	
	Point& pointN(size_t const& n) {
		return *(new Point(((SFCGAL::LineString *)data)->pointN(n)));
	}
	

	const Point& startPoint() const {
		return *(new Point(((SFCGAL::LineString *)data)->startPoint()));
	}
	
	Point& startPoint() {
		return *(new Point(((SFCGAL::LineString *)data)->startPoint()));
	}

	const Point& endPoint() const {
		return *(new Point(((SFCGAL::LineString *)data)->endPoint()));
	}

	Point& endPoint() {
		return *(new Point(((SFCGAL::LineString *)data)->endPoint()));
	}

	void addPoint(const Point& p){
		((SFCGAL::LineString *)data)->addPoint( *(SFCGAL::Point *)(p.get_data()) );
	}

	void addPoint(Point* p){
		((SFCGAL::LineString *)data)->addPoint( *(SFCGAL::Point *)(p->get_data()) );
	}

	bool isClosed() const {
		return ((SFCGAL::LineString *)data)->isClosed();
	}	
	
	// iterator begin() ;
	// iterator end() ;

	void reserve(const size_t& n){
		((SFCGAL::LineString *)data)->reserve(n);
	}

	//Point_2_const_iterator points_2_begin() const ;
	//POint_2_const_iterator points_2_end() const ;
	//std::pair<Point_2_const_iterator, Point_2_const_iterator > points_2() const;

	//Point_3_const_iterator points_3_begin() const ;
	//POint_3_const_iterator points_3_end() const ;
	//std::pair<Point_3_const_iterator, Point_2_const_iterator > points_3() const;

	//CGAL::Polygon_2<Kernel> toPolygon_2(bool fixOrientation = true) const;

	//void accept(GeometryVisitor& visitor);
	//void accept(ConstGeometryVisitor& visitor) const ;

};

#endif

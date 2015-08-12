#ifndef JAVACPP_SFCGAL_Solid_H
#define JAVACPP_SFCGAL_Solid_H

#include <SFCGAL/Solid.h>
#include "PolyhedralSurface.h"

class Solid : public Geometry {
public:	
	Solid() : Geometry(new SFCGAL::Solid()) { }
	Solid(const std::vector< void * > & shells) {
		std::vector<SFCGAL::PolyhedralSurface>* cpp_base_shell = new std::vector<SFCGAL::PolyhedralSurface>();

		for(size_t i=0; i<shells.size(); i++){
			cpp_base_shell->push_back( *(SFCGAL::PolyhedralSurface *)(((PolyhedralSurface *)shells.at(i))->get_data()) );
		}

		data = new SFCGAL::Solid(*cpp_base_shell);
	}
	Solid(const PolyhedralSurface& exteriorShell) : Geometry(new SFCGAL::Solid(*(SFCGAL::PolyhedralSurface *)(exteriorShell.get_data()))) { }
	//Polygon(PolyhedralSurface* exteriorShell) : Surface(new SFCGAL::Solid(*(SFCGAL::PolyhedralSurface *)(exteriorShell->get_data()))) { }
	//Solid(const Solid& other) : Surface(new SFCGAL::Solid(*other.data)) { }
	Solid(const SFCGAL::Solid& other) : Geometry(new SFCGAL::Solid(other)) { }
	Solid(SFCGAL::Solid* other) : Geometry(other) { }

	Solid& operator=(const Solid& other) {
		data = other.data;
		
		return *this;
	}
	
	~Solid() { }
	
	
	//--SFCGAL::Geometry
	Solid* clone() const {
		return new Solid(*this);
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

	
	PolyhedralSurface& exteriorShell() const {
		return *(new PolyhedralSurface(((SFCGAL::Solid *)data)->exteriorShell()));
	}

	PolyhedralSurface& exteriorShell() {
		return *(new PolyhedralSurface(((SFCGAL::Solid *)data)->exteriorShell()));
	}

	size_t numInteriorShells() const {
		return ((SFCGAL::Solid *)data)->numInteriorShells();
	}

	const PolyhedralSurface& interiorShellN( size_t const & n) const {
		return *(new PolyhedralSurface(((SFCGAL::Solid *)data)->interiorShellN(n)));
	}
	
	PolyhedralSurface& interiorShellN( size_t const & n) {
		return *(new PolyhedralSurface(((SFCGAL::Solid *)data)->interiorShellN(n)));
	}

	void addInteriorShell( const PolyhedralSurface& shell ) {
		((SFCGAL::Solid *)data)->addInteriorShell(*(SFCGAL::PolyhedralSurface *)(shell.get_data()));
	}

	void addInteriorShell( PolyhedralSurface* shell ) {
		((SFCGAL::Solid *)data)->addInteriorShell(*(SFCGAL::PolyhedralSurface *)(shell->get_data()));
	}

	size_t numShells() const {
		return ((SFCGAL::Solid *)data)->numShells();
	}

	PolyhedralSurface& shellN( size_t const & n) const {
		return *(new PolyhedralSurface(((SFCGAL::Solid *)data)->shellN(n)));
	}

	PolyhedralSurface& shellN( size_t const & n) {
		return *(new PolyhedralSurface(((SFCGAL::Solid *)data)->shellN(n)));
	}

	//iterator begin();
	//iterator begin() const;
	//iterator end();
	//iterator end() const;	

	//void accept(GeometryVisitor& visitor);
	//void accept(ConstGeometryVisitor& visitor) const ;
};

#endif

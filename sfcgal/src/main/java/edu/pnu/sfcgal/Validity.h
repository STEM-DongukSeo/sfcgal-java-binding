#ifndef JAVACPP_SFCGAL_Validity_H
#define JAVACPP_SFCGAL_Validity_H

//#include <SFCGAL/Validity.h>
//#include <string>

class Validity{
	//SFCGAL::Validity data;
	std::string& str;
public:
	Validity() { }
	//Validity(const Validity& other) : data(other.data) { }
	//Validity(const std::string& reason) : data(SFCGAL::Validity::invalid(reason)) { }
	//Validity(SFCGAL::Validity& other) : data(other){ }
	
	~Validity() { }
	/*
	operator bool() const {
		return data;
	}

	const std::string& reason() const {
		return data.reason();
	}
*/
};

#endif

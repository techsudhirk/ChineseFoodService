package com.niit;

import javax.servlet.http.Part;

public class Application {
String name="";
int price=0,id=0;
String availability1;
String description="";
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getAvailability1() {
	return availability1;
}
public void setAvailability1(String availability1) {
	this.availability1 = availability1;
}
String id1="";
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
String image="";
public int getAvailability() {
	return availability;
}
public void setAvailability(int availability) {
	this.availability = availability;
}
int availability=0;
Part pic;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPrice() {
	return price; 
}
public void setPrice(int price) {
	this.price = price;
}
public Part getPic() {
	return pic;
}
public void setPic(Part pic) {
	this.pic = pic;
}
public Application(String name,int availability,int id)
{
	this.name=name;
	this.id=id;
	this.name=name;
}
public Application(String name,int price,int availability,String image,int id)
{
	this.name=name;
	this.price=price;
	this.availability=availability;
	this.image=image;
	this.id=id;
}


public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Application(String name,int price,int availability,int id)
{
	this.name=name;
	this.price=price;
	this.availability=availability;
	this.image=image;
	this.id=id;
}

public Application(String name,int price,String availability,String id)
{
	this.name=name;
	this.price=price;
	this.availability1=availability;
	this.image=image;
	this.id1=id;
}
public Application(int id3,String name,int price1,int availability)
{
	this.id=id3;
	this.price=price1;
	this.availability=availability;
	this.name=name;
}
public Application(String name)
{
	this.name=name;
}
public Application(int price)
{
	this.price=price;
}
public Application()
{
	this.price=price;
}
}

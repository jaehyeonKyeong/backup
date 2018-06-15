package day0423;

import java.io.Serializable;

public class MyData implements Serializable {
	/**
	 * 이 아이디는 2018-04-25일까지만 유효합니다. 
	 */
	/*private*/ static final long serialVersionUID = -6761890880862691280L;
	transient /*private*/ String name; //transient는 직렬화를 막을 때 사용함.
	private transient double height;
	private double weight;
	
public MyData() {
}//constructor
public MyData(String name,double height,double weight){
	this.name=name;
	this.height=height;
	this.weight=weight;
}
public String getName() {
	return name;
}
public double getHeight() {
	return height;
}
public double getWeight() {
	return weight;
}
public void setName(String name) {
	this.name = name;
}
public void setHeight(double height) {
	this.height = height;
}
public void setWeight(double weight) {
	this.weight = weight;
}

}

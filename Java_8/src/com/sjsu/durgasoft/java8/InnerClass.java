/*
 *INNER CLASS
 *-->A class declared inside one more class is known as inner class.
 *-->Inner classes concept introduced in 1.1 v to fix GUI bugs as a part of event handling, but because of powerful features and benefits of inner classes
 *slowly programmers started using in regular coding also.
 *-->Without existing one type of object, if there is no chance of existing another type of object then we should go for inner classes.
 *
 *EXAMPLE 1:
 *University consists of several departments, without existing university there is no chance of existing department hence we have to declare department 
 *class under University class.
 *class University{
 *	class Department{
 *
 *	}
 *}
 *
 *EXAMPLE 2:
 *Without existing car object, there is no chance of existing engine object, hence we have to declare Engine class inside  Car class.
 *class Car{
 *	class Engine{
 *
 *	}
 *}
 *
 *EXAMPLE 3:
 *-->Each key-value pair in Map is known as Entry.
 *Map is a group of key-value pairs and each key-value pair is called an entry. Without existing Map object there is no chance of existing Entry object,
 *hence interface Entry is defined inside Map interface.
 *interface Map{
 *	interface Entry{
 *
 *	}
 *}
 *
 *
 *NOTE:
 *1)Without existing outer class object there is no chance of existing inner class object.
 *2)The relation between outer class and inner class is not IS-A relation instead it is HAS-A relationship.(Composition or Aggregation)
 *
 *Based on position of declaration and behavior there are four categories of inner classes
 *1)Normal/Regular inner classes: 
 *If we are declaring any named class,directly inside a class without static modifier such type of inner class is called Normal/Regular inner class. 
 *
 *Outer.java
 *class Outer{
 *	class Inner{
 *
 *	}
 *}
 *
 *Compile the code:
 *javac Outer.java, if we are trying to compile 2 .classes will be generated. .class generated for outer class is Outer.class and for inner class is
 *Outer$Inner.class 
 *
 *Run the code
 *java Outer
 *RE: NoSuchMethodError: main
 *
 *java Outer$Inner
 *RE: NoSuchMethodError: main
 *
 *class Outer{
 *	class Inner{
 *		public static void main(String[] args){
 *			SOP("Inner class main method");
 *		}
 *	}
 *}
 *CE: Inner classes cannot have static declarations
 *Inside inner class we can't declare any static members, hence we can't declare main method and we can't run inner class directly from command prompt.  
 *
 *Case 1: Accessing inner class code from static area of outer class.
 *class Outer{
 *	class Inner{
 *		public void m1(){
 *			SOP("Inside Inner Class");
 * 		}
 *	}
 *	public static void main(String[] args){
 *		Outer o=new Outer();
 *		Outer.Inner i=o.new Inner();
 *		/Outer.Inner i=new Outer.new Inner();
 *		i.m1();
 *	}
 *}
 *
 *Case 2: Accessing inner class code from instance area of outer class.
 *class Outer{
 *	class Inner{
 *		public void m1(){
 *			SOP("Inner class method");
 *		}
 *	}
 *	public void m2(){
 *		Inner i=new Inner();
 *		i.m1();
 *		
 *	}
 *	p s v m(String[] args){
 *		Outer o=new Outer();
 *		o.m2();
 *		
 *	}
 *}
 *
 *Case 3: Accessing inner class code from outside of outer class.
 *class Outer(){
 *	class Inner(){
 *		public void m1(){
 *			SOP("Inner class method");
 *		}
 *	}
 *}
 *
 *class Test{
 *	p s v m(String[] args){
 *		Outer.Inner i=new Outer().new Inner();
 *		i.m1();
 *	}
 *}
 *
 * 
 *------------------------------------------------------------------------------------------------------------------------------------
 *2)Method local inner classes:
 *
 *3)Anonymous inner classes
 *4)Static nested classes
 * */


package com.sjsu.durgasoft.java8;

public class InnerClass {

}

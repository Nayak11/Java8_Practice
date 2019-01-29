	/* March 18th 2014
	 * 
	 * 
     * ####################################################################################################################################
	 * 1)Lambda Expressions
	 * 2)Functional Interfaces-can be used to call Lambda expressions
	 * 
	 * Every method present in interface is always public and abstract, and every variable is public static final whether we are declaring or not.
	 * From 1.8 version we can even declare concrete methods inside interfaces, these methods are nothing but  
	 * 3)Default methods in interfaces
	 * 4)Static methods in interfaces
	 * 
	 * There are some standard predefined functional interfaces:
	 * 5)Predicate
	 * 6)Function
	 * 7)Consumer
	 * 
	 * 8)For method and constructor reference we can use double colon (::) operator
	 * 9)Stream API- to perform operations on Collection
	 * 10)Date and Time API(JODA API-joda.org)
	 * 
	 * ####################################################################################################################################
	 * Java versions:
	 * 1.0(1996)
	 * 	1.1
	 * 1.2
	 * 	1.3
	 * 	1.4
	 * 1.5
	 * 	1.6
	 * 	1.7
	 * 1.8
	 * 
	 * ####################################################################################################################################
	 * Objective of Java 8 version:
	 * 1)To simplify programming.
	 * 2)To enable functional programming in java(in the form of Lambda expressions).
	 * 3)To enable parallel programming/parallel processing in java. So now we can write more compatible code which can run on multi-core processors.
	 * 
	 * ####################################################################################################################################
	 * 1)Lambda Expression: A Lambda expression is an anonymous function. It doesn't have any name,modifiers and return type.
	 * -->LISP is the first programming language to use lambda expression.
	 * ------------------------------------------------------------------------------------------------------------------------------------
	 * Benefits?
	 * 1)To enable functional programming in Java.
	 * 2)To write more readable,maintainable and concise code.
	 * 3)To use API's very easily and effectively.
	 * 4)To enable parallel processing.
	 * ------------------------------------------------------------------------------------------------------------------------------------
	 * 	Lambda expression examples:
	 *	Example 1: to print hello
	 *  ()->{
	 *		System.out.println("Hello");
	 *	}
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *	Example 2: to print sum of 2 int values
	 *	(int a, int b)->{
	 *		System.out.println(a+b); 
	 *	}
	 *
	 * Type Inference: Sometimes compiler can guess the data type based on the context, in that case we can skip the data type and write above lambda 
	 * expression as below:
	 * (a,b)->{
	 * 		System.out.println(a+b);
	 * }
	 *	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *	Example 3: to return the length of passed String
	 *	(String s)->{
	 *		return s.length(); 
	 *	}
	 * 
	 *  Can be simplified as: parenthesis is optional if we have only one parameter as input. If the body of the Lambda expression is single expression 
	 *  than even the return statement is optional.
	 *  s->s.length();
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * -->Curly braces are optional if the Lambda expression contains only one line, more than one line curly braces are mandatory.
	 * 
	 * ####################################################################################################################################
	 * 2)Functional Interface: To invoke lambda expression, we require functional interface.
	 * If the interface contains only one abstract method then it is called functional interface. We can have any number of static and default methods.
	 * Example:
	 * Runnable ---> contains only run() method
	 * Callable ---> contains only call() method
	 * ActionListener ---> contains only actionPerformed()
	 * Comparable ---> contains only compareTo() method
	 * 
	 * Example:
	 * interface Interface{
	 * 	public void main(){
	 * 		default void m2(){
	 * 			
	 * 		}
	 * 		public static void m3(){
	 * 
	 * 		}
	 *  }
	 * }
	 * 
	 * 
	 * Here is an example which is not a functional interface, but just normal interface:
	 * interface Interface{
	 * 	 public void m1();
	 *   public void m2();
	 * }
	 * 
	 * --> To indicate  a method as a functional interface explicitly we use the annotation @FunctionalInterface  
	 * ------------------------------------------------------------------------------------------------------------------------------------
	 * Functional interface with respect to Inheritance
	 * 
	 * Case1:If an interface extends Functional Interface and child interface doesn't contain any abstract method , then child interface is always 
	 * Functional Interface.
	 * 
	 * @FunctionalInterface
	 * interface P{
	 * 	public void m1();
	 * }
	 * 
	 * @FunctionalInterface
	 * interface C extends P{
	 * 
	 * }
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Case2:In the child interface, we can define exactly same parent interface abstract method.
	 * 
	 * @FunctionalInterface
	 * interface P{
	 * 	public void m1();
	 * }
	 * 
	 * @FunctionalInterface
	 * interface C{
	 * 	public void m2();
	 * }
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Case3:In the child interface we can't define any new abstract methods otherwise we will get CE.
	 * CE-Unexpected @FunctionalInterface annotation, multiple non overriding abstract method found in interface C. 
	 * 
	 * @FunctionalInterface
	 * interface P{
	 * 	public void m1();
	 * }
	 * 
	 * @FunctionalInterface
	 * interface C extends P{
	 * 	public void m2();
	 * }
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Case4:The below case is perfectly valid.
	 * 
	 * @FunctionalInterface
	 * interface P{
	 * 	public void m1();
	 * }
	 * 
	 * interface C extends P{
	 * 	public void m2();
	 * }
	 * ------------------------------------------------------------------------------------------------------------------------------------
	 * Invoking Lambda Expression using Function Interface 
	 * 
	 * interface Interf{
	 * 	public void m1();
	 * }
	 * 
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Normal Implementation 
	 * 
	 * class Demo implements Interf{
	 * 	public void m1(){
	 * 		System.out.println("Normal implementation called");
	 * 	}
	 * }
	 * 
	 * class Test1{
	 * 	public static void main(String[] args){
	 * 		Interface i=new Demo();
	 * 		i.m1();
	 * 	}
	 * }
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * Lambda-Functional Interface implementation
	 * 
	 * class Test2{
	 * 	public static void main(String[] args){
	 * 		Interf i=()->System.out.println("Lambda Expression");
	 * 		i.m1();
	 *  }
	 * }
	 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *  Code with Lambda expression/Functional Interface to add two numbers
	 *  interface Interf{
	 *  	public void add(int a, int b);
	 *  }
	 *  class Test{
	 *  	public static void main(String[] args){
	 *  //Below compiler is able to guess the method name and the data types of input param based on the Interf reference.
	 *  		Interf i=(a,b)->SOP("Sum is:"+ (a+b));
	 *  		i.add(10,20);
	 *  		i.add(100,200);
	 *  	}
	 *  }
	 *  
	 *  Functional Interface:
	 *  1)It should contain exactly one abstract method(SAM-Single Abstract Method)
	 *  2)It can contain any number of default and static methods
	 *  3)It acts as a type for Lambda expression
	 *  Eg: Interf i=()->SOP("Hello");
	 *  4)It can be used to invoke Lambda expressions.
	 *  Eg: i.m1()
	*/


//##########################################################################################################################################
package com.sjsu.durgasoft.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Below is the thread code example without use of Lambda expression.

//There is no way that we can know in which order does the threads run.
//Way of defining a thread
/*
 * class myRunnable implements Runnable {
	@Override
	public void run() {
		//Below is the job of the thread, executed by the child thread.
		for(int i=0;i<10;i++) {
			System.out.println("Child thread");
		}
	}	
}*/

/*public class ThreadsDemo1{
	public static void main(String[] args) {
		Runnable r=new myRunnable();
		Thread t=new Thread(r);
		t.start();//At this point there are two threads.
		//Main thread is responsible for executing below thread.
		for(int i=0;i<10;i++) {
			System.out.println("Main thread");
		}
	}
}*/

// ------------------------------------------------------------------------------------------------------------------------------------

//Now lets write the same code using Lambda expression.
/*public class ThreadsDemo1{
	public static void main(String[] args) {
		Runnable r=()->{
			for(int i=0;i<10;i++) {
				System.out.println("Child thread-Lambda");
			}
		};
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main thread-Lambda");
		}
	}
}*/
//##########################################################################################################################################

//Q)Why functional interface should contain only one abstract method?
//-->To make sure compiler doesnt't get confused while matching to interface methods.

//Q)What is the advantage of @FunctionalInterface annotation ?
//-->This is a way to explicitly mention that the interface is a functional interface and it should contain only one abstract method.

//##########################################################################################################################################

/*Lambda Expression for Collections:
 * Collection: If we want to represent a group of objects as single entity we can go for Collection.
 * 
 * List(I): When the insertion order need to be preserved and duplicate objects are allowed then we can for List.
 * Implementation Classes: ArrayList, LinkedList, Vector(it's implementation class Stack)
 * 
 * Set(I): When we don't want duplicates and if we don't want insertion order than we can go for Set.
 * Implementation Classes: HashSet, TreeSet etc
 * 
 *  Map(I): Key-value pair, we are not worried about the order.
 * Implementation Classes: HashMap, TreeMap etc
 * 
 * ##########################################################################################################################################
 * Comparator(I) contains only 1 abstract method i.e., compare() method: If we want customized sorting.
 * Internally JVM is going to use this method for sorting when we insert elements to Collection.
 * 
 * Example:
 * public int compare(Object obj1,Object obj2)
 *-->return -ve value if obj1 has to come before obj2
 *-->return +ve value if obj1 has to come after obj2
 *-->return 0 if obj1 nad obj2 are equal.
 *
 * ------------------------------------------------------------------------------------------------------------------------------------
 * */

/*
How to obtain customized sorting ?
public class customizedSorting{
	public static void main(String[] args) {
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(10);
		l.add(0);
		l.add(15);
		l.add(5);
		l.add(20);
		System.out.println("Before sorting: "+l);
		Collections.sort(l);
		System.out.println("After sorting: "+l);
		myComparator mc=new myComparator();
		Collections.sort(l, mc);
		System.out.println("Customized sorting, descending order"+l);
		
	}
}*/


/*class myComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) {
			return -1;
		}else if(o1<o2) {
			return 1;
		}else
			return 0;
		//Beauty of ternary operator
			//return (o1>o2) ? -1 : (o1<02) ? 1 : 0; 
	}	
}*/
//------------------------------------------------------------------------------------------------------------------------------------

/*
//Sorting Elements Of List With Lambda Expression
public class customizedSortingLambdaExpression{
	public static void main(String[] args) {
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(10);
		l.add(0);
		l.add(15);
		l.add(5);
		l.add(20);
		System.out.println("Before sorting: "+l);
		Collections.sort(l, (o1,o2)-> (o1>o2) ? -1 : (o1<o2) ? 1 : 0);
		System.out.println("Aftre customized sorting using Lambda Expression: "+l);
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Sorting Elements of TreeSet with Lambda Expression
/*public class TreeSetLamdaExample{
	public static void main(String[] args) {
		//We use below TreeSet declaration if we want our elements to be inserted according to natural sorting order. 
		TreeSet<Integer> t=new TreeSet<Integer>();
		t.add(10);
		t.add(0);
		t.add(15);
		t.add(5);
		t.add(20);
		System.out.println("Tree Set natural sorting order: "+t);
		
		//For customized sorting we need to pass comparator object as shown below
		TreeSet<Integer> t1=new TreeSet<Integer>((o1,o2)-> (o1>o2) ? -1 : (o1<02) ? 1 : 0);
		t1.add(10);
		t1.add(0);
		t1.add(15);
		t1.add(5);
		t1.add(20);
		System.out.println("Tree Set customized sorting order using Lambda expression: "+t1);
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Sorting Elements of TreeMap with Lambda Expression
//Key value pair will be inserted based on the sorting order of Keys.
/*public class TreeMapLamdaExample{
	public static void main(String[] args) {
		//We use below TreeSet declaration if we want our elements to be inserted according to natural sorting order. 
		TreeMap<Integer,String> t=new TreeMap<Integer,String>();
		t.put(10, "Suhas");
		t.put(16, "Poorni");
		t.put(13, "Puttu");
		t.put(3, "Kittu");
		t.put(19, "Nayak");
		System.out.println("Tree Map natural sorting order: "+t);
		
		//For customized sorting we need to pass comparator object as shown below
		TreeMap<Integer,String> t1=new TreeMap<Integer,String>((o1,o2)-> (o1>o2) ? -1 : (o1<o2) ? 1 : 0);
		t1.put(10, "Suhas");
		t1.put(16, "Poorni");
		t1.put(13, "Puttu");
		t1.put(3, "Kittu");
		t1.put(19, "Nayak");
		System.out.println("Tree Map customized sorting order using Lambda expression: "+t1);
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Sorting of our own object with Lambda Expression
/*class Employee{
	 int no;
	 String ename;
	 
	 public Employee(int no,String ename) {
		this.no=no;
		this.ename=ename;
	}

	 public String toString() {
		 return no+":"+ename;
	 }
}

public class TestEmployee{
	public static void main(String[] args) {
		ArrayList<Employee> l=new ArrayList<>();
		l.add(new Employee(10,"Suhas"));
		l.add(new Employee(2,"Sushanth"));
		l.add(new Employee(7,"Puttu"));
		l.add(new Employee(4,"Kittu"));
		System.out.println(l);
		Collections.sort(l, (e1,e2)->(e1.no<e2.no) ? -1 : (e1.no>e2.no) ? 1 : 0);
		System.out.println(l );
	}
}*/
// ##########################################################################################################################################

//Anonymous inner class vs lambda expression
//NOTE: Wherever we are anonymous inner class there may be a chance of using Lambda Expression
//Without Lambda Expression
/*public class ThreadsDemo{
	public static void main(String[] args) {
		//Here we are  writing a class that implements Runnable interface which is nothing but anonymous inner class, in that class we are providing
		//implementation for run method.
		Runnable r=new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("Child Thread");
				}
			}
		};
		
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Parent Thread");
		}
	}
}*/

//With Lambda Expression
/*public class ThreadsDemo{
	public static void main(String[] args) {
		Runnable r=()->{
			for(int i=0;i<10;i++) {
				System.out.println("Child Thread");
			}
		};
		
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Parent Thread");
		}
	}
}*/
//------------------------------------------------------------------------------------------------------------------------------------

/*
 * Can each and every anonymous class be replaced with Lambda expression
 * NO, ONLY SOMETIMES. Because 
 * 
 * We cannot write Lambda expression for all the below cases. We can write Lambda expression only if the interface contains only one abstract method.
 * Anonymous inner class is more powerful than Lambda expression.
 * 
 * 1)Anonymous inner class that extend concrete class
 * class test{
 * 		Test t=new Test(){
 * 
 * 		}
 * };
 * 
 * 2)Anonymous inner class that extend abstract class
 * abstract class test{
 * 		Test t=new Test(){
 * 
 * 		}
 * };
 * 
 * 3)Anonymous inner class that implements an interface which contains multiple methods.  
 * interface Test{
 * 		public void m1();
 * 		public void m2();
 * 		public void m3();
 * }
 * 
 * Test t=new Test(){
 * 		public void m1(){
 * 
 * 		}
 * 		public void m2(){
 * 
 * 		}
 * 		public void m3(){
 * 
 * 		}
 * };
 * 
 * 4)Anonymous inner class that implements an interface which contains only one abstract methods.
 * interface Test{
 * 		public void m1();
 * }
 * 
 * Test t=new Test(){
 * 		public void m1(){
 * 
 * 		}
 * }
 *  */

//------------------------------------------------------------------------------------------------------------------------------------
 /*
  * "this" keyword acts differently with anonymous inner class as well as Lambda expression.
  *  
  *  interface Interf{
  *  	public void m1()
  *  }
  *  
  *  class Test{
  *  	int x=888;
  *  	public void m2(){
  *  		Interf i=new Interf(){
  *  			int x=999;//instance variable of anonymous inner class
  *  			public void m1(){
  *  				SOP(this.x);//999
  *  			}
  *   		}
  *   		i.m1();
  *  	}
  *  	p.s.v.m(String[] args){
  *  		Test t=new Test();
  *  		t.m2();
  *  	}
  *  }
  *  
  *  1)It is allowed to declare  instance variables inside anonymous inner class.
  *  2)"this" always refers to current inner class object inside anonymous inner class.
  *  3) To print Outer class x value we have to write something like- Test.this.x //888.
  *  
  *  
  *  
  *  SAME EXMAPLE USING LAMBDA EXPRESSION
  *   interface Interf{
  *   	public void m1()
  *   }
  *   
  *   class Test{
  *   	int x=888;
  *     public void m2(){
  *     	int y=999;// 
  *     	Interf i=()->{
  *     		//This block is considered as closure.
  *     		int x=999;//local variable of lambda expression, not instance variable
  *     		SOP(this.x);//"this" always refers to outer class variables only, so we will get x=888
  *     		y=100;//COMPILE TIME ERROR : "Local variable referenced from lambda expression must be final or effectively final"
  *     	};
  *     	i.m1();
  *     }
  *     p s v m(String[] args){
  *     	Test t=new Test();
  *     	t.m2();
  *     }
  *   }
  *------------------------------------------------------------------------------------------------------------------------------------
  *Anonymous Inner class vs Lambda Expression
  *1)It is a class without name		||		It is a function without name
  *2)Can extend abstract as well as concrete class		||		can't extend abstract and concrete classes
  *3)Can implement an interface that contain any number of abstract methods		||		can implement an interface which contains single abstract method.
  *4)inside anonymous inner class we can declare instance variables		||		we can't, whatever variables declared are considered as local variables
  *5)can be instantiated		||		cannot be instantiated
  *6)'this' always refers current anonymous inner class object but not outer class object		||		'this' always refers current outer class object, i.e., enclosing class object.
  *7)Best choice if we want to handle multiple methods		||		if we want to handle interface with single abstract method(Functional interface)
  *8)at the time of compilation, for every class separate .class will be generated		|| no separate .class file will be generated.
  *9)memory will be allocated on demand, whenever we are creating objects		||		will reside in permanent memory of JVM(method area)  		
  *
  *------------------------------------------------------------------------------------------------------------------------------------
  *NOTE:
  *Advantages of Lambda Expressions:
  *1)We can enable functional programming in java
  *2)We can reduce length of the code, so we can improve readability
  *3)We can resolve complexity of Anonymous inner class to some extent.
  *4)we can handle procedures/functions just like values
  *5)we can pass procedures/functions as args
  *6)Easier to use updated APIs and libraries
  *7)Enable support for parallel processing 
  */

//##########################################################################################################################################

/*
 * Default methods inside interface
 *All the methods inside interface are public abstract and all the variables declared inside interface are public static final.
 * interface Interf{
 * 		public abstract void m1();
 * 		public static final int x=10;
 * }
 * 
 * From 1.8 version we can happily declare even concrete methods inside interface.These methods are called default methods.
 * How ?
 * interface Interf{
 * 	default void m1(){
 * 		SOP("default method");
 *  }
 * }
 * Implementation class can use the same method or overwrite as well.
 * If we allow concrete methods inside interface what is the difference between abstract class and interface ?
 * 
 * Default methods wrt multiple Inheritance-AMBIGUITY PROBELM!!!
 * interface Left{
 * 	default void m1(){
 * 		SOP("Left default method")
 * 	}
 * }
 * 
 * interface Right{
 * 	default void m1(){
 * 		SOP("Right default method")
 * 	}
 * }
 * 
 * class Test implements Left,Right{
 * 	m1();//Now which m1 should be executed ? Ambiguity problem.
 * }
 * 
 * Solution:
 * Override and provide our own implementation. 
 * But what if we want to use Left method m1 implementation only?
 * 
 * class Test implements Left,Right{
 * 	public void m1(){
 * 		Left.super.m1();
 * 	}
 * }
 * ------------------------------------------------------------------------------------------------------------------------------------
 * Difference between interface with default methods and abstract class
 * 1)every variable is always public static and final we cannot declare instance variables	||	we can declare instance variables required for child class.
 * 2)never talks about state of object	||	can talk about state of object
 * 3)inside interface we can't declare constructors	||	we can declare constructors
 * 4)we can't declare instance and static blocks	||	we can declare instance and static blocks
 * 5)Functional interface with default methods can refer lambda expression	||	can't refer lambda expression
 * 6)we can't override object class methods	||	we cna override object class methods. 
 * 
 * ------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Static methods inside interface(From 1.8 version)
 * 
 * What is the need ?
 * To declare general utility methods.
 * 
 * interface Interf{
 * 	public static void m1(){
 * 		SOP("interface static method");
 * 	}
 * }
 * 
 * TWIST:
 * interface Interf{
 * 	public static void m1(){
 * 		SOP("interface static method");
 * 	}
 * }
 * class test implements Interf{
 * 	p s v m(String[] args){
 * 		Test t=new Test();
 * 		t.m1(); //Compile time error
 * 		Test.m1(); //Compile time error
 * 		Interf.m1(); //Only way to call static method in interface
 * 	}
 * }
 * ------------------------------------------------------------------------------------------------------------------------------------
 * Interface static methods wrt overriding
 * Since interface methods are not readily available for implementation classes there is no point of overriding! If we want we can define exactly same 
 * method in the child/implementation class.
 * 
 * interface Interf{
 * 	public static void m1(){
 * 
 * 	}
 * }
 * 
 * class test implements Interf{
 * 	public void m1(){
 * 
 * 	}
 * }
 * 
 * Even though here we are changing static method to non static method in implementation class, it is completely valid as it is not overriding. In case 
 * of normal classes in Java it would have thrown compile time error.
 * 
 * From 1.8 version we can directly run Interface!!!!!!
 * interface Interf{
 * 	p s v m(String[] args){
 * 		SOP("Interface main method");
 * 	}
 * }
 * 
 * javac Interf.java
 * java Interf
 * 
 * ------------------------------------------------------------------------------------------------------------------------------------
 * 
 * Topics covered till now:
 * 1)Lambda Expression
 * 2)Functional Interfaces
 * 3)Default methods inside interface
 * 4)Static methods inside interface
 * 
 * There are some predefined Function Interfaces provided by Java people:
 * 1)Predicate
 * 2)Function
 * 3)Consumer
 * 4)Supplier
 * These are defined in java.util.function package
 * 
 * 1)Predicate(I)
 * -->Used to perform a conditional check.
 * -->contains one abstract method test()
 * 
 * interface Predicate<T>{
 * 	boolean test(T t){
 * 
 * 	}
 * }
 * 
 * How to use Predicate ?
 * We can use Predicate to refer Lambda expression
 * Eg: Is the given number grater than 10 ?
 * public boolean Test(Integer I){
 * 	if(I>10)
 * 		return true;
 * else
 * 		return false;
 * }
 * 
 * Lambda expression equivalent:
 * (Integer I)->{
 * 	if(I>10)
 * 		return true;
 *  else
 * 		return false;
 * };
 * 
 * 
 *Simplification
 *	I -> I>10;
 *
 *Using Predicate:
 *Predicate<Integer> P=I->I>10
 *
 *import java.util.function.*;
 *
 *class Test{
 *	p s v m(String[] args){
 *		Predicate<Integer> P=I->I>10;
 *		SOP(P.test(11));//true
 *		SOP(P.test(5));//false	
 *	}
 *}
 *
 *Write a predicate to check the lenght of given String in greater than 5 or not 
 *
 *import java.util.function.*;
 *
 *class Test{
 *	p s v m(String[] args){
 *		Predicate<String> P=str->str.length()>5;
 *		SOP(P.test("Suhas Nayak"));//true
 *		SOP(P.test("sos"));//false	
 *	}
 *}
 *
 *Write a predicate to check if the given Collection is Empty or not
 *
 *public class Test{
 *	public static void main(String[] args) {
 *		Predicate<Collection> P=col->col.isEmpty();
 *		List<Integer> al=new ArrayList<Integer>();
 *		System.out.println(P.test(al));//true
 *		al.add(5);
 *		al.add(10);
 *		System.out.println(P.test(al));//false
 *	}
 *}
 *
 *------------------------------------------------------------------------------------------------------------------------------------
 *Predicate Joining
 *
 *Say we have two predicates 
 *P1 : Given number greater than 10 or not
 *P2 : GIven number is even or not
 *
 *Req : Is the given number not greater than 10 : We can use P1.negate()
 *Req : Numer should be even and geater than 10 : P1.and(P2)
 *Req : Numer should be even or geater than 10  : P1.or(P2)
 *
 *negate(), and() and or() are defined as default methods inside Predicate.
 *
 *------------------------------------------------------------------------------------------------------------------------------------
 *
 *
 * */

//Predicate Example 1:
// Program to display names starts with K by using Predicate 
// i/p : String[] names={"Sunny","Kajal","Mallika","Katrina","Kareena"}

/*public class Test{
	static String[] names={"Sunny","Kajal","Mallika","Katrina","Kareena"};
	public static void main(String[] args) {
		Predicate<String> P=str->str.charAt(0)=='K';
		for(String name : names) {
			if(P.test(name)) {
				System.out.println(name);
			}
		}
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Predicate Example 2:
//Program to remove null values and Empty String from the give list
//i/p : String[] names={"Durga","","Mallika",null,"Kareena"}

/*public class Test{
	static String[] names={"Durga","","Mallika",null,"Kareena"};
	public static void main(String[] args) {
		Predicate<String> P1=str->str=="";
		Predicate<String> P2=str->str==null;
		List<String> al=new ArrayList<>();
		for(String name : names) {
			if(!P1.or(P2).test(name)) {
				al.add(name);
			}
		}
		System.out.println("The list of valid Strings is: "+al);
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Predicate Example 3:
//Program for user authentication 

/*class User{
	String username;
	String password;
	User(String username, String password){
		this.username=username;
		this.password=password;
	}
}

//Write a predicate which takes User object as input and validates the user
public class Authenticate{
	public static void main(String[] args) {
		Predicate<User> P=(User)->{
			return User.username.equals("admin") && User.password.equals("admin");
		};
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username:");
		String username=sc.next();
		System.out.println("Enter password:");
		String password=sc.next();
		User user=new User(username,password);
		if(P.test(user)) {
			System.out.println("User successfully authenticated");
		}else {
			System.out.println("Authentication failed!!!");
		}
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------
  
//Predicate Example 4:
//Program to check whether SOftware Engineer is allowed into Pub or not

/*class SoftwareEngineer{
	String name;
	int age;
	boolean isHavingGF;
	
	public SoftwareEngineer(String name, int age, boolean isHavingGF) {
		super();
		this.name = name;
		this.age = age;
		this.isHavingGF = isHavingGF;
	}
	
	public String toString() {
		return name;
	}
}

//Write a predicate which takes User object as input and validates the user
public class Validate{
	public static void main(String[] args) {
		SoftwareEngineer[] se= {
				new SoftwareEngineer("Suhas",26,false),
				new SoftwareEngineer("Sushanth",14,true),
				new SoftwareEngineer("Annu",45,false),
				new SoftwareEngineer("Raju",40,true),
				new SoftwareEngineer("Grandhome",32,false),
		};
		Predicate<SoftwareEngineer> P=(e)->{
			return e.age >=18 && e.isHavingGF;
		};
		for(SoftwareEngineer e : se) {
			if(P.test(e)) {
				System.out.println(e + " is allowed.");
			}else {
				System.out.println(e + " is not allowed.");
			}
		}
	}
}*/
//------------------------------------------------------------------------------------------------------------------------------------

//Predicate Example 5:
//Employment management application using predicate

/*class Employee{
	String name;
	String designation;
	double salary;
	String city;
	
	public Employee(String name, String designation, double salary, String city) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}
	
	public String toString(){
		String s=String.format("(%s,%s,%.2f,%s)",name,designation,salary,city);
		return s;
	}
	
	public boolean equals(Object obj) {
		Employee e=(Employee)obj;
		if(name.equals(e.name) && designation.equals(e.designation) && salary==e.salary && city.equals(e.city)) {
			return true;
		}else {
			return false;
		}
	}
}

public class EmployeeManagement{
	public static void main(String[] args) {
		ArrayList<Employee> al=new ArrayList<>();
		populate(al);
		System.out.println(al);
		
		Employees with designation Manager
		Predicate<Employee> P1=(emp)->emp.designation.equals("Manager");
		display(P1,al);
		
		All employees whose city is Bangalore
		Predicate<Employee> P2=(emp)->emp.city.equals("Bangalore");
		System.out.println("Bangalore Employees Information:");
		display(P2,al);
		
		All employees whose salary is less than 20000
		Predicate<Employee> P3=(emp)->emp.salary < 20000;
		System.out.println("Employees whose salary is less than 20000:");
		display(P3,al);
		
		Manager and City in Bangalore
		System.out.println("Employees with designation Manager and City in Bangalore");
		display(P1.and(P2), al);
		
		Employees who are not Managers
		System.out.println("Employees who are not Managers:");
		display(P1.negate(), al);
		
		Usage of isEqual method for our Employee class
		Predicate<Employee> isCEO=Predicate.isEqual(new Employee("Sikha", "CEO", 897654321, "Goa"));
		
		Employee e1=new Employee("Anner","Lead",879787,"Mysore");
		Employee e2=new Employee("Sikha", "CEO", 897654321, "Goa");
		
		System.out.println(isCEO.test(e1));
		System.out.println(isCEO.test(e2));
		
	}
	
	public static void display(Predicate<Employee> P,ArrayList<Employee> al){
		for(Employee e : al) {
			if(P.test(e)) {
				System.out.println(e);
			}
		}
		System.out.println("************************************************************************");
	}
	
	public static void populate(ArrayList<Employee> al) {
		al.add(new Employee("Suhas","Manager",100000000,"Bangalore"));
		al.add(new Employee("Kittu","TA",90000000,"California"));
		al.add(new Employee("Puttu","SSE",700000,"Bangalore"));
		al.add(new Employee("Juttu","Manager",8646,"California"));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------
//Predicate interface isEqual method

/*interface Predicate<T>{
	public boolean test(T t);
	
	Default methods:
  	and();
 	or();
 	negate();
	
	
	//Static method : can be used to check for equality purpose
	public static Predicate isEqual(T t) {
		 
	}
	
}*/

/*
 * Predicate<String> P=Predicate.isEqual("Suhas Nayak");
 * SOP(P.test("Suhas Nayak")); //true
 * SOP(P.test("Kittu Puttu")); //false 
 * 
 * */

//------------------------------------------------------------------------------------------------------------------------------------
/*
 * Predicate vs Function
 * 1)Predicate checks some condition and returns boolean value	||	Function is same as predicate, but need not return boolean value, it can return anything.
 * 2)Predicate declaration:
 * interface Predicate<T>{
 * 		boolean Test(T t);
 * }
 * 
 * Function declaration:
 * T is the i/p param, R is the return type
 * interface Function<T,R>{
 * 		R apply(T t);
 * }
 * 3)Predicate can take one type parameter which represents input argument type(Predicate<T>)	||	Function takes 2 type params. First one represent input argument type second one represent
 * return type(Function<T,R>)
 * 4)Predicate interface defines one abstract method called test()	||	Function interface defines one abstract method called apply()
 * 5)public boolean test(T t)	||	public R apply(T t)
 * 6)Predicate can return only boolean value	||	Function can return any type of value.
 * */

//------------------------------------------------------------------------------------------------------------------------------------
//Requirement : To find the length of a given String
/*public class Test{
	public static void main(String[] args) {
		Function<String, Integer> f=s->s.length();
		System.out.println(f.apply("Suhas Nayak"));
		System.out.println(f.apply("Kittu"));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------
//Requirement : Given a integer number return the square of that integer number
/*public class Test{
	public static void main(String[] args) {
		Function<Integer, Integer> f=i->i*i;
		System.out.println(f.apply(5));
		System.out.println(f.apply(7));
	}
}*/
//------------------------------------------------------------------------------------------------------------------------------------

//Program to find number of spaces present in the given String by using function
/*public class Test{
	public static void main(String[] args) {
		Function<String, Integer> f=str->{
			return str.length()-str.replaceAll(" ", "").length();
		};
		System.out.println(f.apply("This is my first example"));
		System.out.println(f.apply("Common Suhas Nayak"));
	}
}*/



//------------------------------------------------------------------------------------------------------------------------------------

//Program to remove spaces present in the given String by using function
/*public class Test{
	public static void main(String[] args) {
		Function<String, String> f=str->{
			return str.replace(" ", "");
		};
		System.out.println(f.apply("This is my first example"));
		System.out.println(f.apply("Common Suhas Nayak"));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Program to find student grade by using function, also write a predicate to check if the student marks is greater than 60 or not, print the student details only if the grade is greater 
//than 60.
/*class Student{
	String name;
	int marks;
	 
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
}

public class Test{
	public static void main(String[] args) {
		ArrayList<Student> al=new ArrayList<>();
		
		Predicate<Student> P=s->s.marks>60;
		
		populate(al);
		Function<Student,String> f=s->{
			int marks=s.marks;
			if(marks >=80) {
				return "A[Distinction]";
			}else if(marks>=60) {
				return "B[First class]";
			}else if(marks>=50) {
				return "C[Second class]";
			}else if(marks>=35) {
				return "D[Third class]";
			}else {
				return "F[Fail]";
			}
		};
		
		for(Student s : al) {
			if(P.test(s)) {
				System.out.println("Name: "+s.name+"	Marks: "+s.marks+"	Grade: "+f.apply(s));
			}
		}
	}
	
	public static void populate(ArrayList<Student> al) {
		al.add(new Student("Suhas", 100));
		al.add(new Student("Sushanth", 70));
		al.add(new Student("Puttu", 50));
		al.add(new Student("Kittu", 45));
		al.add(new Student("Jean", 33));
		al.add(new Student("Melissa", 16));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------
//Program to find total monthly salary of all the employees by using function
/*class Employee{
	String name;
	double salary;
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return name+" : "+salary;
	}
}

class Test{
	public static void main(String[] args) {
		ArrayList<Employee> al=new ArrayList<>();
		populate(al);
		Function<ArrayList<Employee>,Double> f=l->{
			double total=0;
			for(Employee e : l) {
				total+=e.salary;
			}
			return total;
		};
		
		System.out.println("Total salary of all the employees is: "+f.apply(al));
	}
	
	public static void populate(ArrayList<Employee> al) {
		al.add(new Employee("Suhas", 10000));
		al.add(new Employee("Sushanth", 7000));
		al.add(new Employee("Puttu", 5000));
		al.add(new Employee("Kittu", 4500));
		al.add(new Employee("Jean", 3300));
		al.add(new Employee("Melissa", 16000));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------
 
//Program to perform salary increment for Employees by using Predicate and Function(people whose salary is below 3500, increment by 477)
/*class Employee{
	String name;
	double salary;
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return name+" : "+salary;
	}
}

class Test{
	public static void main(String[] args) {
		ArrayList<Employee> al=new ArrayList<>();
		populate(al);
		
		System.out.print("Salary before increment:");
		System.out.println(al);
		
		Predicate<Employee> P=e->e.salary<3500;
		Function<Employee,Employee> f=e->{
			e.salary=e.salary+477;
			return e;
		};
		
		ArrayList<Employee> al2=new ArrayList<>();
		for(Employee e : al) {
			if(P.test(e)) {
				al2.add(f.apply(e));
			}
		}
		
		System.out.print("Employees whose salary incremented:");
		System.out.println(al2);
	}
	
	public static void populate(ArrayList<Employee> al) {
		al.add(new Employee("Suhas", 10000));
		al.add(new Employee("Sushanth", 7000));
		al.add(new Employee("Puttu", 5000));
		al.add(new Employee("Kittu", 4500));
		al.add(new Employee("Jean", 3300));
		al.add(new Employee("Melissa", 2900));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------
//Function chaining
//First way
//f1.andThen(f2)  if we want to execute f2 after f1. First f1 will be applied followed by f2.

//Other way
//f1.compose(f2)  First f2 will be applied followed by f1.

/*class Test{
	public static void main(String[] args) {
		Function<String, String> f1=str->str.toUpperCase();
		Function<String, String> f2=str->str.substring(0, 9);
		System.out.println(f1.apply("aishwaryaabhi"));
		System.out.println(f2.apply("aishwaryaabhi")); 
		System.out.println(f1.andThen(f2).apply("aishwaryaabhi"));
		System.out.println(f1.compose(f2).apply("aishwaryaabhi"));
		
		//andThen vs compose difference example
		Function<Integer, Integer> f3=i->i+i;
		Function<Integer, Integer> f4=i->i*i;
		System.out.println(f3.apply(5));
		System.out.println(f4.apply(5)); 
		System.out.println(f3.andThen(f4).apply(5));
		System.out.println(f4.andThen(f3).apply(5));
		System.out.println(f3.compose(f4).apply(5));
		System.out.println(f4.compose(f3).apply(5));
	}
}*/
//------------------------------------------------------------------------------------------------------------------------------------

//Demo program for Use Authentication by using Function Chaining
/*class Test{
	 public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username:");
		String user=sc.next();
		System.out.println("Enter password");
		String pwd=sc.next();
		
		Function<String,String> f1=str->{
			return str.substring(0, 5);
		};
		
		Function<String,String> f2=str->{
			return str.toLowerCase();
		};
		
		if(f1.andThen(f2).apply(user).equals("suhas") && pwd.equals("java")) {
			System.out.println("Valid user");
		}else {
			System.out.println("Invalid user");
		}
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Function interface static method : identity()
/*Function interface contains:
 * 1 abstract method - apply()
 * 2 default methods - andThen(),compose()
 * 1 static method - identity(), this will always return a function and returns same thing as input.
 * 
 * Function<String,String> f=Function.identity();
 * SOP(f.apply("Suhas"))//Suhas
*/

//##########################################################################################################################################

/*COMSUMER INTRODUCTION
 * We covered 2 pre-defined functional interfaces
 * 1)Predicate
 * 2)Function
 * 
 * Consumer functional interface: Compulsorily it will take some input parameter and perform some operation but it won't return anything.
 * It contains one abstract method : accept()
 * 
 * interface abstract{
 * 		void accept (T t);
 * }
 * 
 * Eg: Consumer<String> c=s->SOP(s);
 * c.accept("Hello Suhas Nayak");
 * 
 * */ 

//Program to display movie information by using Consumer
/*class Movie{
	String name;
	String hero;
	String heronie;
	
	public Movie(String name, String hero, String heronie) {
		super();
		this.name = name;
		this.hero = hero;
		this.heronie = heronie;
	}	
}

class Test{
	public static void main(String[] args) {
		ArrayList<Movie> al=new ArrayList<>();
		populate(al);
		Consumer<Movie> c=m->{
			System.out.println(m.name+" :: "+m.hero+" : "+m.heronie);
		};
		for(Movie m :al) {
			c.accept(m);
		}
	}
	
	public static void populate(ArrayList<Movie> al) {
		al.add(new Movie("Bahubali", "Prabhas", "Anushka"));
		al.add(new Movie("DDLJ", "Shahrukh", "Kajol"));
		al.add(new Movie("Hello Brother", "Salman", "Juhi"));
		al.add(new Movie("Dangal", "Aamir", "Ritu"));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Program to display predicate information using Predicate, Function and Consumer
/*class Student{
	String name;
	int marks;
	 
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
}

public class Test{
	public static void main(String[] args) {
		ArrayList<Student> al=new ArrayList<>();
		
		Predicate<Student> P=s->s.marks>60;
		
		populate(al);
		Function<Student,String> f=s->{
			int marks=s.marks;
			if(marks >=80) {
				return "A[Distinction]";
			}else if(marks>=60) {
				return "B[First class]";
			}else if(marks>=50) {
				return "C[Second class]";
			}else if(marks>=35) {
				return "D[Third class]";
			}else {
				return "F[Fail]";
			}
		};
		
		//Usage of consumer 
		Consumer<Student> c=s->{
			System.out.println("Name: "+s.name+"	Marks: "+s.marks+"	Grade: "+f.apply(s));
		}; 
		
		for(Student s : al) {
			if(P.test(s)) {
				c.accept(s);
			}
		}
	}
	
	public static void populate(ArrayList<Student> al) {
		al.add(new Student("Suhas", 100));
		al.add(new Student("Sushanth", 70));
		al.add(new Student("Puttu", 50));
		al.add(new Student("Kittu", 45));
		al.add(new Student("Jean", 33));
		al.add(new Student("Melissa", 16));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Consumer Chaining
//Consumer interface contains one default method
//andThen()
/*C1.andThen(C2).andThen(C3).accept(m); 
 * */

/*class Movie{
	String name;
	String result;
	
	public Movie(String name, String result) {
		super();
		this.name = name;
		this.result = result;
	}	
}


class Test{
	public static void main(String[] args) {
		
		Consumer<Movie> C1=m->{
			System.out.println("Movie "+ m.name+" is ready to release");
		};
		
		Consumer<Movie> C2=m->{
			System.out.println("Movie "+ m.name+" is "+m.result);
		};
		
		Consumer<Movie> C3=m->{
			System.out.println("Movie "+ m.name+" information storing in database.");
		};
		
		Consumer<Movie> chainerC=C1.andThen(C2).andThen(C3);
		
		Movie m=new Movie("DDLJ", "Hit");
		
		//Consumer chaining
		chainerC.accept(m);
		
	}
}*/

//##########################################################################################################################################

//SUPPLIER INTRODUCTION
//Can you please return random password, random OTP, system date. I am not going to provide any input.
/*
 * interface Supplier<R>{
 * 	R get();
 * }
 */
//Write a Supplier to supply System date:

/*public class Test{
	public static void main(String[] args) {
		Supplier<Date>  s=()->new Date();
		
		System.out.println(s.get());
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Write a Supplier to generate some random name

/*public class Test{
	public static void main(String[] args) {
		Supplier<String> s=()->{
			String[] s1= {"Sunny","Bunny","Chinny","Manny","Danny"};
			int x=(int)(Math.random()*5);
			return s1[x];
		};
		System.out.println(s.get());
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Program to get random 6 digit OTP using Suppplier
/*public class Test{
	public static void main(String[] args) {
		Supplier<String> s=()->{
			String OTP="";
			for(int i=0;i<6;i++) {
				int otp=(int) (Math.random()*10);
				OTP+=otp;
			}
			return OTP;
		};
		System.out.print("Your OTP is: ");
		System.out.println(s.get());
		
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Write a Supplier to generate random password
//Rules: 1)Length should be 8 characters
//2)2,4,6,8 places only digits
//3)1,3,5,7 places only upper case alphabet symbols @,#,$

/*public class Test{
	public static void main(String[] args) {
		Supplier<String> a=()->{
			String pwd="";
			String symbols="ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";
			for(int i=0;i<8;i++) {
				if(i%2==0) {
					int j=(int)(Math.random()*(29));
					pwd+=symbols.charAt(j);
				}else {
					pwd+=(int)(Math.random()*10) ;
				}
			}
			return pwd;
		};
		System.out.println("Randomly generated password is: "+a.get());
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Predicate vs Function vs Consumer vs Supplier 
/*
 *  Purpose:
 *  ->To take some input and perform some conditional checks.
 *  ->To take some input and perform required operation and return the result.
 *  ->To consume some input and perform operation. it won't return anything.
 *  ->To supply some value based on our requirement.
 *  
 *  
 *  Interface Declaration:
 *  ->
 *  interface Predicate<T>
 *  {
 *  
 *  }
 *  
 *  
 *  ->
 *  interface Function<T,R>
 *  {
 *  
 *  }
 *  
 *  ->
 *  interface Consumer<T>
 *  {
 *  
 *  }
 *  
 *  ->
 *  interface Supplier<R>
 *  {
 *  
 *  }
 *  
 *  
 *  Single Abstract Method(SAM)
 *  public boolean test(T t);
 *  public R apply(T,t);
 *  public void accept(T t);
 *  public R get();
 *  
 *  
 *  Default Methods:
 *  and(),or(),negate();
 *  andThen(),compose();
 *  andThen();
 *  -
 *  
 *  
 *  Static Methods:
 *  isEqual();
 *  identity();  
 *  
 * */
//##########################################################################################################################################

//TWO ARGUMENT FUNCTIONAL INTERFACES

//Predicate
/*If we want to accept two input value and then do the conditional check, we have to do the below thing:
 * Predicate<Integer> P =i->i%2==0; // BiPredicate
 * */

//Function
/*BiFunction //if we want to take 2 input values
 * */

//Consumer
/*BiConsumer //if we want to take 2 input values
* */

//------------------------------------------------------------------------------------------------------------------------------------

//BiPredicate
/*interface BiPredicate<T, U>{
	public boolean test(T t,U u);
}

//Eg: Given 2 input values, we need to check if their sum is even or not.

public class Test{
	public static void main(String[] args) {
		 BiPredicate<Integer, Integer> bp=(x,y)->(x+y)%2==0;
		 System.out.println(bp.test(5, 6));
		 System.out.println(bp.test(5, 5));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//BiFunction
/*public class Test{
	public static void main(String[] args) {
		BiFunction<Integer,Integer,Integer> bf=(a,b)->a*b;
		
		System.out.println(bf.apply(10, 20));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Create Student object by taking name and roll no as input argument
/*class Student{
	String name;
	int rollNo;
	
	public Student(String name, int rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}	
	
	public String toString() {
		return this.rollNo + " : " +this.name;
	}
}

class Test{
	public static void main(String[] args) {
		ArrayList<Student>  al=new ArrayList<>();
		BiFunction<String,Integer,Student> bf=(n,r)->{
			return new Student(n,r);
		};
		
		al.add(bf.apply("Suhas", 105));
		al.add(bf.apply("Sushanth", 101));
		
		System.out.println(al);
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Calculate Monthly Salary With Employee and TimeSheet By Using BiFunction
/*class Employee{
	int eno;
	String name;
	double dailyWage;
	
	public Employee(int eno, String name, double dailyWage) {
		super();
		this.eno = eno;
		this.name = name;
		this.dailyWage = dailyWage;
	}
	
}

class TimeSheet{
	int eno;
	int days;
	
	public TimeSheet(int eno, int days) {
		super();
		this.eno = eno;
		this.days = days;
	}
}

class Test{
	public static void main(String[] args) {
		Employee e =new Employee(101,"Suhas",5641);
		TimeSheet t=new TimeSheet(101, 25); 
		
		BiFunction<Employee,TimeSheet, Double> bf=(emp,tim)->{
			return emp.dailyWage*tim.days;
		};
		
		System.out.println("Monthly salary: "+bf.apply(e, t));
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//BiConsumer Example

//------------------------------------------------------------------------------------------------------------------------------------
/*
 * One Argument vs Two Argument Functional Interfaces
 * -->We don't have static method isEqual(Object o) in BiPredicate Functional Interface.
 * -->We don't have default compose() and static identity method in BiFunction Functional Interface.
 *      
 * */

//##########################################################################################################################################

/*
 * Primitive Type Functional Interfaces
 * 
 * 1)Autoboxing : 
 * Suppose we have, 
 * Integer I=10; until 1.4v this was invalid, from 1.5v this is valid because internally compiler converts int to Integer object, this is known as Autoboxing. Internally this line will be
 * converted to Integer I=Integer.valueOf(10); 
 *  
 * 2)Autounboxing : 
 * Integer I=new Integer(10);
 * int x=I;//Autounboxing.
 * Internally, int x=I.intValue(); 
 * 
 * 3)Generics Type Parameter :
 * ArrayList<Integer> l=new ArrayList<Integer>();
 * For type parameters, only objects are allowed, primitives are not allowed.
 * 
 * 
 * */

//------------------------------------------------------------------------------------------------------------------------------------

//Write a predicate to check whether the given number is even or not
/*class Test{
	public static void main(String[] args) {
		int[] c= {1,2,3,4,5,6,7,8,9};
		Predicate<Integer> P=(x)->x%2==0;
		for(int y : c) {
			if(P.test(y))
				System.out.println(y);
		}
	}
	
	//Problem with this approach ?
	/*
	 * Performance wise this is not at all recommended.
	 * ->Predicate will take Integer type argument, but our input type is int. Internal conversion is required(Autoboxing  int-->Integer).
	 * ->If we want to perform % operation, for Object types we can't perform. Integer need to be converted to int type(Autounboxing  Integer-->int).
	 * 
	 *  So if out input type and return type are int values normal functional interfaces are not at all recommended. it is highly recommended to go for primitive type functional interfaces.
	 * 
	 * 
}*/

//Primitive Type Functional Interfaces For Predicate
//We don't need any type parameter
/*interface IntPredicate{
	public boolean test(int i);
}

//Biggest Advantage : Performance Improvement, no autoboxing and autounboxing.
public class Test{
	public static void main(String[] args) {
		int[] c= {1,2,3,4,5,6,7,8,9};
		IntPredicate P=(x)->x%2==0;
		for(int y : c) {
			if(P.test(y))
				System.out.println(y);
		}
	}
}*/

//We even have DoublePredicate,LongPredicate, test method will take double and long value.
 
//------------------------------------------------------------------------------------------------------------------------------------

//Demo Programs about Primitive Type Functional Interfaces for Function
//input - int type, return type - Integer
/*
 * IntFunction<Integer> f=i->i*i;
 * SOP(f.apply(5));
 * */


/*Example 1:
 * Function<String, Integer> f=s->s.length();
 * SOP(f.apply("Suhas"));//5
 * 
 *To improve performance
 *
 *return type is int
 *ToIntFunction<String> f=s->s.lenght();
 *SOP(f.applyAsInt("Suhas"));//5
 */


/*
 *Example 2:
 *Function<Integer,Double> f=i->Math.sqrt(i);
 *SOP(f.apply(5));
 *
 *IntToDoubleFunction f=i->Math.sqrt(i);
 *SOP(f.applyAsDouble(5)); 
 * */

//------------------------------------------------------------------------------------------------------------------------------------

//All 15 Primitive Type Functional Interfaces for Function
/*
 * When we want to fix the input type
 * 1)IntFunction<R>
 *  public R apply(int i;
 *  
 * 2)LongFunction<R>
 * 	public R apply(long i);
 * 
 * 3)DoubleFunction<R>
 * 	public R apply(double i);
 * 
 * When we want to fix the return type
 * 4)ToIntFunction<T>
 *  public int applyAsInt(T t);
 * 
 * 5)ToLongFunction<T>
 *  public long applyAsLong(T t);
 *  
 * 6)ToDoubleFunction<T>
 *  public double applyAsDouble(T t); 
 *  
 * 7)IntToLongFunction
 * 	public long applyAsLong(int i);
 * 
 * 8)IntToDoubleFunction
 * 	public double applyAsDouble(int i);
 * 
 * 9)LongToDoubleFunction
 * 	public double applyAsDouble(long i);
 * 
 * 10)LongToIntFunction
 * 	public int applyAsInt(long i);
 * 
 * 11)DoubleToIntFunction
 * 	public int applyAsInt(double i); 
 * 
 * 12)DoubleToLongFunction
 * 	public long applyAsLong(double i); 
 * 
 * 13)ToIntBiFunction<T,U>
 * 	public int applyAsInt(T t, U u)
 * 
 * 14)ToLongBiFunction<T,U>
 *  public long applyAsLong(T t, U u)
 * 
 * 15)ToDoubleBiFunction<T,U>
 *  public double applyAsDouble(T t,U u)
 * 
 * */
//------------------------------------------------------------------------------------------------------------------------------------
/*
 * Primitive Versions for Consumer
 * 1)IntConsumer
 * 2)LongConsumer
 * 3)DoubleConsumer
 * 
 * Now suppose if we have one input as int and the other input as Object type then
 * ObjIntConsumer<T>
 *  public void accept(T t, int i);
 *  
 * ObjLongConsumer<T>
 *  public void accept(T t, long i);  
 *   
 * ObjDoubleConsumer<T>
 *  public void accept(T t, double  i);
 * Example:
 * ObjDoubleConsumer<Employee> c=(e,d)->e.salary=e.salary+d;
 *   c.accept(e,500.0);
 * */
//------------------------------------------------------------------------------------------------------------------------------------
//Primitive Versions For Supplier
 /*
  * interface IntSupplier{
  * 	public int getAsInt();
  * }
  * 
  * IntSupplier s=()->(int)(Math.random()*10);
  * String otp="";
  * for(int i=0;i<6;i++){
  * 	otp+=s.getAsInt();
  * }
  * SOP(otp);
  * 
  *There are 4 primitive versions of Supplier
  *	getAsInt()
  *	getAsLong()
  *	getAsDouble()
  *	getAsBoolean()
  * */
//##########################################################################################################################################

//Unary Operator and its Primitive versions
/*Unary Operator is the child interface of function only. 
 * We go for Unary operator if the input type and the return type is the same.
 * 
 * 
 * */

/*public class Test{
	public static void main(String[] args) {
		UnaryOperator<Integer> o=i->i*i;
		System.out.println(o.apply(5));
	}
}*/

//Primitive versions of UnaryOperator
/*
 * 1)
 * interface IntUnaryOperator{
 * 	public int applyAsInt(int i);
 * }
 * 
 * 2)LongUnaryOperator
 * 
 * 3)DoubleUnaryOperator
 * 
 * */
//------------------------------------------------------------------------------------------------------------------------------------

//Binary Operator
/*
 * It is the child of BiFunction
 * We go for this, when the data type of two input type and return type is the same.
 * 
 * */ 
//Primitive versions of BinaryOperator
/*
 * 1)IntBinaryOperator
 * 2)LongBinaryOpearator
 * 3)DoubleBinaryOperator
 * */
//##########################################################################################################################################

//We covered:
/*
 * 1)Lambda Expression
 * 2)functional Interfaces
 * 3)Default methods inside interface
 * 4)Static methods inside interface
 * 5)java.util.function(Some predefined functional interfaces present)
 * 5a)Predicate 5b)Function 5c)Consumer 5d)Supplier
 * */

//Method Reference by Double Colon() Operator
/*
 * We can use this for method reference and constructor reference
 * Biggest Advantage ? Code re-usability
 * 
 * NOTE: 
 * Functional interface can refer to Lambda expression or method reference.
 * method reference is alternative syntax to Lambda expression.
 * 
 * Referring to static method:
 * classname :: method name
 * Eg: Test :: m2
 * 
 * Referring to instrance method:
 * objectref :: method name
 * Eg: Test t=new Test();
 * 		 t :: m2
 * 
 */


/*interface Interf{
	public void m1();
}

class Test{
	public static void m2() {
		System.out.println("Method Reference");
	}
	
	public static void main(String[] args) {
		//This is the way how m1 can refer to static method m2. Only condition for method reference is method arguments should match. Return type. 
		//method name can be anything doesn't matter
		Interf i=Test :: m2;
		i.m1();
	}
}*/
//------------------------------------------------------------------------------------------------------------------------------------

//Multi-threading using Lambda expression
/*public class Test{
	public static void main(String[] args) {
		Runnable r=()->{
			for(int i=0;i<10;i++) {
				System.out.println("Child Thread...");
			}
		};
		Thread t=new Thread(r);
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main thread");
		}
	}
}*/

//Multi-threading using method reference
/*public class Test{
	
	public void m1() {
		for(int i=0;i<10;i++) {
			System.out.println("Child thread");
		}
	}
	
	public static void main(String[] args) {
		Test t=new Test();
		Runnable r=t :: m1;
		Thread t1=new Thread(r);
		t1.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main thread");
		}
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------

//Constructor Reference by Double Colon() Operator
/*class Sample{
	Sample(){
		System.out.println("Sample Consructor and Object Creation");
	}
}

interface Interf{
	public Sample get();
}


public class Test{
	public static void main(String[] args) {
		//Using Lambda Expression
		Interf i=()->{
			return new Sample();
		};
		i.get();
		
		//Using constructor reference
		Interf in=Sample :: new;
		Sample s =in.get();
	}
}*/

//------------------------------------------------------------------------------------------------------------------------------------
//STREAMS

/* We covered:
 * How we can declare concrete(default) and static methods inside interface.
 * */

/*We already have java.io streams concept, then what is the difference between this new Java 8 concept ?
 * 
 * If we want to represent data with respect to file operation then we have to go for java.io stream concept.
 * 
 * 1.8v streams concepts nowhere related to file operations, instead it is related to Collections and is present in java.util package.
 * 
 * Difference between Collection and Stream
 * Collection: If we want to represent group of individual objects as single entity.
 * Stream: If we want to process objects from the Collection then we can go for Streams concept.
 *  
 * */
//------------------------------------------------------------------------------------------------------------------------------------

//Methods of Stream : filter() and map()
/*public class Test{
	public static void main(String[] args) {
		ArrayList<Integer> l1=new ArrayList<>();
		ArrayList<Integer> l2=new ArrayList<>();
		l1.add(0);
		l1.add(10);
		l1.add(20);
		l1.add(5);
		l1.add(15);
		l1.add(25);
		System.out.println(l1);
		
		//Without streams
		for(Integer i : l1) {
			if(i%2==0) {
				l2.add(i);
			}
		}
		
		System.out.println("Normal code: "+l2);
		
		//With streams
		//use of filter
		List<Integer> l3=l1.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println("Code with stream(Use of filter): "+l3);
		
		//use of map
		List<Integer> l4=l1.stream().map(i->i*2).collect(Collectors.toList());
		System.out.println("Code with stream(Use of map): "+l4);	
	}
}*/
//------------------------------------------------------------------------------------------------------------------------------------

/*How to get Stream object ?
 * Stream s=c.stream(); where c is any Collection. stream method is present inside Collection interface as default method.
 * Stream is an interface preset in java.util.stream package
 * 
 * What is the purpose of stream object ?
 * To process objects from Collection we use stream object.
 * Processing contains 2 steps:
 * 1)configuration
 * 1a)filter mechanism
 * 1b)map mechanism
 * 2)processing
 * 
 * Filtering:
 * We can configure Filter by using filter() method of stream interface
 * public Stream filter(Predicate<T> t){
 * 	//Predicate value can be any boolean valued function or Lambda expression
 * }
 * 
 * Mapping:
 * We can implement mapping by using map() method of stream interface
 * public Stream map(Function<T,R> f){
 * 
 * }
 * 
 * 
 * Various methods of Stream:
 * 
 * 1)Processing by collect() method
 * This method collects the elements from the stream and adds to the specified Collection.
 * Eg: 
 * AL<String> l=new AL<>();
 * l.add("Pavan")
 * l.add("Ravi")
 * l.add("Chinnu")
 * l.add("Munnu")
 * l.add("Samu")
 * SOP(l);//[Pavan,Ravi,Chinnu,Munnu,Samu]
 * 
 *Say we want names whose length is greater than or equal to 5
 *List<String> l1=l.stream().filter(s->s.length()>=5).collect(Collectors.toList());
 *SOP(l1);
 *
 *2)Processing by count method
 * This method returns the number of elements present in stream
 * public long count()
 * 
 * 3)Processing by sorted method
 * We can use sorted() method to sort elements inside the stream
 * We can sort either based on default natural sorting order or based on our own customized sorting order specified by comparator object.
 * a)sorted() : For default natural sorting.
 * b)sorted(Comparator c) : For customized sorting order.
 * 
 * 4)min(Comparator c) and max(Comparator c) method
 * Returns min/max value based on specified comparator.
 * If we are talking about these two methods then the list should be compulsorily sorted.
 * 
 * 5)forEach()
 * More or less same as forEach loop, which was introduced in 1.5 version, but this is a method.
 * This method won't return anything, instead it can take Lambda expression as parameter and apply it to each element present in the stream object.
 * 
 * 6)Processing by toArray() method
 * We can use this method to copy elements present in the Stream into specified array
 * 
 * NOTE:
 * Streams concept is not applicable only for Collections, it is applicable for any group of objects including arrays as well.
 * 7)Stream.of() methos
 * a)For group of values
 * Stream<Integer> s=Stream.of(9,99,999,9999,99999);// Now we can call any methods on this stream
 * 
 * b)For Arrays
 * 
 *Summary Of Streams:
 *
 * */

/*
public class Test{
	public static void main(String[] args) {
		ArrayList<String> l=new ArrayList<>();
		 l.add("pavan");
		 l.add("Ravi");
		 l.add("Chinnu");
		 l.add("munnu");
		 l.add("Samu");
		 //System.out.println(l);
		 
		 //Processing methods
		  
		 //1)collect method
		 //Filtering the names whose length is greater than 5
		 List<String> l1=l.stream().filter(s->s.length()>=5).collect(Collectors.toList());
		 System.out.println("Names after filtering: "+l1);
		 
		 //Changing the first letter of all the names to Upper case
		 List<String> l2=l.stream().map(s->s.substring(0, 1).toUpperCase()+s.substring(1,s.length())).collect(Collectors.toList());
		 System.out.println("Names after changing first letter of all the String to uppercase: "+l2);
		 
		 
		 //2)count method
		 //Count the number of elements in the initial list whose length is greater than 6
		 System.out.println("Number of elements in the array whose length is greater than or equal to 6: "+l.stream().filter(s->s.length()>=6).count());
		 
		 //3)sorted method- natural sorting
		  List<String> l3=l.stream().sorted().collect(Collectors.toList());
		  System.out.println("Elements after sorting based on natural sorting order: "+l3);
		  
		//sorted method- customized sorting
		  //if we just do s1.compareTo(s2), we will again get default natural sorting order. 
		  List<String> l4=l.stream().sorted((s1,s2)->{
			  if(s1.length()<s2.length()) {
				  return 1;
			  }else if(s1.length()>s2.length()) {
				  return -1;
			  }
			  return 0;
		  }).collect(Collectors.toList());
		  System.out.println("Elements after sorting based on length: "+l4);
		  
		  //4)min and max method
		  ArrayList<Integer> in=new ArrayList<>();
		  in.add(10);
		  in.add(18);
		  in.add(9);
		  in.add(5);
		  in.add(44);
		  in.add(26);
		  in.add(30);
		  System.out.println("Input integer Array List: "+in);
		  
		  System.out.println("Minimum value based on natural order sorting is: "+in.stream().max((i1,i2)->i1.compareTo(i2)).get());
		  
		  //5)forEach() method- print all the elements inside the array list 
		  System.out.print("Printing all the elements inside list using forEach method: ");
		  in.stream().forEach(ele->{
			  System.out.print(ele+" ");			  
		  });
		  System.out.println("\nUsing method reference instead of Lambda Expression: ");
		  //We can replace Lambda expression with method reference:
		  in.stream().forEach(System.out :: println );
		  
		  //6)toArray() method
		  Integer[] arr=in.stream().toArray(Integer[] :: new );//*********************************OBJECT REFERENCE CONCEPT NOT CLEAR*********************************
		  System.out.println(Arrays.toString(arr));
		  
		  //7)Stream.of() method
		  //a)For group of values
		  System.out.print("Stream.of method demo: ");
		  Stream<Integer> s=Stream.of(9,99,999,9999,99999);
		  s.forEach(ele->{
			  System.out.print(ele+" ");
		  });
		  
		  //UNDERSTAND THE ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		  //**********Variable used in lambda expression should be final or effectively final*********************
		  
		  
		  //b)For Arrays
		  Double[] d={10.1,10.2,10.3,10.4,10.5};
		  Stream<Double> s1=Stream.of(d);
		  System.out.print("\nDisplaying double values: ");
		  s1.forEach(ele->{
			  System.out.print(ele);
		  });
		  
	}
}*/


//Java 1.8V New Features Summary
/*
 *1)Lambda Expression
 *
 *2)Functional Interface : If any interface contains only one abstract method then such type of interfaces are called functional interfaces. It can contain any
 *number of default and static methods.
 *Comparable ---> compareTo()
 *Runnable ---> run()
 *Callable ---> call()
 *ActionListener --->  actionPerformed() 
 *Purpose ???
 *To refer Lambda expression we have to go for functional interface.
 *
 *3)Default Methods inside interfaces[Study interface with default methods vs abstract class ]
 *Meaning ? Need ?
 *Concrete methods with default keyword are called default methods.
 *Main objective : To provide dummy implementation.
 *Advantage ?
 *If we want to add a new method, without affecting already implemented classes.
 *Example:
 *interface X{
 *	m1();
 * 
 *}
 *
 *class Test implements X{
 *	m1();
 *}
 * 
 *class Demo implements X{
 *	m1();
 *}
 *
 *If we add any abstract method m2() to the interface in the future then all the implementation classes responsible to provide implementation for m2().
 *That is why we go for default methods, instead of taking m2(), we can take default void m2(); Now the implementation classes no need to implement.
 *
 *4)Static methods in interfaces
 *If we have only static method, it won't be related to object in any way. So it doesn't make sense to create class just to declare static method, so we can use
 *interface to declare static methods. We can even declare main method in interface as well.
 *
 *5)Predefined functional Interfaces
 *a)Predicate<T> : To perform some conditional check. Contains abstract method test.
 *b)Function<T, R> : If we want to return some value after performing some function. Contains abstract method apply.
 *c)Consumer<T> : Exactly same as function, but it won't return anything. Contains abstract method accept.
 *d)Supplier<T> : Always going to provide the values. Contains abstract method get.
 *
 *6) :: operator(******************************************         NOT CLEAR       **************************************************************)
 *To implement method and constructor reference.
 *Biggest advantage :  We can use already existing code for implementing functional interfaces.
 *
 *7)Streams
 *
 *8)Date&Time API(Joda Time API)
 * */


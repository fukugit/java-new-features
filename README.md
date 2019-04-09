# java-new-features
![](https://img.shields.io/badge/Initial%20creation-Jan%202019-brightgreen.svg)  

This project is the cheat sheet of Java for each version, which is from java 5 to 11.    
<br/>

## Description
See [Cheat sheet](https://github.com/fukugit/java-new-features/wiki/Cheat-sheet-for-Java-new-feature).  
That is main contents in this project.  

### Java5
2. Generics for Class.  
    The below Java codes are defined in [here](src/main/java/jp/co/example/java5/GenericsOfClass.java).  
    ```
      public static class Book<T> {
        private T t;
        private List<T> list = new ArrayList<T>();
        
        public String set(T arg){
          this.t = arg;
          return t.toString();
        }
        
        public List<T> add(T arg){
          list.add(arg);
          return list;
        }
      }
    
      // The way to call the above class.
      Book<Integer> book = new Book<>();
      book.set(Integer.valueOf(1));
      book.add(Integer.valueOf(1))
    ```

### Java8
1. Lambda  
    The below Java codes are defined in [here](src/main/java/jp/co/example/java8/LambdaFeature.java).  

    1-1. The below code is not Lambda. That is just Anonymous class(無名クラス). It is possible to replace to lambda class from now like 1-2. That means it is just example.  
    ```
      Runnable run = new Runnable() {
        @Override
        public void run() {
          System.out.println("test");
        }
      };
      
      // The way to call the above class.  
      run.run();
    ```
    
    1-2. The below Lambda is standard way.
    ```
      Runnable run1 = () -> {System.out.println("test 1");};
      
      // The way to call the above class. 
      run1.run();
    ```
    
    1-3. The below Lambda is using method to run Runnable class. The method follow 'type inference'(型推論) implicitly.   
    ```
      public static void runRunnable(Runnable r) {
        r.run();
      }
      
      // The way to call the above method. The Runnable class should be pass to the method at timing of calling.  
      runRunnable(()->{System.out.println("test 2");});
    ```
    
    1-4. Using original @FunctionalInterface.  
    ```
      @FunctionalInterface
      interface Run3{
          public String show(String name);
          public default String getName(String name) {return name;};
      }
      
      // The way to call above class. There are 3 type way to call.  
      Run3 run3 = (String name) -> {return name + "!";};
      System.out.println(run3.show("test 3"));
      
      Run3 run4 = (name) -> {return name + "!";};
      System.out.println(run4.show("test 4"));
      
      Run3 run5 = name -> {return name + "!";};
      System.out.println(run5.show("test 5"));
      
      // The below way is method reference(メソッド参照).  The below section explain the method reference more detail.  
      Run3 run6 = (String::toUpperCase);
      System.out.println(run6.show("test 6"));
    ```

#### Java5
1. [Generics for Method](src/main/java/jp/co/example/java5/GenericsOfMethod.java).  
2. [Generics for Class](src/main/java/jp/co/example/java5/GenericsOfClass.java).
3. [Enum](src/main/java/jp/co/example/java5/EnumFeature.java).

#### Java8
1. [Lambda](src/main/java/jp/co/example/java8/LambdaFeature.java)  
2. [Function method](src/main/java/jp/co/example/java8/FunctionFeature.java)  
3. [Stream](src/main/java/jp/co/example/java8/StreamFeature.java)  
4. [Stream of collect as Collector](src/main/java/jp/co/example/java8/CollectorFeature.java)  
5. [FunctionalInterface](src/main/java/jp/co/example/java8/FunctionalInterfaceFeature.java)  
6. [Optional](src/main/java/jp/co/example/java8/OptionalFeature.java)  
7. [Sort in Collection](src/main/java/jp/co/example/java8/CollectionsSortFeature.java)  
8. [Collector](src/main/java/jp/co/example/java8/CollectorFeature.java)  


## Demo
None.  
<br/>

## Dependency
None  
<br/>

## Requirements
Java  
Maven  
<br/>

## Usage
1. Run the each class on IDE.  
<br/>

## References
none.  
<br/>

## Licence
MIT
<br/>

## Authors
[fukugit](https://github.com/fukugit)
<br/>

## Conclusion
The each version of Java are always had us excited.  


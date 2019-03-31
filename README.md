# java-new-features
![](https://img.shields.io/badge/Initial%20creation-Jan%202019-brightgreen.svg)  

This project is the cheat sheet of Java for each version, which is from java 5 to 11.    
<br/>

## Description
The following sections explain the new feature of java per each java version.  

### Java5
1. Generics for Method.  
    The below Java codes are defined in [here](src/main/java/jp/co/example/java5/GenericsOfMethod.java).  

    1-1. The following method is standard one for Generics.  
    ```
     private static <T> T get(T name) {
       return name;
     }
    ```

    1-2. The following method is for List.  
    ```
      private static <T> List<T> getList(T name) {
        List<T> list = new ArrayList<>();
        list.add(name);
        return list;
      }
    ```


### Java8
1. [Lambda](src/main/java/jp/co/example/java8/LambdaFeature.java)  
2. [Function method](src/main/java/jp/co/example/java8/FunctionFeature.java)  
3. [Stream](src/main/java/jp/co/example/java8/StreamFeature.java)  
4. [Stream of collect as Collector](src/main/java/jp/co/example/java8/CollectorFeature.java)  
5. [FunctionalInterface](src/main/java/jp/co/example/java8/FunctionalInterfaceFeature.java)  
6. [OptionalFeature](src/main/java/jp/co/example/java8/OptionalFeature.java)  
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


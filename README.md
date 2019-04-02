# java-new-features
![](https://img.shields.io/badge/Initial%20creation-Jan%202019-brightgreen.svg)  

This project is the cheat sheet of Java for each version, which is from java 5 to 11.    
<br/>

## Description
The following sections explain the new feature of java per each java version.  

### Java5
1. Generics for Method.  
    The below Java codes are defined in [here](src/main/java/jp/co/example/java5/GenericsOfMethod.java).  

    1-1. Standard Generics for Generics.  
    ```
     private static <T> T get(T name) {
       return name;
     }
    ```

    1-2. For List.  
    ```
      private static <T> List<T> getList(T name) {
        List<T> list = new ArrayList<>();
        list.add(name);
        return list;
      }
    ```
    1-3. For Map.  
    ```
      Map<String, Integer> map1 = getHashMap();
      
      public static <K, V> HashMap<K, V> getHashMap(){
        return new HashMap<K, V>();
      }
    ```
    1-4. For Map that has extended class.  
    ```
      private static <T extends Number> List<T> getList(T id) {
        List<T> list = new ArrayList<>();
        list.add(id);
        return list;
    }
    ```
    1-5. For Wild Card.  
    ```
      Set<String> s1 = Set.of("test1", "test2");
      Set<String> s2 = Set.of("test1");
      System.out.println("numElementsInCommon result : " + numElementsInCommon(s1, s2));
      
      private static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
          if (s2.contains(o1)) {
            result++;
          }
        }
        return result;
      }
    ```
    1-6. For Wild Card, return object is also Wild Card.  
    ```
      Set<String> s1 = Set.of("test1", "test2");
      Set<String> s2 = Set.of("test1");
      System.out.println("getElementsInCommon result :" + getElementsInCommon(s1, s2).toString());
      
      private static Set<?> getElementsInCommon(Set<?> s1, Set<?> s2) {
        Set<Object> result = new HashSet<>();
        for (Object o1 : s1) {
          if (s2.contains(o1)) {
            result.add(o1);
          }
        }
        return result;
      }
    ```
    1-7. Wild Card that is something child class.    
    ```
      List<Number> list2 = Arrays.asList(1L);
      System.out.println("The class type : " + getNum(list2).getClass());
    
      private static <E> E getNum(Iterable<? extends E> src) {
        for (E e : src) {
          return e;
        }
        return null;
      }
    ```
<br/>

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


package alibaba.java;

class ParentClass {
    public String name = "parent";
}

class SonClass extends ParentClass {
    public String name = "son";
}

public class Driver{
    public static void main(String[] args) {
        ParentClass parentClass = new SonClass();
        SonClass sonClass = new SonClass();
    
        System.out.println("parentClass.name = " + parentClass.name);
        System.out.println("sonClass.name = " + sonClass.name);
        System.out.println("debug...");
    }
}

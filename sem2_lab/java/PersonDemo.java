//Write a Java program to create a class called "Person" with a name and age attribute. 
// Create two instances of the "Person" class, set their attributes using the constructor, 
// and print their name and age.
class Person
{
    String name;
    int age;
    Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
}
public class PersonDemo
{
    public static void main(String[] args)
    {
        Person p1=new Person("Gouri",25);
        Person p2=new Person("nandhana",22);
        System.out.println(p1.name+" "+p1.age);
        System.out.println(p2.name+" "+p2.age);
        
    }
}

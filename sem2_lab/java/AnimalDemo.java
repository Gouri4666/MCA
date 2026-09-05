abstract  class Animal
{
    private String species;
    protected int age;
    protected float weight;
    String color;
    Animal()
    {
        species="";
        age=0;
        weight=0;
        color="";
    }
    Animal(String species,int age,float weight,String color)
    {
        this.species=species;
        this.age=age;
        this.weight=weight;
        this.color=color;
    }
    Animal(Animal other)
    {
        this.species=other.species;
        this.age=other.age;
        this.weight=other.weight;
        this.color=other.color;
    }
    abstract void display();
    String getspecies()
    {
        return species;
    }
}
class Dog extends Animal
{
    String breed;
    String bname;
    String owner;
    Dog(String species,int age,float weight,String color,String breed,String bname,String owner)
    {
        super(species,age,weight,color);
        this.breed=breed;
        this.bname=bname;
        this.owner=owner;
    }
    void display()
    {
        System.out.println("\nDog Details");
        System.out.println("Species :"+getspecies());
        System.out.println("Age :"+age);
        System.out.println("Weight :"+weight);
        System.out.println("Color :"+color);
        System.out.println("Breed :"+breed);
        System.out.println("Breed name :"+bname);
        System.out.println("Breed owner :"+owner);
    }
}
class Cat extends Animal
{
    String cname;
    String eyecolor;
    float  taillength;
    Cat(String species,int age,float weight,String color,String cname,String eyecolor,float  taillength)
    {
        super(species,age,weight,color);
        this.cname=cname;
        this.eyecolor=eyecolor;
        this.taillength=taillength;
    }
    void display()
    {
        System.out.println("\nCat Details");
        System.out.println("cat Name :"+cname);
        System.out.println("Eye color :"+eyecolor);
        System.out.println("Tail Length :"+taillength);

    }
}
public class AnimalDemo
{
    public static void main(String[] args) 
    {
        Animal a1=new Dog("mammal",2,52,"Black","Lab","Tobbby","Jose");
        a1.display();
        Animal a2=new Cat("mammal",3,15,"White","Miz","Green",12);
        a2.display();
        
    }
}

//----output----------
// Dog Details
// Species :mammal
// Age :2
// Weight :52.0
// Color :Black
// Breed :Lab
// Breed name :Tobbby
// Breed owner :Jose

// Cat Details
// cat Name :Miz
// Eye color :Green
// Tail Length :12.0

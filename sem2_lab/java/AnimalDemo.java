class Animal
{
    private String species;
    protected int age;
    protected int weight;
    String color;
    Animal()
    {
        species="";
        age=0;
        weight=0;
        color="";
    }
    Animal(String species,int age,int weight,String color)
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
    void display()
    {  
    }
    String getSpecies()
    {
        return species;
    }
}
class Dog extends Animal
{
    String breed;
    String name;
    String owner;
    Dog(String species,int age,int weight,String color,String breed,String name,String owner)
    {
        super(species,age,weight,color);
        this.breed=breed;
        this.name=name;
        this.owner=owner;
    }
    void display()
    {
        System.out.println("Dog Details");
        System.out.println("Species: "+getSpecies());
        System.out.println("Age: "+age);
        System.out.println("Weight: "+weight);
        System.out.println("Color: "+color);
        System.out.println("Name: "+name);
        System.out.println("Breed: "+breed);
        System.out.println("Owner: "+owner);
        
    }
}
class Cat extends Animal
{
    String name;
    String eyeColor;
    int tailLength;
    Cat(String species,int age,int weight,String color,String name,String eyeColor,int tailLength)
    {
        super(species,age,weight,color);
        this.name=name;
        this.eyeColor=eyeColor;
        this.tailLength=tailLength;
    }
    void display()
    {
        super.display();
        System.out.println("\nCat Details");
        System.out.println("Cat Name: "+name);
        System.out.println("Cat Eye Color: "+eyeColor); 
        System.out.println("Cat Tail Length: "+tailLength);
    }
}
class AnimalDemo
{
    public static void main(String[] args)
    {
        //dynamic method dispatch
        Animal a;
        a=new Dog("mammal",2,6,"Brown","Pomeranian","Tobby","Hari");
        a.display();
        a=new Cat("Mammal",2,5,"Orange","Snowbell","Green",15);
        a.display();
    }
}

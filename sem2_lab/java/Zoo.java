class Zoo
{
    String zname;
    String [] regions;
    Zoo(String zname,String [] regions)
    {
        this.zname=zname;
        this.regions=regions;
    }
    void display()
    {
        System.out.println("Zoo Name: "+zname);
        System.out.print("Regions: ");
        for(int i=0;i<regions.length;i++)
        {
            System.out.print(regions[i]+" ");
        }
    }
    class Enclosure
    {
        String name;
        String type;
        String[] animals;
        Enclosure( String name,String type,String[] animals)
        {
            this.name=name;
            this.type=type;
            this.animals=animals;
        }
        void display()
        {
            System.out.println("Enclosure Name: "+name);
            System.out.println("Enclosure Type: "+type);
            System.out.print("Animals: ");
            for(int i=0;i<animals.length;i++)
            {
                System.out.print(animals[i]+" ");
            }
        }
    }
    static class Contact
    {
        String address;
        String phone;
        Contact(String address,String phone)
        {
            this.address=address;
            this.phone=phone;
        }
        void display()
        {
            System.out.println("Address: "+address);
            System.out.println("Phone: "+phone);
        }
    }
}
class ZooDemo
{
    public static void main(String[] args) 
    {
        String [] regions={"TVM","Kochi","Goa"};
        Zoo z=new Zoo("City Zoo",regions);
        z.display();
        String[] animals={"Tiger","Lion"};
        Zoo.Enclosure e=z.new Enclosure("Grassland","Outdoor",animals);
        e.display();
        Zoo.Contact c=new Zoo.Contact("Mumbai","9655874512");
        c.display();
    }
}

// Zoo Name: City Zoo
// Regions: TVM Kochi Goa Enclosure Name: Grassland
// Enclosure Type: Outdoor
// Animals: Tiger Lion Address: Mumbai
// Phone: 9655874512

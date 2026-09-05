class CPU
{
    int price;
    CPU(int price)
    {
        this.price=price;
    }
    void display()
    {
        System.out.println("CPU price: "+price);
    }
    class Processor
    {
        int n;
        String Pmanufacture;
        Processor(int n,String Pmanufacture)
        {
            this.n=n;
            this.Pmanufacture=Pmanufacture;
        }
        void display()
        {
            System.out.println("Processor core: intel "+n);
            System.out.println("Processor manufacture: "+Pmanufacture);
        }
    }
    static class RAM
    {
        int memory;
        String RAMmanufacture;
        RAM(int memory,String RAMmanufacture)
        {
            this.memory=memory;
            this.RAMmanufacture=RAMmanufacture;
        }
        void display()
        {
            System.out.println("RAM memory: "+memory);
            System.out.println("RAM manufacture: "+RAMmanufacture);
        }
    }
}
class CPUDemo
{
    public static void main(String[] args)
    {
        CPU cpu=new CPU(50000);
        cpu.display();
        CPU.Processor p=cpu.new Processor(5, "HP"); 
        p.display();
        CPU.RAM r=new CPU.RAM(512,"HP");
        r.display();
    }
}

// CPU price: 50000
// Processor core: intel 5
// Processor manufacture: HP
// RAM memory: 512
// RAM manufacture: HP

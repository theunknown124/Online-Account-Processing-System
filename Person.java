
public class Person
{
    private String name;
    
    public Person( )
    {
        name = "No name yet";
    }
    
    public Person(String initialName)
    {
        name = initialName;
    }
    
    public Person(int num)
    {
    	name = " ";
        name = name+num;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void writeOutput( )
    {
        System.out.println("Name: " + name);
    }
   
    public boolean hasSameName(Person otherPerson)
    {
    	//if (this.name == otherPerson.name)
        return this.name.equalsIgnoreCase(otherPerson.name);
    }
}

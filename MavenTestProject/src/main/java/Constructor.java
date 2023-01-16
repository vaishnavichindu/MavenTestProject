
public class Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Constructor c=new Constructor("Anu","Maths",24);
		System.out.println("Student1 details");
		c.display2();

	}
	String name;
	String dept;
	int age;
	static String collge="TKM";
	
	Constructor(String name,String dept,int age)
	{
		this.name=name;
		this.dept=dept;
		this.age=age;
	}
	public void display2()
	{
		this.display();
	}
	public void display()
	{
		System.out.println(name);
		System.out.println(dept);
		System.out.println(age);
		System.out.println(collge);
	}


}

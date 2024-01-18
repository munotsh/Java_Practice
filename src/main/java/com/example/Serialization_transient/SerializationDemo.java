package com.example.Serialization_transient;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationDemo
{

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException
	{
		SerializationDemo serializationDemo = new SerializationDemo();
		serializationDemo.writeEmployeeObject();
	}

	private void writeEmployeeObject() throws FileNotFoundException,
			IOException
	{
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try
		{
			fileOutputStream = new FileOutputStream("employee.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			Employee employee = new Employee(101, "Peter", 32);
			System.out.println("Id  = " + employee.getId());
			System.out.println("Name = " + employee.getName());
			System.out.println("Age = " + employee.getAge());
			objectOutputStream.writeObject(employee);
			System.out
					.println("Successfully written employee object to the file.\n");
		}
		finally
		{

			if (objectOutputStream != null)
			{
				objectOutputStream.close();
			}
		}

	}

}

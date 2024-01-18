package com.example.Serialization_transient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializationDemo
{
	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException
	{
		DeSerializationDemo deSerializationDemo = new DeSerializationDemo();
		deSerializationDemo.readEmployeeObject();
	}

	private void readEmployeeObject() throws IOException,
			FileNotFoundException, ClassNotFoundException
	{
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try
		{
			fileInputStream = new FileInputStream("employee.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			Employee employee = (Employee) objectInputStream.readObject();
			System.out.println("Successfully read employee object from the file.");
			System.out.println("Id  = " + employee.getId());
			System.out.println("Name = " + employee.getName());
			System.out.println("Age = " + employee.getAge());
		}
		finally
		{

			if (objectInputStream != null)
			{
				objectInputStream.close();
			}
		}

	}

}

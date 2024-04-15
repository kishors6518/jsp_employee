 package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCrud {
	public Connection getConnection()throws Exception
	{
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/jspdb";
		String user="root";
		String pass="root";
		
		Class.forName(className);
		Connection connection=DriverManager.getConnection(url, user, pass);
		return connection;
	}
	public int singUp(Employee employee)throws Exception
	{
		Connection connection=getConnection();
		String sql="INSERT INTO EMPLOYEE(ID,NAME,PHONE,EMAIL,PASSWORD,DESIGNATION,SALARY) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,employee.getId());
		preparedStatement.setString(2,employee .getName());
		preparedStatement.setLong(3,employee .getPhone());
		preparedStatement.setString(4,employee.getEmail());
		preparedStatement.setString(5,employee.getPass());
		preparedStatement.setString(6,employee.getDesignation());
		preparedStatement.setDouble(7, employee.getSalary());
		
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	} 
	public String getPassword(String email)throws Exception
	{
		Connection  connection=getConnection();
		String pass="SELECT PASSWORD FROM EMPLOYEE WHERE EMAIL=?";
		PreparedStatement preparedStatement=connection.prepareStatement(pass);
		preparedStatement.setString(1, email);
		ResultSet set=preparedStatement.executeQuery();
		String password=null;
		while (set.next()) {
			password=set.getString("password");
		}
		connection.close();
		return password;		
	}
	public List<Employee> getEmployee() throws Exception
	{
		Connection connection=getConnection();
		String all="SELECT * FROM EMPLOYEE";
		PreparedStatement preparedStatement=connection.prepareStatement(all);
		ResultSet set=preparedStatement.executeQuery();
		List<Employee> list=new ArrayList<Employee>();
		while(set.next())
		{
			Employee employee=new Employee();
			employee.setId(set.getInt("id"));
			employee.setName(set.getString("name"));
			employee.setPhone(set.getLong("phone"));
			employee.setEmail(set.getString("email"));
			employee.setPass(set.getString("password"));
			employee.setDesignation(set.getString("designation"));
			employee.setSalary(set.getDouble("salary"));
			
			list.add(employee);
		}
		connection.close();
		return list;
	}
	public int doDelete(int id) throws Exception {
		Connection connection=getConnection();
		String delete="DELETE FROM EMPLOYEE WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(delete);
		preparedStatement.setInt(1, id);
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	}
	public Employee employeeDetail(int id) throws Exception
	{
		Connection connection=getConnection();
		String select="SELECT * FROM EMPLOYEE WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(select);
		preparedStatement.setInt(1, id);
		ResultSet set=preparedStatement.executeQuery();
		Employee employee=new Employee();
		while(set.next())
		{
			employee.setId(set.getInt("id"));
			employee.setName(set.getString("name"));
			employee.setPhone(set.getLong("phone"));
			employee.setEmail(set.getString("email"));
			employee.setPass(set.getString("password"));
			employee.setDesignation(set.getString("designation"));
			employee.setSalary(set.getDouble("salary"));	
		}
		connection.close();
		return employee;
	}
	public int doUpdate(Employee employee) throws Exception
	{
		Connection connection=getConnection();
		String update="UPDATE EMPLOYEE SET NAME=?, PHONE=?, EMAIL=?, PASSWORD=?, DESIGNATION=?, SALARY=? WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(update);
		preparedStatement.setString(1,employee .getName());
		preparedStatement.setLong(2,employee .getPhone());
		preparedStatement.setString(3,employee.getEmail());
		preparedStatement.setString(4,employee.getPass());
		preparedStatement.setString(5,employee.getDesignation());
		preparedStatement.setDouble(6, employee.getSalary());
		preparedStatement.setInt(7,employee.getId());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
	}
}

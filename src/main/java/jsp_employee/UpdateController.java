package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		EmployeeCrud crud=new EmployeeCrud();
		try {
			Employee employee = crud.employeeDetail(id);
			if(employee!=null)
			{
				req.setAttribute("emp", employee);
				req.getRequestDispatcher("update.jsp").forward(req, resp);
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		String desig=req.getParameter("desig");
		double sal=Double.parseDouble(req.getParameter("salary"));
		
		Employee employee=new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setPhone(phone);
		employee.setEmail(email);
		employee.setPass(password);
		employee.setDesignation(desig);
		employee.setSalary(sal);
		
		EmployeeCrud crud=new EmployeeCrud();
		try {
			int result=crud.doUpdate(employee);
			if(result!=0)
			{
				req.setAttribute("list", crud.getEmployee());
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

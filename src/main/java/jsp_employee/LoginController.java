package jsp_employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		EmployeeCrud crud=new EmployeeCrud();
		try {
			String dbpass=crud.getPassword(email);
			if(dbpass!=null)
			{
				if(dbpass.equals(pass))
				{
					req.setAttribute("list", crud.getEmployee());
					RequestDispatcher dispatcher=req.getRequestDispatcher("success.jsp");
					dispatcher.include(req, resp);
		
				}
				else
				{
					req.setAttribute("message", "Please enter valid credentials");
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
					dispatcher.include(req, resp);
				}
				
			}
			else
			{
				req.setAttribute("message", "You are not registered!!! Please Register");
				resp.sendRedirect("signup.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

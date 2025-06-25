package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/call")
@SuppressWarnings("serial")

public class ChoiceType  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		
		String type = req.getParameter("type");
		if(type.equals("Palindrome"))
		{
		RequestDispatcher rdPal = req.getRequestDispatcher("palindrome");
		rdPal.forward(req, res);
			
		}else if(type.equals("Perfect"))
		{
			req.getRequestDispatcher("perfect").forward(req, res);
		}
		else if(type.equals("Armstrong"))
		{
			req.getRequestDispatcher("armstrong").forward(req, res);
		}else if(type.equals("Prime")){
			
			RequestDispatcher rdPrime = req.getRequestDispatcher("prime");
			rdPrime.forward(req, res);
		}
	}

}

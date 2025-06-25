package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/prime")
@SuppressWarnings("serial")

public class Prime extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		try {
		   int num = Integer.parseInt(req.getParameter("num"));
		   boolean prime = isPrime(num);
		   if(prime==true)
		   {
			writer.println("\t  "+num+" \t is prime Number");
		   }else {
			writer.println(" \t "+num+" \t is not prime number");
		    } 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		req.getRequestDispatcher("NumFile.html").include(req, res);
		
	}
	
	public boolean isPrime(int num)
	{
		if(num<=1)
		{
			return false;
		}
		for(int i=2;i<=num/2;i++)
		{
			if(num%i==0)
			{
				return false;
			}
		}
		return true;
		
	}

}

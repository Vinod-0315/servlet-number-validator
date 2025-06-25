package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/perfect")
@SuppressWarnings("serial")

public class perfectNum extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		try {
		         int num = Integer.parseInt(req.getParameter("num"));
		         if(isPerfect(num)) {
		        	 writer.println(num+"is perfect Number");
		         }else {
		        	 writer.println(num+"is not perfect!!!");
		         }
		         
		    } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		req.getRequestDispatcher("NumFile.html").include(req, res);
		
	}
	
	public boolean isPerfect(int num)
	{
		int sum=0;
		int k=num;
		for(int i=1;i<num;i++)
		{
			if(num%i==0)
			{
				sum+=i;
			}
		}
		return k==sum;
		
	}

}

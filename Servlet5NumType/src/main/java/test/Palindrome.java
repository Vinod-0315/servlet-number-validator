package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/palindrome")
@SuppressWarnings("serial")

public class Palindrome extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		try {
		         int num = Integer.parseInt(req.getParameter("num"));
		         if(isPalindrome(num)) {
		        	 writer.println(num+"is palindrome");
		         }else {
		        	 writer.println(num+"is not palindrome!!!");
		         }
		         
		    } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		req.getRequestDispatcher("NumFile.html").include(req, res);
		
	}
	
	public boolean isPalindrome(int num)
	{
		
		int rev=0;
		int k=num;
		while(num!=0) {
			
			int digit=num%10;
			rev=rev*10+digit;
			num/=10;
		}
			
		return rev==k;	
		
			
			
		
	}

}

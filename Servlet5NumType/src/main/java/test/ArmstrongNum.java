package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@WebServlet("/armstrong")
@SuppressWarnings("serial")

public class ArmstrongNum extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		try {
		         int num = Integer.parseInt(req.getParameter("num"));
		         boolean armStrong = isArmStrong(num);
		         if(armStrong==true)
		         {
		        	 writer.println(num+"  \t  is ArmStrong Nuumber");
		         }else {
		        	 writer.println(num+"\t  is not ArmStrong Number");
		         }
		         
		    } 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		req.getRequestDispatcher("NumFile.html").include(req, res);
		
	}
	
	public boolean isArmStrong(int num)
	{
		int power=0;
		int k=num; int m=num;
		int sum=0;
		while(num!=0)
		{
			power++;
			num/=10;
		}
		
		while(k!=0)
		{
			int digit=k%10;
			sum=sum+(int)Math.pow(digit, power);
			k=k/10;
			
		}
		
		if(sum==m) {
			return true;
		}else {
			return false;
		}
			
			
		
	}

}

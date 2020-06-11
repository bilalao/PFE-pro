package ma.pfe.projet.test;

 
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.pfe.projet.dao.DaoClient;
import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Client;
 
@WebServlet("/Servlet_Reg")
public class Servlet_Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		if(  username.isEmpty() || 
				password.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() )
		{
			RequestDispatcher req = request.getRequestDispatcher("/Register_1.jsp");
			req.include(request, response);
		}
		else
		{
			/* RequestDispatcher req = request.getRequestDispatcher("/Register_2.jsp");
			req.forward(request, response); */
			
			 Client user = new Client();
		      	user.setAddress(address);
		        user.setPassword(password);
		        user.setEmail(email);
		        user.setPhone(phone);
		        user.setName(username);
		        
		        IDAO<Client> dao = new DaoClient();
		    	dao.save(user);
		        
			
			getServletContext().getRequestDispatcher("/Register_2.jsp").forward(request, response);
		}
		
		
		
		
	}
 
}
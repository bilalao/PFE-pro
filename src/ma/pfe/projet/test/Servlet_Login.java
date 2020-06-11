package ma.pfe.projet.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.pfe.projet.dao.DaoClient;
import ma.pfe.projet.dao.IDAO;
import ma.pfe.projet.entity.Client;

@WebServlet("/Servlet_Login")
public class Servlet_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IDAO<Client> dao = new DaoClient();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("email");
		String password = request.getParameter("password");
		if (dao.validate(username, password)) {

			getServletContext().getRequestDispatcher("/Login_2.jsp").forward(request, response);

		} else {
			//request.setAttribute("not success", dao.validate(username, password));
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}

	}

}

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaMail.SimpleTextEmail;

/**
 * Servlet implementation class handingRegister
 */
@WebServlet("/handingRegister")
public class handingRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public handingRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		boolean error = false;
		
		

		// notice error username
		String user = request.getParameter("username");
		String user_err = "";
		if (user == null || user.equals("")) {
			user_err = "* Username is not null !";
			error = true;
			request.setAttribute("user_err", user_err);
		}

		// notice error email
		String email = request.getParameter("email");
		String email_err = "";
		if (email == null || email.equals("")) {
			email_err = "* Email is not null !";
			error = true;
			request.setAttribute("email_err", email_err);
		}
		// notice error password
		String pass = request.getParameter("password");
		String pass2 = request.getParameter("password2");
		String pass_err1 = "";
		if (!pass.equals(pass2)) {
			pass_err1 = "* Password not match!";
			error = true;
			request.setAttribute("pass_err1", pass_err1);
		}
		if (error) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/signup.jsp");
			rd.forward(request, response);
		} else {
			String sub = "Finish";
			String text = "Chúc mừng bạn đã đăng ký thành công \n Tài khoản của bạn là:" + user;
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Finish.jsp");
			SimpleTextEmail.sendMail(email, sub, text);
			dispatcher.forward(request, response);
		}
	}

}

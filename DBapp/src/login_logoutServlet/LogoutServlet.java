package login_logoutServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    public LogoutServlet() { super(); }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//セッションをfalseで取得.
    	HttpSession session = request.getSession(false);

    	//セッション破棄.
    	session.invalidate();

    	//フォワード.
    	RequestDispatcher rd = request.getRequestDispatcher("/login_logout/logout.jsp");
    	rd.forward(request, response);

    }

}

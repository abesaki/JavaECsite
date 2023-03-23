package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns= {"/Menu/*","/News/*","/Product/*","/Shopping/*","/Users/*"})
public class LoginCheckFilter extends HttpFilter implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//別名保存.
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpSession session = request2.getSession(true);

		//検証：セッション登録（ID）.
		if(session.getAttribute("userId") == null) {

			//フォワード（新規登録画面へ）.
			RequestDispatcher rd = request2.getRequestDispatcher("/Error/secret.jsp");
			rd.forward(request, response);

		} else {

			//フィルター終了.
			chain.doFilter(request, response);

		}

	}

	@Override
	public void destroy() {
	}

}
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	//initメソッド：開始時に1度だけ呼び出される.
	@Override
	public void init(FilterConfig fConfig) throws ServletException {}

	//doFilterメソッド：フィルター適用時に毎回呼び出される.
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//パラメータ：文字コード設定.
		request.setCharacterEncoding("UTF-8");

		//表示：文字コード設定.
		response.setContentType("text/html;charset=UTF-8");

		//次のフィルターを呼び出す.最後の場合はリクエスト元を呼び出す.
		//フィルターが1つの場合でもChainのdoFilterを呼び出す必要がある.
		chain.doFilter(request, response);

	}

	//destroyメソッド：終了時に1度だけ呼び出される.
	@Override
	public void destroy() {}

}

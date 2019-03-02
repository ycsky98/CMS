package cn.yc.cms.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 授权拦截
 * */
public class AuthorizationInterceptors implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getServletPath();
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>)request.getSession().getAttribute("admin");
		
		//获取权限
		String[] uriArr = String.valueOf(map.get("pcontroller")).replace("[", "").replace("]", "").split(",");
		for (int i = 0; i < uriArr.length; i++) {
			if (uriArr[i].equals(uri)) {
				return true;
			}
			
			if (uriArr[i].replace(uriArr[i].substring(uriArr[i].lastIndexOf("/")), "").
					equals(uri.replace(uri.substring(uri.lastIndexOf("/")),""))) {
				return true;
			}
		}
		response.sendRedirect("/index");
		
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

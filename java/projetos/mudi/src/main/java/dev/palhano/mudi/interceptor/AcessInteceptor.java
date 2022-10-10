package dev.palhano.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * Read Sprng Boot Actuator
 * */
public class AcessInteceptor extends HandlerInterceptorAdapter {
	private static List<Acess> listAcess = new ArrayList<>() ;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Acess acess = new Acess();
		acess.path = request.getRequestURI();
		acess.dateTime = LocalDateTime.now();
		
		request.setAttribute("acessStatic", acess);
		
//		return super.preHandle(request, response, handler);
		return true;
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		Acess acess = (Acess) request.getAttribute("acessStatic");
		acess.duration = Duration.between(acess.dateTime, LocalDateTime.now());
		listAcess.add(acess);
		System.out.println(acess);
	}
	
	public static List<Acess> getAcesss() {
		return listAcess;
	}
		
	
}

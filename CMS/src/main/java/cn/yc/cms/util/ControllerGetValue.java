package cn.yc.cms.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.yc.cms.Controller.ViewController.IndexController;

public class ControllerGetValue{
	/**
	 * 获取控制器所有请求路径
	 * */
	public List<String> getValues(Class<?> class1) {
		List<String> uri = new LinkedList<String>();
		String RootUri = getParentControllerValues(class1);//获取根节点
		
		Method[] methods = class1.getDeclaredMethods();//获取类下所有的方法
		String[] acc = null;
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].isAnnotationPresent(RequestMapping.class)) {
				acc = methods[i].getAnnotation(RequestMapping.class).value();
				if(acc.length!=0) {
					//根节点加子节点等于当前路径
					uri.add(RootUri+acc[0]);
				}
			}
		}
		return uri;
	}
	
	/**
	 * 获取控制器类顶级注解
	 * @param class1 控制器
	 * @author yangcong
	 * */
	public String getParentControllerValues(Class<?> class1) {
		RequestMapping mapping = class1.getAnnotation(RequestMapping.class);
		if (mapping==null) {
			return "";
		}
		if (mapping.value().length==0) {//注解value数组为0说明没有值
			return "";
		}
		return Arrays.toString(mapping.value()).replace("[", "").replace("]", "");
	}
	
	public static void main(String[] args) {
		ControllerGetValue value = new ControllerGetValue();
		List<String> list = value.getValues(IndexController.class);
		System.out.println(list);
	}
}

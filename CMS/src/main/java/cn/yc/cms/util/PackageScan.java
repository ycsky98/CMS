package cn.yc.cms.util;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PackageScan {

	private List<String> classpath = Collections.synchronizedList(new LinkedList<String>());

	/**
	 * 获取类加载器
	 * */
	public ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}
	
	/**
	 * 类加载器
	 * */
	public static Class<?> loaderClass(String classname,boolean isInitialized,ClassLoader loader){
		Class<?> cls = null;
		try {
			cls = Class.forName(classname,isInitialized,loader);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException("Class Not Find");
		}
		return cls;
	}
	
	/**
	 * 包扫描
	 * */
	public List<String> getClassesName(String path){
		path = path.replace(".", "/");
		File file = new File(path);
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					getClassesName(files[i].getPath());
				}else {
					this.classpath.add(files[i].getPath().replace("src\\main\\java\\", "")
							.replace("\\", ".").replace(".java", ""));
				}
			}
		}
		return this.classpath;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		PackageScan scan = new PackageScan();
		System.out.println(scan.getClassesName("src.main.java.cn.yc.cms"));
	}
}

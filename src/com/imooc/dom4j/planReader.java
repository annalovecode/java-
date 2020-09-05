package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class planReader {
    public void readXml1() {
    	String file="D:/Program Files (x86)/workspace/javaWeb/src/plan.xml";
    	SAXReader reader=new SAXReader();
    	//SAXReader类是读取xml文件的核心类，用于将xml解析后以“树”的形式保存在内存里
		try {
			Document document = reader.read(file);
			Element root=document.getRootElement();
			//获取xml文档的根节点，即hr标签
			//获取所有的course标签
			List<Element> courses=root.elements("course");
			for(Element course:courses)
			 {
				  Element name=course.element("name");
			      String courseName=name.getText();
			      //getText()方法用于获取标签文本
			      System.out.println(courseName);
			      System.out.println(course.elementText("course-hour"));
			      System.out.println(course.elementText("exam-form"));
			      Attribute att=course.attribute("no");
			      System.out.println(att.getText());
			  }  
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
	

}

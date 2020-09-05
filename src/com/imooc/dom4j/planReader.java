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
    	//SAXReader���Ƕ�ȡxml�ļ��ĺ����࣬���ڽ�xml�������ԡ���������ʽ�������ڴ���
		try {
			Document document = reader.read(file);
			Element root=document.getRootElement();
			//��ȡxml�ĵ��ĸ��ڵ㣬��hr��ǩ
			//��ȡ���е�course��ǩ
			List<Element> courses=root.elements("course");
			for(Element course:courses)
			 {
				  Element name=course.element("name");
			      String courseName=name.getText();
			      //getText()�������ڻ�ȡ��ǩ�ı�
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

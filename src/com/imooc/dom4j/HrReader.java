package com.imooc.dom4j;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
//����dom4j���ļ����н������ؼ�����xmlΪdocument�Ķ�������dom4j����xml
public class HrReader {
  public void readXml() {
	  String file="D:/Program Files (x86)/workspace/javaWeb/src/hr.xml";
	  SAXReader reader=new SAXReader();
	  //SAXReader�������ڶ�ȡxml�ļ��ĺ����࣬���ڽ�xml�ļ������Ժ���������ʽ�������ڴ�
	  try {
		  Document document=reader.read(file);
		  //��ȡxml�ĵ��ĸ��ڵ㣬��hr��ǩ
		  Element root=document.getRootElement();
		  //��ȡ���е�employee��ǩ
		  List<Element>employees=root.elements("employee");
		  for(Element employee:employees)
			  //element �������ڻ�ȡΨһ���ӽڵ�
		  {
			  Element name=employee.element("name");
		      String empName=name.getText();
		      //getText()�������ڻ�ȡ��ǩ�ı�
		      System.out.println(empName);
		      System.out.println(employee.elementText("age"));
		      Element department=employee.element("department");
		      System.out.println(department.element("dname").getText());
		      Attribute att=employee.attribute("no");
		      System.out.println(att.getText());
		  }  
	  
	  }
	  catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	  
	  
	  
  }
}

package com.imooc.dom4j;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
//利用dom4j对文件进行解析：关键对象：xml为document的对象，利用dom4j遍历xml
public class HrReader {
  public void readXml() {
	  String file="D:/Program Files (x86)/workspace/javaWeb/src/hr.xml";
	  SAXReader reader=new SAXReader();
	  //SAXReader类是用于读取xml文件的核心类，用于将xml文件解析以后以树的形式保存在内存
	  try {
		  Document document=reader.read(file);
		  //获取xml文档的根节点，即hr标签
		  Element root=document.getRootElement();
		  //获取所有的employee标签
		  List<Element>employees=root.elements("employee");
		  for(Element employee:employees)
			  //element 方法用于获取唯一的子节点
		  {
			  Element name=employee.element("name");
		      String empName=name.getText();
		      //getText()方法用于获取标签文本
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

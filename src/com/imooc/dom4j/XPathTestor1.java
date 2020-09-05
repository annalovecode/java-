package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
* XPath对存储课程信息的plan.xml文档
 * 进行查询并将结果输出，要求如下：
 * 获取所有课程信息
 * 查询课时小于50的课程信息
 * 查询课程名为高等数学的课程信息
 * 查询属性id为001的课程信息
 * 查询前两条课程信息
 * @author Anna
 * @date 2020/9/5
 */
public class XPathTestor1 {

	public void xpath(String xpathExp) {
		// TODO Auto-generated method stub
		String file="D:/Program Files (x86)/workspace/javaWeb/src/plan.xml";
		SAXReader reader=new SAXReader();
		try {
			Document document =reader.read(file);
		    List<Node> nodes=document.selectNodes(xpathExp);
		    for(Node node:nodes)
		    {
		    	Element course =(Element)node;
		    	System.out.println(course.attributeValue("id"));
		    	System.out.println(course.elementText("course-name"));
		    	System.out.println(course.elementText("course-hour"));
		    	System.out.println(course.elementText("exam-form"));
		    	System.out.println("==========================");
		    }
		    
		}
		catch (DocumentException e){
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		XPathTestor1 testor=new XPathTestor1();
		//获取所有课程的节点
		testor.xpath("//course");
		//查询课时小于50的课程信息
		testor.xpath("//course[course-hour<50]");
//		查询课程名为高等数学的课程信息
		testor.xpath("//course[course-name='高等数学']");
//		查询属性id为001的课程信息
		testor.xpath("//course[id='001']");
//		查询前两条课程信息
		testor.xpath("//course[1]|//course[2]");
	}

}

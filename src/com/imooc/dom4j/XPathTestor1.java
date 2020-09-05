package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
* XPath�Դ洢�γ���Ϣ��plan.xml�ĵ�
 * ���в�ѯ������������Ҫ�����£�
 * ��ȡ���пγ���Ϣ
 * ��ѯ��ʱС��50�Ŀγ���Ϣ
 * ��ѯ�γ���Ϊ�ߵ���ѧ�Ŀγ���Ϣ
 * ��ѯ����idΪ001�Ŀγ���Ϣ
 * ��ѯǰ�����γ���Ϣ
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
		//��ȡ���пγ̵Ľڵ�
		testor.xpath("//course");
		//��ѯ��ʱС��50�Ŀγ���Ϣ
		testor.xpath("//course[course-hour<50]");
//		��ѯ�γ���Ϊ�ߵ���ѧ�Ŀγ���Ϣ
		testor.xpath("//course[course-name='�ߵ���ѧ']");
//		��ѯ����idΪ001�Ŀγ���Ϣ
		testor.xpath("//course[id='001']");
//		��ѯǰ�����γ���Ϣ
		testor.xpath("//course[1]|//course[2]");
	}

}

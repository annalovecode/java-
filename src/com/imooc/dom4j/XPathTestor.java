package com.imooc.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XPathTestor {
    public void xpath(String xpathExp) {
    	String file="D:/Program Files (x86)/workspace/javaWeb/src/hr.xml";
    	SAXReader reader=new SAXReader();
    	Document document;
		try {
			document = reader.read(file);
			List<Node> nodes=document.selectNodes(xpathExp);
			for(Node node:nodes)
			{
				Element emp=(Element)node;
				System.out.println(emp.attributeValue("no"));
				System.out.println(emp.elementText("name"));
				System.out.println(emp.elementText("age"));
				System.out.println(emp.elementText("salary"));
				System.out.println("====================");
				
				
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
    }
    public static void main(String[] args)
    {
    	XPathTestor testor=new XPathTestor();
    	//�Ӹ��ڵ㿪ʼ
    	//testor.xpath("/hr/employee");
    	//��ȡ���е�Ա���ڵ�
    	//testor.xpath("//employee");
    	//ͳ�����й���С��4000��Ա��
    	//testor.xpath("//employee[salary<4000]");
    	//��ѯĳһ���˵�
    	//testor.xpath("//employee[name='������']");
    	//ͨ�����Խ���ɸѡ
    	//testor.xpath("//employee[@no=3304]");
    	//����λ�û�ȡ��Ϣ
    	testor.xpath("//employee[1]");
    	testor.xpath("//employee[last()]");
    	//���շ�Χɸѡ
    	testor.xpath("//employee[position()<6]");
    	//ɸѡ�������͵ڰ���Ա��
    	testor.xpath("//employee[3]|//employee[8]");
    	
    }
}

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
    	//从根节点开始
    	//testor.xpath("/hr/employee");
    	//获取所有的员工节点
    	//testor.xpath("//employee");
    	//统计所有工资小于4000的员工
    	//testor.xpath("//employee[salary<4000]");
    	//查询某一个人的
    	//testor.xpath("//employee[name='李铁柱']");
    	//通过属性进行筛选
    	//testor.xpath("//employee[@no=3304]");
    	//按照位置获取信息
    	testor.xpath("//employee[1]");
    	testor.xpath("//employee[last()]");
    	//按照范围筛选
    	testor.xpath("//employee[position()<6]");
    	//筛选第三名和第八名员工
    	testor.xpath("//employee[3]|//employee[8]");
    	
    }
}

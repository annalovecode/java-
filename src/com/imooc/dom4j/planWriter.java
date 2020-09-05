package com.imooc.dom4j;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 为plan.xml文件添加一条新的课程信息
 * 遍历plan.xml文件并将节点和属性等内容输出(planReader)
 *  @author Anna
 *  @date 2020/9/5
 *
 */
public class planWriter {
    public void writeXml() {
    	String file="D:/Program Files (x86)/workspace/javaWeb/src/plan.xml";
    	SAXReader reader=new SAXReader();
    	Document document;
		try {
			document = reader.read(file);
			Element root=document.getRootElement();
	    	Element course=root.addElement("course");
	    	course.addAttribute("id", "c0001");
	    	Element name=course.addElement("course-name");
	    	name.setText("c语言程序基础");
	    	course.addElement("course-hour").setText("36");
	    	course.addElement("exam-form").setText("上机考试");
	    	Writer writer=new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
	    	document.write(writer);
	    	writer.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        planWriter planWriter= new planWriter();
        planWriter.writeXml();
	}

}

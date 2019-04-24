package javaBean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JavaBeanCreat {

	public static void main(String[] args) {
		String srcPath = "D:\\文档\\新建文本文档.txt";
		String creatPath = "D:\\文档\\bean.txt";
		try {
			File srcFile = new File(srcPath);
			if (!srcFile.exists()) {
				return;
			}
			
			File creatFile = new File(creatPath);
			if (!creatFile.exists()) {
				creatFile.createNewFile();
			}
		    InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "UTF-8");
		    BufferedReader reader = new BufferedReader(isr);
		    reader.mark((int)srcFile.length() + 1);
		    
		    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(creatPath), "UTF-8");
		    BufferedWriter writer = new BufferedWriter(osw);
			 String tempString = null;
			 
			 String line = System.getProperty("line.separator");
			 
			 // 一次读入一行，直到读入null为文件结束
			 while ((tempString = reader.readLine()) != null) {
				 String[] str = tempString.split(",");
				 writer.write("/**");
				 writer.write(line);
				 writer.write(" * " + str[2]);
				 writer.write(line);
				 writer.write(" */");
				 writer.write(line);
				 writer.write("private " + str[1] + " " + str[0] + ";" + line + line);
			 }
			 
			 reader.reset();
			 while ((tempString = reader.readLine()) != null) {
				 String[] str = tempString.split(",");
				 writer.write("/**");
				 writer.write(line);
				 writer.write(" * 返回" + str[2]);
				 writer.write(line);
				 writer.write(" * @return " + str[0] + " " + str[2] + line);
				 writer.write(" */");
				 writer.write(line);
				 writer.write("public " + str[1] + " "
					 + "get" + str[0].substring(0, 1).toUpperCase()
					 + str[0].substring(1) + "()" + " {" + line);
				 writer.write("    return " + str[0] + ";" + line);
				 writer.write("}" + line + line);
				 
				 // set
				 writer.write("/**");
				 writer.write(line);
				 writer.write(" * 设置" + str[2]);
				 writer.write(line);
				 writer.write(" * @param " + str[0] + " " + str[2] + line);
				 writer.write(" */");
				 writer.write(line);
				 writer.write("public void " + " "
						 + "set" + str[0].substring(0, 1).toUpperCase()
						 + str[0].substring(1) + "(" + str[1] + " " + str[0] + ")" + " {" + line);
				 writer.write("    this." + str[0] + " = " + str[0] + ";" + line);
				 writer.write("}" + line + line);
				 
				 
			 }
			 writer.close();
			 reader.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}

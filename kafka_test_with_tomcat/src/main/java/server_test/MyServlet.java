package server_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class MyServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException,IOException{
		response.setContentType("text/html"); 
		request.setCharacterEncoding("utf8"); 
		response.setCharacterEncoding("utf8");
		PrintWriter out = response.getWriter();
		FileReader file = new FileReader("C:\\Users\\Sieun\\eclipse-workspace\\kafka_test_with_tomcat\\src\\main\\webapp/index.jsp");
		BufferedReader br = new BufferedReader(file);
		String str;
		for(int i=0;i<10;i++){
			out.write(br.readLine());
		}
		BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Sieun\\eclipse-workspace\\kafka_test_with_tomcat\\src\\main\\java\\server_test/log.txt"));
		while((str=br2.readLine())!=null) {
			out.write("<p>"+str+"</p>");
		}
		br2.close();
		for(int i=0;i<14;i++) {
			out.write(br.readLine());
		}
		br.close();
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException,IOException{
		response.setContentType("text/html"); 
		request.setCharacterEncoding("utf8"); 
		response.setCharacterEncoding("utf8");
		String parm = request.getParameter("message");
		PrintWriter out = response.getWriter();
		FileReader file = new FileReader("C:\\Users\\Sieun\\eclipse-workspace\\kafka_test_with_tomcat\\src\\main\\webapp/index.jsp");
		BufferedReader br = new BufferedReader(file);
		String str;
		for(int i=0;i<10;i++){
			out.write(br.readLine());
		}
		BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Sieun\\eclipse-workspace\\kafka_test_with_tomcat\\src\\main\\java\\server_test/log.txt"));
		while((str=br2.readLine())!=null) {
			out.write("<p>"+str+"</p>");
		}
		out.write("<p>"+parm+"</p>");
		br2.close();
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Sieun\\eclipse-workspace\\kafka_test_with_tomcat\\src\\main\\java\\server_test/log.txt",true));
		bw.append(parm+"\n");
		bw.close();
		
		for(int i=0;i<14;i++) {
			out.write(br.readLine());
		}
		br.close();
	}
}

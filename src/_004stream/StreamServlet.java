package _004stream;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "StreamServlet")
public class StreamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // classes目录
        //D:\tomcat\apache-tomcat-7.0.52\wtpwebapps\Test\WEB-INF/classes
//        getClass().getClassLoader().getResourceAsStream("aa.txt");




        //		 D:\tomcat\apache-tomcat-7.0.52\wtpwebapps\Test\WEB-INF/classes/aa.txt
//		String path = getServletContext().getRealPath("WEB-INF/classes/aa.txt");
		String path = getServletContext().getRealPath("WEB-_004stream/aa.txt");
		System.out.println("path="+path);


        //		servletCotnext 取东西 D:\tomcat\apache-tomcat-7.0.52\wtpwebapps\Test
//		getServletContext().getResourceAsStream("");

        InputStream is = getServletContext().getResourceAsStream("web/WEB-_004stream/aa.txt");
        ByteOutputStream outputStream = new ByteOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ( (len = is.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        is.close();
        outputStream.flush();
        System.out.println("read result :" + outputStream.toString());


        outputStream.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

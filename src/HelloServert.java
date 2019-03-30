import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class HelloServert extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("aaa");

        resp.getWriter().write(new String("Hello world".getBytes("iso-8859-1"), "utf-8"));


        System.out.println(getServletConfig().getServletName());
        System.out.println(getServletConfig().getServletContext());

        Enumeration<String> initParameterNames =
                getServletConfig().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String aa = initParameterNames.nextElement();
            System.out.println("aa-" + aa + "  value-" + getServletConfig().getInitParameter(aa));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

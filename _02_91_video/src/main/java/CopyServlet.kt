import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/copy2")
class CopyServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doGet(req, resp)
        doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doPost(req, resp)
//        resp?.getWriter()?.write("CopyServlet")
        req?.getRequestDispatcher("/copy.html")?.forward(req, resp)
    }
}
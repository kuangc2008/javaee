import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(urlPatterns =  arrayOf("/oneWeddingAnniversary", "/love"))
class OneWeddingAnniversary : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doGet(req, resp)
        doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doPost(req, resp)
//        resp?.getWriter()?.write("CopyServlet")
        req?.getRequestDispatcher("/oneWeddingAnniversary.html")?.forward(req, resp)
    }
}
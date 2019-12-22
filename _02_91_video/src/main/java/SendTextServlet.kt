import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet(urlPatterns =  arrayOf("/sendtext", "/getText"))
class SendTextServlet : HttpServlet() {

    var text : String? = null

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doGet(req, resp)
        doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doPost(req, resp)

        if ( "/sendtext" in req!!.servletPath) {
            text = req?.getParameter("text")
        } else if ("/getText" in req!!.servletPath) {
            if (text != null) {
                resp?.contentType = "text/text;  charset=utf8"
                resp?.writer?.write(text)
            }
        }
    }

}
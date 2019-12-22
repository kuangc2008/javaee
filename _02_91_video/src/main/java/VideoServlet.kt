import java.io.File
import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/video/*")
class VideoServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doGet(req, resp)
        doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doPost(req, resp)
//        resp?.getWriter()?.write("CopyServlet")


//        val cookie = Cookie("name", "/Users/kuangcheng/Music/031016_516-caribpr-high.mp4")

//        val cookie = Cookie("name", req?.getServletPath())   ///Video
//        val cookie = Cookie("name", req?.getRealPath(req?.getServletPath()))   //:/Users/kuangcheng/IdeaProjects/javaee/_02_91_video/src/main/webapp/video


        //:/Users/kuangcheng/IdeaProjects/javaee/_02_91_video/src/main/webapp/video

        var path = "/a/"
        when {
            "/1" in req!!.pathInfo -> {
                path += "031016_516-caribpr-high.mp4"
            }
            "/2" in req!!.pathInfo -> {
                path += "1pondo-021816_247-FHD.mp4"
            }
            "/3" in req!!.pathInfo -> {
                path += "mura-021316_351.mp4"
            }
            "/4" in req!!.pathInfo -> {
                path += "733dvd092415_159-1pon-1080p3248.mp4"
            }
            "/5" in req!!.pathInfo -> {
                path += "766dvd101313-454-carib-high_1.mp4"
            }
        }

        val cookie = Cookie("name", File(path).toString())   //:/Users/kuangcheng/IdeaProjects/javaee/_02_91_video/src/main/webapp/video



        resp?.addCookie(cookie)
        req?.getRequestDispatcher("/video.html")?.forward(req, resp)
    }
}
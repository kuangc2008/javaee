import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FilenameFilter
import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/video_list")
class VideoListServlet : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.doGet(req, resp)
        doPost(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val a = File("/a").listFiles()


        resp?.contentType = "text/json;  charset=utf8"


        val json = JSONArray()
        a.forEach {
            json.put(a.toString())
        }

        resp?.writer?.write(json.toString())
    }
}
package uy.com.gabylan;
import org.infinispan.manager.CacheContainer;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/MyServlet")
public class MyServlet extends HttpServlet {

    @Resource(lookup = "java:jboss/infinispan/container/infinispan_cache")
    CacheContainer cache;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println(cache.getCache().get("fuck"));

        response.getWriter().println("chupamela");
        cache.getCache().put("fuck",request.getParameter("fuck"));
    }


}

package uy.com.gabylan;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.infinispan.manager.CacheContainer;

@WebServlet(value = "/MyServlet")
public class MyServlet extends HttpServlet {

    @Resource(lookup = "java:jboss/infinispan/container/infinispan_cache")
    CacheContainer cache;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        for (Map.Entry<Object, Object> entry : cache.getCache().entrySet()) {
            response.getWriter().println(entry.getKey().toString() + ": " + entry.getValue().toString());
        }

        for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
            cache.getCache().put(entry.getKey(), entry.getValue());
        }


    }

}


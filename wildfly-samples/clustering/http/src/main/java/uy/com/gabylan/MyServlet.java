package uy.com.gabylan;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.infinispan.manager.CacheContainer;

@WebServlet(value = "/MyServlet")
public class MyServlet extends HttpServlet {

    @Resource(lookup = "java:jboss/infinispan/container/infinispan_cache")
    CacheContainer cache;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().println(getClass().getPackage().getImplementationVersion());
        response.getWriter().println(cache.getCache().get("param1"));
        cache.getCache().put("param1",request.getParameter("param1"));
    }

}


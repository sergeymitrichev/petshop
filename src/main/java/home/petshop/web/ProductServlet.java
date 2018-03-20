package home.petshop.web;

import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class ProductServlet extends HttpServlet {
    private static final Logger log = getLogger(ProductServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to products");
        String categoryId = request.getParameter("cid");

        request.getRequestDispatcher("/products.jsp").forward(request, response);
    }
}

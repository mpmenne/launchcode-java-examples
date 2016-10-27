package org.launchcode.examples;

import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;


public class BookmarksServlet extends HttpServlet {

    private final static String ACTION_ADD = "add";
    private final static String ACTION_DELETE = "delete";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Bookmark> savedBookmarks = getBookmarksFromSession(req.getSession());
        if (savedBookmarks.isEmpty()) {
            redirectToEmpty(req, resp) ;
        } else {
            redirectToView(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<String, Bookmark> savedBookmarks = getBookmarksFromSession(session);

        String action = req.getParameter("action");

        if (ACTION_ADD.equals(action)) {
            String name = req.getParameter("name");
            String url = req.getParameter("url");
            if (!addBookmark(savedBookmarks, name, url)) {
                req.setAttribute("error", "Incorrect bookmark name or URL");
            }

        } else if (ACTION_DELETE.equals(action)) {
            String id = req.getParameter("id");
            if (savedBookmarks.remove(id) == null) {
                req.setAttribute("error", "org.launchcode.examples.Bookmark cannot be deleted: bookmark not found");
            }
        }

        redirectToView(req, resp);
    }

    private Map<String, Bookmark> getBookmarksFromSession(HttpSession session) {
        Map<String, Bookmark> bookmarks = (Map<String, Bookmark>) session.getAttribute("bookmarks");
        if (bookmarks == null) {
            bookmarks = new LinkedHashMap<String, Bookmark>();
            session.setAttribute("bookmarks", bookmarks);
        }
        return bookmarks;
    }

    private boolean addBookmark(Map<String, Bookmark> savedBookmarks, String name, String url) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(url)) {
            return false;
        }
        String id = generateNewId(savedBookmarks);
        savedBookmarks.put(id, new Bookmark(id, name, url));
        return true;
    }

    private String generateNewId(Map<String, Bookmark> savedBookmarks) {
        Random random = new Random();
        int id = random.nextInt();
        while (savedBookmarks.containsKey(id)) {
            id = random.nextInt();
        }
        return String.valueOf(id);
    }

    private void redirectToView(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/view.jsp");
        rd.forward(req, resp);
    }

    private void redirectToEmpty(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/empty.jsp");
        rd.forward(req, resp);
    }

}

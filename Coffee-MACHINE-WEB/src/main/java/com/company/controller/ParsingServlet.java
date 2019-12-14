package com.company.controller;

import com.company.model.UserProfiles;
import com.company.service.FileHandler;
import com.company.service.ParserService;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
public class ParsingServlet extends HttpServlet {
    private final String RESULT = "/jsp/result.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parserType = request.getParameter("parserType");
        try {
            new FileHandler().updateFile("temp", request);
            UserProfiles userProfiles = new ParserService().parseXML(parserType,"temp");
            request.setAttribute("userProfiles", userProfiles.getUserProfiles());
            request.setAttribute("parserType", parserType);
            request.getRequestDispatcher(RESULT).forward(request, response);
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}

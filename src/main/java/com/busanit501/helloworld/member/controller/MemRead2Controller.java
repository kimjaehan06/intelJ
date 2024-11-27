package com.busanit501.helloworld.member.controller;

import com.busanit501.helloworld.member.dto.MemDTO;
import com.busanit501.helloworld.member.service.MemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "memRead2Controller", urlPatterns = "/member/read2")
public class MemRead2Controller extends HttpServlet {
    private MemService memService = MemService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet TodoRead2Controller 하나 조회");

        try {
            Long mno = Long.parseLong(request.getParameter("mno"));
            MemDTO memDTO = memService.get(mno);
            request.setAttribute("dto", memDTO);
            request.getRequestDispatcher("/WEB-INF/member/memRead2.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

package com.busanit501.helloworld.member.controller;

import com.busanit501.helloworld.member.service.MemService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "memDeleteController", urlPatterns = "/member/delete")
public class MemDeleteController extends HttpServlet {
    private MemService memService = MemService.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long mno = Long.valueOf(request.getParameter("mno"));
        //
        log.info("doPost memDeleteController 확인");
        try {
           memService.delete(mno);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/member/list2");
    }
}

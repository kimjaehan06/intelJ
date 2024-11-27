package com.busanit501.helloworld.member.controller;

import com.busanit501.helloworld.member.dto.MemDTO;
import com.busanit501.helloworld.member.service.MemService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Log4j2
@WebServlet(name = "memList2Controller", urlPatterns = "/member/list2")
public class MemList2Controller extends HttpServlet {
    private MemService memService = MemService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("doGet memList2Controller 확인");
        try {
            List<MemDTO> MemList = memService.listAll();
            request.setAttribute("list", MemList);
            request.getRequestDispatcher("/WEB-INF/member/memList2.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

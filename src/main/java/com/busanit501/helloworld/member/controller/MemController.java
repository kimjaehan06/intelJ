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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Log4j2
@WebServlet(name = "memUpdateController",urlPatterns = "/member/update")
public class MemController extends HttpServlet {
    private MemService memService = MemService.INSTANCE;
    private final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long mno = Long.parseLong(request.getParameter("mno"));
            MemDTO memDTO = memService.get(mno);
            request.setAttribute("dto", memDTO);
            request.getRequestDispatcher("/WEB-INF/member/memUpd.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String finished = request.getParameter("finished");
        log.info("finished : " + finished);
        boolean checkFinished = false;
        if(finished.equals("on")){
            checkFinished = true;
        }
        MemDTO memDTO = MemDTO.builder()
                .mno(Long.valueOf(request.getParameter("mno")))
                .title(request.getParameter("title"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATE_TIME_FORMATTER))
                .finished(checkFinished)
                .build();
        log.info("memDTO 수정된 내용: " + memDTO);
        // Controller -> Service
        try {
            memService.update(memDTO);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("doPost : 글쓰기 처리하는 로직, 디비 연결 전, 리스트로 이동함");
        response.sendRedirect("/member/list2");

    }
}

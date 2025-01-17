package com.busanit501.helloworld.food.controller;

import com.busanit501.helloworld.food.dto.FoodDTO;
import com.busanit501.helloworld.food.service.FoodService;
import com.busanit501.helloworld.todo.dto.TodoDTO;
import com.busanit501.helloworld.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoReadController",urlPatterns = "/food/read")
public class FoodReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doGet TodoReadController 하나 조회 예제");

        // 클릭한 게시글 번호를 가지고 와야함.
        Long fno = Long.parseLong(request.getParameter("fno"));
        System.out.println("fno = " + fno);

        // 서비스에서, 하나의 todo 더미 데이터를 조회 후,
        FoodDTO foodDTO  = FoodService.INSTANCE.getOne(fno);

        // 화면에 전달하기.
        request.setAttribute("dto",foodDTO);

        request.getRequestDispatcher("/WEB-INF/food/foodRead.jsp")
                .forward(request, response);

    }
}

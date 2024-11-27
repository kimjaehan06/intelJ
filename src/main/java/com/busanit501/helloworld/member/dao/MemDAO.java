package com.busanit501.helloworld.member.dao;

import com.busanit501.helloworld.member.vo.MemVO;
import lombok.Cleanup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemDAO {

    //등록
    public void insert(MemVO memVO) throws SQLException {

        String sql = "insert into tbl_mem (title, dueDate, finished) " +
                "values (?, ?, ?)";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(memVO.getDueDate()));
        preparedStatement.setBoolean(3, memVO.isFinished());
        preparedStatement.executeUpdate();
    }

    //전체 조회
    public List<MemVO> selectAll() throws SQLException {
        String sql = "select * from tbl_mem";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        List<MemVO> list = new ArrayList<>();
        while (resultSet.next()) {
            MemVO memVO = MemVO.builder()
                    .mno(resultSet.getLong("mno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .finished(resultSet.getBoolean("finished"))
                    .build();
            list.add(memVO);
        }
        return list;
    }

    //상세보기.
    public MemVO selectOne(Long mno) throws SQLException {
        String sql = "select * from tbl_mem where mno = ?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, mno);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        MemVO memVO = MemVO.builder()
                .mno(resultSet.getLong("mno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .finished(resultSet.getBoolean("finished"))
                .build();
        return memVO;
    }

    // 수정.
    public void updateOne(MemVO memVO) throws SQLException {
        String sql = " update tbl_mem set title=?, dueDate=?, finished=?" +
                " where mno=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, memVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(memVO.getDueDate()));
        preparedStatement.setBoolean(3, memVO.isFinished());
        preparedStatement.setLong(4, memVO.getMno());
        preparedStatement.executeUpdate();

    }

    //삭제,
    public void deleteTodo(Long mno) throws SQLException {
        String sql = "delete from tbl_mem where mno =?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, mno);
        preparedStatement.executeUpdate();

    }

    public String getTime() {
        String now = null;
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            resultSet.next();
            now = resultSet.getString(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public String getTime2() throws SQLException {
        String now = null;
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("select now()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        now = resultSet.getString(1);
        return now;
    }


} //class


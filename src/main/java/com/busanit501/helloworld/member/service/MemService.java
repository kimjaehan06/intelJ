package com.busanit501.helloworld.member.service;

import com.busanit501.helloworld.member.dao.MemDAO;
import com.busanit501.helloworld.member.dto.MemDTO;
import com.busanit501.helloworld.member.util.MapperUtil;
import com.busanit501.helloworld.member.vo.MemVO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemService {
    INSTANCE;

    private MemDAO memDAO;
    private ModelMapper modelMapper;

    MemService() {
        memDAO = new MemDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }
    public void register(MemDTO memDTO) throws SQLException {


        MemVO memVO = modelMapper.map(memDTO, MemVO.class);
        log.info("memVo : " + memVO);


        memDAO.insert(memVO);
    }

    // 전체 조회
    public List<MemDTO> listAll() throws SQLException {
        List<MemVO> voList = memDAO.selectAll();
        log.info("voList : " + voList);

        List<MemDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }


    //상세보기.
    public MemDTO get(Long mno) throws SQLException {
        log.info("mno : " + mno);
        ///  디비에서 하나 조회 결과 받았음.
        MemVO memVO = memDAO.selectOne(mno);
         MemDTO memDTO = modelMapper.map(memVO, MemDTO.class);
         return memDTO;

    }

    //수정 기능
    public void update(MemDTO memDTO) throws SQLException {

        log.info("memDTO : " + memDTO);
         MemVO memVO = modelMapper.map(memDTO, MemVO.class);
         memDAO.updateOne(memVO);

    }

    // 삭제 기능.
    public void delete(Long mno) throws SQLException {
        memDAO.deleteTodo(mno);
    }

}







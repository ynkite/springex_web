package com.example.springex_web.mapper;

import com.example.springex_web.domain.TodoVO;
import com.example.springex_web.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();
    void insert(TodoVO todoVo);
    List<TodoVO> selectAll(); //selectAll();  -> DB에 있는 모든 데이터 조회
    TodoVO selectOne(Long tno);
    void delete(Long tno);
    void update(TodoVO todoVO);
    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
}

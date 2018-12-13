package com.sammi.srvm.dao;

import java.util.ArrayList;
import com.sammi.srvm.dto.TestDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO {
	public ArrayList<TestDTO> TestSelect();
	public int TestInsert(TestDTO tdto);
	public int TestUpdate(@Param("IDX") int IDX);
	public int TestDelete(@Param("IDX") int IDX);
}

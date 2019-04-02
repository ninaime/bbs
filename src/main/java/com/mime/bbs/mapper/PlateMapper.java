package com.mime.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mime.bbs.model.Plate;

@Mapper
public interface PlateMapper {
	List<Plate> findPlate();
}

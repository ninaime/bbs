package com.mime.bbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mime.bbs.model.BbsPlate;

@Mapper
public interface BbsPlateMapper {
	List<BbsPlate> findPlate();
}

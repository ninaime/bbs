package com.mime.bbs.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mime.bbs.mapper.BbsPlateMapper;
import com.mime.bbs.model.BbsPlate;
import com.mime.bbs.system.service.SysPlateService;

@Service("sysPlateService")
public class SysPlateServiceImpl implements SysPlateService {
	
	@Autowired
	BbsPlateMapper plateMapper;

	@Override
	public List<BbsPlate> findPlate() {
		return plateMapper.findPlate();
	}

	

	
}

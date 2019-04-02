package com.mime.bbs.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mime.bbs.mapper.PlateMapper;
import com.mime.bbs.model.Plate;
import com.mime.bbs.system.service.SysPlateService;

@Service("sysPlateService")
public class SysPlateServiceImpl implements SysPlateService {
	
	@Autowired
	PlateMapper plateMapper;

	@Override
	public List<Plate> findPlate() {
		return plateMapper.findPlate();
	}

	

	
}

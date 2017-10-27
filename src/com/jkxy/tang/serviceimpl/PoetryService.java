package com.jkxy.tang.serviceimpl;

import java.util.List;

import com.jkxy.tang.dao.IPoetryDAO;
import com.jkxy.tang.entity.Poetry;
import com.jkxy.tang.service.IPoetryService;

public class PoetryService implements IPoetryService {
	private IPoetryDAO poetryDAO;
	
	
	public IPoetryDAO getPoetryDAO() {
		return poetryDAO;
	}

	public void setPoetryDAO(IPoetryDAO poetryDAO) {
		this.poetryDAO = poetryDAO;
	}

	@Override
	public List getAllByName(String name) {
		return poetryDAO.getAllByName(name);
	}

	@Override
	public Poetry getByTitle(String title) {
		return poetryDAO.getByTitle(title);
	}

	@Override
	public Poetry getByContent(String content) {
		return poetryDAO.getByContent(content);
	}

}

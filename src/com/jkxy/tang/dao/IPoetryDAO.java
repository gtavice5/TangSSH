package com.jkxy.tang.dao;

import java.util.List;

import com.jkxy.tang.entity.Poetry;

public interface IPoetryDAO {
	//根据名字查询所有作品
	public List getAllByName(String name);
	//根据标题获取整首诗
	public Poetry getByTitle(String title);
	//根据内容获取诗人名和整首诗
	public Poetry getByContent(String content);
}

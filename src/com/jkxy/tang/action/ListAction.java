package com.jkxy.tang.action;

import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;

import com.jkxy.tang.entity.Poetry;
import com.jkxy.tang.serviceimpl.PoetryService;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {
	private String action;
	private String content;
	private PoetryService poetryService;
	
	@Override
	public String execute() throws Exception {
//		PoetryDao1 poetryDao=new PoetryDao1();
		ServletRequest request=ServletActionContext.getRequest();
		if(action.equals("getAllByName")){
			List<Poetry> pList=poetryService.getAllByName(content);
			request.setAttribute("pList", pList);
			return SUCCESS;
		}else if(action.equals("getByTitle")){
			Poetry poetry1=poetryService.getByTitle(content);
			request.setAttribute("poetry1", poetry1);
			return SUCCESS;
		}else if(action.equals("getByContent")){
			Poetry poetry2=poetryService.getByContent(content);
			request.setAttribute("poetry2", poetry2);
			return SUCCESS;
		}
		return SUCCESS;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PoetryService getPoetryService() {
		return poetryService;
	}

	public void setPoetryService(PoetryService poetryService) {
		this.poetryService = poetryService;
	}
	
	
	
}

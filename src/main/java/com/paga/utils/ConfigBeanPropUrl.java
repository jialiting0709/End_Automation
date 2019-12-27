package com.paga.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
@PropertySource(value = "classpath:configUrl.properties")
public class ConfigBeanPropUrl {

    private String login;
    private String taskType;
    private String allHdr;
    private String hdr;
    private String addTask;
    private String startTask;
    private String startSubtask;
    private String addclink;
    private String condition;
    private String addPathss;
    private String updateSub;
    private String completeSubTask;
    private String subtasktkId;
    private String write;
    private String approveSubTask;
    private String ruleZip;
    private String RejectSubTask;
    private String newSubTaskuuid;
    private String approveTask;
    private String comments;
    private String addComments;
    private String preview;
    private String updatePath;
    
    
    
	public String getUpdatePath() {
		return updatePath;
	}

	public void setUpdatePath(String updatePath) {
		this.updatePath = updatePath;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getAddComments() {
		return addComments;
	}

	public void setAddComments(String addComments) {
		this.addComments = addComments;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getAllHdr() {
		return allHdr;
	}

	public void setAllHdr(String allHdr) {
		this.allHdr = allHdr;
	}

	public String getHdr() {
		return hdr;
	}

	public void setHdr(String hdr) {
		this.hdr = hdr;
	}

	public String getAddTask() {
		return addTask;
	}

	public void setAddTask(String addTask) {
		this.addTask = addTask;
	}


	public String getStartTask() {
		return startTask;
	}

	public void setStartTask(String startTask) {
		this.startTask = startTask;
	}

	public String getStartSubtask() {
		return startSubtask;
	}

	public void setStartSubtask(String startSubtask) {
		this.startSubtask = startSubtask;
	}

	public String getCompleteSubTask() {
		return completeSubTask;
	}

	public void setCompleteSubTask(String completeSubTask) {
		this.completeSubTask = completeSubTask;
	}
	

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getUpdateSub() {
		return updateSub;
	}

	public void setUpdateSub(String updateSub) {
		this.updateSub = updateSub;
	}


	public String getAddPathss() {
		return addPathss;
	}

	public void setAddPathss(String addPathss) {
		this.addPathss = addPathss;
	}

	public String getAddclink() {
		return addclink;
	}

	public void setAddclink(String addclink) {
		this.addclink = addclink;
	}

	public String getRejectSubTask() {
		return RejectSubTask;
	}

	public void setRejectSubTask(String rejectSubTask) {
		RejectSubTask = rejectSubTask;
	}

	public String getApproveSubTask() {
		return approveSubTask;
	}

	public void setApproveSubTask(String approveSubTask) {
		this.approveSubTask = approveSubTask;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRuleZip() {
		return ruleZip;
	}

	public void setRuleZip(String ruleZip) {
		this.ruleZip = ruleZip;
	}

	public String getSubtasktkId() {
		return subtasktkId;
	}

	public void setSubtasktkId(String subtasktkId) {
		this.subtasktkId = subtasktkId;
	}

	public String getNewSubTaskuuid() {
		return newSubTaskuuid;
	}

	public void setNewSubTaskuuid(String newSubTaskuuid) {
		this.newSubTaskuuid = newSubTaskuuid;
	}

	public String getApproveTask() {
		return approveTask;
	}

	public void setApproveTask(String approveTask) {
		this.approveTask = approveTask;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	} 
	
	
	
    
}

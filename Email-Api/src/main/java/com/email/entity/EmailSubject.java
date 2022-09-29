package com.email.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="email_subject")
public class EmailSubject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="subject_topic")
	private String subjectTopic;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="content_id")
	private EmailContent emailContent;

	public EmailSubject()
	{
		
	}

	public EmailSubject(String subject, String subjectTopic) {
		this.subject = subject;
		this.subjectTopic = subjectTopic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectTopic() {
		return subjectTopic;
	}

	public void setSubjectTopic(String subjectTopic) {
		this.subjectTopic = subjectTopic;
	}
	
	public EmailContent getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(EmailContent emailContent) {
		this.emailContent = emailContent;
	}

	@Override
	public String toString() {
		return "EmailSubject [id=" + id + ", subject=" + subject
				+ ", subjectTopic=" + subjectTopic + ", emailContent="
				+ emailContent + "]";
	}


	
}


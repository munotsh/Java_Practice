package com.example.designPattern.mementoPattern;

public class Orignator {
	String article;
	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String save() {
		return article;
	}

	public void restore(String m) {
		this.article = m;
	}
}

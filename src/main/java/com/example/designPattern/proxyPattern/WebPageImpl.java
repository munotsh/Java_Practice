package com.example.designPattern.proxyPattern;

public class WebPageImpl implements WebPage {
	@Override
	public void renderPage(String uri) throws Exception {
		System.out.println(uri + " rendered successfully");
	}
}

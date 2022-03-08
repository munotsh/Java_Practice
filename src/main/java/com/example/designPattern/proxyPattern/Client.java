package com.example.designPattern.proxyPattern;

public class Client {
	public static void main(String[] args) throws Exception {
		WebPageProxy pageProxy = new WebPageProxy();
		pageProxy.renderPage("www.google.com");
	}
}

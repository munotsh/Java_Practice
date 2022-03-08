package com.example.designPattern.proxyPattern;

public class WebPageProxy implements WebPage {
	WebPage webPage;

	public WebPageProxy() {
		webPage = new WebPageImpl();
	}

	@Override
	public void renderPage(String uri) throws Exception {
		if (uri.contains("youtube")) {
			throw new RuntimeException("youtube is blocked by internet provider");
		} else {
			webPage.renderPage(uri);
		}
	}
}

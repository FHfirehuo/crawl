package com.fire.crawl.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fire.crawl.factory.Initialize;

@Service
public class Crawl {

	private static final Logger LOG =  Logger.getLogger(Crawl.class);
	
	
	private  ChapterService chapterService;
	
	@Autowired
	public Crawl( ChapterService chapterService) {
		 this.chapterService = chapterService;
	}
	
	//http://www.biqukan.com/2_2769/1120528.html
	public void load() {
		load(Initialize.get(Initialize.FIRST_URL));
	}
	
	public void load(String absoluteURL) {
		String url = Initialize.get(Initialize.SITE) + absoluteURL;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			LOG.error("get url:" + url + " is error.", e);
		}
		
		Element main = doc.getElementsByClass("content").first();
		
		String title = main.select("h1").first().text();
		String content = main.getElementById("content").text();
		
		chapterService.save(title, content);
		
		
		Element pageElement = main.getElementsByClass("page_chapter").first();
		String nexturl = pageElement.getElementsByTag("a").get(2).attr("href");
		//load(nexturl);
		
	}

}

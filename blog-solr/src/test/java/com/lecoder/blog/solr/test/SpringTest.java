package com.lecoder.blog.solr.test;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lecoder.blog.solr.bean.ArticleSolr;
import com.lecoder.blog.solr.search.ArticleSearcher;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-solr.xml"})
public class SpringTest {
	
	@Autowired
	private ArticleSearcher articleSearcher;
	
	@Test
	public void test(){
		try {
			List<ArticleSolr> articles = articleSearcher.search("文档", 0, 10);
			System.out.println(articles);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

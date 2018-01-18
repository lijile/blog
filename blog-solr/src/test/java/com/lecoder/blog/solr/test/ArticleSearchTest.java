package com.lecoder.blog.solr.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.junit.Test;
import com.lecoder.blog.solr.bean.ArticleSolr;

public class ArticleSearchTest {
	
	HttpSolrClient httpSolrClient = new HttpSolrClient("http://127.0.0.1:8080/solr/blog");
	
	@Test
	public void test() throws SolrServerException, IOException{
		
		//query("文档", 0, 10);
//		ArticleSolr article = new ArticleSolr();
//		article.setId(11);
//		article.setSummary("文章summary");
//		save(article);
		delete(11);
	}
	
	private List<ArticleSolr> query(String keywords,int start,int rows) throws SolrServerException, IOException {
		
		
		SolrQuery solrQuery = new SolrQuery();
		
		solrQuery.set("q","title:" + keywords + " summary:" + keywords + " article_content:" + keywords);
		
		solrQuery.setStart(start);
		
		solrQuery.setRows(rows);
		
		solrQuery.setHighlight(true);
		
		solrQuery.addHighlightField("title");
		
		solrQuery.addHighlightField("summary");
		
		solrQuery.setHighlightSimplePre("<span style='color:red'>");
		
		solrQuery.setHighlightSimplePost("</span>");
		
		QueryResponse queryResponse = httpSolrClient.query(solrQuery);
		
		List<ArticleSolr> articles = queryResponse.getBeans(ArticleSolr.class);
		
		Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
		
		for(ArticleSolr article : articles) {
			Map<String,List<String>> data = highlight.get(String.valueOf(article.getId()));
			if(data != null && data.get("title") != null){
				String title = data.get("title").get(0);
				article.setTitle(title);
			}
			if(data != null && data.get("summary") != null){
				String summary = data.get("summary").get(0);
				article.setSummary(summary);
			}
		}
		return articles;
	}
	
	private void save(ArticleSolr article) throws SolrServerException, IOException {
		httpSolrClient.addBean(article);
		httpSolrClient.commit();
	}
	
	private void delete(int id) throws SolrServerException, IOException {
		httpSolrClient.deleteById(String.valueOf(id));
		httpSolrClient.commit();
	}

}

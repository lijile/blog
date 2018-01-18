package com.lecoder.blog.solr.search;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.lecoder.blog.solr.bean.ArticleSolr;

@Component
public class ArticleSearcher {
	
	@Autowired
	private HttpSolrClient httpSolrClient;
	
	/**
	 * 搜索文章
	 * @param keywords 关键词
	 * @param start 开始数，开始为0
	 * @param rows 查询行数
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public List<ArticleSolr> search(String keywords,int start,int rows) throws SolrServerException, IOException {
		
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
	
	/**
	 * 保存或更新索引
	 * @param article
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public void save(ArticleSolr article) throws SolrServerException, IOException {
		httpSolrClient.addBean(article);
		httpSolrClient.commit();
	}
	
	/**
	 * 删除文章索引
	 * @param id 文章id
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public void delete(int id) throws SolrServerException, IOException {
		httpSolrClient.deleteById(String.valueOf(id));
		httpSolrClient.commit();
	}


}

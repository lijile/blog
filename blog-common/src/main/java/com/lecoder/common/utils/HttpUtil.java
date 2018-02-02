package com.lecoder.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpUtil {
	
	public static String doGet(String url, Map<String, String> params) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url2 = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) url2
					.openConnection();

			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setUseCaches(false);
			httpConn.setRequestMethod("GET");

			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			String param = "";
			if (params != null) {
				for (Map.Entry<String, String> entry : params.entrySet()) {

					httpConn.setRequestProperty(entry.getKey(),
							entry.getValue());
					param += entry.getKey() + "=" + entry.getValue() + "&";
				}
				OutputStreamWriter osw = new OutputStreamWriter(
						httpConn.getOutputStream(), "utf-8");
				osw.write(param.substring(0, param.length() - 1));
				osw.flush();
			}
			int responseCode = httpConn.getResponseCode();

			if (HttpURLConnection.HTTP_OK == responseCode) {
				String readLine;
				BufferedReader responseReader;
				responseReader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream(), "UTF-8"));

				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine);
				}
				responseReader.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();

	}
	
	public static String doPost(String url, Map<String, String> params) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url2 = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) url2
					.openConnection();

			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setUseCaches(false);
			httpConn.setRequestMethod("POST");

			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			String param = "";
			if (params != null) {
				for (Map.Entry<String, String> entry : params.entrySet()) {

					httpConn.setRequestProperty(entry.getKey(),
							entry.getValue());
					param += entry.getKey() + "=" + entry.getValue() + "&";
				}
				OutputStreamWriter osw = new OutputStreamWriter(
						httpConn.getOutputStream(), "utf-8");
				osw.write(param.substring(0, param.length() - 1));
				osw.flush();
			}
			int responseCode = httpConn.getResponseCode();

			if (HttpURLConnection.HTTP_OK == responseCode) {
				String readLine;
				BufferedReader responseReader;
				responseReader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream(), "UTF-8"));

				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine);
				}
				responseReader.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();

	}

	public static String doPost2(String url, String body) {
		StringBuffer sb = new StringBuffer();
		try {
			URL url2 = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) url2
					.openConnection();

			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setUseCaches(false);
			httpConn.setRequestMethod("POST");

			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			OutputStreamWriter osw = new OutputStreamWriter(
					httpConn.getOutputStream(), "utf-8");
			osw.write(body);
			osw.flush();
			osw.close();

			int responseCode = httpConn.getResponseCode();

			if (HttpURLConnection.HTTP_OK == responseCode) {

				String readLine;
				BufferedReader responseReader;
				responseReader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream(), "UTF-8"));

				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine);
				}
				responseReader.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return sb.toString();

	}

	public static String uploadFile(String urlstr, InputStream inputStream,Map<String, String> params) {
		HttpURLConnection hc = null;  
        ByteArrayOutputStream bos = null;
        String BOUNDARY="------WebKitFormBoundary1qYxJSALUu2w1KAn";
        InputStream is = null;
        byte[] res = null;
        try { 
            URL url = new URL(urlstr); 
            hc = (HttpURLConnection) url.openConnection(); 
 
            hc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY); 
            hc.setRequestProperty("Charsert", "UTF-8"); 
            hc.setDoOutput(true); 
            hc.setDoInput(true); 
            hc.setUseCaches(false); 
            hc.setRequestMethod("POST"); 
 
            OutputStream dout = hc.getOutputStream(); 
            String boundary = BOUNDARY; 
            StringBuffer resSB = new StringBuffer("\r\n"); 
            String endBoundary = "\r\n--" + boundary + "--\r\n"; 
            //strParams 1:key 2:value 
            if (params!=null) {
				for(Map.Entry<String, String> entry:params.entrySet()){
					String key = entry.getKey(); 
                    String value = entry.getValue(); 
                    resSB.append("Content-Disposition: form-data; name=\"").append(key).append("\"\r\n").append("\r\n").append(value).append("\r\n").append("--").append(boundary).append("\r\n"); 
				}
			}

            String boundaryMessage = resSB.toString(); 
             
            dout.write( ("--"+boundary+boundaryMessage).getBytes("utf-8") ); 
             
            resSB = new StringBuffer(); 
            resSB.append("Content-Disposition: form-data; name=\"upload\"; filename=\"\"") .append("\r\n").append("Content-Type: ").append("image/png").append("\r\n\r\n"); 
            
            dout.write( resSB.toString().getBytes("utf-8") );
            
            DataInputStream in = new DataInputStream(inputStream); 
            int bytes = 0; 
            byte[] bufferOut = new byte[1024 * 5]; 
            while ((bytes = in.read(bufferOut)) != -1) { 
                dout.write(bufferOut, 0, bytes); 
            } 
             
            in.close(); 

             
            dout.write( endBoundary.getBytes("utf-8") );    
            dout.close();  
            int ch;  
            is = hc.getInputStream();    
            bos = new ByteArrayOutputStream(); 
            while ((ch = is.read()) != -1) { 
                bos.write(ch); 
            } 
            res = bos.toByteArray(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            try { 
                if (bos != null) 
                    bos.close();  
                if (is != null) 
                    is.close();  
            } catch (Exception e2) { 
                e2.printStackTrace(); 
            } 
        } 
		return new String(res);
	}

	public static String post_https(String url, String content){
		try {
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() },
					new java.security.SecureRandom());

			URL console = new URL(url);
			HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
			conn.setSSLSocketFactory(sc.getSocketFactory());
			conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
			conn.setDoOutput(true);
			conn.connect();
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.write(content.getBytes("utf-8"));
			out.flush();
			out.close();
			InputStream is = conn.getInputStream();
			if (is != null) {
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					outStream.write(buffer, 0, len);
				}
				is.close();
				return new String(outStream.toByteArray());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}
}

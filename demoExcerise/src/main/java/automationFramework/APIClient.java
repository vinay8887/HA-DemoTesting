 package automationFramework;

// Rest Client to perform get and post request
 
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.google.common.base.Joiner;


public class APIClient
{
	private String m_user;
	private String m_password;
	private String m_url;

	public APIClient(String base_url)
	{
       this.m_url = base_url;
	}

	/**
	 * Send Get
	 *
	 * Issues a GET request (read) against the API and returns the result
	 * (as Object, see below).
	 *
	 * Arguments:
	 *
	 * uri                  The API method to call including parameters
	 *                      (e.g. get_case/1)
	 *
	 * Returns the parsed JSON response as standard object which can
	 * either be an instance of JSONObject or JSONArray (depending on the
	 * API method). In most cases, this returns a JSONObject instance which
	 * is basically the same as java.util.Map.
	 */
	public Object sendGet(String uri,Object data)
		throws MalformedURLException, IOException, APIException
	{
		return this.sendRequest("GET", uri, data);
	}

	/**
	 * Send POST
	 *
	 * Issues a POST request (write) against the API and returns the result
	 * (as Object, see below).
	 *
	 * Arguments:
	 *
	 * uri                  The API method to call including parameters
	 *                      (e.g. add_case/1)
	 * data                 The data to submit as part of the request (e.g.,
	 *                      a map)
	 *
	 * Returns the parsed JSON response as standard object which can
	 * either be an instance of JSONObject or JSONArray (depending on the
	 * API method). In most cases, this returns a JSONObject instance which
	 * is basically the same as java.util.Map.	 
	 */
	public Object sendPost(String uri, Object data)
		throws MalformedURLException, IOException, APIException
	{
		return this.sendRequest("POST", uri, data);
	}
	
	private Object sendRequest(String method, String uri, Object data)
		throws MalformedURLException, IOException, APIException
	{
		
		String urlParameters = getUrlParameters(data);
		
		if (urlParameters != null && urlParameters != "") urlParameters = "?" + urlParameters;
		String requestUrl = m_url + urlParameters;
		
		
		URL url = new URL(requestUrl);
		System.out.println(requestUrl);
		// Create the connection object and set the required HTTP method
		// (GET/POST) and headers (content type and basic auth).
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
//		conn.addRequestProperty("Content-Type", "application/json");
//		conn.addRequestProperty("Authorization", "Basic");
//		conn.addRequestProperty("Accept-Encoding", "application/json");
		if (method == "POST")
		{
			// Add the POST arguments, if any. We just serialize the passed
			// data object (i.e. a dictionary) and then add it to the
			// request body.
			if (data != null)
			{				
				byte[] block =  JSONValue.toJSONString(data).
					getBytes("UTF-8");

				conn.setDoOutput(true);				
				OutputStream ostream = conn.getOutputStream();			
				ostream.write(block);
				ostream.flush();
			}
		}
		
		// Execute the actual web request (if it wasn't already initiated
		// by getOutputStream above) and record any occurred errors (we use
		// the error stream in this case).
		int status = conn.getResponseCode();
		
		
		InputStream istream;
		conn.getContent();
		istream = conn.getErrorStream();
		if (status != 200)
		{
			istream = conn.getErrorStream();
			if (istream == null)
			{
				throw new APIException(
					"API return HTTP " + status + 
					" (No additional error message received)"
				);
			}
		}
		else 
		{
			istream = conn.getInputStream();
		}
		
		// Read the response body, if any, and deserialize it from JSON.
		String text = "";
		if (istream != null)
		{
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(
					istream,
					"UTF-8"
				)
			);
		
			String line;
			while ((line = reader.readLine()) != null)
			{
				text += line;
				text += System.getProperty("line.separator");
			}
			
			reader.close();
		}
		
		Object result;
		if (text != "")
		{
			result = JSONValue.parse(text);
		}
		else 
		{
			result = new JSONObject();
		}
		
		// Check for any occurred errors and add additional details to
		// the exception message, if any (e.g. the error message returned)
		if (status != 200)
		{
			String error = "No additional error message received";
			if (result != null && result instanceof JSONObject)
			{
				JSONObject obj = (JSONObject) result;
				if (obj.containsKey("error"))
				{
					error = '"' + (String) obj.get("error") + '"';
				}
			}
			
			throw new APIException(
				"API returned HTTP " + status +
				"(" + error + ")"
			);
		}
		
		return result;
	}
	
	static String getUrlParameters(Object options) {
		String params = "";
		if (options != null) {
			if (options instanceof Map) {
				ArrayList optionList = new ArrayList();
				for (Object key : ((HashMap) options).keySet()) {
					optionList.add(String.format("%s=%s", key, ((HashMap) options).get(key)));
				}
				params += Joiner.on("&").join(optionList);
			} else {
				params = (String) options;
			}
		}
		return params;
	}
}

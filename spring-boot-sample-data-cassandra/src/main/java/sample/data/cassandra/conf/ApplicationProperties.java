package sample.data.cassandra.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ApplicationProperties {

	@Value("${keyspace_name}")
	private String keyspaceName;
	
	@Value("${contact_points}")
	private String contactPoints;
	
	@Value("${port}")
	private int port;
	
	@Value("${max_pool_connection}")
	private int maxPoolConnection;
	
	@Value("${SITE_IV_URL}")
	private String siteIVUrl;
	
	@Value("${SITE_III_URL}")
	private String siteIIIUrl;
	
	@Value("${SITE_II_URL}")
	private String siteIIUrl;
	
	@Value("${SITE_I_URL}")
	private String siteIUrl;
	
	
	public String getSiteIVUrl() {
		return siteIVUrl;
	}

	public void setSiteIVUrl(String siteIVUrl) {
		this.siteIVUrl = siteIVUrl;
	}

	public String getSiteIIIUrl() {
		return siteIIIUrl;
	}

	public void setSiteIIIUrl(String siteIIIUrl) {
		this.siteIIIUrl = siteIIIUrl;
	}

	public String getSiteIIUrl() {
		return siteIIUrl;
	}

	public void setSiteIIUrl(String siteIIUrl) {
		this.siteIIUrl = siteIIUrl;
	}

	public String getSiteIUrl() {
		return siteIUrl;
	}

	public void setSiteIUrl(String siteIUrl) {
		this.siteIUrl = siteIUrl;
	}

	public String getKeyspaceName() {
		return keyspaceName;
	}

	public void setKeyspaceName(String keyspaceName) {
		this.keyspaceName = keyspaceName;
	}

	public String getContactPoints() {
		return contactPoints;
	}

	public void setContactPoints(String contactPoints) {
		this.contactPoints = contactPoints;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getMaxPoolConnection() {
		return maxPoolConnection;
	}

	public void setMaxPoolConnection(int maxPoolConnection) {
		this.maxPoolConnection = maxPoolConnection;
	}
	
}

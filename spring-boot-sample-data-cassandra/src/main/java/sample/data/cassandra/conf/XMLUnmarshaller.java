package sample.data.cassandra.conf;

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

public interface XMLUnmarshaller {

	Logger log = Logger.getLogger(XMLUnmarshaller.class);
	
	
	@SuppressWarnings("unchecked")
	public static <T> T unmarshlall(String url, T model) {
		T modelToMarshall = model;
		try {
			JAXBContext unmarshalJaxbContext = JAXBContext.newInstance(modelToMarshall.getClass());
			Unmarshaller unmarshaller = unmarshalJaxbContext.createUnmarshaller();
			modelToMarshall = (T) unmarshaller.unmarshal(new InputSource(new URL(url).openStream()));
		} catch (Exception e) {
			log.error("Error on unmarshlall XML " +e.getMessage(),e);
		}

		return modelToMarshall;
	}

}

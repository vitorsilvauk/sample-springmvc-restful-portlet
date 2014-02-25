package com.liferay.samples.rest.json;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.type.JavaType;

/***************************************************************************
 * <b>Description:</b> An ObjectMapper to add mixIn annotations
 * This will make all the service builder entities valid for jackson 
 * deserialization
 * <b>Created:</b>20 Feb 2014 17:48:09  @author Vitor Silva 
 **************************************************************************/
public class LiferayObjectMapper extends ObjectMapper {

	public LiferayObjectMapper() {
		super();
	}

	public LiferayObjectMapper(JsonFactory jf, SerializerProvider sp,
			DeserializerProvider dp, SerializationConfig sconfig,
			DeserializationConfig dconfig) {
		super(jf, sp, dp, sconfig, dconfig);
	}

	public LiferayObjectMapper(JsonFactory jf, SerializerProvider sp,
			DeserializerProvider dp) {
		super(jf, sp, dp);
	}

	public LiferayObjectMapper(JsonFactory jf) {
		super(jf);
	}
    
	
	
	
	@Override
	public boolean canDeserialize(JavaType type) {
		
		DeserializationConfig desConfig = copyDeserializationConfig();
		addMixInAnnotations(desConfig, type);
		return _deserializerProvider.hasValueDeserializerFor(desConfig, type);
	}

	/***************************************************************************
	 * <b>Description:</b> Adds mix in annotations to filter out
	 * entity internal fields like expando that prevent deserialization
	 * 
	 * <b>Created:</b>20 Feb 2014 16:57:31  @author Vitor Silva 
	 * @param desConfig 
	 **************************************************************************/
	protected void addMixInAnnotations(DeserializationConfig desConfig, JavaType type) {
		desConfig.addMixInAnnotations(type.getClass(), IgnoreExpandoAttributesMixIn.class);
		
	}

	abstract class IgnoreExpandoAttributesMixIn
	{
	
		@JsonIgnore public abstract void setExpandoBridgeAttributes(ServiceContext serviceContext);

		@JsonIgnore public abstract void setExpandoBridgeAttributes(BaseModel<?> baseModel);

		@JsonIgnore public abstract void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);
	
	}


}

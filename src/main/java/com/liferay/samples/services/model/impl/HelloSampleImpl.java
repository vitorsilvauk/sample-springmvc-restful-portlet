package com.liferay.samples.services.model.impl;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The extended model implementation for the HelloSample service. Represents a row in the &quot;SAMPLES_HelloSample&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.samples.services.model.HelloSample} interface.
 * </p>
 *
 * @author Liferay
 */
@JsonIgnoreProperties({ "expandoBridge", "expandoBridgeAttributes","cachedModel","escapedModel","modelAttributes","modelClass","modelClassName","new","primaryKey","primaryKeyObj" })
public class HelloSampleImpl extends HelloSampleBaseImpl implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6562029375795062141L;

	/*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a hello sample model instance should use the {@link com.liferay.samples.services.model.HelloSample} interface instead.
     */
    public HelloSampleImpl() {
    }
    @JsonIgnore
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
    	super.setExpandoBridgeAttributes(serviceContext);
    }

	@JsonIgnore
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		super.setExpandoBridgeAttributes(baseModel);
	}

	@JsonIgnore
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		super.setExpandoBridgeAttributes(expandoBridge);
	}
    
}

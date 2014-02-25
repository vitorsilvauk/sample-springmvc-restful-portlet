package com.liferay.samples.services.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay.samples.services.service.ClpSerializer;
import com.liferay.samples.services.service.HelloSampleLocalServiceUtil;
import com.liferay.samples.services.service.HelloSampleServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            HelloSampleLocalServiceUtil.clearService();

            HelloSampleServiceUtil.clearService();
        }
    }
}

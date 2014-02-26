package com.liferay.samples.services.service.base;

import com.liferay.samples.services.service.HelloSampleServiceUtil;

import java.util.Arrays;

/**
 * @author Liferay
 * @generated
 */
public class HelloSampleServiceClpInvoker {
    private String _methodName18;
    private String[] _methodParameterTypes18;
    private String _methodName19;
    private String[] _methodParameterTypes19;
    private String _methodName24;
    private String[] _methodParameterTypes24;
    private String _methodName25;
    private String[] _methodParameterTypes25;
    private String _methodName26;
    private String[] _methodParameterTypes26;
    private String _methodName27;
    private String[] _methodParameterTypes27;
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;

    public HelloSampleServiceClpInvoker() {
        _methodName18 = "getBeanIdentifier";

        _methodParameterTypes18 = new String[] {  };

        _methodName19 = "setBeanIdentifier";

        _methodParameterTypes19 = new String[] { "java.lang.String" };

        _methodName24 = "getAllHelloSamples";

        _methodParameterTypes24 = new String[] {  };

        _methodName25 = "getHelloSample";

        _methodParameterTypes25 = new String[] { "java.lang.Long" };

        _methodName26 = "addHelloSample";

        _methodParameterTypes26 = new String[] {
                "com.liferay.samples.services.model.HelloSample"
            };

        _methodName27 = "updateHelloSample";

        _methodParameterTypes27 = new String[] {
                "com.liferay.samples.services.model.HelloSample"
            };

        _methodName28 = "updateExistentHelloSample";

        _methodParameterTypes28 = new String[] {
                "com.liferay.samples.services.model.HelloSample"
            };

        _methodName29 = "deleteHelloSample";

        _methodParameterTypes29 = new String[] { "java.lang.Long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName18.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes18, parameterTypes)) {
            return HelloSampleServiceUtil.getBeanIdentifier();
        }

        if (_methodName19.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes19, parameterTypes)) {
            HelloSampleServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName24.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes24, parameterTypes)) {
            return HelloSampleServiceUtil.getAllHelloSamples();
        }

        if (_methodName25.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes25, parameterTypes)) {
            return HelloSampleServiceUtil.getHelloSample((java.lang.Long) arguments[0]);
        }

        if (_methodName26.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes26, parameterTypes)) {
            return HelloSampleServiceUtil.addHelloSample((com.liferay.samples.services.model.HelloSample) arguments[0]);
        }

        if (_methodName27.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes27, parameterTypes)) {
            return HelloSampleServiceUtil.updateHelloSample((com.liferay.samples.services.model.HelloSample) arguments[0]);
        }

        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return HelloSampleServiceUtil.updateExistentHelloSample((com.liferay.samples.services.model.HelloSample) arguments[0]);
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            return HelloSampleServiceUtil.deleteHelloSample((java.lang.Long) arguments[0]);
        }

        throw new UnsupportedOperationException();
    }
}

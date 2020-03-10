package com.even.Dto;

import java.io.Serializable;

public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Object[] paramType;

    public Invocation(String interfaceName, String methodName, Object[] params, Object[] paramType) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.params = params;
        this.paramType = paramType;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Object[] getParamType() {
        return paramType;
    }

    public void setParamType(Object[] paramType) {
        this.paramType = paramType;
    }
}

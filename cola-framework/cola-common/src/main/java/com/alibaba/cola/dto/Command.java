package com.alibaba.cola.dto;

import com.alibaba.cola.extension.BizScenario;

import java.util.HashMap;
import java.util.Map;

/**
 * Command stands for a request from Client.
 * According CommandExecutor will help to handle the business logic. This is a classic Command Pattern
 *
 * @author fulan.zjf 2017年10月27日 下午12:28:24
 */
public abstract class Command extends DTO {

    private static final long serialVersionUID = 1L;

    private Map<String, Object> extensions = new HashMap<>();

    private BizScenario bizScenario;

    public BizScenario getBizScenario() {
        return bizScenario;
    }

    public void setBizScenario(BizScenario bizScenario) {
        this.bizScenario = bizScenario;
    }

    public void putObject(Object o) {
        extensions.put(o.getClass().getSimpleName(), o);
    }

    public void putObject(String key, Object o) {
        extensions.put(key, o);
    }

    public <T> T getObject(Class<T> type) {
        return (T) extensions.get(type.getSimpleName());
    }

    public <T> T getObject(String key) {
        return (T) extensions.get(key);
    }
}

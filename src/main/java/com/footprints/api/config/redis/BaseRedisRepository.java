package com.footprints.api.config.redis;

public abstract class BaseRedisRepository {
    protected Class<?> classInstance;

    abstract protected void init();
    protected String generateGlobalKey(String localKey) {
        return classInstance.getSimpleName().substring(0,classInstance.getSimpleName().length()-14) + "-" + localKey;
    }
}
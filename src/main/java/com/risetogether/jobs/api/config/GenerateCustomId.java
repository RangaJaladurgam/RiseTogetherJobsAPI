package com.risetogether.jobs.api.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.annotations.IdGeneratorType;
import org.springframework.data.annotation.Id;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@IdGeneratorType(CustomIdGenerator.class)
public @interface GenerateCustomId {

}

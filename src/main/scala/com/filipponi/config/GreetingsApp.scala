package com.filipponi.config

import com.fasterxml.jackson.databind.{ObjectMapper, SerializationConfig}
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.glassfish.jersey.server.ResourceConfig

/**
  * This class will register the jersey resources
  */
class GreetingsApp extends ResourceConfig {
  val objectMapper: ObjectMapper = new ObjectMapper()
  objectMapper.registerModule(DefaultScalaModule)
  packages("com.filipponi,resource")
  register(new JacksonJaxbJsonProvider(objectMapper,JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS),1)
}

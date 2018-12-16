package com.filipponi.config

import com.filipponi.resource.Greetings
import javax.ws.rs.core.UriBuilder
import org.glassfish.jersey.jetty.JettyHttpContainerFactory
import org.glassfish.jersey.server.ResourceConfig

object EmbeddedServer {
  def main(args: Array[String]): Unit = {
    val baseUri = UriBuilder.fromUri("http://localhost").port(8080).build()
    val config = new ResourceConfig(classOf[Greetings])
    val server = JettyHttpContainerFactory.createServer(baseUri, config, false)
    server.start()
    server.join()
  }
}

package com.filipponi

import java.net.ServerSocket

import com.filipponi.resource.Greetings
import com.jayway.restassured.RestAssured._
import javax.ws.rs.core.UriBuilder
import org.apache.http.HttpStatus
import org.eclipse.jetty.server.Server
import org.glassfish.jersey.jetty.JettyHttpContainerFactory
import org.glassfish.jersey.server.ResourceConfig
import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}


class SimpleIT extends FlatSpec with Matchers with BeforeAndAfterAll {

  private var server : Server = _
  //with the server socket I can allocate a random port
  private val basePath = s"""http://localhost:${new ServerSocket(0).getLocalPort}"""

  override def beforeAll(): Unit = {
    printf(s"""Running up the server on: $basePath""")
    val baseUri = UriBuilder.fromUri(basePath).build()
    val config = new ResourceConfig(classOf[Greetings])
    server = JettyHttpContainerFactory.createServer(baseUri, config, false)
    server.getURI
    server.start()
    printf("Local jetty server is up")
  }

  override def afterAll(): Unit = {
    server.stop()
  }

  "this integration test" should "pass" in {
    print("Running test")
    when()
      .get(s"""$basePath/jettytest/hello""")
      .`then`()
      .statusCode(HttpStatus.SC_OK)
  }
}


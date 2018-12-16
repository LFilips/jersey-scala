package com.filipponi.resource

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response}

@Path("/jettytest")
class Greetings {

  @GET
  @Path("/{message}")
  def getTest(@PathParam("message") message: String): String = {
    s"""hello $message"""
  }

  @POST
  @Path("/{message}")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @Produces(Array(MediaType.APPLICATION_JSON))
  def postTest(payload: Payload): Response = {
    printf(s"Received payload $payload")
    Response.ok(payload).build()
  }

}

case class Payload(name: String, surname: String)



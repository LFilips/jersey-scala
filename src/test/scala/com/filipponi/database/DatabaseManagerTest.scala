package com.filipponi.database

import org.scalatest.{FlatSpec, FunSuite, Matchers}

class DatabaseManagerTest extends FlatSpec with Matchers {

  "DatabseManager" should "be able to connect to the db" in {

    val databaseManager: DatabaseManager = new DatabaseManager

    databaseManager.createDb()

  }

}

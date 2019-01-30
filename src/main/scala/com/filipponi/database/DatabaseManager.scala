package com.filipponi.database

import java.sql.DriverManager

import com.filipponi.database.DatabaseManager.{DB_URL, JDBC_DRIVER}

class DatabaseManager {

  def createDb(): Unit = {

    Class.forName(JDBC_DRIVER)

    //STEP 2: Open a connection //STEP 2: Open a connection
    println("Connecting to database...")
    val conn = DriverManager.getConnection(DB_URL, "user", "pass")

    //STEP 3: Execute a query
    printf("Creating table in given database...")
    val stmt = conn.createStatement
    val sql = "CREATE TABLE REGISTRATION " + "(id INTEGER not NULL, " + " first VARCHAR(255), " + " last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))"
    stmt.executeUpdate(sql)
    println("Created table in given database...")

    // STEP 4: Clean-up environment
    stmt.close()

  }

}

object DatabaseManager {
  private val JDBC_DRIVER = "org.h2.Driver"
  private val DB_URL = "jdbc:h2:~/test"
}

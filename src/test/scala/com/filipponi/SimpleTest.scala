package com.filipponi

import org.scalatest.{FlatSpec, Matchers}

class SimpleTest extends FlatSpec with Matchers {

  "this unit test" should "pass" in {
    true should be (true)
  }

}

package com.github.hayasshi

import com.github.hayasshi.assertion._
import com.github.hayasshi.refined._
import eu.timepit.refined.auto._
import org.openjdk.jmh.annotations.Benchmark

class Literal {

  @Benchmark
  def runCreateRefinedObjects(): Unit = {
    RefinedUser(RefinedUserId(1L), RefinedUserName("A1"), RefinedUserAge(101))
  }

  @Benchmark
  def runCreateAssertObjects(): Unit = {
    AssertionUser(AssertionUserId(1L), AssertionUserName("A1"), AssertionUserAge(101))
  }

}

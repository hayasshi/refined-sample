package com.github.hayasshi

import com.github.hayasshi.assertion._
import com.github.hayasshi.refined.RefinedUser._
import com.github.hayasshi.refined._
import eu.timepit.refined._
import org.openjdk.jmh.annotations.Benchmark

class Var {

  @Benchmark
  def runCreateRefinedObjects(): Unit = {
    (1 to 10000).foreach { i =>
      for {
        id   <- refineV[UserIdRefinedType](i.toLong)
        name <- refineV[UserNameRefinedType]("A" + i)
        age  <- refineV[UserAgeRefinedType](100 + i)
      } yield {
        RefinedUser(RefinedUserId(id), RefinedUserName(name), RefinedUserAge(age))
      }
    }
  }

  @Benchmark
  def runCreateAssertObjects(): Unit = {
    (1 to 10000).foreach { i =>
      for {
        id   <- Option(i.toLong)
        name <- Option("A" + i)
        age  <- Option(100 + i)
      } yield {
        AssertionUser(AssertionUserId(id), AssertionUserName(name), AssertionUserAge(age))
      }
    }
  }

}

package com.github.hayasshi

import com.github.hayasshi.assertion._
import com.github.hayasshi.refined.RefinedUser._
import com.github.hayasshi.refined._
import eu.timepit.refined._
import org.openjdk.jmh.annotations.Benchmark

class RefinedSampleMain {

  @Benchmark
  def runCreateRefinedObjectsByVariables(): Unit = {
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
  def runCreateAssertObjectsByVariables(): Unit = {

    (1 to 10000).foreach { i =>
      AssertionUser(AssertionUserId(i.toLong), AssertionUserName("A" + i), AssertionUserAge(100 + i))
    }
  }

}

package com.github.hayasshi.refined

import com.github.hayasshi.refined.RefinedUser._
import eu.timepit.refined._
import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric._
import eu.timepit.refined.string._

case class RefinedUserId(value: UserIdType)

case class RefinedUserName(value: UserNameType)

case class RefinedUserAge(value: UserAgeType)

case class RefinedUser(
  id:   RefinedUserId,
  name: RefinedUserName,
  age:  RefinedUserAge
)

object RefinedUser {
  type UserIdRefinedType = Positive
  type UserIdType        = Long Refined UserIdRefinedType

  type UserNameRefinedType = MatchesRegex[W.`"[A-Z][a-zA-Z0-9]{0,9}"`.T]
  type UserNameType        = String Refined UserNameRefinedType

  type UserAgeRefinedType = GreaterEqual[W.`18`.T]
  type UserAgeType        = Int Refined UserAgeRefinedType
}


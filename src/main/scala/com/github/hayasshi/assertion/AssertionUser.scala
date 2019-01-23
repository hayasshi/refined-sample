package com.github.hayasshi.assertion

import AssertionUser._

case class AssertionUserId(value: Long) {
  assert(value > 0, s"Invalid user id value: $value")
}

case class AssertionUserName(value: String) {
  assert(namePattern.matcher(value).matches(), s"Invalid user name value: $value")
}

case class AssertionUserAge(value: Int) {
  assert(value >= 18, s"Invalid user age value: $value")
}

case class AssertionUser(
  id:   AssertionUserId,
  name: AssertionUserName,
  age:  AssertionUserAge
)

object AssertionUser {
  val namePattern = "[A-Z][a-zA-Z0-9]{0,9}".r.pattern
}
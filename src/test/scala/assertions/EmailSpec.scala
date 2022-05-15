package assertions

import main.scala.com.h2.entities.Email
import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec{
  behavior of "An Email"

  it should "return an Email object for a valid String part 2" in {
    fail("Not implemented yet")
  }

  it should "return an Email object for a valid String" in {
    val email = Email("howdy@google.com")

    assert(email.localPart === "howdy")
    assert(email.domain === "google.com")
  }

  it should "return another Email object for another valid String" in {
    assertResult("test") {
      Email("test@test.com").localPart // within the body is the computation of the result
    }
  }

  it should "throw IllegalArgumentException when no '@' symbol in email" in {
    assertThrows[IllegalArgumentException]{
      Email("test")
    }
  }

  it should "intercept the correct error message when no '@' symbol provided" in {
    val exception = intercept[IllegalArgumentException] { Email("test.com") }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("invalid email: does not contain '@' symbol"))
  }
}

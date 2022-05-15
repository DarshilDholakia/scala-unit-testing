package matchers

import main.scala.com.h2.services.Currency

class ExceptionSpec extends UnitSpec {
  behavior of "Currency during excpetion"
  it should "throw an exception when invalid number is provided in the currency string" in {
    a [NumberFormatException] should be thrownBy Currency.stringToCurrency("Two USD") // [] here indicate what
    // exception we are expecting here (in this case, it's NumberFormatException)
    an [NumberFormatException] should be thrownBy Currency.stringToCurrency("Five USD")
  }

  it should "provide details about the exception thrown" in {
    val exception = the [NumberFormatException] thrownBy Currency.stringToCurrency("Two USD")
    exception.getMessage should include("Two")
  }
}

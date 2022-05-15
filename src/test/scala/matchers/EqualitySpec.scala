package matchers

import main.scala.com.h2.services.Currency

class EqualitySpec extends UnitSpec {
  behavior of "Currency Equals"
  it should "match two 10 USD currencies as equal when using 'should equal'" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should equal (currency2)
  }
}

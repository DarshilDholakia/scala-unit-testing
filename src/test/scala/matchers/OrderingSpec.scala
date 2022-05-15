package matchers

import main.scala.com.h2.services.Currency

class OrderingSpec extends UnitSpec {
  behavior of "Currency conversion cost in comparison"

  it should "report equal costs for 10 USD, 10 USD" in {
    val tenUsd: Currency = "10 USD"
    val anotherTenUsd: Currency = "10 USD"

    tenUsd.costInDollars.amount should be >= anotherTenUsd.costInDollars.amount
  }

  it should "report NZD < USD" in {
    "NZD" should be < "USD"
  }
}

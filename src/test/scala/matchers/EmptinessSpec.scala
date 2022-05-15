package matchers

import main.scala.com.h2.services.{Currency, CustomerService}

class EmptinessSpec extends UnitSpec {
  val customerService = new CustomerService {}

  behavior of "Customer for emptiness"
  it should "return empty for customer's last name" in {
    val (first, last, email, dateOfBirth) = ("Shane", "", "shane@google.com", "1998/12/31")
    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.last should be (empty)
    customer.last shouldBe empty
  }

  // testing for emptiness inside containers
  behavior of "Currencies inside wallet"
  it should "be empty when no currencies are added to wallet" in {
    val wallet: List[Currency] = List.empty

    wallet should be (empty)
  }
}

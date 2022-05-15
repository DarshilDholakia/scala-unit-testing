package matchers

import main.scala.com.h2.services.CustomerService

class ObjectIdentitySpec extends UnitSpec {
  val customerService = new CustomerService {}

  behavior of "CustomerService when creating new customers"

  it should "create one customer for a given email address" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1999/12/31")
    val customerId1 = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customerId2 = customerService.createNewCustomer(first, last, email, dateOfBirth) // same ID as customer1 returned

    val customer1 = customerService.getCustomer(customerId1).get
    val customer2 = customerService.getCustomer(customerId2).get // this object now has 2 references, customer 1 and
    // customer 2 hence customer1 equals customer2

    customer1 should be theSameInstanceAs(customer2)
  }
}

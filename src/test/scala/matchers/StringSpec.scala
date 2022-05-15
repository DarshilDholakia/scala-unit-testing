package matchers

import main.scala.com.h2.services.CustomerService

class StringSpec extends UnitSpec {
  val customerService: CustomerService = new CustomerService {}

  behavior of "Customer Service for Strings"

  it should "correctly match the customer email starting with first name" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should startWith(first.toLowerCase)
  }

  it should "correctly match the customer DOB as fullyMatch regular expression" in {
    val (first, last, email, dateOfBirth) = ("John", "Smith", "john@smith.com", "1982/12/31")

    val customerId = customerService.createNewCustomer(first, last, email, dateOfBirth)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should fullyMatch regex """[0-9]{4}-[0-9]{2}-[0-9]{2}"""
  }
}

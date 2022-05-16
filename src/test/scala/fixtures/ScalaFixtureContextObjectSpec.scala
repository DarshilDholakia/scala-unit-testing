package fixtures

import main.scala.com.h2.entities.{Customer, Deposits, Dollars}
import main.scala.com.h2.services.{CustomerService, ProductService}
import matchers.UnitSpec

import java.util.UUID

class ScalaFixtureContextObjectSpec extends UnitSpec {
  trait ACustomer {
    private val service: CustomerService = new CustomerService {}
    private val customerId: UUID = service.createNewCustomer("nancy", "williams", "nancy@williams.com", "1999/12/10")
    val customer: Customer = service.getCustomer(customerId).get
  }
  trait AProduct {
    private val service: ProductService = new ProductService {}
    private val productId: UUID = service.addNewDepositProduct("CoreChecking", 2000, 0.02, 10)
    val product: Deposits = service.getDepositProduct(productId).get
  }
  trait ADollars {
    val fiveThousandDollars = Dollars(5000)
  }

  behavior of "ACustomer"
  it should "return a customer with non-empty email address" in new ACustomer { // this will give test access to customer object
    // customer.email.toString should not be empty
  }

  behavior of "AProduct"
  it should "return a valid product with more than 1000 dollars minimum balance requirement" in new AProduct {
     product.minimumBalancePerMonth should be >= Dollars(1000)
  }

  behavior of "A Product with some Money"
  it should "return true for 5000 dollars be greater than the product minimum balance requirement" in new ADollars with AProduct {
     fiveThousandDollars should be > product.minimumBalancePerMonth
  }
}

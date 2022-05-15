package assertions

import main.scala.com.h2.entities.Dollars
import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec{
  behavior of "A Dollar"
  it should "create a correct Dollar for number 10 as input" in {
    val tenDollars = Dollars(10)
    assert("$10" === tenDollars.toString)
  }

  it should "correctly identifies that  $10 > $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)

    assert(tenDollars.>(fiveDollars)) // look at Ordered implementation in Scala to understand why this works
  }

  it should "correctly add two Dollar amounts" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)

    assertResult("$15") {
      (tenDollars + fiveDollars).toString
    }
  }

  it should "correctly identify equality between 2 Dollar amounts" in {
    val tenDollars = Dollars(10)

    assertResult(true) {
      (tenDollars == tenDollars)
    }
  }

  it should "throw exception if invalid integer passed as Dollar amount" in {
    assertThrows[ArithmeticException]{
      Dollars(10/0)
    }
  }

  it should "have every Dollar more than 0" in {
//    val dollars: List[Dollars] = List(Dollars(1), Dollars(100), Dollars(20))
    val dollars: List[Dollars] = List.empty

    assume(dollars.nonEmpty)

    dollars.foreach(d =>
    assert(d.amount > 0)
    )
  }
}

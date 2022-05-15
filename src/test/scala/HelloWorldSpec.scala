import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFlatSpec {
  behavior of "Hello World" // 'behaviour of' defines the test subject. "Hello World" is what we're going to test

  it should "start with 'Hello'" in { // "start with 'Hello'" is the nature of this test
    assert("Hello World".startsWith("Hello")) // test body
  }
  it should "ends with 'World'" in { // "start with 'Hello'" is the nature of this test
    assert("Hello World".endsWith("World")) // test body
  }
}
import UIKit
import Lib

class ViewController: UIViewController {

  override func viewDidLoad() {
    super.viewDidLoad()
    self.view.backgroundColor = .orange
    print("ViewController.viewDidLoad")
    testLibBridge()
  }

  private func testLibBridge() {
    let object1 = LibObject()
    let object2 = LibObject()
    assert(object1 === object2)
    print("object: \(object1)")

    let field: String = LibObject().field
    print("object.field: \(field)")

    let classInstance = LibClass()
    print("classInstance.member: \(classInstance.member(p: 10)!)")

    ExampleKt.bridgeIntegersExample(b: 1, s: 2, i: 3, l: 4)
    ExampleKt.bridgeFloatsExample(f: 1.0, d: 2.0)

    let stringExample = ExampleKt.bridgeStringsExample(str: "foo")
    print("bridgeStringsExample: \(stringExample)")

    let cloasureValue1 = ExampleKt.passClosureExample { string in
      return "\(string) Swift"
    }
    print("passClosureExample: \(cloasureValue1!)")

    let closureValue2 = ExampleKt.provideClosureExample()("bar")
    print("provideClosureExample: \(closureValue2!)")

    let context = EventBusContext(identifier: "default")
    let observer = context.eventBus.observer(eventIds: ["foo", "bar"]) { id in
      print("hey")
      return true
    }
  }
}

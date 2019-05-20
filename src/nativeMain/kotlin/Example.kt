package Example

object LibObject {
  val field = "A"
}

interface LibInteface {
  fun libInterfaceMethod() {}
}

class LibClass : LibInteface {
  fun member(p: Int): ULong? = 42UL
}

// Bridge integer scalars.
fun bridgeIntegersExample(b: Byte, s: UShort, i: Int, l: ULong?) {
}

// Bridge flaots scalars.
fun bridgeFloatsExample(f: Float, d: Double?) {
}

// Bridge strings.
fun bridgeStringsExample(str: String?) : String {
  return "echo:$str'"
}

// Bridge closures.

fun passClosureExample(function: (String) -> String?) = function("Default LibKotlin value.")

fun provideClosureExample() : (String) -> String? = { "echo:$it" }
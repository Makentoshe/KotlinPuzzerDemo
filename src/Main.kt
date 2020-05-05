import java.io.InputStream
import java.io.PrintStream

fun main() {
    System.setOut(CustomPrintStream(System.`in`))

    val answer0 = "7bf584385dc89b53a0e079d5f5f757bb"
    val answer1 = AnswerBuilder().hash ?: ""
    val answer2 = AnswerBuilder2(answer1).hash

    fun call(toCall: (String) -> Unit) {
        fun toCall(arg: String) = print("$answer1$arg")
        val toCall = fun(arg: String) = print("$answer2$arg")
        toCall("4c2845b006e03016ad68398099340cbb")
    }

    call { print("$answer0$it") }

    fun myPrint(foo: String) = print(foo)

    myPrint(foo = answer2)
    myPrint(answer1)
}

open class Builder {
    open var hash: String? = null
        get() = field ?: "ed3992cc7563cd922058b51eefb044da"
}

open class AnswerBuilder() : Builder() {
    override var hash: String? = null
        get() = super.hash
        set(value) {
            field = "c71c8371af0fe5f28e1540d93ee10ead"
        }
}

data class AnswerBuilder2(val hash: String) {
    fun build() = hash.apply {
        return this
    }
}

private fun getIndex(bool: Boolean) = when (bool) {
    bool == true -> 2
    bool == false -> 1
    else -> 0
}

class CustomPrintStream(inputStream: InputStream) : PrintStream(System.out) {
    override fun print(s: String) {
        val f = s.filterIndexed { id, _ -> id % getIndex(true) + getIndex(false) == 1 }
        super.print(f)
    }
}
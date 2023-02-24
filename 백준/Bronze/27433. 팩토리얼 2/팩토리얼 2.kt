fun main(){
    val n : String? = readLine()
    val factorial = factorial(n?.toInt())
    println(factorial)
}

fun factorial(n : Int?): Long {
    var num:Long = 1;
    if(n==0){
        return 1
    }
    for (i in 1..n!!){
        num *= i
    }
    return num
}
/** ******** val ********* */
// A val modifier is immutable, its value cannot change once it has been assigned
val volume = 1000

// volume = 100 # not allowed
volume

println(s"Volume is: $volume")

/** ******** var ********* */
var stockPrice = 79

println(s"Stock price is $stockPrice")

stockPrice = 78

println(s"Now stock price is $stockPrice")

/** ******** def ********* */
def dVolume: Int = 1000

def dStockPrice: Int = 79

def finalValue: Int = dStockPrice * dVolume

finalValue

/** ******** lazy ********* */
val faceValue = 5
lazy val lazyFaceValue = 5
faceValue
lazyFaceValue
fun main() {
    val commissionSize = calcCommission(20000)

    println("Комиссия составит: $commissionSize руб.")
}

fun calcCommission(amountOfTransfer: Int, typeOfCard: String = "VK Pay", amountOfPreviousTransfer: Int = 0): Int {
    var commission = 0

    if (typeOfCard == "VK Pay") {
        commission = if (amountOfTransfer > 15_000 || (amountOfTransfer + amountOfPreviousTransfer) > 40_000) -1 else 0
    } else if (amountOfTransfer > 150_000 || (amountOfTransfer + amountOfPreviousTransfer) > 600_000) {
        commission = -2
    } else if (typeOfCard == "Mastercard" || typeOfCard == "Maestro") {
        commission = if (amountOfTransfer > 75_000) (amountOfTransfer * 0.6 / 100).toInt() + 20 else 0
    } else if (typeOfCard == "Visa" || typeOfCard == "МИР") {
        commission = if ((amountOfTransfer * 0.75 / 100).toInt() > 35) (amountOfTransfer * 0.75 / 100).toInt() else 35
    }
    return commission
}




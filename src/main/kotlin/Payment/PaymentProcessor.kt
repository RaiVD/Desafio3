package Payment


interface PaymentProcessor {
    fun processPayment(valueReceivedFromUser: Double, totalPurchaseValue: Double): String
}
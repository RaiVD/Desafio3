package Cart

class InputUser {
    fun lerInteiroDoUsuario(mensagem: String): Int {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()
            try {
                return entrada?.toInt() ?: throw NumberFormatException()
            } catch (e: NumberFormatException) {
                println("Entrada inválida. Por favor, digite um número inteiro válido.")
            }
        }
    }
    fun lerDecimalDoUsuario(mensagem: String): Double {
        while (true) {
            print(mensagem)
            val entrada = readlnOrNull()

            try {
                return entrada?.toDouble() ?: throw NumberFormatException()
            } catch (e: NumberFormatException) {
                println("Entrada inválida. Por favor, digite um número válido.")
            }
        }
    }
}
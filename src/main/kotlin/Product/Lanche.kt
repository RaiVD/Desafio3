package Product

import Produtos.TipoEnum

class Lanche(nome: String, valor: Double) :
    ProductSelect(nome, valor, TipoEnum.COMIDA){

}
package com.example.lib

import kotlin.system.exitProcess

class Calculadora (
    val marca: String,
    val aniosVida: Int,
    var precio: Float
) {
    fun menu1() {
        var opcionMenuPrin: Int? = 0
        println("    CALCULADORA     \n Ingrese el numero de la operacion que desea:")
        println(" 1. Suma \n 2. Resta \n 3. Multiplicacion \n 4. Division \n 5. Salir")
        do {
            opcionMenuPrin = readln().toIntOrNull()
            when (opcionMenuPrin) {
                1 -> suma()
                2 -> resta()
                3 -> multiplicacion()
                4 -> division()
                5 -> exitProcess(0)
                else -> println("Error. Ingrese una opcion valida. \n 1. Suma \n 2. Resta \n 3. Multiplicacion \n 4. Division \n 5. Salir")
            }
        } while(opcionMenuPrin != 1 || opcionMenuPrin != 2 || opcionMenuPrin != 3 || opcionMenuPrin != 4 || opcionMenuPrin != 5 )
    }
    fun menu2() {
        println("Ingrese '1' si desea continuar o '2' si desea volver al menu principal")
    }

    fun suma() {
        var num1: Float? = 0.0f
        var num2: Float? = 0.0f
        var operacion: Float = 0.0f
        var opcionMenuInterno: Int? = 0

        do {
            println("SUMA    \n Ingrese el primer numero:")
            num1 = readln().toFloatOrNull()
            if (num1 == null) {
                println("Dato invalido. Ingrese un numero")
            }
        } while (num1 == null)
        do {
            println("Ingrese el segundo numero:")
            num2 = readln().toFloatOrNull()
            if (num2 == null) {
                println("Dato invalido. Ingrese un numero")
            }
        } while (num2 == null)

        operacion = (num1 + num2)
        println("$num1 + $num2 es igual a: $operacion")

        menu2()
        do{
        opcionMenuInterno = readln().toIntOrNull()
        when (opcionMenuInterno) {
            1 -> suma()
            2 -> menu1()
            else -> println("Ingrese una opcion valida.")
        }
        } while (opcionMenuInterno != 1 || opcionMenuInterno!= 2)

    }
    fun resta() {
        var num1: Float? = 0.0f
        var num2: Float? = 0.0f
        var operacion: Float = 0.0f
        var opcionMenuInterno: Int? = 0

        do {
            println("RESTA \n Ingrese el primer numero:")
            num1 = readln().toFloatOrNull()
            if (num1 == null) {
                println("Dato invalido. Ingrese un numero")
            }
        } while (num1 == null)
        do {
            println("Ingrese el segundo numero:")
            num2 = readln().toFloatOrNull()
            if (num2 == null) {
                println("Dato invalido. Ingrese un numero")
            }
        } while (num2 == null)

        operacion = (num1 - num2)
        println("$num1 - $num2 es igual a: $operacion")

        menu2()
        do {
            opcionMenuInterno = readln().toIntOrNull()
            when (opcionMenuInterno) {
                1 -> resta()
                2 -> menu1()
                else -> println("Ingrese una opcion valida.")
            }
        } while (opcionMenuInterno != 1 || opcionMenuInterno!= 2)
    }
    fun multiplicacion() {
        var num1: Float? = 0.0f
        var num2: Float? = 0.0f
        var operacion: Float = 0.0f
        var opcionMenuInterno: Int? = 0

        do {
            println("MULTIPLICACION    \n Ingrese el primer numero:")
            num1 = readln().toFloatOrNull()
            if (num1 == null) {
                println("Dato invalido. Ingrese un numero")
            }
        } while (num1 == null)
        do {
            println("Ingrese el segundo numero:")
            num2 = readln().toFloatOrNull()
            if (num2 == null) {
                println("Dato invalido. Ingrese un numero")
            }
        } while (num2 == null)

        operacion = (num1 * num2)
        println("$num1 * $num2 es igual a: $operacion")

        menu2()
        do {
        opcionMenuInterno = readln().toIntOrNull()
        when (opcionMenuInterno) {
            1 -> multiplicacion()
            2 -> menu1()
            else -> println("Ingrese una opcion valida.")
        }
        } while (opcionMenuInterno != 1 || opcionMenuInterno!= 2)
    }
    fun division() {
        var num1: Float? = 0.0f
        var num2: Float? = 0.0f
        var operacion: Float = 0.0f
        var opcionMenuInterno: Int? = 0

        do {
            println("DIVISION   \n Ingrese el primer numero:")
            num1 = readln().toFloatOrNull()
            if (num1 == null) {
                println("Dato invalido. Ingrese un numero")
            }
        } while (num1 == null)
        do {
            println("Ingrese el segundo numero:")
            num2 = readln().toFloatOrNull()
            if (num2 == null || num2 == 0.0f) {
                println("Dato invalido. Ingrese un numero valido")
            }
        } while (num2 == null || num2 == 0.0f)

        operacion = (num1 / num2)
        println("$num1 / $num2 es igual a: $operacion")

        menu2()
        do{
        opcionMenuInterno = readln().toIntOrNull()
        when (opcionMenuInterno) {
            1 -> division()
            2 -> menu1()
            else -> println("Ingrese una opcion valida.")
        }
    } while (opcionMenuInterno != 1 || opcionMenuInterno!= 2)
    }
}

fun main(){
    val calculadora1 = Calculadora("Casio", 5, 39.90f)

    calculadora1.menu1()
}
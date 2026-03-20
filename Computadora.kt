package com.example.lib

class Computadora(
    val marca: String,
    val modelo: String,
    var almacenamiento: String,
    var memoriaRAM: String,
    val peso: String,
    var sistemaOperativo: String,
    val programasInstalados: List<String>
) {
    fun encender() {
        println("Encendiendo... Bienvenido!")
    }

    fun mostrarProgramas() {
        println("\n Programas instalados:")
        programasInstalados.forEach { element -> println(element) }
    }

    fun mostrarProgramasAnio(anio: String) {
        println("\n Programas instalados en $anio:")
        val programasFiltrados = programasInstalados.filter { it.contains(anio) }
        programasFiltrados.forEach { element -> println(element) }
    }

    fun apagar() {
        println("\n Apagando... Hasta la proxima!")
    }
}

fun main() {
    val computadora1 = Computadora(
        "Lenovo", "IdeaPad Slim 3", "512 GB", "8 GB",
        "1.7 KG", "Windows 11", listOf(
            "Adobe Photoshop 2021",
            "Visual Studio Code 2026",
            "Adobe Illustrator 2023",
            "Android Studio 2026"
        )
    )

    computadora1.encender()
    computadora1.mostrarProgramas()
    computadora1.mostrarProgramasAnio("2026")
    computadora1.apagar()

}

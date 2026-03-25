package com.example.lib

class Estudiante(
    val nombre: String,
    val carnet: Int,
    var asignatura: String
)

fun main() {
    val estudiantes = listOf(
        Estudiante("Maria Moreno", 78921, "PDM"),
        Estudiante("Fabiola Lopez", 467923, "PDM"),
        Estudiante("Pedro Martinez", 679043, "PDM"),
        Estudiante("Sabrina Mejia", 734519, "Analisis Numerico"),
        Estudiante("Mauricio Dominguez", 875321, "Analisis Numerico"),
        Estudiante("Walter Rodriguez", 672314, "Analisis Numerico"),
        Estudiante("Rosa Rivera", 556721, "Analisis Numerico")
    )
    mostrarEstudianteAsignatura(estudiantes, "PDM")
}

fun mostrarEstudianteAsignatura(lista: List<Estudiante>, asig: String) {
    val estudiantesFiltrados = lista.filter { it.asignatura === asig }

    println("Estudiantes inscritos en $asig:")
    estudiantesFiltrados.forEach {
        println(
            "Nombre: ${it.nombre} \n Carnet: ${it.carnet} \n Asignatura: ${it.asignatura} \n")
    }
}
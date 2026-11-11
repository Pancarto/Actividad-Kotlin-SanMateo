
package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Informacion del estudiante
        val nombreEstudiante: String = "Jeisson Niño"
        val carrera: String = "Ingenieria de Sistemas"
        val asignatura: String = "Desarrollo de aplicaciones moviles"

        // Notas de los tres cortes
        var notaCorte1: Double = 4.2
        var notaCorte2: Double = 3.5
        var notaCorte3: Double? = 4.5

        // Aplicacion del operador Elvis
        val notaFinal3: Double = notaCorte3 ?: 0.0

        // Calcular promedio
        val promedio = calcularPromedio(
            notaCorte1,
            notaCorte2,
            notaFinal3
        )

        // Generar el reporte
        val reporte = generarReporte(
            nombreEstudiante,
            carrera,
            asignatura,
            promedio
        )

        // Mostrar el reporte en pantalla
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        tvResultado.text = reporte

        // Ajustar la pantalla
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v, insets ->

            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }

    // Funcion para calcular el promedio
    fun calcularPromedio(
        n1: Double,
        n2: Double,
        n3: Double
    ): Double {
        return (n1 + n2 + n3) / 3
    }

    // Funcion para generar el reporte
    fun generarReporte(
        estudiante: String,
        carrera: String,
        materia: String,
        promedio: Double
    ): String {

        val estado = if (promedio >= 3.0) {
            "APROBADO"
        } else {
            "REPROBADO"
        }

        return """
            REPORTE DEL ESTUDIANTE

            Nombre: $estudiante
            Carrera: $carrera
            Asignatura: $materia

            Promedio: ${String.format("%.2f", promedio)}
            Estado: $estado
        """.trimIndent()
    }
}

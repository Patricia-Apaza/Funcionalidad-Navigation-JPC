package com.edu.upeu.navegationjpc.ui.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.*

@Composable
fun CalcScreen() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calculadora", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Número 2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Button(onClick = {
                resultado = ((num1.toDoubleOrNull() ?: 0.0) + (num2.toDoubleOrNull() ?: 0.0)).toString()
            }) {
                Text("Sumar")
            }
            Button(onClick = {
                resultado = ((num1.toDoubleOrNull() ?: 0.0) - (num2.toDoubleOrNull() ?: 0.0)).toString()
            }) {
                Text("Restar")
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Button(onClick = {
                resultado = ((num1.toDoubleOrNull() ?: 0.0) * (num2.toDoubleOrNull() ?: 0.0)).toString()
            }) {
                Text("Multiplicar")
            }
            Button(onClick = {
                val divisor = num2.toDoubleOrNull() ?: 0.0
                resultado = if (divisor != 0.0) {
                    ((num1.toDoubleOrNull() ?: 0.0) / divisor).toString()
                } else {
                    "Error: división entre 0"
                }
            }) {
                Text("Dividir")
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Button(onClick = {
                resultado = ((num1.toDoubleOrNull() ?: 0.0).pow(num2.toDoubleOrNull() ?: 0.0)).toString()
            }) {
                Text("Potencia")
            }
            Button(onClick = {
                val n1 = num1.toDoubleOrNull() ?: -1.0
                resultado = if (n1 >= 0) {
                    sqrt(n1).toString()
                } else {
                    "Error: raíz negativa"
                }
            }) {
                Text("Raíz √")
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Button(onClick = {
                num1 = Math.PI.toString()
            }) {
                Text("π")
            }
        }

        Text(
            text = "Resultado: $resultado",
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}
